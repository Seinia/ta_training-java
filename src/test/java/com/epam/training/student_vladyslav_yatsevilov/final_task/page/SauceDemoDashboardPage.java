package com.epam.training.student_vladyslav_yatsevilov.final_task.page;

import com.epam.training.student_vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SauceDemoDashboardPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement logo;

    @Override
    public SauceDemoDashboardPage openPage() {
        log.info("Swag labs dashboard is opened");
        return this;
    }

    public SauceDemoDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLogoText(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(logo)).getText();
    }
}
