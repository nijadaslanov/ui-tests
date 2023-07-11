package com.via.ui.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Optional;

import static com.via.ui.constants.BrowserConstants.BROWSER;
import static com.via.ui.constants.BrowserConstants.CHROMIUM;

@Slf4j
public class TestListener implements ITestListener {
    public static final String TEST_SUITE_STARTED = "Test suite {} started with browser {}";
    public static final String TEST_SUITE_FINISHED = "Test suite {} finished with browser {}";
    public static final String TEST_STARTED = "Test {} started on browser {}";
    public static final String TEST_PASSED = "Test {} passed with browser {}";
    public static final String TEST_FAILED = "Test {} failed on browser {}";
    public static final String TEST_SKIPPED = "Test {} skipped on browser {}";

    @Override
    public void onStart(ITestContext context) {
        String browserName = Optional.ofNullable(context.getCurrentXmlTest().getParameter(BROWSER)).orElse(CHROMIUM);
        log.info(TEST_SUITE_STARTED, context.getName(), browserName);
    }

    @Override
    public void onFinish(ITestContext context) {
        String browserName = Optional.ofNullable(context.getCurrentXmlTest().getParameter(BROWSER)).orElse(CHROMIUM);
        log.info(TEST_SUITE_FINISHED, context.getName(), browserName);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browserName = Optional.ofNullable(result.getTestContext().getCurrentXmlTest().getParameter(BROWSER)).orElse(
                CHROMIUM);
        String className = result.getTestClass().getRealClass().getSimpleName();
        log.info(TEST_STARTED, className, browserName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String browserName = Optional.ofNullable(result.getTestContext().getCurrentXmlTest().getParameter(BROWSER)).orElse(
                CHROMIUM);
        String className = result.getTestClass().getRealClass().getSimpleName();
        log.info(TEST_PASSED, className, browserName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String browserName = Optional.ofNullable(result.getTestContext().getCurrentXmlTest().getParameter(BROWSER)).orElse(
                CHROMIUM);
        String className = result.getTestClass().getRealClass().getSimpleName();
        log.info(TEST_FAILED, className, browserName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String browserName = Optional.ofNullable(result.getTestContext().getCurrentXmlTest().getParameter(BROWSER)).orElse(
                CHROMIUM);
        String className = result.getTestClass().getRealClass().getSimpleName();
        log.info(TEST_SKIPPED, className, browserName);
    }
}
