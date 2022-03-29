/*
KritikBansal
29-March-2022
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//POM Class Of Customer Dashboard Section Returns Element of Customer Dashboard Page
public class CustomerDashboardPage {
    static WebElement element=null;

    //returns account holder name text
    public static WebElement AccountName(WebDriver driver){
        element=driver.findElement(By.xpath("//span[@class='fontBig ng-binding']"));
        return element;
    }
    // return balance feild
    public static WebElement Balance(WebDriver driver){
        element=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        return element;
    }
    // returns transaction button
    public static WebElement TransactionButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        return element;
    }
    // returns deposit button
    public static WebElement DepositButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        return element;
    }
    // returns withdraw button
    public static WebElement WithdrawButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[@ng-class='btnClass3']"));
        return element;
    }
    // returns deposit amount input
    public static WebElement DepositAmountInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='amount']"));
        return element;
    }
    //returns deposit amount button
    public static WebElement DepositAmountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Deposit']"));
        return element;
    }
    //return withdraw amount input
    public static WebElement WithdrawAmountInput(WebDriver driver){
        element=driver.findElement(By.xpath("//input[@ng-model='amount']"));
        return element;
    }
    //returns withdraw amount button
    public static WebElement WithdrawAmountButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Withdraw']"));
        return element;
    }
    //return the final message text
    public static WebElement SuccessMessage(WebDriver driver){
        element=driver.findElement(By.xpath("//span[@ng-show='message']"));
        return element;
    }
    //returns list of all transactions
    public static List<WebElement> TransactionList(WebDriver driver){
        List<WebElement> trans = driver.findElements(By.xpath("//tbody/tr"));
        return trans;
    }
    //returns back button
    public static WebElement BackButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Back']"));
        return element;
    }
    //returns reset button
    public static WebElement ResetButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Reset']"));
        return element;
    }
}
