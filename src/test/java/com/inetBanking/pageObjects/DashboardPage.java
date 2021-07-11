package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class DashboardPage extends Page{
    private WebDriver ldriver;
    public final String pageTitle="Dashboard";
    List<LoginPage.Customer> customers= new LinkedList<LoginPage.Customer>();

    public DashboardPage(WebDriver driver2){
        this.ldriver=driver2;
        PageFactory.initElements(driver2,this);
    }

    public boolean verifyLogin(String expectedMessage){
        String actualMsg= ldriver.findElement((By) welcome).getText();
        if(actualMsg.equalsIgnoreCase(expectedMessage)){
            return true;
        }
        else return false;
    }



    @FindBy(name="welcomeMessage")
    @CacheLookup
    WebElement welcome;

    @FindBy(name="logout")
    @CacheLookup
    WebElement logOutLink;
}
