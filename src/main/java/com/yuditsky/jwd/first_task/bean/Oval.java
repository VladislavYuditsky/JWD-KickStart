package com.yuditsky.jwd.first_task.bean;

import java.util.Objects;

public class Oval {
    private Dot dot1, dot2;

    public Oval() {
    }

    public Oval(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    public Dot getDot1() {
        return dot1;
    }

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;
        return dot1.equals(oval.dot1) &&
                dot2.equals(oval.dot2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot1, dot2);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "dot1=" + dot1 +
                ", dot2=" + dot2 +
                '}';
    }
}
