/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TCreate extends Token
{
    public TCreate()
    {
        super.setText("create");
    }

    public TCreate(int line, int pos)
    {
        super.setText("create");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCreate(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCreate(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCreate text.");
    }
}
