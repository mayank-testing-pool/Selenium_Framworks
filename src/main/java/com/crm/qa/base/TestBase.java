package com.crm.qa.base;

import com.crm.qa.util.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase ()
    {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream( "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties" );
            prop.load( fis );
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization ()
    {
        String browsername = prop.getProperty( "browser" );
        if (browsername.equals( "chrome" ))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenuim_Practice\\support\\chromedriver_2.41.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
        }else if (browsername.equals( "firefox" ))
        {
            System.setProperty( "webdriver.gecko.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenuim_Practice\\support\\geckodriver_0.23.exe" );
            driver = new FirefoxDriver(  );
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS );
        driver.get( prop.getProperty( "url" ) );


    }
}
