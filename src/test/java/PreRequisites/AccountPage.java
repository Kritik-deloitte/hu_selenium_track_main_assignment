package PreRequisites;

import Pages.AddCustomersPage;
import Pages.MangerOptionsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import java.util.List;

public class AccountPage extends CustomersPage{
    List<String[]> Data= Reusable.read();
    private WebElement FName=null;
    private WebElement LName=null;
    private WebElement ZipCode=null;
    private WebElement AddCustomer=null;

    @BeforeTest
    public void Account(){
        FName= AddCustomersPage.FirstNameInput(driver);
        LName= AddCustomersPage.LastNameInput(driver);
        ZipCode=AddCustomersPage.ZipCodeInput(driver);
        AddCustomer=AddCustomersPage.AddCustomerButton(driver);
        for(int i=0;i<4;i++){
            Reusable.Sleep(2000);
            setData(Data.get(i));
            Reusable.Sleep(1000);
            driver.switchTo().alert().accept();
        }
        MangerOptionsPage.OpenAccountButton(driver).click();
        Reusable.Sleep(1000);

    }
    public void setData(String[] Data){
        FName.sendKeys(Data[0]);
        LName.sendKeys(Data[1]);
        ZipCode.sendKeys(Data[2]);
        AddCustomer.click();
    }
}
