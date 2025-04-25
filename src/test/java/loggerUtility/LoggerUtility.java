package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
    private static final Logger logger = LogManager.getLogger();

    public static void startTest(String testName){
        logger.info("===== Execution started: " + testName + " =====");
    }

    public static void finishTest(String testName){
        logger.info("===== Execution finished: " + testName + " =====");
    }

    public static void infoTest(String testMessage){
        logger.info(testMessage);
    }
}
