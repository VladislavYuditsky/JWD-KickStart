package com.yuditsky.jwd.kickstart.dao;

import com.yuditsky.jwd.kickstart.bean.Oval;

public interface OvalDAO {
    Oval read() throws DAOException;

    Oval read(int id) throws DAOException;
}
