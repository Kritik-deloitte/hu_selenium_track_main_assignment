/*
KritikBansal
29-March-2022
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//POM Class Of Add Account Section Returns Element of Add Account Page
public class AddAccountPage {

    static WebElement element=null;

    //returns customer dropdown
    public static WebElement CustomerDropdown(WebDriver driver){
        element=driver.findElement(By.id("userSelect"));
        return element;
    }
    //returns currency dropdown
    public static WebElement CurrencyDropdown(WebDriver driver){
        element=driver.findElement(By.id("currency"));
        return element;
    }
    //return process button
    public static WebElement ProcessButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Process']"));
        return element;
    }
}
