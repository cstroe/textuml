/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.internal.frontend.textuml.node;

import com.abstratt.mdd.internal.frontend.textuml.analysis.*;

@SuppressWarnings("nls")
public final class APortFeatureType extends PFeatureType
{
    private PPortDecl _portDecl_;

    public APortFeatureType()
    {
        // Constructor
    }

    public APortFeatureType(
        @SuppressWarnings("hiding") PPortDecl _portDecl_)
    {
        // Constructor
        setPortDecl(_portDecl_);

    }

    @Override
    public Object clone()
    {
        return new APortFeatureType(
            cloneNode(this._portDecl_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPortFeatureType(this);
    }

    public PPortDecl getPortDecl()
    {
        return this._portDecl_;
    }

    public void setPortDecl(PPortDecl node)
    {
        if(this._portDecl_ != null)
        {
            this._portDecl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._portDecl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._portDecl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._portDecl_ == child)
        {
            this._portDecl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._portDecl_ == oldChild)
        {
            setPortDecl((PPortDecl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}