/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TAlias extends Token
{
    public TAlias()
    {
        super.setText("alias");
    }

    public TAlias(int line, int pos)
    {
        super.setText("alias");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAlias(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAlias(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAlias text.");
    }
}
