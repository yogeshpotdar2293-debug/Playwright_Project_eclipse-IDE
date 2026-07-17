package Playwright_Project.Playwright_Project;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwright_practice {
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		BrowserType browserType = pw.chromium();
		Browser browser = browserType
				.launch(new BrowserType.LaunchOptions().setHeadless(true).setChannel("msedge").setSlowMo(10));
		Page page = browser.newPage();
		page.navigate("https://www.google.com/");
		String title = page.title();
		System.out.println("Title of page is: " + title);
		page.close();
		browser.close();
		pw.close();

	}

}
