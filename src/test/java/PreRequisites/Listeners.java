/*
KritikBansal
29-March-2022
 */
package PreRequisites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

// listeners class implements itestlisteners which do the specific task on the particular state of the test
public class Listeners extends IntializeDriver implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //getting the test name which is failed
        String testName=result.getMethod().getMethodName();
        //initializing the screenshot class
        TakesScreenshot ts=(TakesScreenshot) driver;
        //initializing the source of screenshot
        File src=ts.getScreenshotAs(OutputType.FILE);
        //initializing the destination of screenshot
        File des=new File(System.getProperty("user.dir")+"/Failed Tests Screenshots/"+testName+"_.jpg");
        try {
            //copy the screenshot in the destination
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //System.out.println("Skipped As Maximum Expense is Greater than 100");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Chrome Driver");
        System.out.println("<----------------------------------------------------------------->");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("<----------------------------------------------------------------->");
        System.out.println("Chrome Driver Closed");

    }
}
