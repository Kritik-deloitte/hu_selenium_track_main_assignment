package Scenarios.AddCustomers;

import Pages.AddCustomersPage;
import PreRequisites.CustomersPage;
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

public class TestClass extends CustomersPage {

    List<String[]> Data= Reusable.read();
    private final Logger log= LogManager.getLogger(Scenarios.OpeningWebpage.TestClass.class.getName());
    private WebElement FName=null;
    private WebElement LName=null;
    private WebElement ZipCode=null;
    private WebElement AddCustomer=null;
    private static final String UniqueCustomerExpected="Customer added successfully with customer id";
    private static final String ExistingCustomerExpected="Please check the details. Customer may be duplicate.";
    ExtentSparkReporter myReporter;
    ExtentReports extentReports;

    public void initializeReporter(){
        //initialize the reporter
        extentReports=new ExtentReports();
        myReporter=new ExtentSparkReporter("ExtentReports//AddCustomers//extentReport.html");

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
    public void fNameInputDisplayed(){
        ExtentTest test=extentReports.createTest("fNameInputDisplayed","Checking FName Input Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        FName= AddCustomersPage.FirstNameInput(driver);
        Assert.assertTrue(FName.isDisplayed(),"FName Input Field not Displayed");
        if(FName.isDisplayed()){
            log.info("FName Input Field is Displayed");
            test.pass("FName Input Field is Displayed");
        }
        else{
            test.fail("FName Input Field is not Displayed");
        }
    }
    @Test(priority = 2)
    public void fNameInputEnabled(){
        ExtentTest test=extentReports.createTest("fNameInputEnabled","Checking FName Input Is enable or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(FName.isEnabled(),"FName Input Field not Enabled");
        if(FName.isEnabled()){
            log.info("FName Input Field is Enabled");
            test.pass("FName Input Field is Enabled");
        }
        else {
            test.fail("FName Input Field is not Enabled");
        }

    }
    @Test(priority = 3)
    public void lNameInputDisplayed(){
        ExtentTest test=extentReports.createTest("lNameInputDisplayed","Checking LName Input Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        LName= AddCustomersPage.LastNameInput(driver);
        Assert.assertTrue(LName.isDisplayed(),"LName Input Field not Displayed");
        if(LName.isDisplayed()){
            log.info("LName Input Field is Displayed");
            test.pass("LName Input Field is Displayed");
        }
        else{
            test.pass("LName Input Field is not Displayed");
        }
    }
    @Test(priority = 4)
    public void lNameInputEnabled(){
        ExtentTest test=extentReports.createTest("lNameInputEnabled","Checking LName Input Is enable or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(LName.isEnabled(),"LName Input Field not Enabled");
        if(LName.isEnabled()){
            log.info("LName Input Field is Enabled");
            test.pass("LName Input Field is Enabled");
        }
        else{
            test.pass("LName Input Field is not  Enabled");
        }
    }
    @Test(priority = 5)
    public void ZipCodeInputDisplayed(){
        ExtentTest test=extentReports.createTest("ZipCodeInputDisplayed","Checking ZipCode Input Is Visible or not");
        test.log(Status.INFO, "Initializing Element");
        ZipCode= AddCustomersPage.ZipCodeInput(driver);
        Assert.assertTrue(ZipCode.isDisplayed(),"ZipCode Input Field not Displayed");
        if(ZipCode.isDisplayed()){
            log.info("ZipCode Input Field is Displayed");
            test.pass("ZipCode Input Field is Displayed");
        }
        else {
            test.fail("ZipCode Input Field is not Displayed");
        }
    }
    @Test(priority = 6)
    public void ZipCodeInputEnabled(){
        ExtentTest test=extentReports.createTest("ZipCodeInputEnabled","Checking Zipcode Input Is enable or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(ZipCode.isEnabled(),"ZipCode Input Field not Enabled");
        if(ZipCode.isEnabled()){
            log.info("ZipCode Input Field is Enabled");
            test.pass("ZipCode Input Field is Enabled");
        }else{
            test.fail("ZipCode Input Field is not Enabled");
        }
    }
    @Test(priority = 7)
    public void AddCustomerButtonDisplayed(){
        ExtentTest test=extentReports.createTest("AddCustomerButtonDisplayed","Checking Add Customers Button Is visible or not");
        test.log(Status.INFO, "Initializing Element");
        AddCustomer= AddCustomersPage.AddCustomerButton(driver);
        Assert.assertTrue(AddCustomer.isDisplayed(),"Add Customer Button Field not Displayed");
        if(AddCustomer.isDisplayed()){
            log.info("Add Customer Button Field is Displayed");
            test.pass("Add Customer Button Field is Displayed");
        }
        else{
            test.fail("Add Customer Button Field is not Displayed");
        }
    }
    @Test(priority = 8)
    public void AddCustomerButtonEnabled(){
        ExtentTest test=extentReports.createTest("AddCustomerButtonEnabled","Checking Add Customer Button Is enable or not");
        test.log(Status.INFO, "Initializing Element");
        Assert.assertTrue(AddCustomer.isEnabled(),"Add Customer Button Field not Enabled");
        if(AddCustomer.isEnabled()){
            log.info("Add Customer Button Field is Enabled");
            test.pass("Add Customer Button Field is Enabled");
        }
        else {
            test.pass("Add Customer Button Field is not  Enabled");
        }
    }
    @Test(priority = 9)
    public void UniqueCustomer1(){
        ExtentTest test=extentReports.createTest("UniqueCustomer1","Checking Unique Customer is added or not");
        Reusable.Sleep(2000);
        test.log(Status.INFO, "Setting Data to elements");
        setData(Data.get(0));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        test.info("Switching to alert and getting text");
        driver.switchTo().alert().accept();
        test.info("Accepting the alert");
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected)){
            log.info("Customer Added Successfully");
            test.pass("Customer Added Successfully");
        }
        else {
            test.fail("Customer not Added Successfully");
        }


    }
    @Test(priority = 10)
    public void CustomerWithCaseChange(){
        ExtentTest test=extentReports.createTest("CustomerWithCaseChange","Checking Customer with name case change is added or not");
        Reusable.Sleep(2000);
        test.log(Status.INFO, "Setting Data to elements");
        setData(Data.get(1));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        test.info("Switching to alert and getting text");
        driver.switchTo().alert().accept();
        test.info("Accepting the alert");
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected)){
            log.info("Customer Added Successfully");
            test.pass("Customer Added Successfully");
        }
        else {
            test.fail("Customer not Added Successfully");
        }
    }
    @Test(priority = 11)
    public void UniqueCustomer2(){
        ExtentTest test=extentReports.createTest("UniqueCustomer2","Checking Unique Customer is added or not");
        Reusable.Sleep(2000);
        test.log(Status.INFO, "Setting Data to elements");
        setData(Data.get(2));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        test.info("Switching to alert and getting text");
        driver.switchTo().alert().accept();
        test.info("Accepting the alert");
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected)){
            log.info("Customer Added Successfully");
            test.pass("Customer Added Successfully");
        }
        else {
            test.fail("Customer not Added Successfully");
        }
    }
    @Test(priority = 12)
    public void SameUsernameDifferentZipCode(){
        ExtentTest test=extentReports.createTest("SameUsernameDifferentZipCode","Checking Same Customer with other Zipcode is added or not");
        Reusable.Sleep(2000);
        test.log(Status.INFO, "Setting Data to elements");
        setData(Data.get(3));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        test.info("Switching to alert and getting text");
        driver.switchTo().alert().accept();
        test.info("Accepting the alert");
        Assert.assertTrue(message.contains(ExistingCustomerExpected),"Manager Add Customer with Existing Username Different ZipCode");
        if(message.contains(ExistingCustomerExpected)){
            log.info("Customer may be duplicate not Added");
            test.pass("Customer may be duplicate not Added");
        }
        else {
            test.fail("Customer may be duplicate Added");
        }

    }
    @Test(priority = 13)
    public void SameCustomer(){
        ExtentTest test=extentReports.createTest("SameCustomer","Checking Same Customer is added or not");
        Reusable.Sleep(2000);
        test.log(Status.INFO, "Setting Data to elements");
        setData(Data.get(4));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        test.info("Switching to alert and getting text");
        driver.switchTo().alert().accept();
        test.info("Accepting the alert");
        Assert.assertTrue(message.contains(ExistingCustomerExpected),"Manager Add Customer with Existing Username");
        if(message.contains(ExistingCustomerExpected)){
            log.info("Customer may be duplicate not Added");
            test.pass("Customer may be duplicate not Added");
        }
        else {
            test.fail("Customer may be duplicate Added");
        }
        extentReports.flush();
    }

    public void setData(String[] Data){
        FName.sendKeys(Data[0]);
        LName.sendKeys(Data[1]);
        ZipCode.sendKeys(Data[2]);
        AddCustomer.click();

    }
}
