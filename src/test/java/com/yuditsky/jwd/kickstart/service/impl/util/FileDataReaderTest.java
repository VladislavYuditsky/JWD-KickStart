package com.yuditsky.jwd.kickstart.service.impl.util;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import com.yuditsky.jwd.kickstart.bean.impl.OvalImpl;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileDataReaderTest {
    private static FileDataReader fileDataReader;
    private static final String testDataPath = "src/test/resources/testData.txt";

    @BeforeClass
    public static void initParam() {
        fileDataReader = new FileDataReader(testDataPath);
    }

    @Test
    public void readByZeroIdTest() throws IOException, OvalDataFormatException {
        Dot dot1 = new DotImpl(1, 2);
        Dot dot2 = new DotImpl(3, 4);
        Oval expected = new OvalImpl(dot1, dot2);
        Oval actual = fileDataReader.read(0);
        assertEquals(expected, actual);
    }

    @Test(expected = OvalDataFormatException.class)
    public void readByFirstIdTest() throws IOException, OvalDataFormatException {
        Oval actual = fileDataReader.read(1);
    }
}
