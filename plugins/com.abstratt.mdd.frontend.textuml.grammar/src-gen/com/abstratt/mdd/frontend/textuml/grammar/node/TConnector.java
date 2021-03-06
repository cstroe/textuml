/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TConnector extends Token
{
    public TConnector()
    {
        super.setText("connector");
    }

    public TConnector(int line, int pos)
    {
        super.setText("connector");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TConnector(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTConnector(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TConnector text.");
    }
}
