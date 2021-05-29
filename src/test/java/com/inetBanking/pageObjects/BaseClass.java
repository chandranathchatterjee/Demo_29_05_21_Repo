package com.inetBanking.pageObjects;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetBanking.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;


public class BaseClass {
    ReadConfig readconfig= new ReadConfig();
    public static WebDriver driver;
    public String baseURL=readconfig.getApplicationURL();
    public String userName=readconfig.getUserName();
    public String password=readconfig.getPassword();

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){

        logger= Logger.getLogger(BaseClass.class);
        PropertyConfigurator.configure("log4j.properties");

        if(br.equalsIgnoreCase("chrome")) {
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            dc.acceptInsecureCerts();
//            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if(br.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseURL);
        logger.info("Go to applicaton URL");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreen(String tname) throws IOException, AWTException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        ImageIO.write(image, "png", target);
        System.out.println("Screenshot taken");
    }
}
