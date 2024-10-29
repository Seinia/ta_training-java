package com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task1.page;

import com.epam.training.student_vladyslav_yatsevilov.web_driver.optional_task1.model.Paste1;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class PasteBinHomePage1 extends AbstractPage {
    private static final String BASE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement pasteInput;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationListBox;

    @FindBy(xpath = "//li[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement pasteExpirationListBoxItem;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement pasteButton;

    public PasteBinHomePage1(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage1 openPage(){
        driver.get(BASE_URL);
        log.info("Paste is opened.");
        return this;
    }

    public PasteBinHomePage1 createPaste(Paste1 paste){
        pasteInput.sendKeys(paste.getPasteCode());
        pasteExpirationListBox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results__option' and text()='" + paste.getPasteExpiration() + "']")));
        pasteExpirationListBoxItem.click();
        pasteName.sendKeys(paste.getPasteTitle());
        pasteButton.click();
        log.info("Paste was created.");
        return this;
    }
}

