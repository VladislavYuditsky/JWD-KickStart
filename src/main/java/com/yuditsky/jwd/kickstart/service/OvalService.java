package com.yuditsky.jwd.kickstart.service;

import com.yuditsky.jwd.kickstart.bean.Oval;

public interface OvalService {

    boolean isDotsMakeAnOval(Oval oval) throws ServiceException;

    boolean isOval(Oval oval) throws ServiceException;

    boolean isCircle(Oval oval) throws ServiceException;

    double calculateSquare(Oval oval) throws ServiceException;

    double calculatePerimeter(Oval oval) throws ServiceException;

    boolean intersectCheck(Oval oval, double distance) throws ServiceException;
}
