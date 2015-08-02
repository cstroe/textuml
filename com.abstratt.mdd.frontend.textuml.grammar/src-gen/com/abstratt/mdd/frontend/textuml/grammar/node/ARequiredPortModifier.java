/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ARequiredPortModifier extends PPortModifier
{
    private TRequired _required_;

    public ARequiredPortModifier()
    {
        // Constructor
    }

    public ARequiredPortModifier(
        @SuppressWarnings("hiding") TRequired _required_)
    {
        // Constructor
        setRequired(_required_);

    }

    @Override
    public Object clone()
    {
        return new ARequiredPortModifier(
            cloneNode(this._required_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARequiredPortModifier(this);
    }

    public TRequired getRequired()
    {
        return this._required_;
    }

    public void setRequired(TRequired node)
    {
        if(this._required_ != null)
        {
            this._required_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._required_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._required_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._required_ == child)
        {
            this._required_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._required_ == oldChild)
        {
            setRequired((TRequired) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
