package com.inetBanking.testCases;

import com.inetBanking.pageObjects.Traceability.Survey;
import org.testng.annotations.Test;

import static com.inetBanking.pageObjects.BaseClass.driver;

public class Select_pivot_application {
    @Test
    public void pivotApplication(){
        Survey survey = new Survey(driver);

    }
}
