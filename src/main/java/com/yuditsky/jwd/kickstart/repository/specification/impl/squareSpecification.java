package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;

public class squareSpecification implements Specification {
    private double minSquare;
    private double maxSquare;

    public squareSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Oval oval) {
        OvalService ovalService = new OvalServiceImpl();
        double square = ovalService.perimeter(oval);
        return minSquare <= square && square <= maxSquare;
    }
}
