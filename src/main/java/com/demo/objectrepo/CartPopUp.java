package com.demo.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.demo.genericlib.BaseClass;

public class CartPopUp extends BaseClass{

	private By close =By.xpath("//span[contains(@class,'pomelo-icon cart-notice')]");
	private By addedToCartMsg = By.xpath("//span[contains(@class,'cart-notice__title')]");
	
	public WebElement addedToCartMsg() {
		return driver.findElement(addedToCartMsg);
	}
	public WebElement closeBtn() {
		return driver.findElement(close);
	}
	
	
	public void verifyCartAddedMsg() {
		String expMsg = "Item added to Bag";
		Assert.assertEquals(addedToCartMsg().getText(), expMsg);
		closeBtn().click();
	}
}
