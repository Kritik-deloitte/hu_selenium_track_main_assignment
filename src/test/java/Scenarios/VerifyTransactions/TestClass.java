/*
KritikBansal
29-March-2022
 */
package Scenarios.VerifyTransactions;

import Pages.CustomerDashboardPage;
import PreRequisites.DashboardPage;
import PreRequisites.Reusable;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//testClass for verify transactions scenario
public class TestClass extends DashboardPage {
    //initializing the log
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    //reading data from excel
    List<String[]> Data= Reusable.readTransactions();
    //references to element
    WebElement BackButton=null;
    WebElement ResetButton=null;
    // extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//VerifyTransactions//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }
    //initial steps before executing the whole testcases
    @BeforeTest
    public void init(){
        //click deposit button
        CustomerDashboardPage.DepositButton(driver).click();
        //deposit an amount
        CustomerDashboardPage.DepositAmountInput(driver).sendKeys(Data.get(0)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.DepositAmountButton(driver).click();
        Reusable.Sleep(1000);
        //click withdraw button
        CustomerDashboardPage.WithdrawButton(driver).click();
        Reusable.Sleep(1000);
        //withdrawing an amount
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(1)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.WithdrawAmountButton(driver).click();
        Reusable.Sleep(1000);
        //withdrawing an amount greater than balance
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(2)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.WithdrawAmountButton(driver).click();
        Reusable.Sleep(1000);
        //click transactions tab
        CustomerDashboardPage.TransactionButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(1000);
        //initializing the reporter
        initializeReporter();
    }
    @Test(priority = 1)
    public void BackButtonDisplayed(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("BackButtonDisplayed","Checking Back Button is Displayed or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the back button
        BackButton= CustomerDashboardPage.BackButton(driver);
        //check is it visible or not
        Assert.assertTrue(BackButton.isDisplayed(),"Back Button not Displayed");
        //logs and report conditions based on the check
        if(BackButton.isDisplayed()){
            log.info("Back Button is Displayed");
            test.pass("Back Button is Displayed");
        }
        else {
            test.fail("Back Button is not Displayed");
        }
    }
    @Test(priority = 2)
    public void CurrencyDropdownEnabled(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("BackButtonEnabled","Checking Back Button is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        BackButton= CustomerDashboardPage.BackButton(driver);
        //check back button is enabled or not
        Assert.assertTrue(BackButton.isEnabled(),"Back Button not Enabled");
        //logs and report conditions based on the check
        if(BackButton.isEnabled()){
            log.info("Back Button is Enabled");
            test.pass("Back Button is Enabled");
        }
        else {
            test.fail("Back Button is not Enabled");
        }
    }
    @Test(priority = 3)
    public void ResetButtonDisplayed(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("ResetButtonDisplayed","Checking Reset Button is Displayed or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the reset button
        ResetButton= CustomerDashboardPage.ResetButton(driver);
        //check is it visible or not
        Assert.assertTrue(ResetButton.isDisplayed(),"Reset Button not Displayed");
        //logs and report conditions based on the check
        if(ResetButton.isDisplayed()){
            log.info("Reset Button is Displayed");
            test.pass("Reset Button is Displayed");
        }
        else {
            test.fail("Reset Button is not Displayed");
        }
    }
    @Test(priority = 4)
    public void ResetDropdownEnabled(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("ResetButtonEnabled","Checking Reset Button is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        ResetButton= CustomerDashboardPage.ResetButton(driver);
        //check reset button is enabled or not
        Assert.assertTrue(ResetButton.isEnabled(),"Reset Button not Enabled");
        //logs and report conditions based on the check
        if(ResetButton.isEnabled()){
            log.info("Reset Button is Enabled");
            test.pass("Reset Button is Enabled");
        }
        else {
            test.fail("Reset Button is not Enabled");
        }
    }
    @Test(priority = 5)
    public void CheckTransactions(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CheckTransactions","Checking Transactions are updating accordingly or not");
        boolean CorrectTransactions=true;
        test.log(Status.INFO, "Getting Transactions Data");
        //getting the data of transactions from transactions tab
        List<String[]> transactions=getData();
        test.info("Matching the transactions data");
        //iterative matching the transactions
        for(int i=0;i<transactions.size();i++){
            if(!transactions.get(i)[0].equals(Data.get(i)[2])){
                //if it doesn't match break loop and mark it not correct
                CorrectTransactions= false;
                break;
            }
            if(!transactions.get(i)[1].equals(Data.get(i)[1])){
                CorrectTransactions=false;
                break;
            }
        }
        //check all the transactions return correct or not
        Assert.assertFalse(CorrectTransactions, "Transactions Data is Incorrect");
        //logs and report conditions based on the check
        if(CorrectTransactions){
            log.info("Correct Transactions Data");
            test.pass("Correct Transactions Data");
        }
        else {
            test.fail("Incorrect Transactions Data");
        }
    }
    //flushes the reporter
    @AfterTest
    public void flush(){
        extentReports.flush();
    }

    //fetch data from the transactions table
    public List<String[]> getData(){
        // get the list of all web elements in transaction table
        List<WebElement> ans= CustomerDashboardPage.TransactionList(driver);
        List<String[]> trans=new ArrayList<>();
        //iteratively store them in a list of string array
        for(int i=1;i<= ans.size();i++){
            String[] res=new String[2];
            for(int j=0;j<=1;j++){
                //getting each element by indexed xpath
                res[j]=driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+(j+2)+"]")).getText();
            }
            trans.add(res);
        }
        return trans;
    }

}
