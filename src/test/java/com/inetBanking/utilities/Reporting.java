package com.inetBanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//This is a listener class

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext iTestContext) {
        String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String repName="Test-Report-"+timestamp+".html";
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extentReports= new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Host Name","localhost");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("user","Chandranath");

        htmlReporter.config().setDocumentTitle("Inet Banking Test project" + iTestContext.getName());
        htmlReporter.config().setReportName("Functional Test Automation report" + iTestContext.getName());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test=extentReports.createTest(iTestResult.getMethod().getDescription());
        test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getMethod().getDescription(), ExtentColor.GREEN));
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test=extentReports.createTest(iTestResult.getMethod().getDescription());
        test.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName()+"-test case failed due to: ", ExtentColor.RED));
        test.fail(iTestResult.getThrowable());
        String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+iTestResult.getName()+".png";
        File f=new File(screenshotPath);
        if (f.exists()){
            try {
                test.fail("Screenshot is below :"+ test.addScreenCaptureFromPath(screenshotPath));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test=extentReports.createTest(iTestResult.getMethod().getDescription());
        test.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getMethod().getDescription(), ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
