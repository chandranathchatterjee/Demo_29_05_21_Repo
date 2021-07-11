package com.inetBanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
    public static WebDriver driver1 = null;

    @Test
    public void test(){
        System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");
        driver1= new FirefoxDriver();
        driver1.manage().window().maximize();
        driver1.get("https://google.com");

    }
}
