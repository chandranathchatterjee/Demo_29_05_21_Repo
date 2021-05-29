package com.inetBanking.testCases;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, AWTException {
        LoginPage lp=new LoginPage(driver);
        lp.setTxtUserName(userName);
        logger.info("User name sent");
        lp.setTxtPassword(password);
        logger.info("Password sent");
        lp.clickSubmit();
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else{
            captureScreen("loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
//            Select objselect = new Select(driver.findElement(By.id("search-box")));
//            objselect.
        }
    }
}
