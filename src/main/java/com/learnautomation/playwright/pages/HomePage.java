package com.learnautomation.playwright.pages;

import com.learnautomation.playwright.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
	
	private final Locator lbWelcomeMessage;
	
	public HomePage(Page page) {
		super(page);
		lbWelcomeMessage = page.locator(".welcomeMessage");
	}
	
	public Locator getWelcomeMessage() {
	    return lbWelcomeMessage;
	}

}
