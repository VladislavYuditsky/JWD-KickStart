package com.yuditsky.jwd.kickstart.service;

import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(OvalServiceRunner.class)
public class OvalServiceTest {
    private static OvalService ovalService;

    @BeforeClass
    public static void initOvalService() {
        ovalService = new OvalServiceImpl();
    }

    @Test
    public void isDotsMakeAnOvalTrueTest() throws ServiceException {
        int ovalId = 4;
        boolean actual = ovalService.isDotsMakeAnOval(ovalId);
        assertTrue(actual);
    }

    @Test
    public void isDotsMakeAnOvalFalseTest() throws ServiceException {
        int ovalId = 5;
        boolean actual = ovalService.isDotsMakeAnOval(ovalId);
        assertFalse(actual);
    }

    @Test
    public void isOvalTrueTest() throws ServiceException {
        int ovalId = 6;
        boolean actual = ovalService.isOval(ovalId);
        assertTrue(actual);
    }

    @Test
    public void isOvalFalseTest() throws ServiceException {
        int ovalId = 7;
        boolean actual = ovalService.isOval(ovalId);
        assertFalse(actual);
    }

    @Test
    public void isCircleTrueTest() throws ServiceException {
        int ovalId = 8;
        boolean actual = ovalService.isCircle(ovalId);
        assertTrue(actual);
    }

    @Test
    public void isCircleFalseTest() throws ServiceException {
        int ovalId = 9;
        boolean actual = ovalService.isCircle(ovalId);
        assertFalse(actual);
    }

    @Test
    public void squareTest() throws ServiceException {
        int ovalId = 10;
        double actual = ovalService.square(ovalId);
        double expected = Math.pow(Math.sqrt(2), 2) * Math.PI;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void notOvalSquareTest() throws ServiceException {
        int ovalId = 11;
        double actual = ovalService.square(ovalId);
        double expected = 0;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void perimeterTest() throws ServiceException {
        int ovalId = 12;
        double actual = ovalService.perimeter(ovalId);
        double expected = 4 * ((Math.PI * Math.pow(Math.sqrt(2), 2) + Math.pow((0), 2)) / (2 * Math.sqrt(2)));

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void notOvalPerimeterTest() throws ServiceException {
        int ovalId = 13;
        double actual = ovalService.perimeter(ovalId);
        double expected = 0;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void IntersectTest() throws ServiceException {
        int ovalId = 14;
        boolean actual = ovalService.intersectCheck(ovalId, 0);
        assertFalse(actual);
    }
}
