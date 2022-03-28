package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerDashboardPage {
    static WebElement element=null;
    public static WebElement AccountName(WebDriver driver){
        element=driver.findElement(By.xpath("//span[@class='fontBig ng-binding']"));
        return element;
    }

    public static WebElement Balance(WebDriver driver){
        element=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        return element;
    }

    public static WebElement TransactionButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        return element;
    }
    public static WebElement DepositButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        return element;
    }
    public static WebElement WithdrawButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass3']"));
        return element;
    }
    public static WebElement DepositAmountInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='amount']"));
        return element;
    }
    public static WebElement DepositAmountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Deposit']"));
        return element;
    }
    public static WebElement WithdrawAmountInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='amount']"));
        return element;
    }
    public static WebElement WithdrawAmountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Withdraw']"));
        return element;
    }
    public static WebElement SuccessMessage(WebDriver driver){
        element=driver.findElement(By.xpath("//span[@ng-show='message']"));
        return element;
    }
    public static List<WebElement> TransactionList(WebDriver driver){
        List<WebElement> trans = driver.findElements(By.xpath("//tbody/tr"));
        return trans;
    }

    public static WebElement BackButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Back']"));
        return element;
    }
    public static WebElement ResetButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Reset']"));
        return element;
    }
}
