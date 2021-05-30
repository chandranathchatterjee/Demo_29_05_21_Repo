package com.inetBanking.testCases;

import org.testng.annotations.Test;

public class TC_TestNG_Practice {

// this is a sample practice testNG code
    @Test(priority = 1)
    public void testCase_1(){
        System.out.println("I am under test case 1");
        //System.out.println("This is a test ");
    }

    @Test(priority = 2)
    public void testCase_2(){
        System.out.println("I am under test case 2");
    }

    @Test(priority = 3)
    public void testCase_3(){
        System.out.println("I am under test case 3");
    }
}
