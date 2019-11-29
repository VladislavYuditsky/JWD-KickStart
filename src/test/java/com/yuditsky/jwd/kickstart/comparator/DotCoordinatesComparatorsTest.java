package com.yuditsky.jwd.kickstart.comparator;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DotCoordinatesComparatorsTest {
    private static DotCoordinateXComparator dotCoordinateXComparator;
    private static DotCoordinateYComparator dotCoordinateYComparator;

    @BeforeClass
    public static void initParam(){
        dotCoordinateXComparator = new DotCoordinateXComparator();
        dotCoordinateYComparator = new DotCoordinateYComparator();
    }

    @Test
    public void DotCoordinateXEqualTest(){
        Dot dot1 = new DotImpl(1, 2);
        Dot dot2 = new DotImpl(1, 0);
        int actual = dotCoordinateXComparator.compare(dot1, dot2);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void DotCoordinateXMoreTest(){
        Dot dot1 = new DotImpl(5, 0);
        Dot dot2 = new DotImpl(1, 0);
        boolean actual = dotCoordinateXComparator.compare(dot1, dot2) > 0;

        assertTrue(actual);
    }

    @Test
    public void DotCoordinateXLessTest(){
        Dot dot1 = new DotImpl(-5, 0);
        Dot dot2 = new DotImpl(1, 0);
        boolean actual = dotCoordinateXComparator.compare(dot1, dot2) < 0;

        assertTrue(actual);
    }

    @Test
    public void DotCoordinateYEqualTest(){
        Dot dot1 = new DotImpl(1, 0);
        Dot dot2 = new DotImpl(1, 0);
        int actual = dotCoordinateYComparator.compare(dot1, dot2);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void DotCoordinateYMoreTest(){
        Dot dot1 = new DotImpl(5, 10);
        Dot dot2 = new DotImpl(1, 0);
        boolean actual = dotCoordinateYComparator.compare(dot1, dot2) > 0;

        assertTrue(actual);
    }

    @Test
    public void DotCoordinateYLessTest(){
        Dot dot1 = new DotImpl(-5, -1);
        Dot dot2 = new DotImpl(1, 0);
        boolean actual = dotCoordinateYComparator.compare(dot1, dot2) < 0;

        assertTrue(actual);
    }
}
