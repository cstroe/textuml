/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AClassOperationIdentifierExpression extends PIdentifierExpression
{
    private PMinimalTypeIdentifier _minimalTypeIdentifier_;
    private THash _hash_;
    private TIdentifier _identifier_;
    private TLParen _lParen_;
    private PExpressionList _expressionList_;
    private TRParen _rParen_;

    public AClassOperationIdentifierExpression()
    {
        // Constructor
    }

    public AClassOperationIdentifierExpression(
        @SuppressWarnings("hiding") PMinimalTypeIdentifier _minimalTypeIdentifier_,
        @SuppressWarnings("hiding") THash _hash_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") TLParen _lParen_,
        @SuppressWarnings("hiding") PExpressionList _expressionList_,
        @SuppressWarnings("hiding") TRParen _rParen_)
    {
        // Constructor
        setMinimalTypeIdentifier(_minimalTypeIdentifier_);

        setHash(_hash_);

        setIdentifier(_identifier_);

        setLParen(_lParen_);

        setExpressionList(_expressionList_);

        setRParen(_rParen_);

    }

    @Override
    public Object clone()
    {
        return new AClassOperationIdentifierExpression(
            cloneNode(this._minimalTypeIdentifier_),
            cloneNode(this._hash_),
            cloneNode(this._identifier_),
            cloneNode(this._lParen_),
            cloneNode(this._expressionList_),
            cloneNode(this._rParen_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassOperationIdentifierExpression(this);
    }

    public PMinimalTypeIdentifier getMinimalTypeIdentifier()
    {
        return this._minimalTypeIdentifier_;
    }

    public void setMinimalTypeIdentifier(PMinimalTypeIdentifier node)
    {
        if(this._minimalTypeIdentifier_ != null)
        {
            this._minimalTypeIdentifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minimalTypeIdentifier_ = node;
    }

    public THash getHash()
    {
        return this._hash_;
    }

    public void setHash(THash node)
    {
        if(this._hash_ != null)
        {
            this._hash_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._hash_ = node;
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

    public TLParen getLParen()
    {
        return this._lParen_;
    }

    public void setLParen(TLParen node)
    {
        if(this._lParen_ != null)
        {
            this._lParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lParen_ = node;
    }

    public PExpressionList getExpressionList()
    {
        return this._expressionList_;
    }

    public void setExpressionList(PExpressionList node)
    {
        if(this._expressionList_ != null)
        {
            this._expressionList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionList_ = node;
    }

    public TRParen getRParen()
    {
        return this._rParen_;
    }

    public void setRParen(TRParen node)
    {
        if(this._rParen_ != null)
        {
            this._rParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rParen_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._minimalTypeIdentifier_)
            + toString(this._hash_)
            + toString(this._identifier_)
            + toString(this._lParen_)
            + toString(this._expressionList_)
            + toString(this._rParen_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._minimalTypeIdentifier_ == child)
        {
            this._minimalTypeIdentifier_ = null;
            return;
        }

        if(this._hash_ == child)
        {
            this._hash_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._lParen_ == child)
        {
            this._lParen_ = null;
            return;
        }

        if(this._expressionList_ == child)
        {
            this._expressionList_ = null;
            return;
        }

        if(this._rParen_ == child)
        {
            this._rParen_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._minimalTypeIdentifier_ == oldChild)
        {
            setMinimalTypeIdentifier((PMinimalTypeIdentifier) newChild);
            return;
        }

        if(this._hash_ == oldChild)
        {
            setHash((THash) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._lParen_ == oldChild)
        {
            setLParen((TLParen) newChild);
            return;
        }

        if(this._expressionList_ == oldChild)
        {
            setExpressionList((PExpressionList) newChild);
            return;
        }

        if(this._rParen_ == oldChild)
        {
            setRParen((TRParen) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
