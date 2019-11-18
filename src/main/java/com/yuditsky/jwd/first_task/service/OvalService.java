package com.yuditsky.jwd.first_task.service;

public interface OvalService {

    boolean isDotsMakeAnOval(int ovalId) throws ServiceException;

    boolean isOval(int ovalId) throws ServiceException;

    boolean isCircle(int ovalId) throws ServiceException;

    double square(int ovalId) throws ServiceException;

    double perimeter(int ovalId) throws ServiceException;

    boolean intersectCheck(int ovalId, double distance) throws ServiceException;
}
