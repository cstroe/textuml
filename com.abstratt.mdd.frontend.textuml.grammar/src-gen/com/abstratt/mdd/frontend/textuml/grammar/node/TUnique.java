/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TUnique extends Token
{
    public TUnique()
    {
        super.setText("unique");
    }

    public TUnique(int line, int pos)
    {
        super.setText("unique");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TUnique(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTUnique(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TUnique text.");
    }
}
