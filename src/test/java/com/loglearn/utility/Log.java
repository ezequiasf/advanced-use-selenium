package com.loglearn.utility;

import org.apache.log4j.Logger;

public class Log {

    public static Logger log = Logger.getLogger(Log.class.getName());

    public static void initTestCase (String nameTestCase) {
        log.info("=============="+nameTestCase+"======Test Begin============");
    }

    public static void finishTestCase (String nameTestCase) {
        log.info("=============="+nameTestCase+"======Test Ends============");
    }

    public static void info (String info) {
        log.info(info);
    }

    public static void warn (String warn) {
        log.warn(warn);
    }

    public static void error (String error) {
        log.error(error);
    }
}
