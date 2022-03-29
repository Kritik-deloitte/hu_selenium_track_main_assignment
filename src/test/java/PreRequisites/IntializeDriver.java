/*
KritikBansal
24-March-2022
 */
package PreRequisites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

//prerequisites that have been done before reaching the open webpage scenario scenario
public class IntializeDriver {

    public static WebDriver driver;

    @BeforeTest
    public static WebDriver intialSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kribansal\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver=new ChromeDriver();
        //Maximizing the window
        driver.manage().window().maximize();
        //implicit wait of 5 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        return driver;
    }
    @AfterTest
    public static void closeDriver(){
        //closing web driver
        driver.close();
    }
}
