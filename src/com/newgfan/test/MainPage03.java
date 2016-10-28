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
 * 锋图赏(picture)、锋看点(foces)、游戏&应用(gameApp)、论坛(BBS)
 * 
 * @author xiaohua
 * 
 */
public class MainPage03 {
	WebDriver driver;
	String url = "http://www.gfan.com/new/index.php";

	@BeforeMethod
	public void setUp() {
		Driver.getDriver("firefox");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(enabled = true)
	public void picLeft() {
		WebElement title = driver.findElement(By.xpath(".//*[@id='nav02']/h1"));
		Assert.assertEquals("锋图赏", title.getText());

		WebElement picLeft = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[1]/div[1]/a"));
		WebElement picTitle = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[1]/div[1]/a/div[1]"));
		Assert.assertEquals(true, picTitle.isDisplayed());

		String picLeftURL = picLeft.getAttribute("href");
		picLeft.click();
		SwitchToWindow.switchToWindow(driver);
		String afterClick = SwitchToWindow.window.getCurrentUrl();
		Assert.assertEquals(afterClick.substring(afterClick.indexOf("//")),
				picLeftURL.substring(picLeftURL.indexOf("//")));
		driver.close();

	}

	@Test(enabled = true)
	public void picRight() {
		WebElement picRight = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[1]/div[2]/div[1]/a"));
		WebElement picTitleR = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[1]/div[2]/div[1]/a/div[1]"));
		Assert.assertEquals(true, picTitleR.isDisplayed());

		String picRightURL = picRight.getAttribute("href");
		picRight.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				picRightURL.substring(picRightURL.indexOf("//")));
		driver.close();
	}

