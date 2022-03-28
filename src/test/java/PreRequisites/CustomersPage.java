package PreRequisites;

import Pages.MangerOptionsPage;
import Pages.OpenPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class CustomersPage extends IntializeDriver{
    WebElement element=null;
    @BeforeTest
    public void getPage(){
        Reusable.Sleep(2000);

        element= OpenPage.ManagerLoginButton(driver);
        element.click();

        Reusable.Sleep(1000);

        element= MangerOptionsPage.AddCustomerButton(driver);
        element.click();
    }
}
