/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.abstratt.mdd.frontend.textuml.grammar.node;

import java.util.*;
import com.abstratt.mdd.frontend.textuml.grammar.analysis.*;

@SuppressWarnings("nls")
public final class AOperationDecl extends POperationDecl
{
    private POperationHeader _operationHeader_;
    private final LinkedList<POperationPrecondition> _operationPrecondition_ = new LinkedList<POperationPrecondition>();
    private TSemicolon _semicolon_;
    private POptionalBehavioralFeatureBody _optionalBehavioralFeatureBody_;

    public AOperationDecl()
    {
        // Constructor
    }

    public AOperationDecl(
        @SuppressWarnings("hiding") POperationHeader _operationHeader_,
        @SuppressWarnings("hiding") List<POperationPrecondition> _operationPrecondition_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_,
        @SuppressWarnings("hiding") POptionalBehavioralFeatureBody _optionalBehavioralFeatureBody_)
    {
        // Constructor
        setOperationHeader(_operationHeader_);

        setOperationPrecondition(_operationPrecondition_);

        setSemicolon(_semicolon_);

        setOptionalBehavioralFeatureBody(_optionalBehavioralFeatureBody_);

    }

    @Override
    public Object clone()
    {
        return new AOperationDecl(
            cloneNode(this._operationHeader_),
            cloneList(this._operationPrecondition_),
            cloneNode(this._semicolon_),
            cloneNode(this._optionalBehavioralFeatureBody_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOperationDecl(this);
    }

    public POperationHeader getOperationHeader()
    {
        return this._operationHeader_;
    }

    public void setOperationHeader(POperationHeader node)
    {
        if(this._operationHeader_ != null)
        {
            this._operationHeader_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operationHeader_ = node;
    }

    public LinkedList<POperationPrecondition> getOperationPrecondition()
    {
        return this._operationPrecondition_;
    }

    public void setOperationPrecondition(List<POperationPrecondition> list)
    {
        this._operationPrecondition_.clear();
        this._operationPrecondition_.addAll(list);
        for(POperationPrecondition e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    public POptionalBehavioralFeatureBody getOptionalBehavioralFeatureBody()
    {
        return this._optionalBehavioralFeatureBody_;
    }

    public void setOptionalBehavioralFeatureBody(POptionalBehavioralFeatureBody node)
    {
        if(this._optionalBehavioralFeatureBody_ != null)
        {
            this._optionalBehavioralFeatureBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._optionalBehavioralFeatureBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._operationHeader_)
            + toString(this._operationPrecondition_)
            + toString(this._semicolon_)
            + toString(this._optionalBehavioralFeatureBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._operationHeader_ == child)
        {
            this._operationHeader_ = null;
            return;
        }

        if(this._operationPrecondition_.remove(child))
        {
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        if(this._optionalBehavioralFeatureBody_ == child)
        {
            this._optionalBehavioralFeatureBody_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._operationHeader_ == oldChild)
        {
            setOperationHeader((POperationHeader) newChild);
            return;
        }

        for(ListIterator<POperationPrecondition> i = this._operationPrecondition_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((POperationPrecondition) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        if(this._optionalBehavioralFeatureBody_ == oldChild)
        {
            setOptionalBehavioralFeatureBody((POptionalBehavioralFeatureBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
