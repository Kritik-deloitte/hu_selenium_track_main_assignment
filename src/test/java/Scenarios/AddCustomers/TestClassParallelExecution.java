/*
KritikBansal
29-March-2022
 */
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

//parallel execution of adding the more than one customers at the same time
public class TestClassParallelExecution {
    //reading data from the excel
    List<String[]> Data=Reusable.read();

    //initialing the elements
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
        //press manager login button
        element= OpenPage.ManagerLoginButton(driver);
        element.click();
        Reusable.Sleep(1000);
        //press the add customers button
        element= MangerOptionsPage.AddCustomerButton(driver);
        element.click();
        return driver;
    }
    //fill the data with the customers in the inputs getting form the Excel
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
    //adding the customer with the new data
    @Test
    public void NewData(){
        WebDriver driver=null;
        WebElement element;
        //initialing or doing prerequisites of the driver
        driver=init(driver);
        //filling the data into the input fields
        driver=fillData(driver,Data.get(0));
        //accepting the alert pop ups
        driver.switchTo().alert().accept();
        Reusable.Sleep(10000);
    }
    //adding the customer with new data again
    @Test
    public void NewData1(){
        WebDriver driver=null;
        WebElement element;
        //initialing or doing prerequisites of the driver
        driver=init(driver);
        //filling the data into the input fields
        driver=fillData(driver,Data.get(1));
        //accepting the alert pop ups
        driver.switchTo().alert().accept();
        Reusable.Sleep(10000);
    }
    //adding the customer with the same data
    @Test
    public void SameData(){
        WebDriver driver=null;
        WebElement element;
        //initialing or doing prerequisites of the driver
        driver=init(driver);
        //filling the data into the input fields
        driver=fillData(driver,Data.get(2));
        //accepting the alert pop ups
        driver.switchTo().alert().accept();
        Reusable.Sleep(10000);
    }
    // adding the customer with only changing the case of data
    @Test
    public void ChangeCaseData(){
        WebDriver driver=null;
        WebElement element;
        //initialing or doing prerequisites of the driver
        driver=init(driver);
        //filling the data into the input fields
        driver=fillData(driver,Data.get(3));
        //accepting the alert pop ups
        driver.switchTo().alert().accept();
        Reusable.Sleep(10000);
    }

}
