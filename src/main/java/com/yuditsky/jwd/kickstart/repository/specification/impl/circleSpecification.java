package com.yuditsky.jwd.kickstart.repository.specification.impl;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.repository.specification.Specification;
import com.yuditsky.jwd.kickstart.service.OvalService;
import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;

public class circleSpecification implements Specification {
    @Override
    public boolean specify(Oval oval) {
        OvalService ovalService = new OvalServiceImpl();
        return ovalService.isCircle(oval);
    }
}
