package com.inetBanking.pageObjects.Traceability;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Survey {
    WebDriver ldriver;

    public Survey(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }


}
