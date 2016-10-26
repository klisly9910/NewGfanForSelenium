package com.newgfan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newgfan.pub.SwitchToWindow;

public class MainPage {
	public WebDriver driver = new FirefoxDriver();
	String url = "http://www.gfan.com/new/";

	@BeforeClass
	public void setUp() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * top banner ,left banner,锋头条
	 */
	@Test(enabled = false)
	public void topNav() {
		// top banner exists,size&location
		WebElement topBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[1]/a/img"));
		Assert.assertEquals(true, topBanner.isDisplayed());
		System.out.println("top banner size = " + topBanner.getSize());
		System.out.println("top banner location = " + topBanner.getLocation());

		// main01-left banner exists,size
		List<WebElement> tagA = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[1]/div/a"));
		System.out.println("left banner = " + tagA.size() + "张图片");
		Assert.assertEquals(tagA.size(), 3);

		// right banner size,title
		WebElement fengtoutiao = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/h1"));
		Assert.assertEquals(fengtoutiao.getText(), "锋头条");
		List<WebElement> rightBox = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[2]/div"));
		System.out.println("right box = " + rightBox.size() + "个box");
		Assert.assertEquals(rightBox.size(), 3);

		// middle banner
		WebElement middleBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[3]/a/img"));
		Assert.assertEquals(true, middleBanner.isDisplayed());

	}

	/**
	 * 今日热点，机锋众测
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void middleNav() throws InterruptedException {
		// scroll
		String setscroll = "document.documentElement.scrollTop=" + "1000";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(setscroll);
		Thread.sleep(15000);
		// main01-left banner exists,size
		List<WebElement> main02_left = driver.findElements(By
				.xpath(".//*[@id='nav01-tab']"));
		List<WebElement> nav02 = driver.findElements(By
				.xpath(".//*[@id='nav01-tab']/a"));
		String expectedText[] = { "今日热点", "游戏", "论坛", "图赏", "视频" };
		String linkText = null;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < main02_left.size(); i++) {
			for (int j = 0; j < nav02.size(); j++) {
				linkText = nav02.get(j).getText();
				list.add(linkText);
			}
			System.out.println("list = " + list);
		}
		//验证两个数组的index值是否相等
		for (int i = 0; i < expectedText.length && i < list.size(); i++) {
			Assert.assertEquals(expectedText[i], list.get(i));
			System.out.println("expectedText " + i + " =" + expectedText[i]
					+ "," + "list = " + list.get(i));
		}
		// main02_right exist
		WebElement main02_right = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[1]/span/a"));
		String rigth_text = main02_right.getText();
		Assert.assertEquals(rigth_text, "机锋众测");

		WebElement main02_right01 = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[1]/div/a/div[1]"));
		String right_tex = main02_right01.getText();
		Assert.assertEquals(right_tex, "这个总裁比机器人美");

	}

	/**
	 * 右侧悬浮button
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void rightMenu() throws InterruptedException {
		// scroll
		String setscroll = "document.documentElement.scrollTop=" + "1000";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(setscroll);
		Thread.sleep(15000);
		// right menu
		List<WebElement> rightMenu = driver.findElements(By
				.xpath("html/body/div[2]/ul"));
		List<WebElement> sub_topMenu = driver.findElements(By
				.xpath("html/body/div[2]/ul/li[7]/a"));
		List<String> listMenu = new ArrayList<String>();
		for (int i = 0; i < rightMenu.size(); i++) {
			for (int j = 0; j < sub_topMenu.size(); j++) {
				String subTex = sub_topMenu.get(j).getText();
				listMenu.add(subTex);
			}
			System.out.println("listMenu = " + listMenu);
		}
	}

	/**
	 * 锋快讯
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void timeScroll() throws InterruptedException {
		String setscroll = "document.documentElement.scrollTop=" + "1000";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(setscroll);
		Thread.sleep(10000);

		WebElement title = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[2]/h2/span"));
		String timeTitle = title.getText();
		Assert.assertEquals(timeTitle, "锋快讯");
		System.out.println("timeTitle = " + timeTitle);

		List<WebElement> timeList = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li"));
		Assert.assertEquals(timeList.size(), 11);
		System.out.println("timeList size = " + timeList.size());

		WebElement fengTitle = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/div/div[1]/a"));
		Assert.assertEquals(true, fengTitle.isDisplayed());

		WebElement time = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/span"));
		Assert.assertEquals(true, time.isDisplayed());

		WebElement from = driver
				.findElement(By
						.xpath(".//*[@id='iscroll-rightbox']/div[2]/div/div/ul/li[1]/div/div[2]"));
		Assert.assertEquals(true, from.isDisplayed());
	}

	/**
	 * 锋快讯下方banner&锋专题banner 数量
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void belowFengKuaiXun() throws InterruptedException {
		String setscroll = "document.documentElement.scrollTop=" + "1000";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(setscroll);
		Thread.sleep(10000);
		List<WebElement> banner = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[3]/div"));
		Assert.assertEquals(banner.size(), 3);

		WebElement zhuanti = driver.findElement(By
				.xpath(".//*[@id='iscroll-rightbox']/div[4]/h2/span"));
		Assert.assertEquals(zhuanti.getText(), "锋专题");
		List<WebElement> zhuantiBanner = driver.findElements(By
				.xpath(".//*[@id='iscroll-rightbox']/div[4]/div"));
		Assert.assertEquals(zhuantiBanner.size(), 4);

	}

	@Test
	public void test() {
		// SwitchToWindowTitle.beforeSwitchTitle = driver.findElement(By
		// .xpath("html/body/div[3]/div[2]/div[2]/div[1]/ul/li[1]/a"));
		// SwitchToWindowTitle.getTitle();

		WebElement title = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/div[1]/ul/li[1]/a"));
		String text = title.getText();
		title.click();
		SwitchToWindow.switchToWindow(driver);
		boolean hasSameChar = false;
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < SwitchToWindow.window.getTitle().length(); j++) {
				if (text.charAt(i) == SwitchToWindow.window.getTitle()
						.charAt(j)) {
					char s1 = text.charAt(i);
					char s2 = SwitchToWindow.window.getTitle().charAt(j);
					System.out.println("s1 = " + s1 + "," + "s2 = " + s2);
					hasSameChar = true;

				}
			}

		}
		if (hasSameChar) {
			System.out.println("跳转正确");
		} else {
			System.out.println("跳转不正确");
		}

	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
