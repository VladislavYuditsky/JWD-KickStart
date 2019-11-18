package com.yuditsky.jwd.first_task.dao;

import com.yuditsky.jwd.first_task.bean.Oval;

public interface OvalDAO {
    Oval read() throws DAOException;

    Oval read(int id) throws DAOException;
}
