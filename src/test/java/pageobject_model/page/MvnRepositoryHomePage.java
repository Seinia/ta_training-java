package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MvnRepositoryHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://mvnrepository.com/";

    @FindBy(id = "query")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"search\"]/form/input[2]")
    private WebElement searchButton;

    public MvnRepositoryHomePage(WebDriver driver){
        super(driver);
    }

    public MvnRepositoryHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
        return this;
    }

    public SearchResultsPagePFMixed searchForTerms(String term){
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPagePFMixed(driver, term);
    }
}
