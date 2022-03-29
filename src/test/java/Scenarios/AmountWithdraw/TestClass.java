/*
KritikBansal
29-March-2022
 */
package Scenarios.AmountWithdraw;

import Pages.CustomerDashboardPage;
import PreRequisites.DashboardPage;
import PreRequisites.Reusable;
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

import java.util.List;

//testClass for the withdraw Amount scenario
public class TestClass extends DashboardPage {
    //initializing the log
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    //reading data from excel
    List<String[]> Data= Reusable.readTransactions();
    //reference to the elements
    private WebElement WithdrawButton=null;
    // extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//AmountWithdraw//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }
    //initial steps before executing the whole testcases
    @BeforeTest
    public void init(){
        //deposit the amount to withdraw
        CustomerDashboardPage.DepositButton(driver).click();
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.DepositAmountButton(driver).click();
        Reusable.Sleep(1000);
        //press withdraw tab
        CustomerDashboardPage.WithdrawButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        //initialize the reporter
        initializeReporter();
    }
    @Test(priority =1)
    public void WithdrawButtonVisible() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("WithdrawButtonVisible","Checking Withdraw Button Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the withdraw button
        WithdrawButton= CustomerDashboardPage.WithdrawAmountButton(driver);
        //checking it is visible or not
        Assert.assertTrue(WithdrawButton.isDisplayed(),"Withdraw Amount Button Not Displayed");
        //logs and report conditions based on the check
        if (WithdrawButton.isDisplayed()){
            log.info("Withdraw Amount Button is Displayed");
            test.pass("Withdraw Amount Button is Displayed");
        }
        else {
            test.fail("Withdraw Amount Button is not Displayed");
        }

    }
    @Test(priority =2)
    public void WithdrawButtonEnabled() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("WithdrawButtonEnabled","Checking Withdraw Button Is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking withdraw button is enabled or not
        Assert.assertTrue(WithdrawButton.isEnabled(),"Withdraw Amount Button Not Enabled");
        //logs and report conditions based on the check
        if (WithdrawButton.isEnabled()){
            log.info("Withdraw Amount Button is Enabled");
            test.pass("Withdraw Amount Button is Enabled");
        }
        else {
            test.fail("Withdraw Amount Button is not Enabled");
        }

    }
    @Test(priority =3)
    public void AccountHolderName() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("AccountholderName","Checking Account Holder Name is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the account holder name text
        WebElement element = CustomerDashboardPage.AccountName(driver);
        //checking it is correct or not
        Assert.assertEquals(element.getText(),Data.get(0)[0],"Account Holder Name not Matched");
        //logs and report conditions based on the check
        if (element.isEnabled()){
            log.info("Account Holder Name Matched");
            test.pass("Account Holder Name Matched");
        }
        else {
            test.fail("Account Holder Name not Matched");
        }

    }
    @Test(priority = 4)
    public void withdraw(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("Withdraw","Checking Withdrawing or not and balance updated accordingly or not");
        //getting the initial balace
        String balance = getBalance();
        test.log(Status.INFO,"Getting inital balance");
        //setting the amount to be withdraw
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(1)[2]);
        Reusable.Sleep(500);
        //click withdraw button
        WithdrawButton.click();
        test.info("balance Added");
        Reusable.Sleep(1000);
        //checking balance updated accordingly or nor
        Assert.assertEquals(Integer.parseInt(balance)-Integer.parseInt(Data.get(1)[2]),Integer.parseInt(getBalance()),"Account Balance Not Updated Correctly");
        //logs and report conditions based on the check
        if(Integer.parseInt(balance)-Integer.parseInt(Data.get(1)[2])==Integer.parseInt(getBalance())){
            log.info("Balance Updated Correctly");
            test.pass("Balance Updated Correctly");
        }
        else {
            test.fail("Balance not Updated Correctly");
        }
    }
    @Test(priority = 5)
    public void SuccessMessage(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("SuccessMessage","Checking Success Message is correct or not");
        test.log(Status.INFO, "Getting Message");
        //getting the final text message
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        String expected="Transaction successful";
        Reusable.Sleep(500);
        //checking it is correct or not
        Assert.assertEquals(message,expected,"Incorrect Success Message");
        //logs and report conditions based on the check
        if(message.equals(expected)){
            log.info("Correct Success Message");
            test.pass("Correct Success Message");
        }
        else {
            test.fail("Incorrect Success Message");
        }
        extentReports.flush();
    }
    //get the balance from the balance text
    public String getBalance(){
        return CustomerDashboardPage.Balance(driver).getText();
    }
}
