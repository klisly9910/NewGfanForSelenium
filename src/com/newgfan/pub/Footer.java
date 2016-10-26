package com.newgfan.pub;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newgfan.driver.Driver;

/**
 * get footer links
 * 
 * @author xiaohua
 * 
 */
public class Footer {
	static WebDriver driver;
	String url = "http://phone.gfan.com/";

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		Driver.getDriver("firefox");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public static void getFooterTopLinks() {
		List<WebElement> footerTop = driver.findElements(By
				.xpath("html/body/div[4]/div/div[1]/strong/a"));

		List<WebElement> ul = driver.findElements(By
				.xpath("html/body/div[4]/div/div[1]/ul/li/a"));

		for (int i = 0; i < footerTop.size(); i++) {

			String topText = footerTop.get(i).getText();
			String topurl = footerTop.get(i).getAttribute("href");
			System.out.println("机锋  第" + i + "次循环: " + topText + " :" + topurl);

			for (int j = 0; j < ul.size(); j++) {
				String ulText = ul.get(j).getText();
				String url = ul.get(j).getAttribute("href");
				System.out
						.println("机锋  第:" + j + "次循环 :" + ulText + " :" + url);
			}
			System.out.println("机锋  共有 " + ul.size() + "个链接");
			Assert.assertEquals(ul.size(), 14);

		}
		System.out.println("==========================");

	}

	@Test(enabled = true)
	public static void getFriendlyLinks() {
		List<WebElement> friendly = driver.findElements(By
				.xpath("html/body/div[4]/div/div[2]/strong"));
		List<WebElement> ul = driver.findElements(By
				.xpath("html/body/div[4]/div/div[2]/ul/li/a"));
		for (int i = 0; i < friendly.size(); i++) {
			// 获取链接中的文本
			String linkText = friendly.get(i).getText();
			System.out.println("友情链接 第" + i + "次循环: " + linkText);

			for (int j = 0; j < ul.size(); j++) {
				String linkTex = ul.get(j).getText();
				String url = ul.get(j).getAttribute("href");
				System.out.println("友情链接 第 :" + j + "次循环 :" + linkTex + " :"
						+ url);

			}
			System.out.println("友情链接  共有 " + ul.size() + "个链接");
			Assert.assertEquals(ul.size(), 45);
			System.out.println("==========================");

		}

	}

	@Test
	public static void getBottom() {
		WebElement bottom = driver.findElement(By
				.xpath("html/body/div[4]/div/div[3]/p"));
		String bottomText = bottom.getText();
		System.out.println("bottom :" + bottomText);
		Assert.assertEquals(
				bottomText,
				"京ICP备15020343号 | 京公网安备11010802020450号 | 京网文 【2015】 0397-177号 | 京ICP证150677号 | 北京机锋科技有限公司");
		System.out.println("==========================");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
