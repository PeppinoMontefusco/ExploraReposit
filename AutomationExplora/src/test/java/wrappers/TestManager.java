package wrappers;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
    }

    public static synchronized ExtentTest startTest(String testName, String desc,String category) {
        ExtentTest test = extent.createTest(testName, desc).assignCategory(category);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
