/*
KritikBansal
29-March-2022
 */
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

//testClass for withdrawing more than balance scenario
public class TestClass extends DashboardPage {
    //initializing the log
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    //reading data from excel
    List<String[]> Data= Reusable.readTransactions();
    // extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//WithdrawMoreThanBalance//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }
    //initial steps before executing the whole testcases
    @BeforeTest
    public void init(){
        //click deposit tab
        CustomerDashboardPage.DepositButton(driver).click();
        //deposit some amount
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.DepositAmountButton(driver).click();
        Reusable.Sleep(1000);
        //click withdraw tab
        CustomerDashboardPage.WithdrawButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        //initializing the reporter
        initializeReporter();
    }

    @Test(priority = 1)
    public void withdraw(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("withdraw","Checking Withdrawing more than balance");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the withdraw amount input and send the amount greater than balance
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(2)[2]);
        Reusable.Sleep(500);
        test.info("Withdrawing Amount");
        //finding and initializing the withdraw button
        WebElement withdrawButton = CustomerDashboardPage.WithdrawAmountButton(driver);
        //click withdraw button
        withdrawButton.click();
        Reusable.Sleep(1000);
        //checking whether amount debited or not
        Assert.assertTrue(Integer.parseInt(getBalance())>0,"Account Withdraw More Than Balance");
        //logs and report conditions based on the check
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
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("Message","Checking final Message is correct or not");
        test.log(Status.INFO, "Initializing Element");
        test.info("Getting final message");
        //finding and initializing the final message text and then get text
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        //store the expected one
        String expected="Transaction Failed. You can not withdraw amount more than the balance.";
        Reusable.Sleep(500);
        //compare with expected and check is it same or not
        Assert.assertEquals(message,expected,"Incorrect Message");
        //logs and report conditions based on the check
        if(message.equals(expected)){
            log.info("Correct Message");
            test.pass("Correct Message");
        }
        else {
            test.fail("Incorrect Message");
        }
        extentReports.flush();
    }
    //returns balance at particular instance
    public String getBalance(){
        return CustomerDashboardPage.Balance(driver).getText();
    }
}
