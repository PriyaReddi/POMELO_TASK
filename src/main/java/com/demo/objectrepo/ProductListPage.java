package com.demo.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.demo.genericlib.BaseClass;

public class ProductListPage  extends BaseClass{
	
	public ProductListPage(WebDriver driver) {
		this.driver = driver;
	}

	private By product = By.xpath("//div[@class='jsx-3030558961 category-list__wrapper']/div[contains(@class,'product-list')]/div[contains(@class,'product-item ')][2]");
	private By errorMsg =  By.xpath("//div[text()='Oops! Something went wrong']");
	
	
	public WebElement productToSelect() {
		return driver.findElement(product);
	}
	public WebElement errorMsg() {
		return driver.findElement(errorMsg);
	}
	
	
	public void selectProduct() {
		productToSelect().click();
	}
	
	public void handleErrorMsg() {
		
		try {
			if(errorMsg().isDisplayed()==true)
				driver.navigate().refresh();
		}catch(Exception e) {
			
		}
		
	}
	
}
