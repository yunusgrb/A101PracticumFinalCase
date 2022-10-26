package Tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

        Log.info("");
        Log.info(iTestResult.getMethod().getMethodName()+" Started");
        Log.info(iTestResult.getMethod().getDescription());
        Log.info(iTestResult.getHost());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(iTestResult.getMethod().getMethodName()+" PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        Log.info("Failed because of- "+iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped because of - "+ iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
