package com.example.demo.appmanager;

import com.example.demo.pages.LoginPage;
import com.example.demo.pages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HelperBase extends ApplicationManager {
    public WebDriver driver;

    private MainPage mainPage;
    private LoginPage loginPage;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return driver;
    }

    public HelperBase init() {
        errorList = new ArrayList<>();
        return this;
    }

    public LoginPage openApplication() {
        open("http://the-internet.herokuapp.com/login");
        return loginPage();
    }

    public MainPage mainPage() {
        return mainPage == null ? new MainPage(driver) : mainPage;
    }

    public LoginPage loginPage() {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    @Step("Navigating to '{url}'")
    public void open(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void isClickable(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Click")
    public void click(By locator) {
        isClickable(locator);
        find(locator).click();
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    @Step("Clear text from the field")
    public void clear(By locator) {
        isClickable(locator);
        find(locator).clear();
    }

    @Step("Type into field")
    public void type(By locator, String text) {
        clear(locator);
        if (!getText(locator).equals(text)) {
            clear(locator);
            find(locator).sendKeys(text);
        }
    }

    public void select(By locator, String val) {
        isClickable(locator);
        new Select((WebElement) locator).selectByVisibleText(val);
    }
}
