package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.ServiceException;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class perimeterSpecification implements Specification {
    private final static Logger logger = LogManager.getLogger(OvalServiceImpl.class);

    private double minPerimeter;
    private double maxPerimeter;

    public perimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Oval oval) {
        try {
            OvalService ovalService = new OvalServiceImpl(); //фабрика
            double square = ovalService.perimeter(oval);
            return minPerimeter <= square && square <= maxPerimeter;
        } catch (ServiceException e) {
            logger.warn("Can't calculate square");
        }

        return false;
    }
}
