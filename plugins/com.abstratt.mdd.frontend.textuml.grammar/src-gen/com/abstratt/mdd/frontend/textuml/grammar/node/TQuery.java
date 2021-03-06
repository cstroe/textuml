/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TQuery extends Token
{
    public TQuery()
    {
        super.setText("query");
    }

    public TQuery(int line, int pos)
    {
        super.setText("query");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TQuery(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTQuery(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TQuery text.");
    }
}
