/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AMinusArithmeticBinaryOperator extends PArithmeticBinaryOperator
{
    private TMinus _minus_;

    public AMinusArithmeticBinaryOperator()
    {
        // Constructor
    }

    public AMinusArithmeticBinaryOperator(
        @SuppressWarnings("hiding") TMinus _minus_)
    {
        // Constructor
        setMinus(_minus_);

    }

    @Override
    public Object clone()
    {
        return new AMinusArithmeticBinaryOperator(
            cloneNode(this._minus_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusArithmeticBinaryOperator(this);
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._minus_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
