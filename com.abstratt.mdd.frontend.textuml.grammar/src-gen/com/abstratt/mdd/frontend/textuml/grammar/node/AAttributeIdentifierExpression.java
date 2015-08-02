/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AAttributeIdentifierExpression extends PIdentifierExpression
{
    private PTarget _target_;
    private TIdentifier _identifier_;

    public AAttributeIdentifierExpression()
    {
        // Constructor
    }

    public AAttributeIdentifierExpression(
        @SuppressWarnings("hiding") PTarget _target_,
        @SuppressWarnings("hiding") TIdentifier _identifier_)
    {
        // Constructor
        setTarget(_target_);

        setIdentifier(_identifier_);

    }

    @Override
    public Object clone()
    {
        return new AAttributeIdentifierExpression(
            cloneNode(this._target_),
            cloneNode(this._identifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAttributeIdentifierExpression(this);
    }

    public PTarget getTarget()
    {
        return this._target_;
    }

    public void setTarget(PTarget node)
    {
        if(this._target_ != null)
        {
            this._target_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._target_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._target_)
            + toString(this._identifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._target_ == child)
        {
            this._target_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._target_ == oldChild)
        {
            setTarget((PTarget) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
