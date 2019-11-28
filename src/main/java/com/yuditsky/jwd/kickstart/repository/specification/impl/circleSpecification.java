package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.ServiceException;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class circleSpecification implements Specification {
    private final static Logger logger = LogManager.getLogger(OvalServiceImpl.class);

    @Override
    public boolean specify(Oval oval) {
        OvalService ovalService = new OvalServiceImpl();
        try {
            boolean result = ovalService.isCircle(oval);
            return result;
        } catch (ServiceException e) {
            logger.warn("Can't check oval for circle", e);
        }

        return false;
    }
}
