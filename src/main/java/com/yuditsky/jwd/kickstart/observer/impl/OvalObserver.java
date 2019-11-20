package com.yuditsky.jwd.kickstart.observer.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.observer.Observer;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;

public class OvalObserver implements Observer {
    private double square;
    private double perimeter;

    @Override
    public void handleEvent(Oval oval) {
        OvalService ovalService = new OvalServiceImpl();

        square = ovalService.square(oval);
        perimeter = ovalService.perimeter(oval);
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
