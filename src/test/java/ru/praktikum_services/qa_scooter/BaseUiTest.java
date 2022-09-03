package ru.praktikum_services.qa_scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;

import java.time.Duration;

public abstract class BaseUiTest {
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        webDriver.get("https://qa-scooter.praktikum-services.ru");


    }

    @After
    public void refreshPage() {
        webDriver.navigate().refresh();
    }


    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
