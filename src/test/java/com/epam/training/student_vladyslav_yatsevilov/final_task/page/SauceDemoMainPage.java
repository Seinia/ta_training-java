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
public class SauceDemoMainPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://saucedemo.com/";

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public SauceDemoMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public SauceDemoMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Swag labs login page is opened");
        return this;
    }

    public SauceDemoMainPage setUsername(String username){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(usernameInput)).clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public SauceDemoMainPage setPassword(String password){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(passwordInput)).clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public SauceDemoDashboardPage clickLogin(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(loginButton)).click();
        log.info("User clicked login button");
        return new SauceDemoDashboardPage(driver);
    }

    public String getErrorMessage(){
        String message = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(errorMessage)).getText().replaceAll("Epic sadface: ", "");
        log.info("Get an error: ", message);
        return message;
    }

}
