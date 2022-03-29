/*
KritikBansal
29-March-2022
 */
package PreRequisites;

import Pages.AddCustomersPage;
import Pages.MangerOptionsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import java.util.List;

//prerequisites that have been done before reaching the add account scenario
public class AccountPage extends CustomersPage{
    List<String[]> Data= Reusable.read();

    //creating the object of elements on the customer page
    private WebElement FName=null;
    private WebElement LName=null;
    private WebElement ZipCode=null;
    private WebElement AddCustomer=null;

    @BeforeTest
    public void Account(){
        //initialing and finding each and every element
        FName= AddCustomersPage.FirstNameInput(driver);
        LName= AddCustomersPage.LastNameInput(driver);
        ZipCode=AddCustomersPage.ZipCodeInput(driver);
        AddCustomer=AddCustomersPage.AddCustomerButton(driver);
        //loop through the data in the Excel file
        for(int i=0;i<4;i++){
            Reusable.Sleep(2000);
            //setting the data into the input fields
            setData(Data.get(i));
            Reusable.Sleep(1000);
            //accepting the alerts pop up
            driver.switchTo().alert().accept();
        }
        //clicking the open account button
        MangerOptionsPage.OpenAccountButton(driver).click();
        Reusable.Sleep(1000);

    }
    //set data into the input text
    public void setData(String[] Data){
        FName.sendKeys(Data[0]);
        LName.sendKeys(Data[1]);
        ZipCode.sendKeys(Data[2]);
        AddCustomer.click();
    }
}
