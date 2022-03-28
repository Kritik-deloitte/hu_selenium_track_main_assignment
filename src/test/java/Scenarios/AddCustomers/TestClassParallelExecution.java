package Scenarios.AddCustomers;

import Pages.AddCustomersPage;
import Pages.MangerOptionsPage;
import Pages.OpenPage;
import PreRequisites.Reusable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClassParallelExecution {

    List<String[]> Data=Reusable.read();

    public WebDriver init(WebDriver driver){
        System.out.println("<-------------------------------------------------------->");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kribansal\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver=new ChromeDriver();
        //Maximizing the window
        driver.manage().window().maximize();
        //implicit wait of 5 secs
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Reusable.Sleep(2000);
        WebElement element;
        element= OpenPage.ManagerLoginButton(driver);
        element.click();
        Reusable.Sleep(1000);
        element= MangerOptionsPage.AddCustomerButton(driver);
        element.click();
        return driver;
    }
    public WebDriver fillData(WebDriver driver,String[] Data){
        WebElement element;
        element= AddCustomersPage.FirstNameInput(driver);
        element.sendKeys(Data[0]);
        element= AddCustomersPage.LastNameInput(driver);
        element.sendKeys(Data[1]);
        element= AddCustomersPage.ZipCodeInput(driver);
        element.sendKeys(Data[2]);
        element= AddCustomersPage.AddCustomerButton(driver);
        element.click();
        return driver;
    }

    @Test
    public void NewData(){
        WebDriver driver=null;
        WebElement element;
        driver=init(driver);
        driver=fillData(driver,Data.get(0));
        Reusable.Sleep(10000);
    }
    @Test
    public void NewData1(){
        WebDriver driver=null;
        WebElement element;
        driver=init(driver);
        Reusable.Sleep(2000);
        driver=fillData(driver,Data.get(1));
        Reusable.Sleep(10000);
    }
    @Test
    public void SameData(){
        WebDriver driver=null;
        WebElement element;
        driver=init(driver);
        Reusable.Sleep(3000);
        driver=fillData(driver,Data.get(2));
        Reusable.Sleep(10000);
    }
    @Test
    public void ChangeCaseData(){
        WebDriver driver=null;
        WebElement element;
        driver=init(driver);
        Reusable.Sleep(4000);
        driver=fillData(driver,Data.get(3));
        Reusable.Sleep(10000);
    }

}
