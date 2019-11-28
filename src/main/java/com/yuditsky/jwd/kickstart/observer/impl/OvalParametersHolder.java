package com.yuditsky.jwd.kickstart.observer.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.observer.Observer;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.ServiceException;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalParametersHolder implements Observer<Oval> {
    private final static Logger logger = LogManager.getLogger(OvalParametersHolder.class);

    private double square;
    private double perimeter;
    //private final OvalService ovalService = new OvalServiceImpl();//фабрика

    public OvalParametersHolder(Oval oval) {
        OvalService ovalService = new OvalServiceImpl(); //фабрика
        double square = 0;
        double perimeter = 0;
        try {
            square = ovalService.square(oval);//rename meth
            perimeter = ovalService.perimeter(oval);
        } catch (ServiceException e) {
            logger.warn("Can't calculate square/perimeter", e);
        }

        this.square = square;
        this.perimeter = perimeter;
    }

    public OvalParametersHolder(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public void handleEvent(Oval oval) {
        try {
            OvalService ovalService = new OvalServiceImpl(); //фабрика
            perimeter = ovalService.perimeter(oval);
            square = ovalService.square(oval);
        } catch (ServiceException e) {
            logger.warn("Can't calculate square/perimeter", e);
        }
    }
}
