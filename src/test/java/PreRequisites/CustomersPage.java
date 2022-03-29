/*
KritikBansal
29-March-2022
 */
package PreRequisites;

import Pages.MangerOptionsPage;
import Pages.OpenPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

//prerequisites that have been done before reaching the add customers scenario
public class CustomersPage extends IntializeDriver{
    WebElement element=null;
    @BeforeTest
    public void getPage(){
        Reusable.Sleep(2000);
        //finding and clicking manager login button in the landing page
        element= OpenPage.ManagerLoginButton(driver);
        element.click();

        Reusable.Sleep(1000);
        //finding and clicking add customers button in the manager options page
        element= MangerOptionsPage.AddCustomerButton(driver);
        element.click();
    }
}
