package com.yuditsky.jwd.kickstart.bean.impl;

import com.yuditsky.jwd.kickstart.bean.Dot;

import java.util.Objects;

public class DotImpl implements Dot {
    private double x;
    private double y;

    public DotImpl() {
    }

    public DotImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DotImpl dot = (DotImpl) o;
        return Double.compare(dot.x, x) == 0 &&
                Double.compare(dot.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "DotImpl{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
