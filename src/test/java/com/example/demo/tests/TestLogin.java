package com.example.demo.tests;

import com.example.demo.TestBase;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {


    @Test
    public void testLogin() {
        app()
                .openApplication()
                .login()
                .actionONMainPge();
    }
}
