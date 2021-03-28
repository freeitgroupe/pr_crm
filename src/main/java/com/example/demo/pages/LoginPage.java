package com.example.demo.pages;

import com.example.demo.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HelperBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameFieldLocator = By.xpath("//*[@id='username']");
    private final By passwordFieldLocator = By.xpath("//*[@id='password']");
//    private final By submitFormLocator = By.xpath("//button[@type='submit']"); // CORRECT LOCATOR
    private final By submitFormLocator = By.xpath("//button[@type='submitt']"); //INCORRECT LOCATOR: to fail test

    public LoginPage fillLoginForm() {
        type(usernameFieldLocator, "tomsmith");
        type(passwordFieldLocator,"SuperSecretPassword!" );
        return this;
    }

    public MainPage clickLogin() {
        click(submitFormLocator);
        return mainPage();
    }

    public MainPage login() {
        fillLoginForm();
        clickLogin();
        return mainPage();
    }
}
