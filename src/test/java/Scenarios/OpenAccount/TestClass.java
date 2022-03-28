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

public class TestClass extends AccountPage {
    List<String[]> Data= Reusable.read();
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    private WebElement Customers=null;
    private WebElement Currency=null;
    private WebElement Process=null;
    private String expected="Account created successfully with account Number";
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//OpenAccount//extentReport.html");

        //attach reporter to extent reporter
        extentReports.attachReporter(myReporter);
    }


    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
        initializeReporter();
    }

    @Test(priority = 1)
    public void CustomersDropdownDisplayed(){
        ExtentTest test=extentReports.createTest("CustomersDropdownDisplayed","Checking Customer Dropdown is visible or not");
        test.log(Status.INFO, "Initializing Element");
        Customers= AddAccountPage.CustomerDropdown(driver);
        Assert.assertTrue(Customers.isDisplayed(),"Customers Dropdown not Displayed");
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
        ExtentTest test=extentReports.createTest("CustomersDropdownEnabled","Checking Customer Dropdown is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(Customers.isEnabled(),"Customers Dropdown not Enabled");
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
        ExtentTest test=extentReports.createTest("CurrencyDropDownDisplayed","Checking Currency Dropdown is visible or not");
        test.log(Status.INFO, "Initializing Element");
        Currency= AddAccountPage.CurrencyDropdown(driver);
        Assert.assertTrue(Currency.isDisplayed(),"Currency Dropdown not Displayed");
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
        ExtentTest test=extentReports.createTest("CurrencyDropDownEnabled","Checking Currency Dropdown is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(Currency.isEnabled(),"Currency Dropdown not Enabled");
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
        ExtentTest test=extentReports.createTest("ProcessButtonDisplayed","Checking Process Button is visible or not");
        test.log(Status.INFO, "Initializing Element");
        Process= AddAccountPage.ProcessButton(driver);
        Assert.assertTrue(Process.isDisplayed(),"Process Button not Displayed");
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
        ExtentTest test=extentReports.createTest("ProcessButtonDisplayed","Checking Process Button is enabled or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(Process.isEnabled(),"Process Button not Enabled");
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
        ExtentTest test=extentReports.createTest("CustomerDropdownHavingUniqueItems","Checking Customers Dropdown is having unique items or not");
        test.log(Status.INFO, "Getting All the Items of Customers Dropdown");
        Assert.assertTrue(isSelectOptionsRepeating(Customers),"Customers Dropdown Have Duplicate Values");
        if(isSelectOptionsRepeating(Customers)){
            log.info("Customers Dropdown Have Duplicate Values");
            test.fail("Customers Dropdown Have Duplicate Values");
        }
        else {
            test.pass("Customers Dropdown Have Unique Values");
        }
    }
    @Test(priority = 8)
    public void CurrencyDropdownHavingUniqueItems(){
        ExtentTest test=extentReports.createTest("CurrencyDropdownHavingUniqueItems","Checking Currency Dropdown is having unique items or not");
        test.log(Status.INFO, "Getting All the Items of Currency Dropdown");
        Assert.assertTrue(isSelectOptionsRepeating(Currency),"Currency Dropdown Have Duplicate Values");
        if(isSelectOptionsRepeating(Currency)){
            log.info("Currency Dropdown Have Duplicate Values");
            test.fail("Currency Dropdown Have Duplicate Values");
        }
        else {
            test.fail("Currency Dropdown Have Unique Values");
        }
        Reusable.Sleep(1000);
    }
    @Test(priority = 9)
    public void AccountWithUniqueCurrency(){
        ExtentTest test=extentReports.createTest("AccountWithUniqueCurrency","Adding Account with the Unique Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        test.info("Opening Account");
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
        if(message.contains(expected)){
            log.info("Account Created with unique Currency");
            test.pass("Account Created with unique Currency");
        }
        else {
            test.fail("Account not Created with unique Currency");
        }

        Reusable.Sleep(1000);
    }
    @Test(priority = 10)
    public void AccountWithOtherCurrency(){
        ExtentTest test=extentReports.createTest("AccountWithOtherCurrency","Adding Account with the Other Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Dollar");
        Reusable.Sleep(1000);
        test.info("Opening Account");
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
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
        ExtentTest test=extentReports.createTest("AccountWithSameCurrency","Adding Account with the Same Currency");
        test.log(Status.INFO, "Selecting Values from dropdown");
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        test.info("Opening Account");
        Reusable.Sleep(1000);
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        test.info("Handling Alert");
        Assert.assertFalse(message.contains(expected), "Account Created with same Currency");
        if(message.contains(expected)){
            log.info("Account not Created with same Currency");
            test.pass("Account not Created with same Currency");
        }
        else {
            test.fail("Account Created with same Currency");

        }
        Reusable.Sleep(1000);
    }
    @AfterTest
    public void flush(){
        extentReports.flush();
    }
    public boolean isSelectOptionsRepeating(WebElement dropdown)
    {
        Select s = new Select(dropdown);
        List<WebElement> list = s.getOptions();
        Set<String> listNames = new HashSet<>(list.size());
        for (WebElement w : list) {
            listNames.add(w.getText().trim());
        }
        return list.size() == listNames.size();
    }
}
