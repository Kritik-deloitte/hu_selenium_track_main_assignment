/*
KritikBansal
29-March-2022
 */
package PreRequisites;

import Pages.AddAccountPage;
import Pages.CustomerLoginPage;
import Pages.OpenPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

//prerequisites that have been done before reaching the withdraw/deposit scenario
public class DashboardPage extends AccountPage{
    //referecing the web elements
    WebElement Customers=null;
    WebElement Currency=null;

    @BeforeTest
    public void getDepositPage(){
        //finding the currency and customers dropdown in the open account page
        Customers= AddAccountPage.CustomerDropdown(driver);
        Currency=AddAccountPage.CurrencyDropdown(driver);
        Reusable.Sleep(1000);
        //initializing the select class for both the dropdowns
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        //selecting the values for both the dropdown
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        //pressing the open account button
        AddAccountPage.ProcessButton(driver).click();
        //accepting the alerts poop ups
        driver.switchTo().alert().accept();
        Reusable.Sleep(1000);
        //again same thing with the new currency
        CustDropdown=new Select(Customers);
        CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        //changing the currency
        CurrDropdown.selectByValue("Dollar");
        Reusable.Sleep(1000);
        AddAccountPage.ProcessButton(driver).click();
        driver.switchTo().alert().accept();
        Reusable.Sleep(1000);
        //back to home
        OpenPage.HomeButton(driver).click();
        Reusable.Sleep(1000);
        //press customers login button
        OpenPage.CustomerLoginButton(driver).click();
        Reusable.Sleep(1000);
        //find the customers account by its name
        Select name= new Select(CustomerLoginPage.CustomerNameInput(driver));
        name.selectByValue("6");
        Reusable.Sleep(1000);
        //press login
        CustomerLoginPage.LoginButton(driver).click();
        Reusable.Sleep(1000);
    }
}
