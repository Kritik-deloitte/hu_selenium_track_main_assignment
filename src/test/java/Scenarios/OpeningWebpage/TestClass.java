/*
KritikBansal
29-March-2022
 */
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

//testClass for the open url scenario
public class TestClass extends IntializeDriver {

    //initializing the log
    private final Logger log= LogManager.getLogger(TestClass.class.getName());
    //reference to the elements
    private WebElement element=null;
    //extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//OpeningWebpage//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }

    //initial steps before executing the whole testcases
    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        //initializing the reporter
        initializeReporter();
    }

    @Test(priority =1)
    public void checkTitle() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkTitle","Checking Title is corrct or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing page title text
        element = OpenPage.TitleText(driver);
        //checking is it correct or not
        Assert.assertEquals(element.getText(), "XYZ Bank", "Title not Matches the Expected one");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonVisible","Checking Customer Login Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the customer login button
        element = OpenPage.CustomerLoginButton(driver);
        //checking is it visible or not
        Assert.assertTrue(element.isDisplayed(),"Customer Login Button Not Displayed");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonEnabled","Checking Customer Login Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking customer login button is enabled or not
        Assert.assertTrue(element.isEnabled(),"Customer Login Button Not Enabled");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkCustomerLoginButtonText","Checking Customer Login Button Text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //checking customer login button having correct text or not
        Assert.assertEquals(element.getText(),"Customer Login","Customer Login Button Text not matched with Expected one");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonVisible","Checking Manager Login Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the manager login button
        element = OpenPage.ManagerLoginButton(driver);
        //checking is it visible or not
        Assert.assertTrue(element.isDisplayed(),"Manager Login Button Not Displayed");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonEnabled","Checking Manager Login Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking manager login button is enabled or not
        Assert.assertTrue(element.isEnabled(),"Manager Login Button Not Enabled");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkManagerLoginButtonText","Checking Manager Login Button text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //checking manager login button having correct text or not
        Assert.assertEquals(element.getText(),"Manager Login","Manager Login Button Text not matched with Expected one");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkHomeButtonVisible","Checking Home Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the home button
        element = OpenPage.HomeButton(driver);
        //checking is it visible or not
        Assert.assertTrue(element.isDisplayed(),"Home Button Not Displayed");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkHomeButtonEnabled","Checking Home Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking home button is enabled or not
        Assert.assertTrue(element.isEnabled(),"Home Button Not Enabled");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkHomeButtonText","Checking Home Button text is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //checking home button text is correct or not
        Assert.assertEquals(element.getText(),"Home","Home Button Text not matched with Expected one");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("checkHomeButtonCLick","Checking Home Button Functioning is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //clicking home button
        element.click();
        //getting page url
        test.info("Getting Page URL");
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        //checking the home button redirects to correct url or not
        Assert.assertEquals(driver.getCurrentUrl(), url,"Home Button Not Redirected to Home");
        //logs and report conditions based on the check
        if (driver.getCurrentUrl().equals(url)){
            log.info("Home Button Redirected to Home Functioned Properly");
            test.pass("Home Button Redirected to Home Functioned Properly");
        }
        else {
            test.fail("Home Button not Redirected to Home not Functioned Properly");
        }
        //flushing the extent reports
        extentReports.flush();

    }
}
