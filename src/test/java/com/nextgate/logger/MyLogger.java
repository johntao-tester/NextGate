package com.nextgate.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void makeLog(String str) {

        LOGGER.info(str);


    }
}
