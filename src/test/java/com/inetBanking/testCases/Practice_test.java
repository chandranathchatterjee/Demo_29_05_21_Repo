package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Practice_test {

    @Test
    public void setUpSpiceJet() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","F:\\SeleniumProjects\\InetBankingSelenium\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Select select = new Select(driver.findElement(By.xpath("")));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));


        List<WebElement> drpdwnItems =driver.findElements(By.xpath(""));
        for (WebElement item:drpdwnItems){
            if(item.getText()==""){
                item.click();
            }
        }
        Map<String,List<Integer>> pracMap= new HashMap<String,List<Integer>>();
        pracMap.put("Prac1", Arrays.asList(1,10,100,1000));
        pracMap.put("Prac2",Arrays.asList(2,20,200,2000,20000));
        for(Map.Entry<String,List<Integer>> entry : pracMap.entrySet()){
            String name=entry.getKey();
            List<Integer> nameVal=new ArrayList<Integer>(entry.getValue());
            for(int listItem: nameVal){

            }
        }
        Actions builder=new Actions(driver);
        builder.moveToElement(driver.findElement(By.id(""))).keyDown(Keys.SHIFT).build().perform();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        List<WebElement> links= driver.findElements(By.tagName("a"));
        final URLStreamHandler streamHandler = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return null;
            }
        };
        for (WebElement link:links){
            String url= link.getAttribute("href");
            HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int rspnscode=conn.getResponseCode();
            SoftAssert a = new SoftAssert();
            a.assertTrue(rspnscode<400,"Broken link");
        }
//        Select objselect = new Select(driver.findElement(By.id("ctl00_mainContent_group_details")));
//        objselect.selectByValue("BLR");

        driver.quit();

    }
}
