/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ATupleTypeSingleTypeIdentifier extends PSingleTypeIdentifier
{
    private PTupleType _tupleType_;

    public ATupleTypeSingleTypeIdentifier()
    {
        // Constructor
    }

    public ATupleTypeSingleTypeIdentifier(
        @SuppressWarnings("hiding") PTupleType _tupleType_)
    {
        // Constructor
        setTupleType(_tupleType_);

    }

    @Override
    public Object clone()
    {
        return new ATupleTypeSingleTypeIdentifier(
            cloneNode(this._tupleType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATupleTypeSingleTypeIdentifier(this);
    }

    public PTupleType getTupleType()
    {
        return this._tupleType_;
    }

    public void setTupleType(PTupleType node)
    {
        if(this._tupleType_ != null)
        {
            this._tupleType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tupleType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tupleType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tupleType_ == child)
        {
            this._tupleType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tupleType_ == oldChild)
        {
            setTupleType((PTupleType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
