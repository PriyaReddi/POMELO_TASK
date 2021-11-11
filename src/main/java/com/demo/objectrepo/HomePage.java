package com.demo.objectrepo;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.genericlib.BaseClass;
import com.demo.genericlib.CommonLib;
import com.demo.genericlib.FileUtils;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	FileUtils fu = new FileUtils();
	CommonLib cl = new CommonLib();
	
	private By shopBtn = By.xpath("//span[text()='Shop']");
	private By bestsellers = By.xpath("//a[text()='Best Sellers']");
	private By newArrivals =By.xpath("//span[text()='New arrivals']");
	private By furtherOpts = By.xpath("//figcaption[text()='New Arrivals']");
	private By cartIcon = By.xpath("//li[contains(@class,'ul-icon-bag')]");
	
	public WebElement getShopButton() {
		return driver.findElement(shopBtn);
	}
	public WebElement getBestsellers() {
		return driver.findElement(bestsellers);
	}
	public WebElement getCartIcon() {
		return driver.findElement(cartIcon);
	}
	public WebElement getNewArrivals() {
		return driver.findElement(newArrivals);
	}
	public WebElement getFurtherOpts() {
		return driver.findElement(furtherOpts);
	}
	
	public void clickShopButton() {
		getShopButton().click();
	}
	public void clickBestSellers() {
		getBestsellers().click();
	}
	public void selectNewArrivals() {
		getNewArrivals().click();
	}
	public void selectFurtherOpts() {
		getFurtherOpts().click();
	}
	public void clickCartIcon() {
		getCartIcon().click();
	}
}
