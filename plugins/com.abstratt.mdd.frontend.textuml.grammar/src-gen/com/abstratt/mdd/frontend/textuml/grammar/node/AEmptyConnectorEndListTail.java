/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AEmptyConnectorEndListTail extends PConnectorEndListTail
{

    public AEmptyConnectorEndListTail()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AEmptyConnectorEndListTail();
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyConnectorEndListTail(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
