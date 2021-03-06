/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class ASimpleConnectorEnd extends PConnectorEnd
{
    private TIdentifier _partOrPort_;

    public ASimpleConnectorEnd()
    {
        // Constructor
    }

    public ASimpleConnectorEnd(
        @SuppressWarnings("hiding") TIdentifier _partOrPort_)
    {
        // Constructor
        setPartOrPort(_partOrPort_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleConnectorEnd(
            cloneNode(this._partOrPort_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleConnectorEnd(this);
    }

    public TIdentifier getPartOrPort()
    {
        return this._partOrPort_;
    }

    public void setPartOrPort(TIdentifier node)
    {
        if(this._partOrPort_ != null)
        {
            this._partOrPort_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._partOrPort_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._partOrPort_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._partOrPort_ == child)
        {
            this._partOrPort_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._partOrPort_ == oldChild)
        {
            setPartOrPort((TIdentifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
