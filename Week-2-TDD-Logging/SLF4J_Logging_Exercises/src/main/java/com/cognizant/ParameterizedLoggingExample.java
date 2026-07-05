package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String employeeName = "Sri Lakshmi";
        int employeeId = 5037;

        logger.info("Employee {} logged in successfully.", employeeName);

        logger.warn("Employee {} attempted login {} times.",
                employeeName, 3);

        logger.error("Employee ID {} encountered an error.",
                employeeId);
    }
}