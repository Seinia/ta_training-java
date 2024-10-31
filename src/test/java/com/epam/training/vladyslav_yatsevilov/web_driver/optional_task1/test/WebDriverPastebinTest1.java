package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.test;

import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.model.Paste1;
import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.page.PasteBinHomePage1;
import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task1.service.PasteCreator1;
import com.epam.training.vladyslav_yatsevilov.infrastructure.test.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class WebDriverPastebinTest1 extends BaseTest {

    @Test
    @DisplayName("PasteBin input data test")
    public void commonSearchTestResultsAreNotEmpty(){
        Paste1 paste = PasteCreator1.getPasteDataFromProperties();
        PasteBinHomePage1 expectedSearchResultsNumber = new PasteBinHomePage1(driver)
                .openPage()
                .createPaste(paste);

        assertThat(expectedSearchResultsNumber).isNotNull();
    }

}
