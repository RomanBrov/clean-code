package org.robotdreams.patterns.lesson5.theory;

import java.util.logging.Level;

public interface Loggable {
    void log(Level level, String msg);

    void log(Level level, String msg, Object param1);

    void log(Level level, String msg, Object params[]);
}

