package com.newgfan.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pub.ErrorPageMessages;
import com.newgfan.pub.SwitchToWindow;

public class PhonePage01 {
	WebDriver driver;
	String url = "http://phone.gfan.com/";

	@BeforeMethod
	public void setUp() {
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void phoneHeadLine() {
		WebElement headLine = driver.findElement(By
				.xpath("html/body/div[3]/div[1]/div[1]/h1"));
		Assert.assertEquals(headLine.getText(), "手机头条");

		List<WebElement> phoneBoxs = driver.findElements(By
				.xpath("html/body/div[3]/div[1]/div[1]/div"));
		List<WebElement> titles = driver.findElements(By
				.xpath("html/body/div[3]/div[1]/div[1]/div/h2/a"));
		List<String> secondTitles = new ArrayList<String>();
		Assert.assertEquals(phoneBoxs.size(), 3);
		for (int i = 0; i < phoneBoxs.size(); i++) {
			for (int j = 0; j < titles.size(); j++) {
				secondTitles.add(titles.get(j).getText());
				String beforeURL = titles.get(j).getAttribute("href");
				titles.get(j).click();
				SwitchToWindow.switchToWindow(driver);
				Assert.assertEquals(
						SwitchToWindow.window.getCurrentUrl().substring(
								SwitchToWindow.window.getCurrentUrl().indexOf(
										"//")),
						beforeURL.substring(beforeURL.indexOf("//")));
//				Assert.assertEquals(
//						true,
//						driver.findElement(
//								By.xpath("html/body/div[5]/div[1]/a[4]"))
//								.isDisplayed());
				driver.close();
				WebDriver backwindow = driver.switchTo().window(
						SwitchToWindow.currentWindow);
			}

		}
		System.out.println("secondTitles = " + secondTitles);

		WebElement hy = driver
				.findElement(By
						.xpath("html/body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
		String beforeURL = hy.getAttribute("href");
		hy.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(SwitchToWindow.window.getCurrentUrl(), beforeURL);

		driver.close();
		WebDriver backwindow = driver.switchTo().window(
				SwitchToWindow.currentWindow);

	}

	@Test(enabled = false)
	public void test() {
		WebElement text = driver
				.findElement(By
						.xpath("html/body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
		text.click();
		SwitchToWindow.switchToWindow(driver);
		ErrorPageMessages.getErrorMessage(driver);

		File file = new File("E://GitHub//NewGfan");

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
