package com.learnautomation.playwright.base;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.learnautomation.playwright.utils.ExcelUtil;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	static Playwright playwright;
	static Browser browser;
	protected Page page;
	private int currentRow;
	private String currentSheet;
	
	protected void setExcelDetails(String sheet, int row) {
	    this.currentSheet = sheet;
	    this.currentRow = row;
	}

	@BeforeClass
	public static void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		System.out.println("Before Class executed sucessfully");
	}

	@BeforeMethod
	public void createPage() {
		page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		System.out.println("Before Method executed sucessfully");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {

	    if (result.getStatus() == ITestResult.SUCCESS) {
	        ExcelUtil.writeResult(currentSheet, currentRow, 3, "PASS");
	    } else {
	        ExcelUtil.writeResult(currentSheet, currentRow, 3, "FAIL");
	    }
	    page.close();
	    System.out.println("After Method executed sucessfully");
	}


	@AfterClass
	public void closeBrowser() {
		browser.close();
		playwright.close();
		System.out.println("After Class executed sucessfully");
	}

}
