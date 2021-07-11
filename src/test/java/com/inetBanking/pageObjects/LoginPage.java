package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class LoginPage extends Page {
     WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    public void setTxtUserName(String uname) {

        txtUserName.clear();
        txtUserName.sendKeys(uname);
    }

    public void setTxtPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit(){
        btnLogin.click();
    }
    public void clicklogOut(){
        btnLogOut.click();
    }

    public DashboardPage signIn(String uname, String pwd){
        DashboardPage d1 = null;
        setTxtUserName(uname);
        setTxtPassword(pwd);
        clickSubmit();
        d1= new DashboardPage(ldriver);
        new WebDriverWait(ldriver,5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) d1.logOutLink));
        return d1;
    }

    protected class Customer
    {
        int id;
        String name;

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }



    @FindBy(name="uid")
    @CacheLookup
    private WebElement txtUserName;

    @FindBy(name="password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(name="btnLogin")
    @CacheLookup
    public WebElement btnLogin;

    @FindBy(xpath = "//a[text()='Log out']")
    @CacheLookup
    private WebElement btnLogOut;

}
