package wrappers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {

    public static ExtentReports extent;
    private static ExtentSparkReporter spark;

    public synchronized static ExtentReports getReporter() {
        

        if (extent == null) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("Report.html")
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();
            spark.config().setTheme(Theme.DARK);
            extent.attachReporter(spark);

        }
        return extent;
    }
}
