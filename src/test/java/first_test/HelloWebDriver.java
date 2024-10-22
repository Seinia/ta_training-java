package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
        

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("query")));

        WebElement searchInput = driver.findElement(By.id("query"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id=\"search\"]/form/input[2]"));
        searchBtn.get(0).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div[1]/div[2]/div[1]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("/html/body/div/main/div[1]/div[2]/div[1]]"));
        System.out.println("Numbers of results: " + searchResults.size());

        driver.quit();

    }
}
