package com.demo.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.genericlib.BaseClass;

public class ProductPage extends BaseClass {

	
	private String size = "//div[@id='pdp_price_name']/following-sibling::div/div[@class='pdp__options-container']/button[text()='";
	private By sizeToSelect = By.xpath("//div[@id='pdp_price_name']/following-sibling::div/div[@class='pdp__options-container']/button[6]");
	private By addToCart = By.xpath("//span[text()='Add To Bag']");
	
	public String sizeToSelect() {
		return size;
	}
	public String selectSize() {
		return driver.findElement(sizeToSelect).getText();
	}
	public WebElement addToCart() {
		return driver.findElement(addToCart);
	}
	
	
	public void selectSizeAcc() {
		driver.findElement(By.xpath(sizeToSelect()+selectSize()+"']")).click();
	}
	public void clickAddToCart() {
		addToCart().click();
	}
	
}
