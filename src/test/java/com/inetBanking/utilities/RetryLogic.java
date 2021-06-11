package com.inetBanking.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
    int counter=0;
    int retryLimit=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
