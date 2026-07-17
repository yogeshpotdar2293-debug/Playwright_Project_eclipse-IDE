package com.learnautomation.playwright.tests;

import com.learnautomation.playwright.base.BaseTest;
import com.learnautomation.playwright.pages.HomePage;
import com.learnautomation.playwright.pages.LoginPage;
import com.learnautomation.playwright.utils.ExcelUtil;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "ValidLogin", priority = 0)
	public void LoginTest(String rowNum, String email, String password) {
		setExcelDetails("ValidLogin", Integer.parseInt(rowNum));
		LoginPage loginpage = new LoginPage(page);
		HomePage homePage = new HomePage(page);
		loginpage.enterEmail(email).enterPassword(password).clickSignin();
		PlaywrightAssertions.assertThat(homePage.getWelcomeMessage()).containsText("Welcome");
	}
	
	@DataProvider(name = "ValidLogin")
	public Object[][] Logindata() {
		return ExcelUtil.getSheetData("ValidLogin");
	}

	@Test(dataProvider = "InvalidLogin", priority = 1)
	public void VerifyInvalidLoginScenarios(String rowNum, String email, String password, String expectedError) {
		setExcelDetails("InvalidLogin", Integer.parseInt(rowNum));
		LoginPage loginpage = new LoginPage(page);
		loginpage.enterEmail(email).enterPassword(password).clickSignin();
		PlaywrightAssertions.assertThat(loginpage.getErrorMessage()).containsText(expectedError);
	}

	@DataProvider(name = "InvalidLogin")
	public Object[][] InvoidLogindata() {
		return ExcelUtil.getSheetData("InvalidLogin");
	}

}
