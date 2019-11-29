package com.yuditsky.jwd.kickstart.service.impl.util;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader {
    private String filePath;

    public FileDataReader(String filePath) {
        this.filePath = filePath;
    }

    public Oval read(int ovalId) throws IOException, OvalDataFormatException {
        String ovalData = readString(ovalId);
        OvalParser ovalParser = new OvalParser();

        return ovalParser.parseOval(ovalData);
    }

    private String readString(int id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int i = 0;
        String ovalData = null;
        while (i <= id && (ovalData = bufferedReader.readLine()) != null) {
            i++;
        }

        bufferedReader.close();

        return ovalData;
    }
}
