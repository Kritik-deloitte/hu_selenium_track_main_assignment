package Scenarios.AddCustomers;

import Pages.AddCustomersPage;
import PreRequisites.CustomersPage;
import PreRequisites.Reusable;
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



    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
    }

    @Test(priority = 1)
    public void fNameInputDisplayed(){
        FName= AddCustomersPage.FirstNameInput(driver);
        Assert.assertTrue(FName.isDisplayed(),"FName Input Field not Displayed");
        if(FName.isDisplayed()){
            log.info("FName Input Field is Displayed");
        }
    }
    @Test(priority = 2)
    public void fNameInputEnabled(){
        Assert.assertTrue(FName.isEnabled(),"FName Input Field not Enabled");
        if(FName.isEnabled()){
            log.info("FName Input Field is Enabled");
        }
    }
    @Test(priority = 3)
    public void lNameInputDisplayed(){
        LName= AddCustomersPage.LastNameInput(driver);
        Assert.assertTrue(LName.isDisplayed(),"LName Input Field not Displayed");
        if(LName.isDisplayed()){
            log.info("LName Input Field is Displayed");
        }
    }
    @Test(priority = 4)
    public void lNameInputEnabled(){
        Assert.assertTrue(LName.isEnabled(),"LName Input Field not Enabled");
        if(LName.isEnabled()){
            log.info("LName Input Field is Enabled");
        }
    }
    @Test(priority = 5)
    public void ZipCodeInputDisplayed(){
        ZipCode= AddCustomersPage.ZipCodeInput(driver);
        Assert.assertTrue(ZipCode.isDisplayed(),"ZipCode Input Field not Displayed");
        if(ZipCode.isDisplayed()){
            log.info("ZipCode Input Field is Displayed");
        }
    }
    @Test(priority = 6)
    public void ZipCodeInputEnabled(){
        Assert.assertTrue(ZipCode.isEnabled(),"ZipCode Input Field not Enabled");
        if(ZipCode.isEnabled()){
            log.info("ZipCode Input Field is Enabled");
        }
    }
    @Test(priority = 7)
    public void AddCustomerButtonDisplayed(){
        AddCustomer= AddCustomersPage.AddCustomerButton(driver);
        Assert.assertTrue(AddCustomer.isDisplayed(),"Add Customer Button Field not Displayed");
        if(AddCustomer.isDisplayed()){
            log.info("Add Customer Button Field is Displayed");
        }
    }
    @Test(priority = 8)
    public void AddCustomerButtonEnabled(){
        Assert.assertTrue(AddCustomer.isEnabled(),"Add Customer Button Field not Enabled");
        if(AddCustomer.isEnabled()){
            log.info("Add Customer Button Field is Enabled");
        }
    }
    @Test(priority = 9)
    public void UniqueCustomer1(){
        Reusable.Sleep(2000);
        setData(Data.get(0));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected))
            log.info("Customer Added Successfully");

    }
    @Test(priority = 10)
    public void CustomerWithCaseChange(){
        Reusable.Sleep(2000);
        setData(Data.get(1));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected))
            log.info("Customer Added Successfully");
    }
    @Test(priority = 11)
    public void UniqueCustomer2(){
        Reusable.Sleep(2000);
        setData(Data.get(2));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(UniqueCustomerExpected),"Manager Can't Add Customer with Unique Username");
        if(message.contains(UniqueCustomerExpected))
            log.info("Customer Added Successfully");
    }
    @Test(priority = 12)
    public void SameUsernameDifferentZipCode(){
        Reusable.Sleep(2000);
        setData(Data.get(3));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(ExistingCustomerExpected),"Manager Add Customer with Existing Username Different ZipCode");
        if(message.contains(ExistingCustomerExpected))
            log.info("Customer may be duplicate not Added");
    }
    @Test(priority = 13)
    public void SameCustomer(){
        Reusable.Sleep(2000);
        setData(Data.get(4));
        Reusable.Sleep(1000);
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(ExistingCustomerExpected),"Manager Add Customer with Existing Username");
        if(message.contains(ExistingCustomerExpected))
            log.info("Customer may be duplicate not Added");
    }

    public void setData(String[] Data){
        FName.sendKeys(Data[0]);
        LName.sendKeys(Data[1]);
        ZipCode.sendKeys(Data[2]);
        AddCustomer.click();
    }
}
