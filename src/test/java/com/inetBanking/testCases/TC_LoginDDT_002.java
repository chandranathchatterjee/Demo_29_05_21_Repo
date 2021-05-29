package com.inetBanking.testCases;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class TC_LoginDDT_002 extends BaseClass {

    @Test(dataProvider = "LoginData",description = "Verify login functionality with data driven test",groups = "Regression")
    public void loginDDT(String user,String password) throws IOException, AWTException {
        LoginPage lp= new LoginPage(driver);
        lp.setTxtUserName(user);
        logger.info("User name provided");
        lp.setTxtPassword(password);
        logger.info("Password provided");
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) lp.btnLogin));

        Wait wait1 = new FluentWait(driver).pollingEvery(Duration.ofSeconds(10)).withTimeout(Duration.ofSeconds(60)).ignoring(Exception.class);

        driver.findElement((By) lp.btnLogin).click();
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(false);
        softassert.assertEquals("true","");
        lp.clickSubmit();
        if(isAlertPresent()==true){
            captureScreen("loginDDT");
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();

            Assert.assertTrue(false);
            logger.warn("Login failed");

        }
        else{
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.clicklogOut();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }

    }

    public boolean isAlertPresent(){ //User defined method to check
        try {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e){
            return false;
        }
    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
        int rowNum= XLUtils.getRowCount(path,"Sheet1");
        int cellNum=XLUtils.getCellCount(path,"Sheet1",1);
        String logindata[][]=new String[rowNum][cellNum];

        for(int i=1;i<=rowNum;i++){
            for(int j=0;j<cellNum;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return logindata;
    }
}
