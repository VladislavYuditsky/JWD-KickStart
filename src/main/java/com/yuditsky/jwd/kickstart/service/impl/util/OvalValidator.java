package com.yuditsky.jwd.kickstart.service.impl.util;

import com.yuditsky.jwd.kickstart.exception.OvalDataFormatException;

public class OvalValidator {
    private static final OvalValidator instance = new OvalValidator();

    private OvalValidator() {
    }

    public static OvalValidator getInstance() {
        return instance;
    }

    public boolean isValid(String ovalData) {
        OvalParser ovalParser = OvalParser.getInstance();
        try {
            ovalParser.parseOval(ovalData);
        } catch (OvalDataFormatException e) {
            return false;
        }

        return true;
    }
}
