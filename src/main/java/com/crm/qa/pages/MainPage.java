package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends TestBase {


    //"//button[contains(text(),'Login')]")
    @FindBy(xpath = "//image[contains(src(),'/images/cogtiny1.jpg')]")
    WebElement crm_image;

    @FindBy (className = "btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left")
    //@FindBy (xpath = "//button[contains (@href().'https://ui.cogmento.com/')]")     //Customize Xpath
     WebElement mainpage_loginbutton;



    public String validateCRMPageTitle ()
    {
        return driver.getTitle();
    }

    public boolean validateCRMLogo()
    {
        return crm_image.isDisplayed();

    }

    public LoginPage clickOnLoginButton ()
    {
        mainpage_loginbutton.click();
        return new LoginPage();
    }
}
