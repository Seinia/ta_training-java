package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.MvnRepositoryHomePage;


public class WebDriverMvnRepoTest {

    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test(description = "First test")
    public void commonSearchTestResultsAreNotEmpty(){
        int expectedSearchResultsNumber = new MvnRepositoryHomePage(webDriver)
                .openPage()
                .searchForTerms("selenium java")
                .countSearchResults();

        Assert.assertTrue(expectedSearchResultsNumber > 0, "True results");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        webDriver.quit();
        webDriver = null;
    }
}
