package com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task3.page;

import com.epam.training.student_vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
public class GoogleCloudEstimateSummaryPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='Total estimated cost']/following-sibling::div[@class='n8xu5 Nh2Phe D0aEmf']")
    private WebElement estimatedPrice;

    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::span[@class='Kfvdz']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::span[@class='Kfvdz']")
    private WebElement operatingSystem;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::span[@class='Kfvdz']")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::span[@class='Kfvdz']")
    private WebElement machineType;

    @FindBy(xpath = "//span[text()='Add GPUs']/following-sibling::span[@class='Kfvdz']")
    private WebElement addGPU;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span[@class='Kfvdz']")
    private WebElement gpuModel;

    @FindBy(xpath = "//span[text()='Number of GPUs']/following-sibling::span[@class='Kfvdz']")
    private WebElement numbersOfGPU;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span[@class='Kfvdz']")
    private WebElement ssdCapacity;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::span[@class='Kfvdz']")
    private WebElement region;

    public GoogleCloudEstimateSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public GoogleCloudEstimateSummaryPage openPage() {
        log.info("Google cloud estimate summary page is opened");
        return this;
    }

    public String getEstimatedPrice() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(estimatedPrice)).getText();
    }

    public String getNumberOfInstances() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(numberOfInstances)).getText();
    }

    public String getOperatingSystem() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(operatingSystem)).getText();
    }

    public String getProvisioningModel() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(operatingSystem)).getText();
    }

    public String getMachineType() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(machineType)).getText();
    }

    public String getAddGPU() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(addGPU)).getText();
    }

    public String getGpuModel() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(gpuModel)).getText();
    }

    public String getNumbersOfGPU() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(numbersOfGPU)).getText();
    }

    public String getSsdCapacity() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(ssdCapacity)).getText();
    }

    public String getRegion() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(region)).getText();
    }
}
