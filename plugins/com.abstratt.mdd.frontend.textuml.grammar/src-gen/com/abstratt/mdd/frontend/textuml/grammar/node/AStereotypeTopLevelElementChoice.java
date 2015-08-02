/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AStereotypeTopLevelElementChoice extends PTopLevelElementChoice
{
    private PStereotypeDef _stereotypeDef_;

    public AStereotypeTopLevelElementChoice()
    {
        // Constructor
    }

    public AStereotypeTopLevelElementChoice(
        @SuppressWarnings("hiding") PStereotypeDef _stereotypeDef_)
    {
        // Constructor
        setStereotypeDef(_stereotypeDef_);

    }

    @Override
    public Object clone()
    {
        return new AStereotypeTopLevelElementChoice(
            cloneNode(this._stereotypeDef_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStereotypeTopLevelElementChoice(this);
    }

    public PStereotypeDef getStereotypeDef()
    {
        return this._stereotypeDef_;
    }

    public void setStereotypeDef(PStereotypeDef node)
    {
        if(this._stereotypeDef_ != null)
        {
            this._stereotypeDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stereotypeDef_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._stereotypeDef_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._stereotypeDef_ == child)
        {
            this._stereotypeDef_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._stereotypeDef_ == oldChild)
        {
            setStereotypeDef((PStereotypeDef) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
