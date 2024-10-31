package com.epam.training.vladyslav_yatsevilov.final_task.step_definitions;

import com.epam.training.vladyslav_yatsevilov.final_task.page.SauceDemoDashboardPage;
import com.epam.training.vladyslav_yatsevilov.final_task.page.SauceDemoMainPage;
import com.epam.training.vladyslav_yatsevilov.infrastructure.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

public class LoginSteps {

    private WebDriver driver;
    private SauceDemoMainPage sauceDemoMainPage;
    private SauceDemoDashboardPage sauceDemoDashboardPage;

    @Before
    public void setUp(){
        driver = DriverFactory.getDriver();
    }

    @Given("browser is opened on Swag Labs login page")
    public void browser_is_opened_on_swag_labs_login_page(){
        sauceDemoMainPage = new SauceDemoMainPage(driver)
                .openPage();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password){
        sauceDemoMainPage
                .setUsername(username)
                .setPassword(password);
    }

    @And("user clicks login button")
    public void user_click_login_button(){
        sauceDemoDashboardPage = sauceDemoMainPage.clickLogin();
    }

    @Then("user should get the expected message {string}")
    public void user_should_get_the_expected_message(String expectedMessage){
        if (expectedMessage.equals("Password is required") || expectedMessage.equals("Username is required")){
            assertThat(sauceDemoMainPage.getErrorMessage()).isEqualTo(expectedMessage);
        } else {
            assertThat(sauceDemoDashboardPage.getLogoText()).isEqualTo(expectedMessage);
        }
    }

    @After
    public void stopBrowser(){
        DriverFactory.closeDriver();
    }

}
