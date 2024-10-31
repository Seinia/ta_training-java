package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task3.page;

import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task3.model.ComputeEngineConfiguration;
import com.epam.training.vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

@Slf4j
public class GoogleCloudCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//input[@value='1']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//ul[@aria-label='Operating System / Software']/../..")
    private WebElement operatingSystemListBox;

    @FindBy(xpath = "//ul[@aria-label='Machine Family']/../..")
    private WebElement machineFamilyListBox;

    @FindBy(xpath = "//ul[@aria-label='Series']/../..")
    private WebElement seriesListBox;

    @FindBy(xpath = "//ul[@aria-label='Machine type']/../..")
    private WebElement machineTypeListBox;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGpuButton;

    @FindBy(xpath = "//ul[@aria-label='GPU Model']/../..")
    private WebElement gpuModelListBox;

    @FindBy(xpath = "//ul[@aria-label='Number of GPUs']/../..")
    private WebElement gpuNumberListBox;

    @FindBy(xpath = "//ul[@aria-label='Local SSD']/../..")
    private  WebElement localSsdListBox;

    @FindBy(xpath = "//ul[@aria-label='Region']/../..")
    private WebElement regionListBox;

    @FindBy(xpath = "//span[@class='FOBRw-kBDsod-Rtc0Jf FOBRw-kBDsod-Rtc0Jf-OWXEXe-M1Soyc']")
    private WebElement shareButton;

    @FindBy(xpath = "//div[text()='Service cost updated']")
    private WebElement updateCheckElement;

    @FindBy(xpath = "//span[@class='MyvX5d D0aEmf']")
    private WebElement estimatedCost;

    @FindBy(xpath = "//a[text()='Open estimate summary']")
    private WebElement openEstimateSummaryButton;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public GoogleCloudCalculatorPage openPage() {
        log.info("Google cloud calculator is opened");
        return this;
    }


    public GoogleCloudCalculatorPage setGoogleCloudConfiguration(ComputeEngineConfiguration configuration){
        setNumberOfInstances(configuration.getNumberOfInstances());
        setOperatingSystem(configuration.getOperatingSystem());
        selectProvisioningModel(configuration.getProvisioningModel());
        setMachineFamily(configuration.getMachineFamily());
        setSeries(configuration.getSeries());
        setMachineType(configuration.getMachineType());
        addGPU(configuration.isAddGPU());
        setGpuModel(configuration.getGpuModel());
        setGpuNumber(configuration.getNumbersOfGPU());
        setLocalSsd(configuration.getSsdCapacity());
        setRegion(configuration.getRegion());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(updateCheckElement));
        log.info("Compute engine configuration was filled.");
        return new GoogleCloudCalculatorPage(driver);
    }

    public GoogleCloudCalculatorPage clickShareButton(){
        shareButton.click();
        log.info("Share button was clicked");
        return this;
    }

    public GoogleCloudEstimateSummaryPage openEstimateSummaryPage(){
        String currentTab = driver.getWindowHandle();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(openEstimateSummaryButton)).click();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        return new GoogleCloudEstimateSummaryPage(driver);
    }

    public String getEstimatedCost(){
        log.info("Estimated cost was sent");
        return estimatedCost.getText();
    }


    private GoogleCloudCalculatorPage setNumberOfInstances(String number){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(numberOfInstancesInput)).clear();
        numberOfInstancesInput.sendKeys(number);
        return this;
    }

    private GoogleCloudCalculatorPage setOperatingSystem(String operatingSystem){
        return selectListBoxItem(operatingSystemListBox, operatingSystem);
    }

    private GoogleCloudCalculatorPage selectProvisioningModel(String provisioningModel){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ provisioningModel +"']"))).click();
        return this;
    }

    private GoogleCloudCalculatorPage setMachineFamily(String machineFamily){
        return selectListBoxItem(machineFamilyListBox, machineFamily);
    }

    private GoogleCloudCalculatorPage setSeries(String series){
        return selectListBoxItem(seriesListBox, series);
    }

    private GoogleCloudCalculatorPage setMachineType(String machineType){
        return selectListBoxItem(machineTypeListBox, machineType);
    }

    private GoogleCloudCalculatorPage addGPU(boolean isAddGpus) {
        scrollToElementWithOffset(addGpuButton);
        String ariaChecked = addGpuButton.getAttribute("aria-checked");
        if (isAddGpus && Objects.equals(ariaChecked, "false")) {
            addGpuButton.click();
        } else if (!isAddGpus && Objects.equals(ariaChecked, "true")) {
            addGpuButton.click();
        }
        return this;
    }

    private GoogleCloudCalculatorPage setGpuModel(String gpuModel){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(gpuModelListBox));
        return selectListBoxItem(gpuModelListBox, gpuModel);
    }

    private GoogleCloudCalculatorPage setGpuNumber(String number){
        return selectListBoxItem(gpuNumberListBox, number);
    }

    private GoogleCloudCalculatorPage setLocalSsd(String ssd){
        String optionXPath = String.format("//li[@data-value='%s' and .//span[text()='2x375 GB']]", transformStringToDataValue(ssd));
        localSsdListBox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath))).click();
        return this;
    }

    private GoogleCloudCalculatorPage setRegion(String region){
        return selectListBoxItem(regionListBox, region);
    }

    private GoogleCloudCalculatorPage selectListBoxItem(WebElement listBox, String item){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(listBox)).click();
        String SELECT_BOX_OPTION_LOCATOR = "//li[@data-value='%s']";
        String optionXPath = String.format(SELECT_BOX_OPTION_LOCATOR, transformStringToDataValue(item));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath))).click();
        return this;
    }

    private String transformStringToDataValue(String input) {
        return input.toLowerCase()
                .replaceAll("[,:;()]", "")
                .replaceAll("\\s+", "-");
    }

    private void scrollToElementWithOffset(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var elementTop = arguments[0].getBoundingClientRect().top;" +
                "window.scrollBy(0, elementTop - arguments[1]);", element, 200);
    }
}
