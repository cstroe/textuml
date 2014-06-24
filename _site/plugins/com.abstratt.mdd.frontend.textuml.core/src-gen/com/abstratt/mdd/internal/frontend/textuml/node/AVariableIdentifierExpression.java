/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.internal.frontend.textuml.node;

import com.abstratt.mdd.internal.frontend.textuml.analysis.*;

@SuppressWarnings("nls")
public final class AVariableIdentifierExpression extends PIdentifierExpression
{
    private PVariableAccess _variableAccess_;

    public AVariableIdentifierExpression()
    {
        // Constructor
    }

    public AVariableIdentifierExpression(
        @SuppressWarnings("hiding") PVariableAccess _variableAccess_)
    {
        // Constructor
        setVariableAccess(_variableAccess_);

    }

    @Override
    public Object clone()
    {
        return new AVariableIdentifierExpression(
            cloneNode(this._variableAccess_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableIdentifierExpression(this);
    }

    public PVariableAccess getVariableAccess()
    {
        return this._variableAccess_;
    }

    public void setVariableAccess(PVariableAccess node)
    {
        if(this._variableAccess_ != null)
        {
            this._variableAccess_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variableAccess_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._variableAccess_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._variableAccess_ == child)
        {
            this._variableAccess_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._variableAccess_ == oldChild)
        {
            setVariableAccess((PVariableAccess) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}