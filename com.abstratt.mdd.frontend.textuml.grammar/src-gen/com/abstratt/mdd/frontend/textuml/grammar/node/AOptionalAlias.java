/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AOptionalAlias extends POptionalAlias
{
    private TAlias _alias_;
    private TIdentifier _identifier_;

    public AOptionalAlias()
    {
        // Constructor
    }

    public AOptionalAlias(
        @SuppressWarnings("hiding") TAlias _alias_,
        @SuppressWarnings("hiding") TIdentifier _identifier_)
    {
        // Constructor
        setAlias(_alias_);

        setIdentifier(_identifier_);

    }

    @Override
    public Object clone()
    {
        return new AOptionalAlias(
            cloneNode(this._alias_),
            cloneNode(this._identifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOptionalAlias(this);
    }

    public TAlias getAlias()
    {
        return this._alias_;
    }

    public void setAlias(TAlias node)
    {
        if(this._alias_ != null)
        {
            this._alias_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._alias_ = node;
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
            + toString(this._alias_)
            + toString(this._identifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._alias_ == child)
        {
            this._alias_ = null;
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
        if(this._alias_ == oldChild)
        {
            setAlias((TAlias) newChild);
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
