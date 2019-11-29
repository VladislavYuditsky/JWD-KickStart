package com.yuditsky.jwd.kickstart.comparator;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;

import java.util.Comparator;

public class OvalDot1CoordinateXComparator implements Comparator<Oval> {
    @Override
    public int compare(Oval o1, Oval o2) {
        DotCoordinateXComparator dotCoordinateXComparator = new DotCoordinateXComparator();
        Dot oval1Dot = o1.getDot1();
        Dot oval2Dot = o2.getDot1();
        return dotCoordinateXComparator.compare(oval1Dot, oval2Dot);
    }
}
