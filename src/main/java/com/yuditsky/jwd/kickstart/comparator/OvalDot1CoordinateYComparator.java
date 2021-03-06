package com.yuditsky.jwd.kickstart.comparator;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;

import java.util.Comparator;

public class OvalDot1CoordinateYComparator implements Comparator<Oval> {
    @Override
    public int compare(Oval o1, Oval o2) {
        DotCoordinateYComparator dotCoordinateYComparator = new DotCoordinateYComparator();
        Dot oval1Dot = o1.getDot1();
        Dot oval2Dot = o2.getDot1();
        return dotCoordinateYComparator.compare(oval1Dot, oval2Dot);
    }
}
