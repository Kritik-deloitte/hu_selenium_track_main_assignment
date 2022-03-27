package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenPage {

    private static WebElement element=null;

    public static WebElement HomeButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Home']"));
        return element;
    }

    public static WebElement CustomerLoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Customer Login']"));
        return element;
    }

    public static WebElement ManagerLoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        return element;
    }

    public static WebElement TitleText(WebDriver driver){
        element=driver.findElement(By.xpath("//strong[text()='XYZ Bank']"));
        return element;
    }
}
