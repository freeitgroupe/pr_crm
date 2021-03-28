package com.example.demo.pages;

import com.example.demo.appmanager.HelperBase;
import org.openqa.selenium.WebDriver;

public class MainPage extends HelperBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage actionONMainPge() {
        return this;
    }
}
