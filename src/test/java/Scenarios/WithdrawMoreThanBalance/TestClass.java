package Scenarios.WithdrawMoreThanBalance;

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
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//WithdrawMoreThanBalance//extentReport.html");

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

    @Test(priority = 1)
    public void withdraw(){
        ExtentTest test=extentReports.createTest("withdraw","Checking Withdrawing more than balance");
        test.log(Status.INFO, "Initializing Element");
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(2)[2]);
        Reusable.Sleep(500);
        test.info("Withdrawing Amount");
        WebElement withdrawButton = CustomerDashboardPage.WithdrawAmountButton(driver);
        withdrawButton.click();
        Reusable.Sleep(1000);
        Assert.assertTrue(Integer.parseInt(getBalance())>0,"Account Withdraw More Than Balance");
        if(Integer.parseInt(getBalance())>0){
            log.info("Account Can't Withdraw More Than Balance");
            test.pass("Account Can't Withdraw More Than Balance");
        }
        else {
            test.fail("Account Withdraw More Than Balance");
        }
    }
    @Test(priority = 2)
    public void SuccessMessage(){
        ExtentTest test=extentReports.createTest("Message","Checking final Message is correct or not");
        test.log(Status.INFO, "Initializing Element");
        test.info("Getting final message");
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        String expected="Transaction Failed. You can not withdraw amount more than the balance.";
        Reusable.Sleep(500);
        Assert.assertEquals(message,expected,"Incorrect Message");
        if(message.equals(expected)){
            log.info("Correct Message");
            test.pass("Correct Message");
        }
        else {
            test.fail("Incorrect Message");
        }
        extentReports.flush();
    }
    public String getBalance(){
        return CustomerDashboardPage.Balance(driver).getText();
    }
}
