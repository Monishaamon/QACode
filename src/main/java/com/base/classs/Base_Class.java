package com.base.classs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver;

	public static WebDriver getbrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			}

			else if (browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + ("\\Driver\\geckodriver.exe"));
				driver = new FirefoxDriver();
			}

			else {
				System.out.println("Invalid Browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void geturl(String url) {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendkeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void actions(WebElement element, String options) {
		Actions ac = new Actions(driver);
		try {
			if (options.equalsIgnoreCase("moveToElement")) {
				ac.moveToElement(element).perform();
			} else if (options.equalsIgnoreCase("contextClick")) {
				ac.contextClick(element).perform();
			} else if (options.equalsIgnoreCase("doubleClick")) {
				ac.doubleClick(element).perform();
			} else if (options.equalsIgnoreCase("click")) {
				ac.click(element).perform();
			} else if (options.equalsIgnoreCase("dragAndDrop")) {
				ac.dragAndDrop(element, element).perform();
			} else if (options.equalsIgnoreCase("clickAndHold")) {
				ac.clickAndHold(element).perform();
			} else {
				System.out.println("Invalid Actions");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dropDown(WebElement element, String options, String value) {
		Select s = new Select(element);
		try {
			if (options.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value);
				s.selectByIndex(parseInt);
			} else if (options.equalsIgnoreCase("byValue")) {
				s.selectByValue(value);
			} else if (options.equalsIgnoreCase("byVisibleText")) {
				s.selectByVisibleText(value);
			} else {
				System.out.println("Invalid Selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void robot() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_DOWN);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void windowHandling(String options) {
		try {
			if (options.equalsIgnoreCase("windowHandle")) {
				String parentId = driver.getWindowHandle();
				System.out.println(parentId);
				String parentTitle = driver.switchTo().window(parentId).getTitle();
				System.out.println(parentTitle);
			} else if (options.equalsIgnoreCase("windowHandles")) {
				Set<String> allIds = driver.getWindowHandles();
				System.out.println(allIds);
				for (String ids : allIds) {
					String allTitles = driver.switchTo().window(ids).getTitle();
					System.out.println(allTitles);
				}
			} else {
				System.out.println("Invalid WindowHandling");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scroll(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getScreenshot() throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			File desfile = new File("C:\\Users\\divya\\eclipse-workspace\\AdactinCucumber\\Screenshot\\img.png");
			FileUtils.copyFile(srcfile, desfile);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}