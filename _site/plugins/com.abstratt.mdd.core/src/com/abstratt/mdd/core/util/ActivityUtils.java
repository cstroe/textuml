/*******************************************************************************
 * Copyright (c) 2006, 2008 Abstratt Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Rafael Chaves (Abstratt Technologies) - initial API and implementation
 *******************************************************************************/
package com.abstratt.mdd.core.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.uml2.common.util.UML2Util.EObjectMatcher;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPackage.Literals;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.ValueSpecificationAction;
import org.eclipse.uml2.uml.Variable;

import com.abstratt.mdd.core.IRepository;

public class ActivityUtils {

	private static final String BODY_NODE = "body";

	public static StructuredActivityNode createBodyNode(Activity currentActivity) {
		return currentActivity.createStructuredNode(BODY_NODE);
	}

	/**
	 * Finds an exception handler for the given exception type.
	 * 
	 * @param startingPoint
	 *            starting point node, will fall back to parents if required
	 * @param exceptionType
	 *            the type of exception to be handled
	 * @return the handler, or <code>null</code>
	 */
	public static ExceptionHandler findHandler(ExecutableNode startingPoint, Classifier exceptionType, boolean recurse) {
		for (ExceptionHandler current : startingPoint.getHandlers())
			if (current.getExceptionTypes().contains(exceptionType))
				return current;
		if (recurse && startingPoint.getOwner() instanceof ExecutableNode)
			return findHandler((ExecutableNode) startingPoint.getOwner(), exceptionType, true);
		return null;
	}

	/**
	 * Performs a variable lookup traversing the structured activity node
	 * hierarchy if necessary. Supports closures.
	 * 
	 * @see StructuredActivityNode#getVariable(String, Type)
	 */
	public static Variable findVariable(StructuredActivityNode node, String variableName) {
		Variable found = node.getVariable(variableName, null);
		if (found != null)
			return found;
		if (node.getOwner() instanceof StructuredActivityNode)
			// this is an inner block, fall back to outer block
			return findVariable((StructuredActivityNode) node.getOwner(), variableName);
		if (MDDExtensionUtils.isClosure(node.getOwner()))
			// this is the outermost block of a closure, fall back to the
			// closure context
			return findVariable(MDDExtensionUtils.getClosureContext((Activity) node.getOwner()), variableName);
		return null;
	}

	public static List<Parameter> getClosureInputParameters(Activity closure) {
		return FeatureUtils.filterParameters(closure.getOwnedParameters(), ParameterDirectionKind.IN_LITERAL);
	}

	public static Parameter getClosureInputParameter(Activity closure) {
		List<Parameter> inputParams = getClosureInputParameters(closure);
		Assert.isLegal(inputParams.size() > 0);
		return inputParams.get(0);
	}

	public static Parameter getClosureReturnParameter(Activity closure) {
		return FeatureUtils.getReturnParameter(closure.getOwnedParameters());
	}

	/**
	 * Returns the structured activity node that corresponds to the body of an
	 * activity.
	 */
	public static StructuredActivityNode getBodyNode(Activity activity) {
		return (StructuredActivityNode) activity.getStructuredNode(BODY_NODE);
	}

	public static StructuredActivityNode getRootAction(Operation operation) {
		Activity activity = getActivity(operation);
		return activity == null ? null : getRootAction(activity);
	}

	public static Activity getActivity(Operation operation) {
		List<Behavior> methods = operation.getMethods();
		if (methods.isEmpty())
			return null;
		Behavior method = methods.get(0);
		if (!(method instanceof Activity))
			return null;
		return (Activity) method;
	}

	public static Activity getActionActivity(Action action) {
		return MDDUtil.getNearest(action, UMLPackage.Literals.ACTIVITY);
	}

	public static StructuredActivityNode getRootAction(Activity method) {
		StructuredActivityNode body = getBodyNode(method);
		Assert.isTrue(body.getNodes().size() == 1, "expecting 1, found " + body.getNodes().size());
		return (StructuredActivityNode) body.getNodes().get(0);
	}

	public static ObjectFlow connect(StructuredActivityNode parent, ObjectNode source, ObjectNode target) {
		ObjectFlow flow = (ObjectFlow) parent.createEdge(null, IRepository.PACKAGE.getObjectFlow());
		flow.setSource(source);
		flow.setTarget(target);
		flow.setWeight(MDDUtil.createLiteralInteger(parent.getNearestPackage(), 1));
		flow.setGuard(MDDUtil.createLiteralBoolean(parent.getNearestPackage(), true));
		if (target.getType() == null && source.getType() != null)
			TypeUtils.copyType(source, target);
		return flow;
	}

