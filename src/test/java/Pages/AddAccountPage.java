package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccountPage {

    static WebElement element=null;

    public static WebElement CustomerDropdown(WebDriver driver){
        element=driver.findElement(By.id("userSelect"));
        return element;
    }

    public static WebElement CurrencyDropdown(WebDriver driver){
        element=driver.findElement(By.id("currency"));
        return element;
    }
    public static WebElement ProcessButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Process']"));
        return element;
    }
}
