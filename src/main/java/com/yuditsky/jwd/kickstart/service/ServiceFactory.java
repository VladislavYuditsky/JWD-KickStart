package com.yuditsky.jwd.kickstart.service;

import com.yuditsky.jwd.kickstart.service.impl.OvalServiceImpl;

public class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();

    private OvalService ovalServiceImpl = new OvalServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public OvalService getOvalService() {
        return ovalServiceImpl;
    }
}
