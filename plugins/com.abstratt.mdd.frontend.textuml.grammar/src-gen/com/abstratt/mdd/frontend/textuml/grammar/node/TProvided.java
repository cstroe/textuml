/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TProvided extends Token
{
    public TProvided()
    {
        super.setText("provided");
    }

    public TProvided(int line, int pos)
    {
        super.setText("provided");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TProvided(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTProvided(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TProvided text.");
    }
}
