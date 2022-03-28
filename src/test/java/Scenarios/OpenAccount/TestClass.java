package Scenarios.OpenAccount;

import Pages.AddAccountPage;
import PreRequisites.AccountPage;
import PreRequisites.Reusable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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


    @BeforeTest
    public void init(){
        log.info("Pre-requisites Achieved");
        System.out.println("Starting Test Execution");
        System.out.println("<------------------------------------------------------------------>\n");
        Reusable.Sleep(2000);
    }

    @Test(priority = 1)
    public void CustomersDropdownDisplayed(){
        Customers= AddAccountPage.CustomerDropdown(driver);
        Assert.assertTrue(Customers.isDisplayed(),"Customers Dropdown not Displayed");
        if(Customers.isDisplayed()){
            log.info("Customers Dropdown is Displayed");
        }
    }
    @Test(priority = 2)
    public void CustomersDropdownEnabled(){
        Assert.assertTrue(Customers.isEnabled(),"Customers Dropdown not Enabled");
        if(Customers.isEnabled()){
            log.info("Customers Dropdown is Enabled");
        }
    }
    @Test(priority = 3)
    public void CurrencyDropDownDisplayed(){
        Currency= AddAccountPage.CurrencyDropdown(driver);
        Assert.assertTrue(Currency.isDisplayed(),"Currency Dropdown not Displayed");
        if(Currency.isDisplayed()){
            log.info("Currency Dropdown is Displayed");
        }
    }
    @Test(priority = 4)
    public void CurrencyDropdownEnabled(){
        Assert.assertTrue(Currency.isEnabled(),"Currency Dropdown not Enabled");
        if(Currency.isEnabled()){
            log.info("Currency Dropdown is Enabled");
        }
    }
    @Test(priority = 5)
    public void ProcessButtonDisplayed(){
        Process= AddAccountPage.ProcessButton(driver);
        Assert.assertTrue(Process.isDisplayed(),"Process Button not Displayed");
        if(Process.isDisplayed()){
            log.info("Process Button is Displayed");
        }
    }
    @Test(priority = 6)
    public void ProcessButtonEnabled(){
        Assert.assertTrue(Process.isEnabled(),"Process Button not Enabled");
        if(Process.isEnabled()){
            log.info("Process Button is Enabled");
        }
    }
    @Test(priority = 7)
    public void CustomerDropdownHavingUniqueItems(){
        Assert.assertTrue(isSelectOptionsRepeating(Customers),"Customers Dropdown Have Duplicate Values");
        if(Process.isEnabled()){
            log.info("Customers Dropdown Have Duplicate Values");
        }
    }
    @Test(priority = 8)
    public void CurrencyDropdownHavingUniqueItems(){
        Assert.assertTrue(isSelectOptionsRepeating(Currency),"Currency Dropdown Have Duplicate Values");
        if(Process.isEnabled()){
            log.info("Currency Dropdown Have Duplicate Values");
        }
        Reusable.Sleep(1000);
    }
    @Test(priority = 9)
    public void AccountWithUniqueCurrency(){
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
        if(message.contains(expected))
            log.info("Account Created with unique Currency");
        Reusable.Sleep(1000);
    }
    @Test(priority = 10)
    public void AccountWithOtherCurrency(){
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Dollar");
        Reusable.Sleep(1000);
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(message.contains(expected),"Account Not Created with unique Currency");
        if(message.contains(expected))
            log.info("Account Created with unique Currency");
        Reusable.Sleep(1000);
    }
    @Test(priority = 11)
    public void AccountWithSameCurrency(){
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        Process.click();
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertFalse(message.contains(expected), "Account Created with same Currency");
        if(message.contains(expected))
            log.info("Account not Created with same Currency");
        Reusable.Sleep(1000);
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
