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

public class TestClass extends DashboardPage {
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    List<String[]> Data= Reusable.readTransactions();
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//VerifyTransactions//extentReport.html");

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
        Reusable.Sleep(1000);
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(1)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.WithdrawAmountButton(driver).click();
        Reusable.Sleep(1000);
        CustomerDashboardPage.WithdrawAmountInput(driver).sendKeys(Data.get(2)[2]);
        Reusable.Sleep(500);
        CustomerDashboardPage.WithdrawAmountButton(driver).click();
        Reusable.Sleep(1000);
        CustomerDashboardPage.TransactionButton(driver).click();
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(1000);
        initializeReporter();
    }
    @Test(priority = 1)
    public void BackButtonDisplayed(){
        ExtentTest test=extentReports.createTest("BackButtonDisplayed","Checking Back Button is Displayed or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement BackButton= CustomerDashboardPage.BackButton(driver);
        Assert.assertTrue(BackButton.isDisplayed(),"Back Button not Displayed");
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
        ExtentTest test=extentReports.createTest("BackButtonEnabled","Checking Back Button is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement BackButton= CustomerDashboardPage.BackButton(driver);
        Assert.assertTrue(BackButton.isEnabled(),"Back Button not Enabled");
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
        ExtentTest test=extentReports.createTest("ResetButtonDisplayed","Checking Reset Button is Displayed or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement ResetButton= CustomerDashboardPage.ResetButton(driver);
        Assert.assertTrue(ResetButton.isDisplayed(),"Reset Button not Displayed");
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
        ExtentTest test=extentReports.createTest("ResetButtonEnabled","Checking Reset Button is Enabled or not");
        test.log(Status.INFO, "Initializing Element");
        WebElement ResetButton= CustomerDashboardPage.ResetButton(driver);
        Assert.assertTrue(ResetButton.isEnabled(),"Reset Button not Enabled");
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
        ExtentTest test=extentReports.createTest("CheckTransactions","Checking Transactions are updating accordingly or not");
        boolean CorrectTransactions=true;
        test.log(Status.INFO, "Getting Transactions Data");
        List<String[]> transactions=getData();
        test.info("Matching the transactions data");
        for(int i=0;i<transactions.size();i++){
            if(!transactions.get(i)[0].equals(Data.get(i)[2])){
                CorrectTransactions= false;
                break;
            }
            if(!transactions.get(i)[1].equals(Data.get(i)[1])){
                CorrectTransactions=false;
                break;
            }
        }
        Assert.assertTrue(!CorrectTransactions,"Transactions Data is Incorrect");
        if(CorrectTransactions){
            log.info("Correct Transactions Data");
            test.pass("Correct Transactions Data");
        }
        else {
            test.fail("Incorrect Transactions Data");
        }
    }
    @AfterTest
    public void flush(){
        extentReports.flush();
    }

    public List<String[]> getData(){
        List<WebElement> ans= CustomerDashboardPage.TransactionList(driver);
        List<String[]> trans=new ArrayList<>();
        for(int i=1;i<= ans.size();i++){
            String[] res=new String[2];
            for(int j=0;j<=1;j++){
                res[j]=driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+(j+2)+"]")).getText();
            }
            trans.add(res);
        }
        return trans;
    }

}
