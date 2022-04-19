package com.freecrm.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReports3 implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest test;

	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("dd.mm.yyyy.HH.mm").format(new Date());
		String repName = " Report-"+ timeStamp + ".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\10693635\\eclipse-workspace\\FreeCRM\\reports\\"+context.getName()+repName);

		// customization of view report
		spark.config().setDocumentTitle("FreeCRM_Application");
		spark.config().setReportName("Regression_Test");
		spark.config().setTheme(Theme.DARK);

		// setting system info
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Author", "AMK");
		extent.setSystemInfo("Os", "windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("TestRunner Name", context.getName());
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.INFO, result.getName() + "method started");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.pass(MarkupHelper.createLabel("case has passed", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.fail(MarkupHelper.createLabel("case has failed", ExtentColor.RED));
		test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.skip(MarkupHelper.createLabel("case has skipped", ExtentColor.BLUE));
		test.skip(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		// writing all logs into report
		extent.flush();
	}
}
