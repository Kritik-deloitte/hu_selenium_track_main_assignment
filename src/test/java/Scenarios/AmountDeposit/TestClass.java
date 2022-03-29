/*
KritikBansal
29-March-2022
 */
package Scenarios.AmountDeposit;

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

//testClass for the Deposit Amount scenario
public class TestClass extends DashboardPage {

    //initializing the log
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    //reading data from excel
    List<String[]> Data= Reusable.readTransactions();
    //reference to the elements
    private WebElement DepositButton=null;
    // extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//AmountDeposit//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }
    //initial steps before the whole testcases
    @BeforeTest
    public void init(){
        CustomerDashboardPage.DepositButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        //initialize the reporter
        initializeReporter();
    }
    @Test(priority =1)
    public void DepositButtonVisible() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("DepositButtonVisible","Checking Deposit Button Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding the Deposit Button
        DepositButton= CustomerDashboardPage.DepositAmountButton(driver);
        //checking it is displayed or not
        Assert.assertTrue(DepositButton.isDisplayed(),"Deposit Amount Button Not Displayed");
        //logs and report conditions based on the check
        if (DepositButton.isDisplayed()){
            log.info("Deposit Amount Button is Displayed");
            test.pass("Deposit Amount Button is Displayed");
        }
        else {
            test.fail("Deposit Amount Button is not Displayed");
        }

    }
    @Test(priority =2)
    public void DepositButtonEnabled() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("DepositButtonEnabled","Checking Deposit Button Is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking Deposit button is enabled or not
        Assert.assertTrue(DepositButton.isEnabled(),"Deposit Amount Button Not Enabled");
        //logs and report conditions based on the check
        if (DepositButton.isEnabled()){
            log.info("Deposit Amount Button is Enabled");
            test.pass("Deposit Amount Button is Enabled");
        }
        else {
            test.fail("Deposit Amount Button is not Enabled");
        }

    }
    @Test(priority =3)
    public void AccountHolderName() {
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("AccountHolderName","Checking Account Holder Name is correct or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the Account holder name text
        WebElement element = CustomerDashboardPage.AccountName(driver);
        //checking it is correct or not
        Assert.assertEquals(element.getText(),Data.get(0)[0],"Account Holder Name not Matched");
        //logs and report conditions based on the check
        if (element.isEnabled()){
            log.info("Account Holder Name Matched");
            test.pass("Account Holder Name Matched");
        }
        else {
            test.fail("Account Holder Name doesn't Matched");
        }

    }
    @Test(priority = 4)
    public void deposit(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("Deposit","Checking Depositing or not and balance updated accordingly or not");
        //getting the balance from the balance text
        String balance = getBalance();
        test.log(Status.INFO,"Getting inital balance");
        //setting deposit amount
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        DepositButton.click();
        test.info("balance Added");
        Reusable.Sleep(1000);
        //checking balance updates or not
        Assert.assertEquals(Integer.parseInt(balance)+Integer.parseInt(Data.get(0)[2]),Integer.parseInt(getBalance()),"Account Balance Not Updated Correctly");
        //logs and report conditions based on the check
        if(Integer.parseInt(balance)+Integer.parseInt(Data.get(0)[2])==Integer.parseInt(getBalance())){
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
        //getting the final message from the message text
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        String expected="Deposit Successful";
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
