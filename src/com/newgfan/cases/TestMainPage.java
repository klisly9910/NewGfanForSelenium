package com.newgfan.cases;

import org.junit.AfterClass;
import org.junit.internal.runners.statements.ExpectException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pub.Login;
import com.newgfan.pub.SwitchToWindow;

public class TestMainPage {
	String url = "http://www.gfan.com/new/";
	WebDriver driver;

	@BeforeClass
	public void init() {
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass
	public void quit() {
		driver.close();
		driver.quit();
	}

	@Test
	public void testcase() {
		driver.get(url);
		WebElement title = driver.findElement(By
				.xpath("html/body/div[4]/div[2]/div[2]/div[1]/h2/a"));
		title.click();
		SwitchToWindow.switchToWindow(driver);
//		Assert.assertEquals(true,
//				driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/strong/a/img"))
//						.isDisplayed());
		// 点击畅言
		driver.findElement(
				By.xpath("//*[@id='SOHU_MAIN']/div[1]/div[3]/div/div[1]/div[2]"))
				.click();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 点击机锋logo登录
		driver.findElement(
				By.xpath("//*[@id='SOHU_MAIN']/div[5]/div/div[2]/ul/li[5]"))
				.click();

		// driver.findElement(By.className("login-logo login-logo-other")).click();
		// 跳转到机锋登录界面
		SwitchToWindow.switchToWindow(driver);
		driver.manage().window().maximize();
		// 调用login 方法
		try {
			Login.Logingfan(driver, "imopan501", "123456");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 登录成功，关闭登录后的页面并返回之前的之前的页面
		driver.close();
		WebDriver back = driver.switchTo().window(SwitchToWindow.currentWindow);
		System.out.println("currentWindow:" + back.getCurrentUrl());

	}

}
