package com.inetBanking.pageObjects;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetBanking.utilities.ReadConfig;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;


public class BaseClass {
    ReadConfig readconfig= new ReadConfig();
    public static WebDriver driver;
    public String baseURL=readconfig.getApplicationURL();
    //public String userName=readconfig.getUserName();
    //public String password=readconfig.getPassword();

    public static Logger logger;

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional("firefox") String br){

        logger= Logger.getLogger(BaseClass.class);
        PropertyConfigurator.configure("log4j.properties");
       //For basic configurator--It will print the output on the console
        // BasicConfigurator.configure();

        System.out.println("The parameter browser is : "+br);

        if(br.equalsIgnoreCase("chrome")) {
            //1st way of handling SSL
            DesiredCapabilities dc = DesiredCapabilities.chrome();

            dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            dc.acceptInsecureCerts();
//            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
           // driver = new ChromeDriver(dc);

            //2nd way of handling SSL and Insecure Certification
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            driver= new ChromeDriver(chromeOptions);
            //driver= new RemoteWebDriver(new URL("http://"),)
        }
        else if(br.equalsIgnoreCase("firefox")){
            // User need to create a profile first in firefox
            ProfilesIni prof = new ProfilesIni();
            FirefoxProfile ffProfile = prof.getProfile("Selenium Test Profile");
            ffProfile.setAcceptUntrustedCertificates(true);
            ffProfile.setAssumeUntrustedCertificateIssuer(false);
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equalsIgnoreCase("ie")){
            DesiredCapabilities dc1 = new DesiredCapabilities();
            DesiredCapabilities dc2 = DesiredCapabilities.internetExplorer();
            dc2.setBrowserName("internet explor");
            dc1.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
            driver = new InternetExplorerDriver(dc1);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseURL);
        logger.info("Go to applicaton URL");

    }

    @AfterTest
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
