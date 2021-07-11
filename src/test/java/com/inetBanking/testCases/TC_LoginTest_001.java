package com.inetBanking.testCases;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.DashboardPage;
import com.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, AWTException {
        LoginPage lp=new LoginPage(driver);
//        lp.setTxtUserName(userName);
//        logger.info("User name sent");
//        lp.setTxtPassword(password);
//        logger.info("Password sent");
//        lp.clickSubmit();
        DashboardPage d =lp.signIn("Chandranath","developer");
        d.verifyHeader();
        d.verifyFooter();
        boolean status = d.verifyLogin("Hi Chandranath");


        if(status && driver.getTitle().equals(d.pageTitle)){
            Assert.assertTrue(true);
            logger.info("Login test passed");
            //Append the reporter log to the testNg report
            Reporter.log("Login test case passed...");
        }
        else {
            captureScreen("loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }

    }
}
