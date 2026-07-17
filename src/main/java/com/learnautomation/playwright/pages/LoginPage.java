package com.learnautomation.playwright.pages;

import com.learnautomation.playwright.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

	private final Locator txtEmail;
	private final Locator txtPassword;
	private final Locator btnSignin;
	private final Locator lblmessage;
	private final Locator linkSignUp;

	public LoginPage(Page page) {
		super(page);
		txtEmail = page.getByPlaceholder("Enter Email");
		txtPassword = page.locator("#password1");
		btnSignin = page.locator(".submit-btn");
		lblmessage = page.locator(".errorMessage");
		linkSignUp = page.locator(".subLink");

	}

	public LoginPage enterEmail(String email) {
		txtEmail.fill(email);
		return this;
	}

	public LoginPage enterPassword(String password) {
		txtPassword.fill(password);
		return this;
	}

	public LoginPage clickSignin() {
		btnSignin.click();
		return this;
	}
	
	public Locator getErrorMessage() {
		return lblmessage;
	}
	
	public LoginPage clickSignUp() {
		linkSignUp.click();
		 return this;
	}
	

}
