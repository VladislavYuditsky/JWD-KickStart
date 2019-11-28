package com.yuditsky.jwd.kickstart.observer;

import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;
import com.yuditsky.jwd.kickstart.observer.impl.ObservableOval;
import com.yuditsky.jwd.kickstart.observer.impl.OvalParametersHolder;
import com.yuditsky.jwd.kickstart.service.impl.util.FileDataReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;

public class OvalObserverTest {
    private static final String testDataPath = "src/test/resources/testData.txt";
    private static FileDataReader fileDataReader;
    private static ObservableOval oval;
    private static OvalParametersHolder ovalParametersHolder;

    @BeforeClass
    public static void initParam() throws IOException, OvalDataFormatException {
        fileDataReader = new FileDataReader(testDataPath);
        oval = new ObservableOval(fileDataReader.read(0));
        ovalParametersHolder = new OvalParametersHolder(oval);
        oval.addObserver(ovalParametersHolder);
    }

    @Test
    public void perimeterShouldNotBeEqualAfterTheChange() {
        double perimeterBeforeChanging = ovalParametersHolder.getPerimeter();

        oval.setDot1(new DotImpl(1, 1));

        double perimeterAfterChanging = ovalParametersHolder.getPerimeter();

        assertNotEquals(perimeterBeforeChanging, perimeterAfterChanging);
    }

    @Test
    public void squareShouldNotBeEqualAfterTheChange() {
        double squareBeforeChanging = ovalParametersHolder.getSquare();

        oval.setDot1(new DotImpl(1, 0));

        double squareAfterChanging = ovalParametersHolder.getSquare();

        assertNotEquals(squareBeforeChanging, squareAfterChanging);
    }
}
