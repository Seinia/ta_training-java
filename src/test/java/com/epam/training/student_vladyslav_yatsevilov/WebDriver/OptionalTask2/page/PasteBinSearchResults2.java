package com.epam.training.student_vladyslav_yatsevilov.WebDriver.OptionalTask2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.page.AbstractPage;

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
    }

    public String getPageTitleText(){
        return pasteTitle.getText();
    }

    public String getPasteSyntax(){
        return pasteSyntax.getText();
    }

    public String getPasteCode(){
        return pasteCode.getText();
    }

    public String getPasteExpiration(){
        return pasteExpiration.getText().replaceAll("MIN", "Minutes");
    }


    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This is blank page without any requests");
    }

}
