package com.learnautomation.playwright.tests;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.learnautomation.playwright.base.BaseTest;
import com.learnautomation.playwright.pages.LoginPage;
import com.learnautomation.playwright.pages.SignUpPage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class SignUpTest extends BaseTest {

	@Test
	public void SignUpTest() {
		LoginPage loginPage = new LoginPage(page);
		loginPage.clickSignUp();
		PlaywrightAssertions.assertThat(page).hasURL("https://freelance-learn-automation.vercel.app/signup");
		SignUpPage signUpPage = new SignUpPage(page);
		signUpPage.enterName("Yogesh").enterEmail("yogi@email.com").enterPassword("yogi@123");
		signUpPage.selectInterests(Arrays.asList("Python", "SQL", "JavaScript", "Selenium"));
		signUpPage.selectGender("Male").selectState("Maharashtra").selectHobbies("Playing").clickSignUp();
		PlaywrightAssertions.assertThat(signUpPage.getsuccessMessage()).containsText("Signup successfully");

	}

}
