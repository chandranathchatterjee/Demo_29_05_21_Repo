package com.inetBanking.testCases;

import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_TestNG_Practice {

// this is a sample practice testNG code
    @Test(priority = 1, retryAnalyzer=com.inetBanking.utilities.RetryLogic.class)
    public void testCase_1(){
        System.out.println("I am under test case 1");
        Assert.assertTrue(false);
        //System.out.println("This is a test ");
    }

    @Parameters({"browser","myName"})
    @BeforeTest
    public void verifyParams(String br1,String name){
        System.out.println(br1);
        System.out.println(name);
    }

    @Test(dataProvider = "check_data",priority = -2)
    public void testcase_4(String name, String pwd){
        System.out.println(name);
        System.out.println(pwd);

    }

    @Test(priority = 2)
    public void testCase_2(){
        System.out.println("I am under test case 2");
        //Assert.assertTrue(false);
    }

    @Test(priority = -1,enabled = false)
    public void testCase_3(){
        System.out.println("I am under test case 3");
    }

    @DataProvider(name="check_data")
    public Object[][] checkData(){
        Object[][] data = new Object[3][2];
        for (int i=0;i<3;i++){
            data[i][0]="New User "+i;
            data[i][1]="Password" +i;
        }
        return data;
    }
}
