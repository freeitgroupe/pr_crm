package com.example.demo;

import com.example.demo.appmanager.ApplicationManager;
import com.example.demo.appmanager.HelperBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TestBase {

    protected ApplicationManager app;
    protected HelperBase hb;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        app = new ApplicationManager();
        hb = new HelperBase(app.getDriver());
        hb.init().openApplication();
        context.setAttribute("app", app);
    }

    public HelperBase app() {
        return hb.mainPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (app.driver != null) {
            app.stop();
        }
    }
}
