/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AClassClassType extends PClassType
{
    private TClazz _clazz_;

    public AClassClassType()
    {
        // Constructor
    }

    public AClassClassType(
        @SuppressWarnings("hiding") TClazz _clazz_)
    {
        // Constructor
        setClazz(_clazz_);

    }

    @Override
    public Object clone()
    {
        return new AClassClassType(
            cloneNode(this._clazz_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassClassType(this);
    }

    public TClazz getClazz()
    {
        return this._clazz_;
    }

    public void setClazz(TClazz node)
    {
        if(this._clazz_ != null)
        {
            this._clazz_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._clazz_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._clazz_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._clazz_ == child)
        {
            this._clazz_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._clazz_ == oldChild)
        {
            setClazz((TClazz) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
