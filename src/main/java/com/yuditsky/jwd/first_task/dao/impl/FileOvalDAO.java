package com.yuditsky.jwd.first_task.dao.impl;

import com.yuditsky.jwd.first_task.bean.Oval;
import com.yuditsky.jwd.first_task.dao.DAOException;
import com.yuditsky.jwd.first_task.dao.OvalDAO;
import com.yuditsky.jwd.first_task.dao.impl.util.OvalParser;
import com.yuditsky.jwd.first_task.exception.OvalDataFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOvalDAO implements OvalDAO {
    private static final String DATA_FILE_PATH = "data/data.txt";
    private final static Logger logger = LogManager.getLogger(FileOvalDAO.class);

    @Override
    public Oval read() throws DAOException {
        Oval oval;
        OvalParser parser = OvalParser.getInstance();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            oval = parser.parseOval(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            logger.error("FileNotFound: ", e);
            throw new DAOException(e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
            throw new DAOException(e);
        } catch (OvalDataFormatException e) {
            logger.error("OvalDataFormatException: ", e);
            throw new DAOException(e);
        }

        return oval;
    }

    @Override
    public Oval read(int id) throws DAOException {
        Oval oval;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            for (int i = 0; i < id; i++) {
                bufferedReader.readLine();
            }

            OvalParser parser = OvalParser.getInstance();
            oval = parser.parseOval(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: ", e);
            throw new DAOException(e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
            throw new DAOException(e);
        } catch (OvalDataFormatException e) {
            logger.error("OvalDataFormatException: ", e);
            throw new DAOException(e);
        }

        return oval;
    }
}
