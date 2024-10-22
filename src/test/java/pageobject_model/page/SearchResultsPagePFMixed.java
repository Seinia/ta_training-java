package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchResultsPagePFMixed extends AbstractPage {

    private String searchTerm;

    @FindBy(xpath = "/html/body/div/main/div[1]/div[2]/div[1]]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPagePFMixed(WebDriver driver, String searchTerm){
        super(driver);
        this.searchTerm = searchTerm;
    }

    public int countSearchResults(){
        List<WebElement> resultNumberWithSearchTerm = driver.findElements(By.xpath(""));
        System.out.println("Search results number for requested term: " + resultNumberWithSearchTerm.size());
        return resultNumberWithSearchTerm.size();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This is blank page without any requests");
    }
}
