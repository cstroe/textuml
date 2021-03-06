/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ACreateParameterModifier extends PParameterModifier
{
    private TCreate _create_;

    public ACreateParameterModifier()
    {
        // Constructor
    }

    public ACreateParameterModifier(
        @SuppressWarnings("hiding") TCreate _create_)
    {
        // Constructor
        setCreate(_create_);

    }

    @Override
    public Object clone()
    {
        return new ACreateParameterModifier(
            cloneNode(this._create_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACreateParameterModifier(this);
    }

    public TCreate getCreate()
    {
        return this._create_;
    }

    public void setCreate(TCreate node)
    {
        if(this._create_ != null)
        {
            this._create_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._create_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._create_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._create_ == child)
        {
            this._create_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._create_ == oldChild)
        {
            setCreate((TCreate) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
