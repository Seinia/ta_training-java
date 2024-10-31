package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.service;

import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.model.Paste1;
import com.epam.training.vladyslav_yatsevilov.infrastructure.util.TestDataReader;

public class PasteCreator1 {

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
