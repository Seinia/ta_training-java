package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.test;

import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.model.ComputeEngineConfiguration;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.page.GoogleCloudCalculatorPage;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.page.GoogleCloudChooseProductPage;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.page.GoogleCloudEstimateSummaryPage;
import com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask3.service.ComputeEngineConfigurationService;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.test.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class GoogleCloudPriceCalculatorTest extends BaseTest {

    @Test(description = "Estimating cost of compute engine")
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

        SoftAssert softAssertions = new SoftAssert();

        softAssertions.assertEquals(estimateSummaryPage.getNumberOfInstances(), configuration.getNumberOfInstances());
        softAssertions.assertEquals(estimateSummaryPage.getOperatingSystem(), configuration.getOperatingSystem());
        softAssertions.assertEquals(estimateSummaryPage.getProvisioningModel(), configuration.getProvisioningModel());
        softAssertions.assertEquals(estimateSummaryPage.getMachineType(), configuration.getMachineType());
        softAssertions.assertEquals(estimateSummaryPage.getAddGPU(), String.valueOf(configuration.isAddGPU()));
        softAssertions.assertEquals(estimateSummaryPage.getGpuModel(), configuration.getGpuModel());
        softAssertions.assertEquals(estimateSummaryPage.getNumbersOfGPU(), configuration.getNumbersOfGPU());
        softAssertions.assertEquals(estimateSummaryPage.getSsdCapacity(), configuration.getSsdCapacity());
        softAssertions.assertEquals(estimateSummaryPage.getRegion(), configuration.getRegion());



    }

}