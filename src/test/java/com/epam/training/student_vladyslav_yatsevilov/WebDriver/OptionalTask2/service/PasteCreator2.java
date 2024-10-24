package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.service;

import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.model.Paste2;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.util.TestDataReader;

public class PasteCreator2 {
    private static final String TESTDATA_PASTE_CODE = "testdata.paste.code2";
    private static final String TESTDATA_PASTE_SYNTAX = "testdata.paste.syntax2";
    private static final String TESTDATA_PASTE_EXPIRATION = "testdata.paste.expiration2";
    private static final String TESTDATA_PASTE_TITLE = "testdata.paste.title2";

    public static Paste2 getPasteDataFromProperties(){
        return new Paste2(
                TestDataReader.getTestData(TESTDATA_PASTE_CODE),
                TestDataReader.getTestData(TESTDATA_PASTE_SYNTAX),
                TestDataReader.getTestData(TESTDATA_PASTE_TITLE),
                TestDataReader.getTestData(TESTDATA_PASTE_EXPIRATION)
        );
    }
}
