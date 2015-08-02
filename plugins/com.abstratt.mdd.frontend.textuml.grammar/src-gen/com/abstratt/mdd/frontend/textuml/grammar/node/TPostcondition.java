/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class TPostcondition extends Token
{
    public TPostcondition()
    {
        super.setText("postcondition");
    }

    public TPostcondition(int line, int pos)
    {
        super.setText("postcondition");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPostcondition(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPostcondition(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TPostcondition text.");
    }
}
