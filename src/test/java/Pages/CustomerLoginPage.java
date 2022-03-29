/*
KritikBansal
29-March-2022
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//POM Class Of Customer login Section Returns Element of Customer login Page
public class CustomerLoginPage {
    static WebElement element=null;
    //returns customer name input text
    public static WebElement CustomerNameInput(WebDriver driver){
        element=driver.findElement(By.id("userSelect"));
        return element;
    }
    //returns login button
    public static WebElement LoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Login']"));
        return element;
    }
}
