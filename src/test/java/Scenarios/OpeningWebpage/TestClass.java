package Scenarios.OpeningWebpage;

import Pages.OpenPage;
import PreRequisites.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass extends IntializeDriver {

    private final Logger log= LogManager.getLogger(TestClass.class.getName());
    private WebElement element=null;
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//OpeningWebpage//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }

    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        initializeReporter();
    }

    @Test(priority =1)
    public void checkTitle() {
        ExtentTest test=extentReports.createTest("checkTitle","Checking Title is corrct or not");
        test.log(Status.INFO, "Initializing Element");
        element = OpenPage.TitleText(driver);
        Assert.assertEquals(element.getText(), "XYZ Bank", "Title not Matches the Expected one");
        if(element.getText().equals("XYZ Bank")){
            log.info("Title Matches");
            test.pass("Title Matches");
        }
        else {
            test.fail("Title not Matches");
        }

    }
    @Test(priority =2)
    public void checkCustomerLoginButtonVisible() {
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonVisible","Checking Customer Login Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        element = OpenPage.CustomerLoginButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Customer Login Button Not Displayed");
        if (element.isDisplayed()){
            log.info("Customer Login Button is Displayed");
            test.pass("Customer Login Button is Displayed");
        }
        else {
            test.fail("Customer Login Button is not Displayed");
        }

    }
    @Test(priority =3)
    public void checkCustomerLoginButtonEnabled() {
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonEnabled","Checking Customer Login Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(element.isEnabled(),"Customer Login Button Not Enabled");
        if (element.isEnabled()){
            log.info("Customer Login Button is Enabled");
            test.pass("Customer Login Button is Enabled");
        }
        else {
            test.fail("Customer Login Button is not Enabled");
        }

    }
    @Test(priority =4)
    public void checkCustomerLoginButtonText() {
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonText","Checking Customer Login Button Text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertEquals(element.getText(),"Customer Login","Customer Login Button Text not matched with Expected one");
        if (element.getText().equals("Customer Login")){
            log.info("Customer Login Button Text Matched with Expected One ");
            test.pass("Customer Login Button Text Matched with Expected One ");
        }
        else {
            test.fail("Customer Login Button Text not Matched with Expected One ");
        }

    }
    @Test(priority =5)
    public void checkManagerLoginButtonVisible() {
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonVisible","Checking Manager Login Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        element = OpenPage.ManagerLoginButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Manager Login Button Not Displayed");
        if (element.isDisplayed()){
            log.info("Manager Login Button is Displayed");
            test.pass("Manager Login Button is Displayed");
        }
        else {
            test.fail("Manager Login Button is not Displayed");
        }
    }
    @Test(priority =6)
    public void checkManagerLoginButtonEnabled() {
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonEnabled","Checking Manager Login Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(element.isEnabled(),"Manager Login Button Not Enabled");
        if (element.isEnabled()){
            log.info("Manager Login Button is Enabled");
            test.pass("Manager Login Button is Enabled");
        }
        else {
            test.fail("Manager Login Button is not Enabled");
        }

    }
    @Test(priority =7)
    public void checkManagerLoginButtonText() {
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonText","Checking Manager Login Button text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertEquals(element.getText(),"Manager Login","Manager Login Button Text not matched with Expected one");
        if (element.getText().equals("Manager Login")){
            log.info("Manager Login Button Text Matched with Expected One ");
            test.pass("Manager Login Button Text Matched with Expected One ");
        }
        else {
            test.fail("Manager Login Button Text not Matched with Expected One ");
        }

    }
    @Test(priority =8)
    public void checkHomeButtonVisible() {
        ExtentTest test=extentReports.createTest("checkHomeButtonVisible","Checking Home Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        element = OpenPage.HomeButton(driver);
        Assert.assertTrue(element.isDisplayed(),"Home Button Not Displayed");
        if (element.isDisplayed()){
            log.info("Home Button is Displayed");
            test.pass("Home Button is Displayed");
        }
        else {
            test.fail("Home Button is not Displayed");
        }

    }
    @Test(priority =9)
    public void checkHomeButtonEnabled() {
        ExtentTest test=extentReports.createTest("checkHomeButtonEnabled","Checking Home Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(element.isEnabled(),"Home Button Not Enabled");
        if (element.isEnabled()){
            log.info("Home Button is Enabled");
            test.pass("Home Button is Enabled");
        }
        else {
            test.fail("Home Button is not Enabled");
        }
    }
    @Test(priority =10)
    public void checkHomeButtonText() {
        ExtentTest test=extentReports.createTest("checkHomeButtonText","Checking Home Button text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertEquals(element.getText(),"Home","Home Button Text not matched with Expected one");
        if (element.getText().equals("Home")){
            log.info("Home Button Text Matched with Expected One ");
            test.pass("Home Button Text Matched with Expected One ");
        }
        else {
            test.fail("Home Button Text not Matched with Expected One ");
        }

    }
    @Test(priority =11)
    public void checkHomeButtonClick() {
        ExtentTest test=extentReports.createTest("checkHomeButtonCLick","Checking Home Button Functioning is correct or not");
        test.log(Status.INFO, "Initializing Element");
        element.click();
        test.info("Getting Page URL");
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        Assert.assertEquals(driver.getCurrentUrl(), url,"Home Button Not Redirected to Home");
        if (driver.getCurrentUrl().equals(url)){
            log.info("Home Button Redirected to Home Functioned Properly");
            test.pass("Home Button Redirected to Home Functioned Properly");
        }
        else {
            test.fail("Home Button not Redirected to Home not Functioned Properly");
        }
        extentReports.flush();

    }
}
