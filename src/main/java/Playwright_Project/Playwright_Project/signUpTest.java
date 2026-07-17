package Playwright_Project.Playwright_Project;

import java.util.regex.Pattern;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
public class signUpTest {

	static Browser browser;
	static Page page;

	public static void main(String[] args) {

		try {
			browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

			page = browser.newPage();

			page.navigate("https://freelance-learn-automation.vercel.app/login");

			PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
			
			page.locator(".subLink").click();
			
			page.locator("#name").fill("Yogesh Potdar");
			
			page.locator("#email").fill("yogeshpotdar@email.com");
			
			page.locator("#password").fill("Yogesh22@");
			
			page.getByText("Selenium").check();
			
			page.locator("#gender1").check();
			
			page.locator("#state").selectOption("Maharashtra");
			
			page.locator("#hobbies").selectOption("Dancing");
			
			page.locator(".submit-btn").click();
			
			PlaywrightAssertions.assertThat(page.getByText("Email already registered!")).containsText(Pattern.compile("Email already registered!"));
			
			page.locator(".subLink").click();

		}

		finally {

			page.close();

			browser.close();

		}

	}

}
