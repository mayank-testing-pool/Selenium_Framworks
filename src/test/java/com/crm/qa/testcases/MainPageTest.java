package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {

    MainPage mainpage;
    LoginPage loginpage;
    public MainPageTest()
    {
        super();                //Will call parent class constructor or super class constructor. It will initialize properties mention in Super class

    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        mainpage = new MainPage();
    }

    @Test (priority = 1)
    public void mainPageTitle ()
    {
        String title = mainpage.validateCRMPageTitle();
        Assert.assertEquals( title,"Free CRM software in the cloud for sales and service");
    }

    @Test (priority = 2)
    public void validateCRMLogoImage ()
    {
        boolean flag = mainpage.validateCRMLogo();
        Assert.assertTrue( flag);
    }

    @Test (priority = 3)
    public void clickOnLoginButton ()
    {
        loginpage = mainpage.clickOnLoginButton();
    }




    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
