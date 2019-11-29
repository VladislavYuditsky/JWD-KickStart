package com.yuditsky.jwd.kickstart.service.impl;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.ServiceException;
import com.yuditsky.jwd.kickstart.service.impl.util.GaussMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalServiceImpl implements OvalService {
    private final static Logger logger = LogManager.getLogger(OvalServiceImpl.class);

    private double distanceBetween(Dot dot1, Dot dot2) {
        return Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot2.getY(), 2));
    }

    private double[][] parseMatrix(Oval oval) {
        Dot dot1 = oval.getDot1();
        Dot dot2 = oval.getDot2();
        double x1 = dot1.getX();
        double y1 = dot1.getY();
        double x2 = dot2.getX();
        double y2 = dot2.getY();

        while (x1 == 0 || y1 == 0 || x2 == 0 || y2 == 0) {
            x1 += 1;
            y1 += 1;
            x2 += 1;
            y2 += 1;
        }

        double[][] matrix = new double[2][3];

        matrix[0][0] = Math.pow(x1, 2);
        matrix[0][1] = Math.pow(y1, 2);
        matrix[0][2] = 1;
        matrix[1][0] = Math.pow(x2, 2);
        matrix[1][1] = Math.pow(y2, 2);
        matrix[1][2] = 1;

        return matrix;
    }

    private double[] calculateOvalCenter(Oval oval) {
        double[] centerCoordinates = new double[2];
        Dot dot1 = oval.getDot1();
        Dot dot2 = oval.getDot2();
        double x1 = dot1.getX();
        double y1 = dot1.getY();
        double x2 = dot2.getX();
        double y2 = dot2.getY();

        if (x1 > x2) {
            centerCoordinates[0] = x2 + (x1 - x2) / 2;
        } else {
            centerCoordinates[0] = x1 + (x2 - x1) / 2;
        }

        if (y1 > y2) {
            centerCoordinates[1] = y2 + (y1 - y2) / 2;
        } else {
            centerCoordinates[1] = y1 + (y2 - y1) / 2;
        }

        return centerCoordinates;
    }

    private double[] takeAxises(Oval oval) throws ServiceException {
        double[] axises = new double[2];

        if (isCircle(oval)) {
            double[] centerCoordinates = calculateOvalCenter(oval);
            axises[0] = axises[1] = distanceBetween(new DotImpl(centerCoordinates[0],
                    centerCoordinates[1]), oval.getDot1());
        } else {
            GaussMethod gaussMethod = new GaussMethod();
            axises = gaussMethod.calculate(parseMatrix(oval));

            for (int i = 0; i < axises.length; i++) {
                axises[i] = Math.sqrt(1 / Math.abs(axises[i]));
            }
        }

        return axises;
    }

    private double[] intersectsX(Oval oval) throws ServiceException {
        double[] centerCoordinates = calculateOvalCenter(oval);
        double[] axises = takeAxises(oval);

        double y1 = Math.sqrt(1 - (Math.pow(centerCoordinates[0], 2) / Math.pow(axises[0], 2)) * Math.pow(axises[1], 2))
                + centerCoordinates[1];
        double y2 = -Math.sqrt(1 - (Math.pow(centerCoordinates[0], 2) / Math.pow(axises[0], 2)) * Math.pow(axises[1], 2))
                + centerCoordinates[1];

        return new double[]{y1, y2};
    }

    private double[] intersectsY(Oval oval) throws ServiceException {
        double[] centerCoordinates = calculateOvalCenter(oval);
        double[] axises = takeAxises(oval);

        double x1 = Math.sqrt(1 - (Math.pow(centerCoordinates[1], 2) / Math.pow(axises[1], 2)) * Math.pow(axises[0], 2))
                + centerCoordinates[0];
        double x2 = -Math.sqrt(1 - (Math.pow(centerCoordinates[1], 2) / Math.pow(axises[1], 2)) * Math.pow(axises[0], 2))
                + centerCoordinates[0];

        return new double[]{x1, x2};
    }

    private double squareCalc(Oval oval) throws ServiceException {
        double[] axises = takeAxises(oval);

        return axises[0] * axises[1] * Math.PI;
    }

    private double perimeterCalc(Oval oval) throws ServiceException {
        double[] axises = takeAxises(oval);
        double a = axises[0];
        double b = axises[1];

        return 4 * ((Math.PI * a * b + Math.pow((a - b), 2)) / (a + b));
    }

    @Override
    public boolean isDotsMakeAnOval(Oval oval) throws ServiceException {
        Dot dot1 = oval.getDot1();
        Dot dot2 = oval.getDot2();
        return dot1.getX() != dot2.getX() && dot1.getY() != dot2.getY();
    }

    @Override
    public boolean isOval(Oval oval) throws ServiceException {
        if (isDotsMakeAnOval(oval)) {
            double[] axis = takeAxises(oval);
            double a = axis[0];
            double b = axis[1];

            double[] centerCoordinates = calculateOvalCenter(oval);
            double x0 = centerCoordinates[0];
            double y0 = centerCoordinates[1];

            Dot dot1 = oval.getDot1();
            double x = dot1.getX();
            double y = dot1.getY();

            return Math.pow(x - x0, 2) / Math.pow(a, 2) + Math.pow(y - y0, 2) / Math.pow(b, 2) == 1;
        } else {
            return false;
        }
    }

    @Override
    public boolean isCircle(Oval oval) throws ServiceException {
        if (isDotsMakeAnOval(oval)) {
            Dot dot1 = oval.getDot1();
            Dot dot2 = oval.getDot2();
            Dot dot3 = new DotImpl(dot1.getX(), dot2.getY());

            return distanceBetween(dot1, dot3) == distanceBetween(dot2, dot3);
        } else {
            return false;
        }
    }

    @Override
    public double calculateSquare(Oval oval) throws ServiceException {
        if (isDotsMakeAnOval(oval)) {
            return squareCalc(oval);
        } else {
            return 0;
        }
    }

    @Override
    public double calculatePerimeter(Oval oval) throws ServiceException {
        if (isDotsMakeAnOval(oval)) {
            return perimeterCalc(oval);
        } else {
            return 0;
        }
    }

    @Override
    public boolean intersectCheck(Oval oval, double distance) throws ServiceException {
        if (isDotsMakeAnOval(oval)) {
            double[] intersectsX = intersectsX(oval);
            double[] intersectsY = intersectsY(oval);

            return (intersectsX[0] - intersectsX[1] == distance && intersectsY[0] - intersectsY[1] != distance)
                    || (intersectsX[0] - intersectsX[1] != distance && intersectsY[0] - intersectsY[1] == distance);
        } else {
            return false;
        }
    }
}
