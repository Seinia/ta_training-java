package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.page;

import com.epam.training.student_vladyslav_yatsevilov.infrastructure.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinSearchResults2 extends AbstractPage {


    @FindBy(xpath = "//a[@class='btn -small h_800' and text()='Bash']")
    private WebElement pasteSyntax;

    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement pasteCode;

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//div[@class='expire']")
    private WebElement pasteExpiration;

    public PasteBinSearchResults2(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(pasteTitle)).getText();
    }

    public String getPasteSyntax(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(pasteSyntax)).getText();
    }

    public String getPasteCode(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(pasteCode)).getText();
    }

    public String getPasteExpiration(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(pasteExpiration)).getText().replaceAll("MIN", "Minutes");
    }


    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This is blank page without any requests");
    }

}
