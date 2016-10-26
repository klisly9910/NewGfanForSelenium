package com.newgfan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pub.SwitchToWindow;

/**
 * 机锋众测(pubTest),锋快讯(quickNews),below
 * banner(threeBanner),锋专题(topic),右侧悬浮按钮(suspendButton)
 * 
 * @author xiaohua
 * 
 */
public class MainPage02 {
	WebDriver driver;
	String url = "http://www.gfan.com/new/";

	@BeforeMethod
	public void setUp() {
		Driver.getDriver("firefox");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void pubTest() {
		// 机锋众测
		WebElement pubTest = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[1]/span/a"));
		String pubTestText = pubTest.getText();
		Assert.assertEquals(pubTestText, "机锋众测");

		WebElement pubTitle = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[1]/div/a"));
		String beforeURL = pubTitle.getAttribute("href");
		pubTitle.click();
		SwitchToWindow.switchToWindow(driver);
		String afterURL = SwitchToWindow.window.getCurrentUrl();
		Assert.assertEquals(afterURL, beforeURL);
		driver.close();
	}

	@Test(enabled = false)
	public void quickNews() {
		WebElement newsTitle = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[2]/h2/span"));
		String title = newsTitle.getText();
		Assert.assertEquals(title, "锋快讯");
		System.out.println("newsTitle = " + title);

		// 锋快讯时间卡片
		List<WebElement> newsBoxs = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li"));
		Assert.assertEquals(newsBoxs.size(), 11);
		System.out.println("newsBoxs = " + newsBoxs.size());

		// 时间点
		WebElement newsTime = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/span"));
		Assert.assertEquals(true, newsTime.isDisplayed());

		// 文章来源
		WebElement newsFrom = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/div/div[2]"));
		Assert.assertEquals(true, newsFrom.isDisplayed());

		// 卡片title,click title
		WebElement newsTitlTex = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/div/div[1]/a"));
		// String titleText = newsTitlTex.getText();
		String beforeClickURL = newsTitlTex.getAttribute("href");
		newsTitlTex.click();
		SwitchToWindow.switchToWindow(driver);
		String afterClickURL = SwitchToWindow.window.getCurrentUrl();
		// String afterClickTitle = SwitchToWindow.window.getTitle();
		Assert.assertEquals(afterClickURL, beforeClickURL);

	}

	@Test(enabled = false)
	public void threeBanner() {
		List<WebElement> banners = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[3]/div"));
		Assert.assertEquals(banners.size(), 3);

		WebElement banner = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[3]/div[3]/a"));
		String beforeClickURL = banner.getAttribute("href");
		banner.click();
		SwitchToWindow.switchToWindow(driver);
		String afterClickURL = SwitchToWindow.window.getCurrentUrl();
		Assert.assertEquals(afterClickURL, beforeClickURL);

	}

	@Test(enabled = false)
	public void topic() {
		WebElement topicTitle = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[4]/h2/span"));
		Assert.assertEquals(topicTitle.getText(), "锋专题");

		List<WebElement> topicBanners = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[4]/div"));
		Assert.assertEquals(topicBanners.size(), 4);

		WebElement topicBanner = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[4]/div[1]/a"));
		String beforeClickURL = topicBanner.getAttribute("href");
		topicBanner.click();
		SwitchToWindow.switchToWindow(driver);
		String afterClickURL = SwitchToWindow.window.getCurrentUrl();
		Assert.assertEquals(afterClickURL, beforeClickURL);
	}

	@Test
	public void suspendMenu() {
		List<WebElement> suspendMenu = driver.findElements(By
				.xpath("html/body/div[2]/ul"));
		List<WebElement> suspendMenus = driver.findElements(By
				.xpath("html/body/div[2]/ul/li/a"));
		List<String> menus = new ArrayList<String>();
		for (int i = 0; i < suspendMenu.size(); i++) {
			for (int j = 0; j < suspendMenus.size(); j++) {
				String menuText = suspendMenus.get(j).getText();
				menus.add(menuText);
				Assert.assertEquals(true, suspendMenus.get(j).isEnabled());

			}
			System.out.println("menus = " + menus);
		}

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
