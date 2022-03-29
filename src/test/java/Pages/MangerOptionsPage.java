/*
KritikBansal
29-March-2022
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//POM Class Of Manager Option Page Section Returns Element of Manager Option Page
public class MangerOptionsPage {
    private static WebElement element=null;

    //returns add customer button
    public static WebElement AddCustomerButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        return element;
    }
    // returns customers button
    public static WebElement CustomersButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass3']"));
        return element;
    }

    //returns open account button
    public static WebElement OpenAccountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        return element;
    }
}
