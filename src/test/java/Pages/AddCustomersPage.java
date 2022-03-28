package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomersPage {

    static WebElement element=null;
    public static WebElement FirstNameInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='fName']"));
        return element;
    }

    public static WebElement LastNameInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='lName']"));
        return element;
    }

    public static WebElement ZipCodeInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='postCd']"));
        return element;
    }
    public static WebElement AddCustomerButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Add Customer']"));
        return element;
    }
}
