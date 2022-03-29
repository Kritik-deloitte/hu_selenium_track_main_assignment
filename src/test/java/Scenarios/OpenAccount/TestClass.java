/*
KritikBansal
29-March-2022
 */
package Scenarios.OpenAccount;

import Pages.AddAccountPage;
import PreRequisites.AccountPage;
import PreRequisites.Reusable;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//testClass for the open account scenario
public class TestClass extends AccountPage {

    //reading data from excel
    List<String[]> Data= Reusable.read();
    //initializing the log
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    //reference to the elements
    private WebElement Customers=null;
    private WebElement Currency=null;
    private WebElement Process=null;
    private String expected="Account created successfully with account Number";
    // extent reports references
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//OpenAccount//extentReport.html");

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

    @Test(priority = 1)
    public void CustomersDropdownDisplayed(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CustomersDropdownDisplayed","Checking Customer Dropdown is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the customers dropdwon
        Customers= AddAccountPage.CustomerDropdown(driver);
        //checking it is visible or not
        Assert.assertTrue(Customers.isDisplayed(),"Customers Dropdown not Displayed");
        //logs and report conditions based on the check
        if(Customers.isDisplayed()){
            log.info("Customers Dropdown is Displayed");
            test.pass("Customers Dropdown is Displayed");
        }
        else {
            test.fail("Customers Dropdown is not Displayed");
        }
    }
    @Test(priority = 2)
    public void CustomersDropdownEnabled(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CustomersDropdownEnabled","Checking Customer Dropdown is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking customers dropdown is enabled or not
        Assert.assertTrue(Customers.isEnabled(),"Customers Dropdown not Enabled");
        //logs and report conditions based on the check
        if(Customers.isEnabled()){
            log.info("Customers Dropdown is Enabled");
            test.pass("Customers Dropdown is Enabled");
        }
        else {
            test.fail("Customers Dropdown is not Enabled");
        }
    }
    @Test(priority = 3)
    public void CurrencyDropDownDisplayed(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CurrencyDropDownDisplayed","Checking Currency Dropdown is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the currency dropdown
        Currency= AddAccountPage.CurrencyDropdown(driver);
        //checking it is visible or not
        Assert.assertTrue(Currency.isDisplayed(),"Currency Dropdown not Displayed");
        //logs and report conditions based on the check
        if(Currency.isDisplayed()){
            log.info("Currency Dropdown is Displayed");
            test.pass("Currency Dropdown is Displayed");
        }
        else {
            test.fail("Currency Dropdown is not Displayed");
        }
    }
    @Test(priority = 4)
    public void CurrencyDropdownEnabled(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CurrencyDropDownEnabled","Checking Currency Dropdown is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking currency dropdown is enabled or not
        Assert.assertTrue(Currency.isEnabled(),"Currency Dropdown not Enabled");
        //logs and report conditions based on the check
        if(Currency.isEnabled()){
            log.info("Currency Dropdown is Enabled");
            test.pass("Currency Dropdown is Enabled");
        }
        else {
            test.fail("Currency Dropdown is not Enabled");
        }
    }
    @Test(priority = 5)
    public void ProcessButtonDisplayed(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("ProcessButtonDisplayed","Checking Process Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        //finding and initializing the process button
        Process= AddAccountPage.ProcessButton(driver);
        //checking it is visible or not
        Assert.assertTrue(Process.isDisplayed(),"Process Button not Displayed");
        //logs and report conditions based on the check
        if(Process.isDisplayed()){
            log.info("Process Button is Displayed");
            test.pass("Process Button is Displayed");
        }
        else {
            test.fail("Process Button is not Displayed");
        }
    }
    @Test(priority = 6)
    public void ProcessButtonEnabled(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("ProcessButtonDisplayed","Checking Process Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        //checking process button is enabled or not
        Assert.assertTrue(Process.isEnabled(),"Process Button not Enabled");
        //logs and report conditions based on the check
        if(Process.isEnabled()){
            log.info("Process Button is Enabled");
            test.pass("Process Button is Enabled");
        }
        else {
            test.fail("Process Button is not Enabled");
        }
    }
    @Test(priority = 7)
    public void CustomerDropdownHavingUniqueItems(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CustomerDropdownHavingUniqueItems","Checking Customers Dropdown is having unique items or not");
        test.log(Status.INFO, "Getting All the Items of Customers Dropdown");
        //checking customers dropdown is having unique items or not
        Assert.assertTrue(isSelectOptionsRepeating(Customers),"Customers Dropdown Have Duplicate Values");
        //logs and report conditions based on the check
        if(isSelectOptionsRepeating(Customers)){
            log.info("Customers Dropdown Have Duplicate Values");
            test.fail("Customers Dropdown Have Duplicate Values");
        }
        else {
            test.pass("Customers Dropdown Have Unique Values");
        }
    }
    //test for open account for customer with unique currency
    @Test(priority = 8)
    public void CurrencyDropdownHavingUniqueItems(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("CurrencyDropdownHavingUniqueItems","Checking Currency Dropdown is having unique items or not");
        test.log(Status.INFO, "Getting All the Items of Currency Dropdown");
        //checking currency dropdown is having unique items or not
        Assert.assertTrue(isSelectOptionsRepeating(Currency),"Currency Dropdown Have Duplicate Values");
        //logs and report conditions based on the check
        if(isSelectOptionsRepeating(Currency)){
            log.info("Currency Dropdown Have Duplicate Values");
            test.fail("Currency Dropdown Have Duplicate Values");
        }
        else {
            test.fail("Currency Dropdown Have Unique Values");
        }
        Reusable.Sleep(1000);
    }
    //test for open account for customer with other unique currency
    @Test(priority = 9)
    public void AccountWithUniqueCurrency(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("AccountWithUniqueCurrency","Adding Account with the Unique Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        //initializing the select class for customers and currency dropdown
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        //selecting the values of customers dropdown
        CustDropdown.selectByValue("6");
        //selecting the values of currency dropdown
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        test.info("Opening Account");
        //click process
        Process.click();
        //getting the alert text
        String message=driver.switchTo().alert().getText();
        //accepting the alert
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        //checking the account is opened or not
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
        //logs and report conditions based on the check
        if(message.contains(expected)){
            log.info("Account Created with unique Currency");
            test.pass("Account Created with unique Currency");
        }
        else {
            test.fail("Account not Created with unique Currency");
        }

        Reusable.Sleep(1000);
    }
    //test for open account for customer with same currency
    @Test(priority = 10)
    public void AccountWithOtherCurrency(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("AccountWithOtherCurrency","Adding Account with the Other Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        //initializing the select class for customers and currency dropdown
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        //selecting the values of customers dropdown
        CustDropdown.selectByValue("6");
        //selecting the values of currency dropdown
        CurrDropdown.selectByValue("Dollar");
        Reusable.Sleep(1000);
        test.info("Opening Account");
        //click process
        Process.click();
        //getting the alert text
        String message=driver.switchTo().alert().getText();
        //accepting the alert
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        //checking the account is opened or not
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
        //logs and report conditions based on the check
        if(message.contains(expected)){
            log.info("Account Created with other Currency");
            test.pass("Account Created with other Currency");
        }
        else {
            test.fail("Account not Created with other Currency");
        }

        Reusable.Sleep(1000);
    }
    @Test(priority = 11)
    public void AccountWithSameCurrency(){
        //initializing the test for the report
        ExtentTest test=extentReports.createTest("AccountWithSameCurrency","Adding Account with the Same Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        //initializing the select class for customers and currency dropdown
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        //selecting the values of customers dropdown
        CustDropdown.selectByValue("6");
        //selecting the values of currency dropdown
        CurrDropdown.selectByValue("Rupee");
        test.info("Opening Account");
        Reusable.Sleep(1000);
        //click process
        Process.click();
        //getting the alert text
        String message=driver.switchTo().alert().getText();
        //accepting the alert
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        //checking the account is opened or not
        Assert.assertFalse(message.contains(expected), "Account Created with same Currency");
        //logs and report conditions based on the check
        if(message.contains(expected)){
            log.info("Account not Created with same Currency");
            test.pass("Account not Created with same Currency");
        }
        else {
            test.fail("Account Created with same Currency");

        }
        Reusable.Sleep(1000);
    }
    //flush the reporter after logging all th testcases
    @AfterTest
    public void flush(){
        extentReports.flush();
    }
    // check that add customers dropdown having the duplicate values or not
    public boolean isSelectOptionsRepeating(WebElement dropdown)
    {
        //initialing the select class of dropdown
        Select s = new Select(dropdown);
        //getting all the options from dropdown
        List<WebElement> list = s.getOptions();
        //initializing the set
        Set<String> listNames = new HashSet<>(list.size());
        //add them to set
        for (WebElement w : list) {
            listNames.add(w.getText().trim());
        }
        //compare and return
        return list.size() == listNames.size();
    }
}
