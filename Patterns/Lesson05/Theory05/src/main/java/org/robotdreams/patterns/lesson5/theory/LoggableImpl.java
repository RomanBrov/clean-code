package org.robotdreams.patterns.lesson5.theory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggableImpl implements Loggable {

    private static final Logger LOGGER = Logger.getLogger(LoggableImpl.class.getName());

    @Override
    public void log(Level level, String msg) {
        LOGGER.log(level, msg);
    }

    @Override
    public void log(Level level, String msg, Object param1) {
        LOGGER.log(level, msg, param1);
    }

    @Override
    public void log(Level level, String msg, Object[] params) {
        LOGGER.log(level, msg, params);
    }
}
