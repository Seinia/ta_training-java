package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.test;

import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.model.Paste2;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.page.PasteBinHomePage2;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.page.PasteBinSearchResults2;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.service.PasteCreator2;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.test.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class WebDriverPastebinTest2 extends BaseTest {

    @Test(description = "PasteBin input data test")
    public void commonSearchTestResultsAreNotEmpty(){
        Paste2 paste = PasteCreator2.getPasteDataFromProperties();
        PasteBinSearchResults2 expectedPage = new PasteBinHomePage2(driver)
                .openPage()
                .createPaste(paste);


        assertEquals(expectedPage.getPageTitleText(), paste.getPasteTitle());
        assertEquals(expectedPage.getPasteCode(), paste.getPasteCode());
        assertEquals(expectedPage.getPasteSyntax(), paste.getPasteSyntax());
        assertEquals(expectedPage.getPasteExpiration(), paste.getPasteExpiration());
    }

}
