package com.yuditsky.jwd.kickstart.service.impl.util;

import com.yuditsky.jwd.kickstart.bean.Oval;
import com.yuditsky.jwd.kickstart.bean.impl.DotImpl;
import com.yuditsky.jwd.kickstart.bean.impl.OvalImpl;
import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;

import java.util.ArrayList;
import java.util.List;

public class OvalParser {
    public Oval parseOval(String ovalData) throws OvalDataFormatException {
        List<Double> dataNotes = parseListDouble(ovalData);

        if (dataNotes.size() != 4) {
            throw new OvalDataFormatException();
        }

        DotImpl dotImpl1 = new DotImpl(dataNotes.get(0), dataNotes.get(1));
        DotImpl dotImpl2 = new DotImpl(dataNotes.get(2), dataNotes.get(3));

        return new OvalImpl(dotImpl1, dotImpl2);
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
