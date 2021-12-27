package com.pom.classs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaLogin {

	public static WebDriver driver;

	public QaLogin(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement Username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='rememberme']")
	private WebElement Checkbox;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement Login;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getCheckbox() {
		return Checkbox;
	}

	public WebElement getLogin() {
		return Login;
	}

}
