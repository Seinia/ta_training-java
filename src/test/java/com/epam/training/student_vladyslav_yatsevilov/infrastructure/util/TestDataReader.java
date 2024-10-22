package com.epam.training.student_vladyslav_yatsevilov.infrastructure.util;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env", "main"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}