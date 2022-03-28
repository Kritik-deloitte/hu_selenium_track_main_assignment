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

public class TestClass extends DashboardPage {

    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    List<String[]> Data= Reusable.readTransactions();
    private WebElement DepositButton=null;
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//AmountDeposit//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }

    @BeforeTest
    public void init(){
        CustomerDashboardPage.DepositButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        initializeReporter();
    }
    @Test(priority =1)
    public void DepositButtonVisible() {
        ExtentTest test=extentReports.createTest("DepositButtonVisible","Checking Deposit Button Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        DepositButton= CustomerDashboardPage.DepositAmountButton(driver);
        Assert.assertTrue(DepositButton.isDisplayed(),"Deposit Amount Button Not Displayed");
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
        ExtentTest test=extentReports.createTest("DepositButtonEnabled","Checking Deposit Button Is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(DepositButton.isEnabled(),"Deposit Amount Button Not Enabled");
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
        ExtentTest test=extentReports.createTest("AccountHolderName","Checking Account Holder Name is correct or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement element = CustomerDashboardPage.AccountName(driver);
        Assert.assertEquals(element.getText(),Data.get(0)[0],"Account Holder Name not Matched");
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
        ExtentTest test=extentReports.createTest("Deposit","Checking Depositing or not and balance updated accordingly or not");
        String balance = getBalance();
        test.log(Status.INFO,"Getting inital balance");
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        DepositButton.click();
        test.info("balance Added");
        Reusable.Sleep(1000);
        Assert.assertEquals(Integer.parseInt(balance)+Integer.parseInt(Data.get(0)[2]),Integer.parseInt(getBalance()),"Account Balance Not Updated Correctly");
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
        ExtentTest test=extentReports.createTest("SuccessMessage","Checking Success Message is correct or not");
        test.log(Status.INFO, "Getting Message");
        String message=CustomerDashboardPage.SuccessMessage(driver).getText();
        String expected="Deposit Successful";
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
