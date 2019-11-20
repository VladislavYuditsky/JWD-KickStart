package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;

public class perimeterSpecification implements Specification {
    private double minPerimeter;
    private double maxPerimeter;

    public perimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Oval oval) {
        OvalService ovalService = new OvalServiceImpl();
        double perimeter = ovalService.perimeter(oval);
        return minPerimeter <= perimeter && perimeter <= maxPerimeter;
    }
}
