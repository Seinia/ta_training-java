package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.test;

import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.model.Paste1;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.page.PasteBinHomePage1;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask1.service.PasteService1;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.test.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class WebDriverPastebinTest1 extends BaseTest {

    @Test(description = "PasteBin input data test")
    public void commonSearchTestResultsAreNotEmpty(){
        Paste1 paste = PasteService1.getPasteDataFromProperties();
        PasteBinHomePage1 expectedSearchResultsNumber = new PasteBinHomePage1(driver)
                .openPage()
                .createPaste(paste);

        assertNotNull(expectedSearchResultsNumber);
    }

}
