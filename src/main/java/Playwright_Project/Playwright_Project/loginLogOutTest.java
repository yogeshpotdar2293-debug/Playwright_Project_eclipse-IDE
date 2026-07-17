package Playwright_Project.Playwright_Project;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class loginLogOutTest {

	static Browser browser;
	static Page page;

	@Test
	public void LoginTest() {

		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			page = browser.newPage();

			page.navigate("https://freelance-learn-automation.vercel.app/login");

			//PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses"); // It will wait for 5 sec.
			
			Assert.assertTrue(page.title().contains("Learn Automation Courses"));
			
			page.getByPlaceholder("Enter Email").fill("admin@email.com");
			
			page.locator("#password1").fill("admin@123");
			
			page.locator(".submit-btn").click();
			
			PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
			
			Assert.assertTrue(page.locator(".welcomeMessage").textContent().contains("Welcome"));
			
			page.getByAltText("menu").click();
			
			page.getByText("Sign out").click();
			
			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
			
			Assert.assertTrue(page.url().contains("login"));

		}

		finally {
			page.close();

			browser.close();
			
		}
	}

}
