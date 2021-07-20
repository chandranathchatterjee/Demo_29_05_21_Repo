package com.inetBanking.testCases;

import com.inetBanking.utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCalender {
    WebDriver driver=null;
    ReadConfig readconfig = new ReadConfig();
    //private WebElement date= driver.findElement(By.id("datepicker"));

@BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://testautomationpractice.blogspot.com/");

}
@AfterTest
    public void quit(){
        driver.quit();

}

public String[] getSelectedMonthYear(){
    String[] monyear= new String[2];
    String monthyearVal=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
    monyear[0]= monthyearVal.split(" ")[0].trim();
    monyear[1] = monthyearVal.split("")[1].trim();
    return monyear;
}

public  void selectDate(String day, String month,String year) throws InterruptedException {
    String[] monthYearValue=getSelectedMonthYear();
    while (!(monthYearValue[0].equals(month) && monthYearValue[1].equals(year))){
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Next']")).click();
        monthYearValue=getSelectedMonthYear();
    }
    driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+day+"']")).click();
}

@Test
    public void testCalender()
{
    driver.findElement(By.id("datepicker")).click();
    new WebDriverWait(driver, 5).
            until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
    try {
        selectDate("23","October","2021");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
