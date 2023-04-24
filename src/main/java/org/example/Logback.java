package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logback {
    private static final Logger logger = LoggerFactory.getLogger(Logback.class);

    public static void iO() {
        logger.error("IOException when trying to input credentials.");
    }
    public static void nullPointer() {
        logger.error("NullPointerException when trying to input credentials.");
    }
    public static void postSuccess() {logger.info("Posting was successful.");}
    public static void postFailure() {logger.error("Posting failed.");}
    public static void navigationSuccess() {logger.info("User home page loaded.");}
    public static void navigationFailure() {logger.error("User home page not loaded correctly. Is there another Chrome window open?");}
}