	public static ActivityNode findNode(ActivityNode root, EObjectMatcher matcher) {
		if (matcher.matches(root))
			return root;
		if (!(root instanceof StructuredActivityNode))
			return null;
		StructuredActivityNode parent = (StructuredActivityNode) root;
		ActivityNode found = null;
		for (ActivityNode current : parent.getNodes())
			if ((found = findNode(current, matcher)) != null)
				return found;
		return null;
	}

	public static ObjectNode getSource(ObjectNode target) {
		final List<ActivityEdge> incomings = target.getIncomings();
		if (incomings.isEmpty())
			return null;
		Assert.isLegal(incomings.size() == 1);
		return (ObjectNode) ((ObjectFlow) incomings.get(0)).getSource();
	}

	public static Action getControlSource(ActivityNode target) {
		final List<ActivityEdge> incomings = target.getIncomings();
		if (incomings.isEmpty())
			return null;
		Assert.isLegal(incomings.size() == 1);
		return (Action) ((ControlFlow) incomings.get(0)).getSource();
	}

	public static Action getSourceAction(ObjectNode target) {
		ObjectNode sourcePin = getSource(target);
		if (sourcePin == null)
			return null;
		Action sourceAction = (Action) sourcePin.getOwner();
		// skip casts as they provide no value
		return isCast(sourceAction) ? getSourceAction(sourceAction) : sourceAction;
	}

	public static Action getSourceAction(Action target) {
		List<InputPin> inputs = getActionInputs(target);
		Assert.isTrue(inputs.size() == 1);
		return getSourceAction(inputs.get(0));
	}

	public static Action getTargetAction(ObjectNode target) {
		ObjectNode targetPin = getTarget(target);
		if (targetPin == null)
			return null;
		Action targetAction = (Action) targetPin.getOwner();
		// skip casts as they provide no value
		return isCast(targetAction) ? getTargetAction(targetAction) : targetAction;
	}

	public static Action getTargetAction(Action source) {
		List<OutputPin> outputs = getActionOutputs(source);
		Assert.isTrue(outputs.size() == 1);
		return getTargetAction(outputs.get(0));
	}

	public static ValueSpecification buildBehaviorReference(Package parent, Activity activity, Type type) {
		OpaqueExpression expression = (OpaqueExpression) parent.createPackagedElement(null,
				IRepository.PACKAGE.getOpaqueExpression());
		expression.setBehavior(activity);
		expression.setType(type == null ? activity : type);
		return expression;
	}

	public static boolean isBehaviorReference(ValueSpecification spec) {
		return spec instanceof OpaqueExpression && ((OpaqueExpression) spec).getBehavior() != null;
	}

	public static Behavior resolveBehaviorReference(ValueSpecification spec) {
		Assert.isLegal(isBehaviorReference(spec), "Not a behavior reference: " + spec);
		return ((OpaqueExpression) spec).getBehavior();
	}

	public static Behavior resolveBehaviorReference(Action action) {
		Assert.isLegal(action instanceof ValueSpecificationAction, "Not a behavior reference action: "
				+ action.eClass().getName());
		return (Activity) resolveBehaviorReference(((ValueSpecificationAction) action).getValue());
	}

	/**
	 * Returns the closure fed to the given input pin.
	 * 
	 * @param input
	 *            input pin
	 * @return the referred closure
	 */
	public static Activity getSourceClosure(InputPin input) {
		Action sourceAction = getSourceAction(input);
		Assert.isLegal(sourceAction != null, "No source action");
		return (Activity) resolveBehaviorReference(sourceAction);
	}

	public static ObjectNode getTarget(ObjectNode source) {
		final List<ActivityEdge> outgoings = source.getOutgoings();
		if (outgoings.isEmpty())
			return null;
		Assert.isLegal(outgoings.size() == 1);
		return (ObjectNode) outgoings.get(0).getTarget();
	}

	/**
	 * A way of getting an action's input pins that will work for
	 * StructuredActivityNodes.
	 */
	public static List<InputPin> getActionInputs(Action action) {
		if (action instanceof StructuredActivityNode)
			return MDDUtil.filterByClass(((StructuredActivityNode) action).getNodes(), Literals.INPUT_PIN);
		return action.getInputs();
	}

