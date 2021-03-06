/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AOptionalDefault extends POptionalDefault
{
    private TAssignop _assignop_;
    private PLiteral _literal_;

    public AOptionalDefault()
    {
        // Constructor
    }

    public AOptionalDefault(
        @SuppressWarnings("hiding") TAssignop _assignop_,
        @SuppressWarnings("hiding") PLiteral _literal_)
    {
        // Constructor
        setAssignop(_assignop_);

        setLiteral(_literal_);

    }

    @Override
    public Object clone()
    {
        return new AOptionalDefault(
            cloneNode(this._assignop_),
            cloneNode(this._literal_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOptionalDefault(this);
    }

    public TAssignop getAssignop()
    {
        return this._assignop_;
    }

    public void setAssignop(TAssignop node)
    {
        if(this._assignop_ != null)
        {
            this._assignop_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assignop_ = node;
    }

    public PLiteral getLiteral()
    {
        return this._literal_;
    }

    public void setLiteral(PLiteral node)
    {
        if(this._literal_ != null)
        {
            this._literal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._literal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._assignop_)
            + toString(this._literal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._assignop_ == child)
        {
            this._assignop_ = null;
            return;
        }

        if(this._literal_ == child)
        {
            this._literal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._assignop_ == oldChild)
        {
            setAssignop((TAssignop) newChild);
            return;
        }

        if(this._literal_ == oldChild)
        {
            setLiteral((PLiteral) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
