package com.newgfan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pub.IfElementExist;
import com.newgfan.pub.SwitchToWindow;

public class TestErrorMessages {
	WebDriver driver;

	@BeforeClass
	public void init() {
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}

	@Test
	public void testMainPageLinks() throws InterruptedException {
		driver.get("http://www.gfan.com/new/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("links size = " + links.size());
		Thread.sleep(10000);
		for (int i = 0; i < links.size(); i++) {
			String link = links.get(i).getAttribute("href");
			System.out.println("link = :" + link);
			links.get(i).click();
			SwitchToWindow.switchToWindow(driver);
//			By locator = By.xpath("xhtml:html/xhtml:body/xhtml:pre");
//			boolean flag = false;
//			flag = IfElementExist.isElementExsit(driver, locator);
//			if (!flag) {
//				System.out.println("error url :"
//						+ SwitchToWindow.window.getCurrentUrl());
//				break;
//			}
//			driver.close();
//			driver.switchTo().window(SwitchToWindow.currentWindow);

		}
	}

}
