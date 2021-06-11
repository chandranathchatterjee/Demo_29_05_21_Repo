package com.inetBanking.testCases;

import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_TestNG_Practice {

// this is a sample practice testNG code
    @Test(priority = 1, retryAnalyzer=com.inetBanking.utilities.RetryLogic.class)
    public void testCase_1(){
        System.out.println("I am under test case 1");
        Assert.assertTrue(false);
        //System.out.println("This is a test ");
    }

    @Test(priority = 2)
    public void testCase_2(){
        System.out.println("I am under test case 2");
        Assert.assertTrue(false);
    }

    @Test(priority = -1)
    public void testCase_3(){
        System.out.println("I am under test case 3");
    }
}
