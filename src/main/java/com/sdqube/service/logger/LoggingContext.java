package com.sdqube.service.logger;

import org.slf4j.Logger;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:05 AM
 */
public interface LoggingContext<T> {
    void error(Logger logger, T debug, String msg, Throwable throwable);

    void error(Logger logger, T debug, String msg);

    void error(Logger logger, T debug, String format, Object... arguments);

    void debug(Logger logger, T debug, String msg);

    void debug(Logger logger, T debug, String msg, Throwable throwable);

    void debug(Logger logger, T debug, String format, Object... arguments);

    void info(Logger logger, T debug, String msg);

    void info(Logger logger, T debug, String msg, Throwable throwable);

    void warn(Logger logger, T debug, String msg);

    void warn(Logger logger, T debug, String msg, Throwable throwable);

    void warn(Logger logger, T debug, String format, Object... arguments);
}

