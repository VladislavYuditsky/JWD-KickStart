package com.yuditsky.jwd.kickstart.service;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import com.yuditsky.jwd.kickstart.service.impl.util.FileDataReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(OvalServiceRunner.class)
public class OvalServiceTest {
    private static final String testDataPath = "src/test/resources/testData.txt";
    private static OvalService ovalService;//фабрика
    private static FileDataReader fileDataReader;

    @BeforeClass
    public static void initParam() {
        ovalService = new OvalServiceImpl();
        fileDataReader = new FileDataReader(testDataPath);
    }

    @Test
    public void isDotsMakeAnOvalTrueTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(2);
        boolean actual = ovalService.isDotsMakeAnOval(oval);
        assertTrue(actual);
    }

    @Test
    public void isDotsMakeAnOvalFalseTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(3);
        boolean actual = ovalService.isDotsMakeAnOval(oval);
        assertFalse(actual);
    }

    @Test
    public void isOvalTrueTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(4);
        boolean actual = ovalService.isOval(oval);
        assertTrue(actual);
    }

    @Test
    public void isOvalFalseTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(5);
        boolean actual = ovalService.isOval(oval);
        assertFalse(actual);
    }

    @Test
    public void isCircleTrueTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(6);
        boolean actual = ovalService.isCircle(oval);
        assertTrue(actual);
    }

    @Test
    public void isCircleFalseTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(7);
        boolean actual = ovalService.isCircle(oval);
        assertFalse(actual);
    }

    @Test
    public void squareTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(8);
        double actual = ovalService.calculateSquare(oval);
        double expected = Math.pow(Math.sqrt(2), 2) * Math.PI;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void notOvalSquareTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(9);
        double actual = ovalService.calculateSquare(oval);
        double expected = 0;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void perimeterTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(10);
        double actual = ovalService.calculatePerimeter(oval);
        double expected = 4 * ((Math.PI * Math.pow(Math.sqrt(2), 2) + Math.pow((0), 2)) / (2 * Math.sqrt(2)));

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void notOvalPerimeterTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(11);
        double actual = ovalService.calculatePerimeter(oval);
        double expected = 0;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void intersectTest() throws ServiceException, IOException, OvalDataFormatException {
        Oval oval = fileDataReader.read(12);
        boolean actual = ovalService.intersectCheck(oval, 0);
        assertFalse(actual);
    }
}
