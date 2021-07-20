package com.inetBanking.testCases;

import com.inetBanking.utilities.ReadConfig;
import com.inetBanking.utilities.XLUtils;
import com.inetBanking.utilities.XLsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExcelReader {
    ReadConfig readconfig = new ReadConfig();
    private By speed = By.id("speed");
    private By files= By.id("files");
    private By num= By.id("number");
    static WebDriver driver=null;


    @AfterTest
    public void exit(){
        driver.quit();
    }
    @Test
    public void testExcelReader(){
        try {
            int rows= XLsUtils.getRowCount("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet1");
            System.out.println("The number of rows is :"+ rows);
            int columns= XLsUtils.getCellCount("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet1",0);
            System.out.println("The number of columns is :"+ columns);
            XLsUtils.setCellData("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet1",9,10,"Chandranath");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void selectdrpdwnValueFromExcel(String filePath,String sheet,int rownum,int colNum,By locator){
        String data1 = null;
        try {
            data1 = XLsUtils.getCellData(filePath,
                    sheet, rownum,colNum );
            System.out.println("The value in ["+rownum+"]["+colNum+"] location is :"+ data1);
            Select select = new Select(driver.findElement(locator));
            select.selectByVisibleText(data1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void sendValuefromExcel()
    {
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testautomationpractice.blogspot.com/");
        try {
            //FileInputStream fl= new FileInputStream("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls");
            int rows= XLsUtils.getRowCount("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet2");
            System.out.println("The number of rows in Sheet 2 is "+rows);
            for(int i=1;i<=rows;i++)
            {
                int cols= XLsUtils.getCellCount("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet2",i);
                System.out.println("Total column in sheet2 is :"+cols);
                selectdrpdwnValueFromExcel("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet2",i,0,speed);
                selectdrpdwnValueFromExcel("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet2",i,1,files);
                selectdrpdwnValueFromExcel("C:\\Users\\lenovo\\Desktop\\file_example_XLS_10.xls","Sheet2",i,2,num);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
