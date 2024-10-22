package com.epam.training.student_vladyslav_yatsevilov.infrastructure.test;

import com.epam.training.student_vladyslav_yatsevilov.infrastructure.driver.DriverSingleton;
import com.epam.training.student_vladyslav_yatsevilov.infrastructure.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}