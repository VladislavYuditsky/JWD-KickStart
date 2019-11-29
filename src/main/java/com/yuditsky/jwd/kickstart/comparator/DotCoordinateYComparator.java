package com.yuditsky.jwd.kickstart.comparator;

import com.yuditsky.jwd.kickstart.bean.Dot;

import java.util.Comparator;

public class DotCoordinateYComparator implements Comparator<Dot> {
    @Override
    public int compare(Dot o1, Dot o2) {
        return (int) (o1.getY() - o2.getY());
    }
}

