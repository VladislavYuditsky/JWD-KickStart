package com.yuditsky.jwd.kickstart.dao.impl.util;

import com.yuditsky.jwd.kickstart.bean.Dot;
import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;

import java.util.ArrayList;
import java.util.List;

public class OvalParser {
    private static final OvalParser instance = new OvalParser();

    private OvalParser() {
    }

    public static OvalParser getInstance() {
        return instance;
    }

    public Oval parseOval(String ovalData) throws OvalDataFormatException {
        List<Double> dataNotes = parseListDouble(ovalData);

        if (dataNotes.size() != 4) {
            throw new OvalDataFormatException();
        }

        Dot dot1 = new Dot(dataNotes.get(0), dataNotes.get(1));
        Dot dot2 = new Dot(dataNotes.get(2), dataNotes.get(3));

        return new Oval(dot1, dot2);
    }

    private List<Double> parseListDouble(String ovalData) throws OvalDataFormatException {
        List<Double> dataNotes = new ArrayList<>();

        try {
            for (String dataNote : ovalData.split(" ")) {
                dataNotes.add(Double.parseDouble(dataNote));
            }
        } catch (NumberFormatException e) {
            throw new OvalDataFormatException(e);
        }

        return dataNotes;
    }
}
