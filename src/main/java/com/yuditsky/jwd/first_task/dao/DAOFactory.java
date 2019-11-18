package com.yuditsky.jwd.first_task.dao;

import com.yuditsky.jwd.first_task.dao.impl.FileOvalDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final OvalDAO ovalDAOImpl = new FileOvalDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public OvalDAO getOvalDAO() {
        return ovalDAOImpl;
    }

}