	@Test(enabled = true)
	public void picBelow() {
		WebElement picBelow = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[1]/div[2]/div[1]/a"));
		WebElement picTitleB = driver.findElement(By
				.xpath(".//*[@id='nav02']/div[2]/div[1]/a/div[1]"));
		Assert.assertEquals(true, picTitleB.isDisplayed());
		String picBelowURL = picBelow.getAttribute("href");
		picBelow.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				picBelowURL.substring(picBelowURL.indexOf("//")));
		driver.close();
	}

	@Test(enabled = true)
	public void foceLeft() {
		WebElement foces = driver.findElement(By.xpath(".//*[@id='nav03']/h1"));
		Assert.assertEquals("锋看点", foces.getText());

		WebElement foceLeft = driver.findElement(By
				.xpath(".//*[@id='nav03']/div/div[1]/a"));
		WebElement foceTitle = driver.findElement(By
				.xpath(".//*[@id='nav03']/div/div[1]/a/div[4]"));
		Assert.assertEquals(true, foceTitle.isDisplayed());

		String foceLeftURL = foceLeft.getAttribute("href");
		foceLeft.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				foceLeftURL.substring(foceLeftURL.indexOf("//")));

	}

	@Test(enabled = true)
	public void foceRight() {
		WebElement foceRight = driver.findElement(By
				.xpath(".//*[@id='nav03']/div/div[2]/div[2]/a"));
		WebElement foceRitghtTitle = driver.findElement(By
				.xpath(".//*[@id='nav03']/div/div[2]/div[2]/a/div[4]"));
		Assert.assertEquals(true, foceRitghtTitle.isDisplayed());

		String foceRightURL = foceRight.getAttribute("href");
		foceRight.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				foceRightURL.substring(foceRightURL.indexOf("//")));

	}

	@Test(enabled = true)
	public void gameAppTop() {
		WebElement topTitle = driver.findElement(By
				.xpath(".//*[@id='nav04']/h1"));
		Assert.assertEquals(topTitle.getText(), "游戏&应用");

		WebElement secondTitle = driver.findElement(By
				.xpath(".//*[@id='nav04']/h2/strong"));
		Assert.assertEquals(secondTitle.getText(), "热门游戏推荐");

		List<WebElement> secondTitleA = driver.findElements(By
				.xpath(".//*[@id='nav04']/h2/a"));
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < secondTitleA.size(); i++) {
			String listA = secondTitleA.get(i).getText();
			lists.add(listA);
			String secondURL = secondTitleA.get(i).getAttribute("href");
			secondTitleA.get(i).click();
			SwitchToWindow.switchToWindow(driver);
			Assert.assertEquals(
					SwitchToWindow.window.getCurrentUrl()
							.substring(
									SwitchToWindow.window.getCurrentUrl()
											.indexOf("//")), secondURL
							.substring(secondURL.indexOf("//")));
			driver.close();
			WebDriver backWindow = driver.switchTo().window(
					SwitchToWindow.currentWindow);

		}
		System.out.println("lists = " + lists);
	}

	@Test(enabled = true)
	public void gameAppPicLeft() {
		WebElement picLeft = driver.findElement(By
				.xpath(".//*[@id='nav04']/div[1]/div[2]/div[1]/a"));
		String beforeClickURL = picLeft.getAttribute("href");
		picLeft.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeClickURL.substring(beforeClickURL.indexOf("//")));

	}

	@Test(enabled = true)
	public void gameAppPicRight() {
		WebElement picRight = driver.findElement(By
				.xpath(".//*[@id='nav04']/div[1]/div[2]/div[1]/a"));
		String beforeClickURL = picRight.getAttribute("href");
		picRight.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeClickURL.substring(beforeClickURL.indexOf("//")));
	}

	@Test(enabled = false)
	public void gameAppBelowPic() {
		WebElement picBelow = driver.findElement(By
				.xpath(".//*[@id='nav04']/div[2]/div[1]/a"));
		String beforeClickURL = picBelow.getAttribute("href").substring(7);
		String beforeURL = beforeClickURL.substring(beforeClickURL
				.indexOf("//"));
		picBelow.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeURL);
	}

	@Test
	public void bbs() {
		WebElement secondTitle = driver.findElement(By
				.xpath(".//*[@id='nav05']/div/h2/strong"));
		Assert.assertEquals(secondTitle.getText(), "热门板块推荐");

		List<WebElement> secondTitleA = driver.findElements(By
				.xpath(".//*[@id='nav05']/div/h2/a"));
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < secondTitleA.size(); i++) {
			String urlText = secondTitleA.get(i).getText();
			lists.add(urlText);
			String beforeClickURL = secondTitleA.get(i).getAttribute("href");
			secondTitleA.get(i).click();
			SwitchToWindow.switchToWindow(driver);
			Assert.assertEquals(
					SwitchToWindow.window.getCurrentUrl()
							.substring(
									SwitchToWindow.window.getCurrentUrl()
											.indexOf("//")), beforeClickURL
							.substring(beforeClickURL.indexOf("//")));
			driver.close();
			WebDriver backWindow = driver.switchTo().window(
					SwitchToWindow.currentWindow);

		}
		System.out.println("lists = " + lists);

	}

	@Test
	public void bbsPic() {
		WebElement bbsURL = driver.findElement(By
				.xpath(".//*[@id='nav05']/div/div/div[1]/div[1]/a"));
		String beforeClickURL = bbsURL.getAttribute("href");
		String beforeUrl = beforeClickURL.substring(beforeClickURL
				.indexOf("//"));
		bbsURL.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				beforeUrl);

	}

	@Test(enabled = true)
	public void bbsJoin() {

		WebElement join = driver.findElement(By
				.xpath(".//*[@id='nav05']/div/div/div[1]/div[2]/div/a"));
		String joinURL = join.getAttribute("href");
		join.click();
		SwitchToWindow.switchToWindow(driver);
		Assert.assertEquals(
				SwitchToWindow.window.getCurrentUrl().substring(
						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
				joinURL.substring(joinURL.indexOf("//")));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
