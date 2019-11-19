package com.yuditsky.jwd.kickstart.dao;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.dao.impl.FileOvalDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(OvalDAORunner.class)
public class OvalDAOTest {
    private static OvalDAO ovalDAO;

    @BeforeClass
    public static void initOvalService() {
        ovalDAO = new FileOvalDAO();
    }

    @Test
    public void readByZeroIdTest() throws DAOException {
        String expected = "1 2 3 4";
        String actual = ovalDAO.read(0);
        assertEquals(expected, actual);
    }

    @Test
    public void readByFirstIdTest() throws DAOException {
        String expected = "abcd";
        String actual = ovalDAO.read(1);
        assertEquals(expected, actual);
    }

    @Test
    public void readByNegativeIdTest() throws DAOException {
        String actual = ovalDAO.read(-1);
        assertNull(actual);
    }
}
