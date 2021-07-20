package com.inetBanking.testCases;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.utilities.EnumDropDown;
import com.inetBanking.utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DrpDwnTest  {
    ReadConfig readconfig = new ReadConfig();
    private By country = By.id("Form_submitForm_Country");
    static  WebDriver driver=null;

    @Test
    public void selectDropDown(){
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        try {
            Thread.sleep(5000);
            selectDropDownValue(country,"India","visibletext");
            selectDropDownValue(country,"Algeria", EnumDropDown.VISIBLETEXT.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

public static WebElement getElement(By locator){
    return  driver.findElement(locator);
}

public static void selectDropDownValue(By locator, String value,String type){
    Select select = new Select(getElement(locator));
    switch (type){
        case "value":
            select.selectByValue(value);
            break;
        case "visibletext":
            select.selectByVisibleText(value);
            break;
        case "index":
            select.selectByIndex(Integer.parseInt(value));
            break;
        default:
            System.out.println("Please select a proper selection type");
    }
}

public static void doSelectByVisibleText(By locator, String value){
    Select select = new Select(getElement(locator));
    select.selectByVisibleText(value);
}

    public static void doSelectByIndex(By locator, int index){
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }
    public static void doSelectByValue(By locator, String value){
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
}
