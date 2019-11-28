package com.yuditsky.jwd.kickstart.bean.impl;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;

import java.util.Objects;

public class OvalImpl implements Oval {
    private Dot dot1;
    private Dot dot2;

    public OvalImpl() {
    }

    public OvalImpl(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    @Override
    public Dot getDot1() {
        return dot1;
    }

    @Override
    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    @Override
    public Dot getDot2() {
        return dot2;
    }

    @Override
    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OvalImpl oval = (OvalImpl) o;
        return dot1.equals(oval.dot1) &&
                dot2.equals(oval.dot2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot1, dot2);
    }

    @Override
    public String toString() {
        return "OvalImpl{" +
                "dot1=" + dot1 +
                ", dot2=" + dot2 +
                '}';
    }
}
