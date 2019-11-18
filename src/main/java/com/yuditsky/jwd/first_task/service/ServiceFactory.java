package com.yuditsky.jwd.first_task.service;

import com.yuditsky.jwd.first_task.service.impl.OvalServiceImpl;

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
