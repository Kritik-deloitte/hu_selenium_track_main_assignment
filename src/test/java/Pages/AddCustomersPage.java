/*
KritikBansal
29-March-2022
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//POM Class Of Add Customer Section Returns Element of Add Customer Page
public class AddCustomersPage {

    static WebElement element=null;

    // returns fname input field
    public static WebElement FirstNameInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='fName']"));
        return element;
    }
    //returns lname input field
    public static WebElement LastNameInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='lName']"));
        return element;
    }
    // returns zipcode input field
    public static WebElement ZipCodeInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='postCd']"));
        return element;
    }
    // returns add customer button
    public static WebElement AddCustomerButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Add Customer']"));
        return element;
    }
}
