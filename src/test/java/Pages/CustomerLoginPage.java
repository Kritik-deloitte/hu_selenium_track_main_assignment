package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage {
    static WebElement element=null;
    public static WebElement CustomerNameInput(WebDriver driver){
        element=driver.findElement(By.id("userSelect"));
        return element;
    }

    public static WebElement LoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Login']"));
        return element;
    }
}
