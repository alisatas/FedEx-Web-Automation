package util;


import org.slf4j.LoggerFactory;

public class CustomLogger {

    private final Class clazz;

    public CustomLogger(Class clazz) {
        this.clazz = clazz;
    }

    public void info(String log) {
        System.out.println(log);
    }

    public void info2(String log) {
        final org.slf4j.Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(log);
    }
}
