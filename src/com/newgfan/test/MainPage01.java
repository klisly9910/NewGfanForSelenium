package com.newgfan.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pub.ScrollPage;
import com.newgfan.pub.SwitchToWindow;
import com.sun.java.swing.plaf.windows.resources.windows;

/**
 * 验证首页顶部banner(topBanner)、左侧轮播图(leftBanner)、锋头条(topLine)
 * ,中部banner(middleBanner) 点击跳转
 * 
 * @author xiaohua
 * 
 */
public class MainPage01 {
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

	@Test(enabled = true)
	public void topBanner() throws InterruptedException {
		// top banner exists,size&location,click banner
		WebElement topBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[1]/a"));
		Assert.assertEquals(true, topBanner.isDisplayed());
		// 获取点击前banner的URL
		String bannerURL = topBanner.getAttribute("href");
		topBanner.click();
		SwitchToWindow.switchToWindow(driver);
		// 获取跳转后的URL并与点击前的URL进行比较
		// Assert.assertEquals(SwitchToWindow.window.getCurrentUrl(),
		// bannerURL);
		driver.close();

	}

	@Test(enabled = true)
	public void leftBanner() {
		// main01-left banner exists,size,click
		List<WebElement> left_banners = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[1]/div/a"));
		System.out.println("left banner = " + left_banners.size()
				+ " pices banner");
		// 验证轮播图数量
		// Assert.assertEquals(left_banners.size(), 3);
		for (int i = 0; i < left_banners.size(); i++) {
			// 获取点击前的URL
			String url = left_banners.get(i).getAttribute("href");
			left_banners.get(i).click();
			// 获取跳转后的title&URL,验证跳转前后的URL是否一致
			SwitchToWindow.switchToWindow(driver);
			// Assert.assertEquals(SwitchToWindow.window.getCurrentUrl(), url);
			// 关闭当前窗口
			driver.close();
			// 返回点击跳转前的窗口
			WebDriver backWindow = driver.switchTo().window(
					SwitchToWindow.currentWindow);
			System.out.println("backWindow = " + backWindow.getCurrentUrl());

		}
		driver.close();

	}

	@Test
	public void topLine() {
		// click pre,next
		WebElement preButton = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[1]/span[1]"));
		WebElement nextButton = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[1]/span[2]"));
		Assert.assertEquals(true, preButton.isEnabled());
		Assert.assertEquals(true, nextButton.isEnabled());
		// right banner size,title
		WebElement fengtoutiao = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/h1"));
		Assert.assertEquals(fengtoutiao.getText(), "锋头条");
		List<WebElement> rightBoxs = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[2]/div"));
		System.out.println("right box = " + rightBoxs.size() + " boxs");
		Assert.assertEquals(rightBoxs.size(), 3);

		WebElement firstTitle = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/div[1]/h2/a"));
		String firstUrl = firstTitle.getAttribute("href");
		firstTitle.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(SwitchToWindow.window.getCurrentUrl(), firstUrl);
		driver.close();
		WebDriver backWindow = driver.switchTo().window(
				SwitchToWindow.currentWindow);
		System.out.println("backWindow = " + backWindow.getCurrentUrl());

		WebElement secondTitle = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/div[1]/ul/li[1]/a"));
		// 点击前title
		String secondTex = secondTitle.getText();
		String secondUrl = secondTitle.getAttribute("href");
		secondTitle.click();
		SwitchToWindow.switchToWindow(driver);
		// 点击后title
		String clickSecondTex = SwitchToWindow.window.getTitle();
		Assert.assertEquals(SwitchToWindow.window.getCurrentUrl(), secondUrl);
		// 比较点击前与点击后的title字符串是否有相同的字符
		boolean hasSameChar = false;
		for (int i = 0; i < secondTex.length(); i++) {
			for (int j = 0; j < clickSecondTex.length(); j++) {
				if (secondTex.charAt(i) == clickSecondTex.charAt(j)) {
					char secondText = secondTex.charAt(i);
					char clickSecondText = clickSecondTex.charAt(j);
					System.out.println("secondTex&clickSecondTex =  "
							+ secondText + ", " + clickSecondText);
					hasSameChar = true;

				}

			}

		}
		if (hasSameChar) {
			System.out.println("跳转正确");
		} else {
			System.out.println("跳转错误");
		}
		driver.close();

	}

	@Test
	public void middleBanner() {
		WebElement middleBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[3]/a"));
		Assert.assertEquals(true, middleBanner.isDisplayed());
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
