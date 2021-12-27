package com.step.definition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.base.classs.Base_Class;
import com.pom.classs.QaLogin;
import com.qa.helper.FileReaderManager;
import com.runner.file.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefinition extends Base_Class {

	public static WebDriver driver = TestRunner.driver;

	QaLogin qa = new QaLogin(driver);

	@Given("User launch the url")
	public void user_launch_the_url() {
		geturl("https://qa-fake.herokuapp.com/");
	}

	@When("User enter the valid username")
	public void user_enter_the_valid_username() throws IOException {
		String username = FileReaderManager.getInstance().getCrInstance().getUsername();
		sendkeys(qa.getUsername(), username);
	}

	@When("User enter the valid password")
	public void user_enter_the_valid_password() throws IOException {
		String password = FileReaderManager.getInstance().getCrInstance().getPassword();
		sendkeys(qa.getPassword(), password);
	}

	@When("User able to click the remember me checkbox")
	public void user_able_to_click_the_remember_me_checkbox() {
		click(qa.getCheckbox());
	}

	@When("user able to click the login button")
	public void user_able_to_click_the_login_button() {
		click(qa.getLogin());
	}

	@Then("User verify the login is successful")
	public void user_verify_the_login_is_successful() {
	}

}
