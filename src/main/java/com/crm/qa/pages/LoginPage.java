package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy (className = "content")
    WebElement loginpage_pagetitle;

    @FindBy (name = "email")
    WebElement username;

    @FindBy (name = "password")
    WebElement password;

    @FindBy (xpath = "//button[contains(text(),'Login')]")      //Customize Xpath
    WebElement loginpage_loginbutton;

    @FindBy (xpath = "//*[@id=\"ui\"]/div/div/div[1]/a")
    WebElement forgpass;

    @FindBy (xpath = "//*[@id=\"ui\"]/div/div/div[2]/a")
    WebElement signup;

    @FindBy (xpath = "//*[@id=\"ui\"]/div/div/div[3]/a")
    WebElement classic_crm;



    //Initialize page factory object defined above

    public LoginPage ()
    {
        PageFactory.initElements( driver,this );

        //PageFactory.initElements( driver,LoginPage.class );

        //this - current class objects
    }


    public HomePage login (String un, String pwd)
    {
        username.sendKeys( un );
        password.sendKeys( pwd );
        loginpage_loginbutton.click();

        return new HomePage();
    }

}
