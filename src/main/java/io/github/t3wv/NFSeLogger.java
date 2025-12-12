package io.github.t3wv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface NFSeLogger {
    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
