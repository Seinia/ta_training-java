package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.service;

import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.model.Paste1;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.util.TestDataReader;

public class PasteService1 {

    private static final String TESTDATA_PASTE_CODE = "testdata.paste.code";
    private static final String TESTDATA_PASTE_EXPIRATION = "testdata.paste.expiration";
    private static final String TESTDATA_PASTE_TITLE = "testdata.paste.title";

    public static Paste1 getPasteDataFromProperties(){
        return new Paste1(
                TestDataReader.getTestData(TESTDATA_PASTE_CODE),
                TestDataReader.getTestData(TESTDATA_PASTE_TITLE),
                TestDataReader.getTestData(TESTDATA_PASTE_EXPIRATION)
        );
    }

}
