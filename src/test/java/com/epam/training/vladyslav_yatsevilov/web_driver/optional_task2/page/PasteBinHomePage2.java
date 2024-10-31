package com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.page;

import com.epam.training.vladyslav_yatsevilov.web_driver.optional_task2.model.Paste2;
import com.epam.training.vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
public class PasteBinHomePage2 extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement pasteInput;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingListBox;

    @FindBy(xpath = "//li[@class='select2-results__option' and text()='Bash']")
    private WebElement syntaxHighlightingListBoxItem;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationListBox;

    @FindBy(xpath = "//li[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement pasteExpirationListBoxItem;


    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement pasteButton;

    public PasteBinHomePage2(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage2 openPage(){
        driver.get(HOMEPAGE_URL);
        log.info("Pastebin is opened");
        return this;
    }

    public PasteBinSearchResults2 createPaste(Paste2 paste){
        pasteInput.sendKeys(paste.getPasteCode());
        syntaxHighlightingListBox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results__option' and text()='" + paste.getPasteSyntax() + "']")));
        syntaxHighlightingListBoxItem.click();
        pasteExpirationListBox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results__option' and text()='" + paste.getPasteExpiration() +"']")));
        pasteExpirationListBoxItem.click();
        pasteName.sendKeys(paste.getPasteTitle());
        pasteButton.click();
        log.info("Paste was created.");
        return new PasteBinSearchResults2(driver);
    }
}