	/**
	 * A way of getting an action's output pins that will work for
	 * StructuredActivityNodes.
	 */
	public static List<OutputPin> getActionOutputs(Action action) {
		if (action instanceof StructuredActivityNode)
			return MDDUtil.filterByClass(((StructuredActivityNode) action).getNodes(), Literals.OUTPUT_PIN);
		return action.getOutputs();
	}

	public static boolean isTerminal(Action instance) {
		List<OutputPin> outputPins = getActionOutputs(instance);
		for (OutputPin current : outputPins)
			if (!current.getOutgoings().isEmpty())
				return false;
		return true;
	}

	public static void createParameterVariables(Activity activity) {
		StructuredActivityNode bodyNode = getBodyNode(activity);
		for (Parameter parameter : activity.getOwnedParameters()) {
			// variables represent the value for each input/output parameter -
			// their values will be transferred to the output pins of the
			// activity at the end
			// convention: the unnamed variable corresponds to the result value
			String varName = parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL ? "" : parameter
					.getName();
			Variable newVariable = bodyNode.createVariable(varName, null);
			TypeUtils.copyType(parameter, newVariable);
		}
	}

	/**
	 * A cast is a {@link StructuredActivityNode} with only two nodes: an input
	 * and an output. TODO an ObjectFlow would be more appropriate
	 */
	public static boolean isCast(Action nextAction) {
		if (!(nextAction instanceof StructuredActivityNode))
			return false;
		StructuredActivityNode san = (StructuredActivityNode) nextAction;
		List<ActivityNode> nodes = san.getNodes();
		return nodes.size() == 2 && nodes.get(0) instanceof InputPin && nodes.get(1) instanceof OutputPin;
	}

	public static List<Action> findStatements(StructuredActivityNode target) {
		List<Action> terminalActions = new ArrayList<Action>();
		for (ActivityNode node : target.getNodes()) {
			if (node instanceof StructuredActivityNode) {
				terminalActions.addAll(findStatements((StructuredActivityNode) node));
			} else if (node instanceof Action && ActivityUtils.isTerminal((Action) node))
				terminalActions.add((Action) node);
		}
		return terminalActions;
	}

	/**
	 * Is the action a final action (i.e. followed by an ActivityFinalNode)?
	 */
	public static boolean isFinal(Action toCheck) {
		for (ActivityEdge outgoing : toCheck.getOutgoings())
			if (outgoing.getTarget() instanceof ActivityFinalNode)
				return true;
		return false;
	}

	/** Makes an action a final action (i.e. followed by an ActivityFinalNode). */
	public static void makeFinal(StructuredActivityNode block, Action lastAction) {
		ActivityFinalNode finalNode = (ActivityFinalNode) block.createNode(null,
				UMLPackage.Literals.ACTIVITY_FINAL_NODE);
		ControlFlow controlFlow = (ControlFlow) block.createEdge(null, UMLPackage.Literals.CONTROL_FLOW);
		controlFlow.setSource(lastAction);
		controlFlow.setTarget(finalNode);
	}

	public static BehavioredClassifier getContext(Behavior behavior) {
		BehavioredClassifier standardContext = behavior.getContext();
		if (standardContext instanceof Behavior) {
			BehavioredClassifier contextsContext = getContext((Behavior) standardContext);
			if (contextsContext != null)
				return contextsContext;
		}
		if (standardContext == null && (behavior.getOwner() instanceof BehavioredClassifier))
			// bug in UML2? During a tycho build, a behavior owned by a
			// behaviored classifier would be null sometimes
			return (BehavioredClassifier) behavior.getOwner();
		return standardContext;
	}

	public static Action getFinalAction(StructuredActivityNode startingPoint) {
		ActivityFinalNode finalNode = (ActivityFinalNode) ActivityUtils.findNode(startingPoint,
				new MDDUtil.EClassMatcher(Literals.ACTIVITY_FINAL_NODE));
		if (finalNode == null)
			return null;
		return getControlSource(finalNode);
	}

	public static Activity getOwningActivity(StructuredActivityNode context) {
		if (context.getActivity() != null)
			return context.getActivity();
		if (context.getOwner() instanceof StructuredActivityNode)
			return getOwningActivity((StructuredActivityNode) context.getOwner());
		return null;
	}

	public static boolean shouldIsolate(StructuredActivityNode currentBlock) {
		boolean shouldIsolate = currentBlock.getOwner() instanceof StructuredActivityNode
				&& currentBlock.getOwner().getOwner() instanceof StructuredActivityNode
				&& currentBlock.getOwner().getOwner().getOwner() == getBodyNode(getOwningActivity(currentBlock));
		return shouldIsolate;
	}
}