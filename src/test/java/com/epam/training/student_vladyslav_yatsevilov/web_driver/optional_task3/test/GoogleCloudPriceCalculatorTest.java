package com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.test;

import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.model.ComputeEngineConfiguration;
import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.page.GoogleCloudCalculatorPage;
import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.page.GoogleCloudChooseProductPage;
import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.page.GoogleCloudEstimateSummaryPage;
import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.service.ComputeEngineConfigurationService;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.test.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleCloudPriceCalculatorTest extends BaseTest {

    @Test
    @DisplayName("Estimating cost of compute engine")
    public void testComputeEnginePriceEstimation(){
        ComputeEngineConfiguration configuration = ComputeEngineConfigurationService.getPasteDataFromProperties();
        String expectedCost = new GoogleCloudChooseProductPage(driver)
                .openPage()
                .chooseGoogleProduct()
                .setGoogleCloudConfiguration(configuration)
                .getEstimatedCost();

        String actualCost = new GoogleCloudCalculatorPage(driver)
                .clickShareButton()
                .openEstimateSummaryPage()
                .getEstimatedPrice();

        assertEquals(actualCost, expectedCost, "Estimated cost is another to expected cost");

        GoogleCloudEstimateSummaryPage estimateSummaryPage = new GoogleCloudEstimateSummaryPage(driver);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(estimateSummaryPage.getNumberOfInstances()).isEqualTo(configuration.getNumberOfInstances());
        softAssertions.assertThat(estimateSummaryPage.getOperatingSystem()).isEqualTo(configuration.getOperatingSystem());
        softAssertions.assertThat(estimateSummaryPage.getProvisioningModel()).isEqualTo(configuration.getProvisioningModel());
        softAssertions.assertThat(estimateSummaryPage.getMachineType()).isEqualTo(configuration.getMachineType());
        softAssertions.assertThat(estimateSummaryPage.getAddGPU()).isEqualTo(String.valueOf(configuration.isAddGPU()));
        softAssertions.assertThat(estimateSummaryPage.getGpuModel()).isEqualTo(configuration.getGpuModel());
        softAssertions.assertThat(estimateSummaryPage.getNumbersOfGPU()).isEqualTo(configuration.getNumbersOfGPU());
        softAssertions.assertThat(estimateSummaryPage.getSsdCapacity()).isEqualTo(configuration.getSsdCapacity());
        softAssertions.assertThat(estimateSummaryPage.getRegion()).isEqualTo(configuration.getRegion());



    }

}