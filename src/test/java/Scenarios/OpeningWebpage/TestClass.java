package Scenarios.OpeningWebpage;

import Pages.OpenPage;
import PreRequisites.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass extends IntializeDriver {

    private final Logger log= LogManager.getLogger(TestClass.class.getName());
    private WebElement element=null;

    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
    }

    @Test(priority =1)
    public void checkTitle() {
        element = OpenPage.TitleText(driver);
        Assert.assertEquals(element.getText(), "XYZ Bank", "Title not Matches the Expected one");
        if(element.getText().equals("XYZ Bank"))
            log.info("Title Matches");
    }
    @Test(priority =2)
    public void checkCustomerLoginButtonVisible() {
        element = OpenPage.CustomerLoginButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Customer Login Button Not Displayed");
        if (element.isDisplayed())
            log.info("Customer Login Button is Displayed");
    }
    @Test(priority =3)
    public void checkCustomerLoginButtonEnabled() {
        Assert.assertTrue(element.isEnabled(),"Customer Login Button Not Enabled");
        if (element.isEnabled())
            log.info("Customer Login Button is Enabled");
    }
    @Test(priority =4)
    public void checkCustomerLoginButtonText() {
        Assert.assertEquals(element.getText(),"Customer Login","Customer Login Button Text not matched with Expected one");
        if (element.getText().equals("Customer Login"))
            log.info("Customer Login Button Text Matched with Expected One ");
    }
    @Test(priority =5)
    public void checkManagerLoginButtonVisible() {
        element = OpenPage.ManagerLoginButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Manager Login Button Not Displayed");
        if (element.isDisplayed())
            log.info("Manager Login Button is Displayed");
    }
    @Test(priority =6)
    public void checkManagerLoginButtonEnabled() {
        Assert.assertTrue(element.isEnabled(),"Manager Login Button Not Enabled");
        if (element.isEnabled())
            log.info("Manager Login Button is Enabled");
    }
    @Test(priority =7)
    public void checkManagerLoginButtonText() {
        Assert.assertEquals(element.getText(),"Manager Login","Manager Login Button Text not matched with Expected one");
        if (element.getText().equals("Manager Login"))
            log.info("Manager Login Button Text Matched with Expected One ");
    }
    @Test(priority =8)
    public void checkHomeButtonVisible() {
        element = OpenPage.HomeButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Home Button Not Displayed");
        if (element.isDisplayed())
            log.info("Home Button is Displayed");
    }
    @Test(priority =9)
    public void checkHomeButtonEnabled() {
        Assert.assertTrue(element.isEnabled(),"Home Button Not Enabled");
        if (element.isEnabled())
            log.info("Home Button is Enabled");
    }
    @Test(priority =10)
    public void checkHomeButtonText() {
        Assert.assertEquals(element.getText(),"Home","Home Button Text not matched with Expected one");
        if (element.getText().equals("Home"))
            log.info("Home Button Text Matched with Expected One ");
    }
    @Test(priority =11)
    public void checkHomeButtonClick() {
        element.click();
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        Assert.assertEquals(driver.getCurrentUrl(), url,"Home Button Not Redirected to Home");
        if (driver.getCurrentUrl().equals(url))
            log.info("Home Button Redirected to Home Functioned Properly");
    }
}
