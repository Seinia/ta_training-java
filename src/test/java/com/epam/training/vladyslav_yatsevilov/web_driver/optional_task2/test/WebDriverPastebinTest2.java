package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.test;

import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.model.Paste2;
import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.page.PasteBinHomePage2;
import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.page.PasteBinSearchResults2;
import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.service.PasteCreator2;
import com.epam.training.vladyslav_yatsevilov.infrastructure.test.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WebDriverPastebinTest2 extends BaseTest {

    @Test
    @DisplayName("PasteBin input data test")
    public void commonSearchTestResultsAreNotEmpty(){
        Paste2 paste = PasteCreator2.getPasteDataFromProperties();
        PasteBinSearchResults2 expectedPage = new PasteBinHomePage2(driver)
                .openPage()
                .createPaste(paste);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(expectedPage.getPageTitleText()).isEqualTo(paste.getPasteTitle());
        softAssertions.assertThat(expectedPage.getPasteCode()).isEqualTo(paste.getPasteCode());
        softAssertions.assertThat(expectedPage.getPasteSyntax()).isEqualTo(paste.getPasteSyntax());
        softAssertions.assertThat(expectedPage.getPasteExpiration()).isEqualTo(paste.getPasteExpiration());
    }

}
