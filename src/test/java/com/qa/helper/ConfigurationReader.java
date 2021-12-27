package com.qa.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	public static Properties p;

	public ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\divya\\eclipse-workspace\\Cucumber001\\src\\test\\java\\com\\qa\\properties\\qa.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}

	public String getUsername() {
		String username = p.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}

}
