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
public class GoogleCloudChooseProductPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//button[@class='UywwFc-LgbsSe UywwFc-LgbsSe-OWXEXe-Bz112c-M1Soyc UywwFc-LgbsSe-OWXEXe-dgl2Hf xhASFc']")
    WebElement addEstimateButton;

    @FindBy(xpath = "//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf']//h2[@class='honxjf' and text()='Compute Engine']")
    WebElement computeEngineButton;

    public GoogleCloudChooseProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public GoogleCloudChooseProductPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Google cloud choose page is opened");
        return this;
    }

    public GoogleCloudCalculatorPage chooseGoogleProduct(){
        addEstimateButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(computeEngineButton)).click();
        return new GoogleCloudCalculatorPage(driver);
    }

    
}
