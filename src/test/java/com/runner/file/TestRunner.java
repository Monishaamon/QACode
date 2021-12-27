package com.runner.file;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.classs.Base_Class;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\com\\feature\\file", glue = "com\\step\\definition")

public class TestRunner {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		driver = Base_Class.getbrowser("chrome");

	}

}
