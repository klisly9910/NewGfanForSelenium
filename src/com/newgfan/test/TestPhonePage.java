package com.newgfan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;
import com.newgfan.pagefactory.PhonePage;
import com.newgfan.pub.SwitchToWindow;

public class TestPhonePage {

	WebDriver back;
	WebDriver driver;
	String url = "http://phone.gfan.com";

	// PhonePage page = PageFactory.initElements(driver, PhonePage.class);

	@BeforeMethod
	public void init() {
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	@Test(enabled = false)
	public void clickLogoImage() {
		// PhonePage page = new PhonePage(driver);
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		Assert.assertEquals("手机头条", page.phoneTitle.getText());
		page.logoImag.click();

	}

	@Test(enabled = false)
	public void getPhoneBoxs() {
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		Assert.assertEquals(page.phoneBoxs.size(), 3);
		System.out.println(page.phoneBoxs.size());
	}

	@Test(enabled = false)
	public void clickFirstTitle() {
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		List<String> titleTex = new ArrayList<String>();
		for (int i = 0; i < page.phoneBoxs.size(); i++) {
			for (int j = 0; j < page.phoneFirstTitle.size(); j++) {
				titleTex.add(page.phoneFirstTitle.get(j).getText());
				String parentURL = page.phoneFirstTitle.get(j).getAttribute(
						"href");
				page.phoneFirstTitle.get(j).click();
				SwitchToWindow.switchToWindow(driver);
				Assert.assertEquals(
						SwitchToWindow.window.getCurrentUrl().substring(
								SwitchToWindow.window.getCurrentUrl().indexOf(
										"//")),
						parentURL.substring(parentURL.indexOf("//")));
				Assert.assertEquals(true, page.footerGfanLogo.isDisplayed());
				driver.close();
				// driver.navigate().back();
				back = driver.switchTo().window(SwitchToWindow.currentWindow);

			}

		}

	}

	@Test(enabled = false)
	public void clickClassify() {
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		String beforeURL01 = page.classify01.getAttribute("href");
		page.classify01.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeURL01.substring(beforeURL01.indexOf("//")));
		Assert.assertEquals(true, page.classifyLogo.isDisplayed());
		driver.close();
		back = driver.switchTo().window(SwitchToWindow.currentWindow);

		String beforeURL02 = page.classify02.getAttribute("href");
		page.classify02.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeURL02.substring(beforeURL02.indexOf("//")));
		Assert.assertEquals(true, page.classifyLogo.isDisplayed());

		driver.close();
		back = driver.switchTo().window(SwitchToWindow.currentWindow);

		String beforeURL03 = page.classify03.getAttribute("href");
		page.classify03.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeURL03.substring(beforeURL03.indexOf("//")));
		Assert.assertEquals(true, page.classifyLogo.isDisplayed());

	}

	@Test(enabled = false)
	public void testSecondTitle() {
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		String title01 = page.secondTitle01.getAttribute("href");
		page.secondTitle01.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				title01.substring(title01.indexOf("//")));
		Assert.assertEquals(true, page.footerGfanLogo.isDisplayed());
		driver.close();
		driver.switchTo().window(SwitchToWindow.currentWindow);

		String title02 = page.secondTitle02.getAttribute("href");
		page.secondTitle02.click();
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				title02.substring(title02.indexOf("//")));
		Assert.assertEquals(true, page.footerGfanLogo.isDisplayed());
		driver.close();
		driver.switchTo().window(SwitchToWindow.currentWindow);

		String title03 = page.secondTitle03.getAttribute("href");
		page.secondTitle03.click();
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				title03.substring(title03.indexOf("//")));
		Assert.assertEquals(true, page.footerGfanLogo.isDisplayed());
	}
	@Test
	public void test1(){
		PhonePage page = PageFactory.initElements(driver, PhonePage.class);
		String title02 = page.secondTitle02.getAttribute("href");
		page.secondTitle02.click();
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				title02.substring(title02.indexOf("//")));
		Assert.assertEquals(true, page.footerGfanLogo.isDisplayed());
	}
}
