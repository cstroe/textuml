/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TOut extends Token
{
    public TOut()
    {
        super.setText("out");
    }

    public TOut(int line, int pos)
    {
        super.setText("out");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TOut(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTOut(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TOut text.");
    }
}
