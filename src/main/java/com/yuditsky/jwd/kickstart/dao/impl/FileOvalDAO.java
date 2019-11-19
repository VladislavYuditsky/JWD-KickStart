package com.yuditsky.jwd.kickstart.dao.impl;

import com.yuditsky.jwd.kickstart.dao.DAOException;
import com.yuditsky.jwd.kickstart.dao.OvalDAO;
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
    public String read(int id) throws DAOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            int i = 0;
            String ovalData = null;
            while(i <= id && (ovalData = bufferedReader.readLine()) != null){
                i++;
            }
            return ovalData;
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: ", e);
            throw new DAOException(e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
            throw new DAOException(e);
        }
    }
}
