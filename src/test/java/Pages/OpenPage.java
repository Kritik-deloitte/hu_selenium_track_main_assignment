/*
KritikBansal
29-March-2022
 */
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//POM Class Of Landing page Section Returns Element of landing Page
public class OpenPage {

    private static WebElement element=null;

    //returns home button
    public static WebElement HomeButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Home']"));
        return element;
    }
    //returns customer login button
    public static WebElement CustomerLoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Customer Login']"));
        return element;
    }
    //returns manager login button
    public static WebElement ManagerLoginButton(WebDriver driver){
        element=driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        return element;
    }
    //returns title text of the page
    public static WebElement TitleText(WebDriver driver){
        element=driver.findElement(By.xpath("//strong[text()='XYZ Bank']"));
        return element;
    }
}
