package com.newgfan.pagefactory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.newgfan.pub.SwitchToWindow;

public class PhonePage {

	WebDriver driver;

	//构造方法（有参数
	public PhonePage(WebDriver driver) {
		this.driver = driver;
		// driver.get(url);
		// PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = ".//*[@id='nav-top']/div[2]/a/img")
	public WebElement classifyLogo;

	@FindBy(xpath = "html/body/div[6]/div/div[1]/strong/a/img")
	public WebElement footerGfanLogo;
	
	// @FindBy(xpath = "html/body/div[3]/div/div[1]/strong/a/img")
	// public WebElement footerlogo;

	@FindBy(xpath = "/html/body/div[2]/div/a/img")
	public WebElement logoImag;
	
	//每个box的大标题
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/h1")
	public WebElement phoneTitle;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div")
	public List<WebElement> phoneBoxs;

	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div/h2/a")
	public List<WebElement> phoneFirstTitle;
	
	//分类：标题前的分类
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	public WebElement classify01; 
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	public WebElement classify02;
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]")
	public WebElement classify03;
	
	//每个box的第一个标题
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[2]")
	public WebElement secondTitle01;
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[2]")
	public WebElement secondTitle02;
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[2]")
	public WebElement secondTitle03;
	


	

}
