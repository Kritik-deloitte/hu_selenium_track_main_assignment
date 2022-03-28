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

public class TestClass extends DashboardPage {
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    List<String[]> Data= Reusable.readTransactions();
    private WebElement WithdrawButton=null;
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//AmountWithdraw//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }

    @BeforeTest
    public void init(){
        CustomerDashboardPage.DepositButton(driver).click();
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.DepositAmountButton(driver).click();
        Reusable.Sleep(1000);
        CustomerDashboardPage.WithdrawButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        initializeReporter();
    }
    @Test(priority =1)
    public void WithdrawButtonVisible() {
        ExtentTest test=extentReports.createTest("WithdrawButtonVisible","Checking Withdraw Button Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        WithdrawButton= CustomerDashboardPage.WithdrawAmountButton(driver);
        Assert.assertTrue(WithdrawButton.isDisplayed(),"Withdraw Amount Button Not Displayed");
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
        ExtentTest test=extentReports.createTest("WithdrawButtonEnabled","Checking Withdraw Button Is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(WithdrawButton.isEnabled(),"Withdraw Amount Button Not Enabled");
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
        ExtentTest test=extentReports.createTest("AccountholderName","Checking Account Holder Name is correct or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement element = CustomerDashboardPage.AccountName(driver);
        Assert.assertEquals(element.getText(),Data.get(0)[0],"Account Holder Name not Matched");
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
        ExtentTest test=extentReports.createTest("Withdraw","Checking Withdrawing or not and balance updated accordingly or not");
        String balance = getBalance();
        test.log(Status.INFO,"Getting inital balance");
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(1)[2]);
        Reusable.Sleep(500);
        WithdrawButton.click();
        test.info("balance Added");
        Reusable.Sleep(1000);
        Assert.assertEquals(Integer.parseInt(balance)-Integer.parseInt(Data.get(1)[2]),Integer.parseInt(getBalance()),"Account Balance Not Updated Correctly");
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
        ExtentTest test=extentReports.createTest("SuccessMessage","Checking Success Message is correct or not");
        test.log(Status.INFO, "Getting Message");
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        String expected="Transaction successful";
        Reusable.Sleep(500);
        Assert.assertEquals(message,expected,"Incorrect Success Message");
        if(message.equals(expected)){
            log.info("Correct Success Message");
            test.pass("Correct Success Message");
        }
        else {
            test.fail("Incorrect Success Message");
        }
        extentReports.flush();
    }
    public String getBalance(){
        return CustomerDashboardPage.Balance(driver).getText();
    }
}
