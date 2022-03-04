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
            spark = new ExtentSparkReporter("Reports/Report.html")

            		
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
            spark.config().setTheme(Theme.STANDARD);
            extent.attachReporter(spark);
            spark.config().setReportName("Explora Automation Report");
            spark.config().setTimeStampFormat("dd MMMM , yyyy, HH:mm");
            extent.setSystemInfo("Creation By", "Montefusco - Paolino");
            extent.setSystemInfo("Company", "Nexsoft SPA");
            extent.setSystemInfo("Client", "Explora SA");
            
            

        }
        return extent;
    }
}
