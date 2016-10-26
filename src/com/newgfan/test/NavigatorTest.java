package com.newgfan.test;

import java.util.Iterator;
import java.util.Set;
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
 * click logo and top navigator->get title & url
 * 
 * @author xiaohua
 * 
 */
public class NavigatorTest {

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
	public void clickLogo() {
		WebElement logo = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/a/img"));
		String logoTex = logo.getText();
		logo.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(logoTex));
		driver.close();// 关闭窗口

	}

	@Test(enabled = false)
	public void clickPhone() throws InterruptedException {
		// driver.get(url);
		WebElement phone = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[1]/a"));
		String phoneTex = phone.getText();
		phone.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(phoneTex));
		driver.close();

	}

	@Test
	public void clickComputer() throws InterruptedException {
		// driver.get(url);
		WebElement computer = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[2]/a"));
		String comTex = computer.getText();
		computer.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(comTex));
		driver.close();
	}

	@Test
	public void clickSmart() {
		// driver.get(url);
		WebElement smart = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[3]/a"));
		String smartTex = smart.getText();
		smart.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(smartTex));
		driver.close();
	}

	@Test
	public void clickWemedia() {
		// driver.get(url);
		WebElement wemedia = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[4]/a"));
		String mediaTex = wemedia.getText();
		wemedia.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(mediaTex));
		driver.close();
	}

	@Test
	public void clickJiaDian() {
		// driver.get(url);
		WebElement jiadian = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[5]/a"));
		String jiadianTex = jiadian.getText();
		jiadian.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(jiadianTex));
		driver.close();
	}

	@Test
	public void clickOffice() {
		// driver.get(url);
		WebElement office = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[6]/a"));
		String officeTex = office.getText();
		office.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(officeTex));
		driver.close();
	}

	@Test
	public void clickBBS() {
		// driver.get(url);
		WebElement bbs = driver.findElement(By
				.xpath(".//*[@id='nav-top']/div/ul/li[7]/a"));
		String bbsTex = bbs.getText();
		bbs.click();
		SwitchToWindow.switchToWindow(driver);

		Assert.assertEquals(true,
				SwitchToWindow.window.getTitle().contains(bbsTex));
		driver.close();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
