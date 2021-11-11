package com.demo.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.demo.genericlib.BaseClass;
import com.demo.genericlib.CommonLib;

public class CartPage extends BaseClass {

	CommonLib lib = new CommonLib();
	HomePage hp = new HomePage(driver);

	private By quantityDropDwn = By.xpath(
			"//div[@class='cart-body']//div[contains(@class,'cart-products')][1]//div[@class='cart-item-info__quantity']//select");
	private By sizeDrpDwn = By.xpath(
			"//div[@class='cart-body']//div[contains(@class,'cart-products')][1]//div[contains(@class,' size-quantity')]//select[1]");
	private By sizeToChange =By.xpath("//div[@class='cart-body']//div[contains(@class,'cart-products')][1]//div[contains(@class,' size-quantity')]//select[1]/option[3]");
	private By closeCart = By.cssSelector("span[data-cy='close_cart']");
	private By promoode = By.cssSelector("input[placeholder='Enter Promo Code']");
	private By applyBtn = By.xpath("//span[text()='Apply']");
	private By invalidVoucher = By.xpath("//span[text()='Invalid voucher code']");
	private By deleteProductBTn = By.xpath("//div[contains(@class,'cart-remove')]");
	private By addedProd = By.xpath("//div[@class='cart-body']/div[contains(@class,'cart-product')]");
	private By proceedToCheckOut = By.xpath("//button[contains(@class,'cart-checkout-button')]/span");
	private By emptyCart = By.xpath("//span[text()='Your Bag is Empty']");
	private By loader = By.cssSelector("div[role='alert']");

	
	public WebElement getQuantityDropDwn() {
		return driver.findElement(quantityDropDwn);
	}
	public WebElement loader() {
		return driver.findElement(loader);
	}
	public WebElement getSizeDrpDwnn() {
		return driver.findElement(sizeDrpDwn);
	}
	public String sizeToChange() {
		return driver.findElement(sizeToChange).getText();
	}
	public WebElement closeCart() {
		return driver.findElement(closeCart);
	}
	public WebElement promoCode() {
		return driver.findElement(promoode);
	}
	public WebElement apply() {
		return driver.findElement(applyBtn);
	}
	public WebElement invalidVoucherMsg() {
		return driver.findElement(invalidVoucher);
	}
	public WebElement deleteProductBTn() {
		return driver.findElement(deleteProductBTn);
	}
	public WebElement addedProduct() {
		return driver.findElement(addedProd);
	}
	public WebElement proceedToCheckOutBTn() {
		return driver.findElement(proceedToCheckOut);
	}
	public String emptyCartMsg() {
		return driver.findElement(emptyCart).getText();
	}

	
	public void checkProceedToCheckOut() throws Exception {
		hp.clickCartIcon();
		proceedToCheckOutBTn().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.pomelofashion.com/th/en/checkout"));
	}
	public void changeQuantity() {
		String expQuantity = "2";
		hp.clickCartIcon();
		lib.handleDropDwn(getQuantityDropDwn(), "2");
		while(loader().isDisplayed()==false) 
		Assert.assertEquals(lib.fetchTheSelectedDropDownOption(getQuantityDropDwn(), "Quantity"), expQuantity);
		closeCart().click();
		
	}
	public void changeSize() {
		hp.clickCartIcon();
		String expSize = sizeToChange();
		lib.handleDropDwn(getSizeDrpDwnn(), sizeToChange());
		while(loader().isDisplayed()==false) 
		Assert.assertEquals(lib.fetchTheSelectedDropDownOption(getSizeDrpDwnn(), "Size"), expSize);
		closeCart().click();
	}
	public void applyPromoCode() throws Exception {
		hp.clickCartIcon();
		promoCode().sendKeys("TEST PROMOCODE");
		apply().click();
		Thread.sleep(8000);
		Assert.assertEquals(invalidVoucherMsg().getText(), "Invalid voucher code");
		closeCart().click();
	}
	public void removeProduct() throws Exception {
		hp.clickCartIcon();
		deleteProductBTn().click();
		checkInvisibiltyOfProduct();
		closeCart().click();
	}
	public void checkInvisibiltyOfProduct() {
		try {
			if(addedProduct().isDisplayed()==true)
				System.out.println("Product is successfully not removed");
			else
				Assert.assertEquals(emptyCartMsg(), "Your Bag is Empty");
				System.out.println("Product is successfully removed");
			
		}catch(Exception e) {
			
			
		}
	}
}
