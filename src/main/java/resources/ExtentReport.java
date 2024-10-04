package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReport {
	private static ExtentReports extent;

	public static ExtentReports getReporterObject() {
		if (extent == null) {
			String path = System.getProperty("user.dir") + "\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path).viewConfigurer()
					.viewOrder()
					.as(new ViewName[] {
							ViewName.DASHBOARD,
							ViewName.TEST,
							ViewName.CATEGORY,
							ViewName.AUTHOR,
							ViewName.DEVICE,
							ViewName.EXCEPTION,
							ViewName.LOG
					})
					.apply();

			reporter.config().setReportName("SELLABLE UI Automation Results");
			reporter.config().setDocumentTitle("Test Result");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Amirul");
		}
		return extent;
	}
}