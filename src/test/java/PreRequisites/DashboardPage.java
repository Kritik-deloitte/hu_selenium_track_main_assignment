package PreRequisites;

import Pages.AddAccountPage;
import Pages.CustomerLoginPage;
import Pages.OpenPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class DashboardPage extends AccountPage{

    WebElement Customers=null;
    WebElement Currency=null;

    @BeforeTest
    public void getDepositPage(){
        Customers= AddAccountPage.CustomerDropdown(driver);
        Currency=AddAccountPage.CurrencyDropdown(driver);
        Reusable.Sleep(1000);
        Select CustDropdown=new Select(Customers);
        Select CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Rupee");
        Reusable.Sleep(1000);
        AddAccountPage.ProcessButton(driver).click();
        driver.switchTo().alert().accept();
        Reusable.Sleep(1000);
        CustDropdown=new Select(Customers);
        CurrDropdown=new Select(Currency);
        CustDropdown.selectByValue("6");
        CurrDropdown.selectByValue("Dollar");
        Reusable.Sleep(1000);
        AddAccountPage.ProcessButton(driver).click();
        driver.switchTo().alert().accept();
        Reusable.Sleep(1000);
        OpenPage.HomeButton(driver).click();
        Reusable.Sleep(1000);
        OpenPage.CustomerLoginButton(driver).click();
        Reusable.Sleep(1000);
        Select name= new Select(CustomerLoginPage.CustomerNameInput(driver));
        name.selectByValue("6");
        Reusable.Sleep(1000);
        CustomerLoginPage.LoginButton(driver).click();
        Reusable.Sleep(1000);
    }
}
