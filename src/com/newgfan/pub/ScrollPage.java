package com.newgfan.pub;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollPage {
	static WebDriver driver;

	public static void scroll() throws InterruptedException {
		String setscroll = "document.documentElement.scrollTop=" + "1000";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(setscroll);
		Thread.sleep(15000);
	}

}
