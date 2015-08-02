/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AEnumerationLiteralDecl extends PEnumerationLiteralDecl
{
    private TEnumerationLiteral _enumerationLiteral_;
    private TIdentifier _identifier_;
    private PEnumerationLiteralSlotValues _enumerationLiteralSlotValues_;
    private TSemicolon _semicolon_;

    public AEnumerationLiteralDecl()
    {
        // Constructor
    }

    public AEnumerationLiteralDecl(
        @SuppressWarnings("hiding") TEnumerationLiteral _enumerationLiteral_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PEnumerationLiteralSlotValues _enumerationLiteralSlotValues_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setEnumerationLiteral(_enumerationLiteral_);

        setIdentifier(_identifier_);

        setEnumerationLiteralSlotValues(_enumerationLiteralSlotValues_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new AEnumerationLiteralDecl(
            cloneNode(this._enumerationLiteral_),
            cloneNode(this._identifier_),
            cloneNode(this._enumerationLiteralSlotValues_),
            cloneNode(this._semicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEnumerationLiteralDecl(this);
    }

    public TEnumerationLiteral getEnumerationLiteral()
    {
        return this._enumerationLiteral_;
    }

    public void setEnumerationLiteral(TEnumerationLiteral node)
    {
        if(this._enumerationLiteral_ != null)
        {
            this._enumerationLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enumerationLiteral_ = node;
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

    public PEnumerationLiteralSlotValues getEnumerationLiteralSlotValues()
    {
        return this._enumerationLiteralSlotValues_;
    }

    public void setEnumerationLiteralSlotValues(PEnumerationLiteralSlotValues node)
    {
        if(this._enumerationLiteralSlotValues_ != null)
        {
            this._enumerationLiteralSlotValues_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enumerationLiteralSlotValues_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._enumerationLiteral_)
            + toString(this._identifier_)
            + toString(this._enumerationLiteralSlotValues_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._enumerationLiteral_ == child)
        {
            this._enumerationLiteral_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._enumerationLiteralSlotValues_ == child)
        {
            this._enumerationLiteralSlotValues_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._enumerationLiteral_ == oldChild)
        {
            setEnumerationLiteral((TEnumerationLiteral) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._enumerationLiteralSlotValues_ == oldChild)
        {
            setEnumerationLiteralSlotValues((PEnumerationLiteralSlotValues) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
