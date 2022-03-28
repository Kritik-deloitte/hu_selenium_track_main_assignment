package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MangerOptionsPage {
    private static WebElement element=null;

    public static WebElement AddCustomerButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        return element;
    }

    public static WebElement CustomersButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass3']"));
        return element;
    }

    public static WebElement OpenAccountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        return element;
    }
}
