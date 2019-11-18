package com.yuditsky.jwd.kickstart.dao;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.dao.impl.FileOvalDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(OvalDAORunner.class)
public class OvalDAOTest {
    private static OvalDAO ovalDAO;

    @BeforeClass
    public static void initOvalService() {
        ovalDAO = new FileOvalDAO();
    }

    @Test
    public void readTest() throws DAOException {
        Dot dot1 = new Dot(1, 1);
        Dot dot2 = new Dot(2, 2);
        Oval expected = new Oval(dot1, dot2);
        Oval actual = ovalDAO.read();
        assertEquals(expected, actual);
    }

    @Test
    public void readByFirstIdTest() throws DAOException {
        Dot dot1 = new Dot(1, 2);
        Dot dot2 = new Dot(3, 4);
        Oval expected = new Oval(dot1, dot2);
        Oval actual = null;
        actual = ovalDAO.read(1);
        assertEquals(expected, actual);
    }

    @Test(expected = DAOException.class)
    public void readBySecondIdTest() throws DAOException {
        Oval expected = new Oval();
        Oval actual = ovalDAO.read(2);
        assertEquals("For id 2 wasn't exception:", expected, actual);
    }

    @Test(expected = DAOException.class)
    public void readByThirdIDTest() throws DAOException {
        Oval expected = new Oval();
        Oval actual = ovalDAO.read(3);
        assertEquals("For id 3 wasn't exception", expected, actual);
    }
}
