package com.yuditsky.jwd.kickstart.comparator;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import com.yuditsky.jwd.kickstart.bean.impl.OvalImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class OvalDotsCoordinatesComparatorsTest {
    private static OvalDot1CoordinateXComparator ovalDot1CoordinateXComparator;
    private static OvalDot2CoordinateYComparator ovalDot2CoordinateYComparator;

    @BeforeClass
    public static void initParam(){
        ovalDot1CoordinateXComparator = new OvalDot1CoordinateXComparator();
        ovalDot2CoordinateYComparator = new OvalDot2CoordinateYComparator();
    }

    @Test
    public void OvalDot1CoordinateXEqualTest(){
        Dot dot = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot, dot);
        Oval oval2 = new OvalImpl(dot, dot);
        int expected = 0;
        int actual = ovalDot1CoordinateXComparator.compare(oval1, oval2);

        assertEquals(expected, actual);
    }

    @Test
    public void ovalDot1CoordinateXMoreTest(){
        Dot dot1 = new DotImpl(5,2);
        Dot dot2 = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot1, dot2);
        Oval oval2 = new OvalImpl(dot2, dot2);
        boolean actual = ovalDot1CoordinateXComparator.compare(oval1, oval2) > 0;

        assertTrue(actual);
    }

    @Test
    public void ovalDot1CoordinateXLessTest(){
        Dot dot1 = new DotImpl(-5,2);
        Dot dot2 = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot1, dot2);
        Oval oval2 = new OvalImpl(dot2, dot2);
        boolean actual = ovalDot1CoordinateXComparator.compare(oval1, oval2) < 0;

        assertTrue(actual);
    }

    @Test
    public void OvalDot2Coordinate2EqualTest(){
        Dot dot = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot, dot);
        Oval oval2 = new OvalImpl(dot, dot);
        int expected = 0;
        int actual = ovalDot2CoordinateYComparator.compare(oval1, oval2);

        assertEquals(expected, actual);
    }

    @Test
    public void ovalDot2CoordinateYMoreTest(){
        Dot dot1 = new DotImpl(5,10);
        Dot dot2 = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot1, dot1);
        Oval oval2 = new OvalImpl(dot2, dot2);
        boolean actual = ovalDot2CoordinateYComparator.compare(oval1, oval2) > 0;

        assertTrue(actual);
    }

    @Test
    public void ovalDot2CoordinateYLessTest(){
        Dot dot1 = new DotImpl(-5,-2);
        Dot dot2 = new DotImpl(1,2);
        Oval oval1 = new OvalImpl(dot1, dot1);
        Oval oval2 = new OvalImpl(dot2, dot2);
        boolean actual = ovalDot2CoordinateYComparator.compare(oval1, oval2) < 0;

        assertTrue(actual);
    }
}
