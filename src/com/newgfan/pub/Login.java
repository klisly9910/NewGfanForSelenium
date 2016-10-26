package com.newgfan.pub;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Login {

	// login method
	@SuppressWarnings("resource")
	public static void Logingfan(WebDriver driver, String name, String password)
			throws InterruptedException {
		driver.findElement(By.id("loginName")).clear();
		driver.findElement(By.id("loginName")).sendKeys(name);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		Scanner readline = new Scanner(System.in);
		System.out.println("请输入验证码：");
		String authcode = readline.nextLine();
		driver.findElement(By.id("authCode")).sendKeys(authcode);
		driver.findElement(By.id("regInputBt")).click();
		Thread.sleep(5000);
	}

	// logout methond
	public static void logout(WebDriver driver) {
		Actions action = new Actions(driver);
		// find mygfan element
		WebElement el = driver.findElement(By
				.xpath("html/body/div[1]/div/div/div[6]/div/div/a"));
		action.clickAndHold(el).perform();
		// find logout element and click logout
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		// mouse hold and click logout
//		action.clickAndHold(el).click(els);
	}

}
