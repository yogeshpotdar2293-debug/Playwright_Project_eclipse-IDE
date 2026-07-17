package com.learnautomation.playwright.pages;

import java.util.List;

import com.learnautomation.playwright.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpPage extends BasePage {

	private final Locator txtName;
	private final Locator txtEmail;
	private final Locator txtPassword;
	private final Locator checkBoxes;
	private final Locator btnRadio;
	private final Locator selectState;
	private final Locator selectHobbies;
	private final Locator btnSignUp;
	private final Locator lblmessage;

	public SignUpPage(Page page) {
		super(page);
		txtName = page.locator("#name");
		txtEmail = page.locator("#email");
		txtPassword = page.locator("#password");
		checkBoxes = page.locator(".form-check-input");
		btnRadio = page.locator("#gender1");
		selectState = page.locator("#state");
		selectHobbies = page.locator("#hobbies");
		btnSignUp = page.locator(".submit-btn");
		lblmessage = page.locator(".Toastify__toast-body");
	}

	public SignUpPage enterName(String name) {
		txtName.fill(name);
		return this;
	}

	public SignUpPage enterEmail(String email) {
		txtEmail.fill(email);
		return this;
	}

	public SignUpPage enterPassword(String password) {
		txtPassword.fill(password);
		return this;
	}

	public SignUpPage selectInterests(List<String> interests) {
		for (String interest : interests) {
			page.getByLabel(interest).check();
		}
		return this;
	}

	public Locator getCheckBoxes() {
		return checkBoxes;
	}

	public SignUpPage selectGender(String gender) {
		btnRadio.click();
		return this;
	}

	public Locator getBtnRadio() {
		return btnRadio;
	}
	
	public SignUpPage selectState (String state) {
		selectState.selectOption(state);
		return this;
	}

	public SignUpPage selectHobbies(String hobbies) {
			selectHobbies.selectOption(hobbies);
		return this;
	}

	public Locator getSelectHobbies() {
		return selectHobbies;
	}

	public SignUpPage clickSignUp() {
		btnSignUp.click();
		return this;
	}

	public Locator getsuccessMessage() {
		return lblmessage;
	}

	public Locator getSelectState() {
		return selectState;
	}

}
