package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.ServiceException;
import com.yuditsky.jwd.kickstart.service.ServiceFactory;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class squareSpecification implements Specification {
    private final static Logger logger = LogManager.getLogger(OvalServiceImpl.class);

    private double minSquare;
    private double maxSquare;

    public squareSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Oval oval) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OvalService ovalService = serviceFactory.getOvalService();
        try {
            double square = ovalService.calculateSquare(oval);
            return minSquare <= square && square <= maxSquare;
        } catch (ServiceException e) {
            logger.warn("Can't calculate square");
        }

        return false;
    }
}
