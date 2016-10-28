package com.newgfan.pub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ErrorPageMessages {
//	static WebDriver driver;

	public static void getErrorMessage(WebDriver driver) {
		WebElement page_404 = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/h3[1]"));
		WebElement file_not_exist = driver.findElement(By
				.xpath("xhtml:html/xhtml:body/xhtml:pre"));
		if (page_404.isDisplayed()) {
			System.out.println("404  page");
			Assert.assertEquals(false, page_404.isDisplayed(), "404 page");
		} else if (file_not_exist.isDisplayed()) {
			Assert.assertEquals(false, file_not_exist.isDisplayed(),
					"file_not_exist");
		}

	}

}
