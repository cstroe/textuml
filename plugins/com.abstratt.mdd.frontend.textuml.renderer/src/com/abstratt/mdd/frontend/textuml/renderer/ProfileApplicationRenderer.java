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
package com.abstratt.mdd.frontend.textuml.renderer;

import static com.abstratt.mdd.frontend.textuml.renderer.TextUMLRenderingUtils.qualifiedName;

import org.eclipse.uml2.uml.ProfileApplication;

import com.abstratt.mdd.modelrenderer.IEObjectRenderer;
import com.abstratt.mdd.modelrenderer.IRenderingSession;
import com.abstratt.mdd.modelrenderer.IndentedPrintWriter;

public class ProfileApplicationRenderer implements IEObjectRenderer<ProfileApplication> {

	public boolean renderObject(ProfileApplication element, IndentedPrintWriter out, IRenderingSession context) {
		out.println("apply " + qualifiedName(element.getAppliedProfile()) + ";");
		return true;
	}

}
