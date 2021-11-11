package com.demo.tests;

import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.genericlib.BaseClass;
import com.demo.genericlib.FileUtils;
import com.demo.objectrepo.ProductListPage;
import com.demo.objectrepo.CartPage;
import com.demo.objectrepo.CartPopUp;
import com.demo.objectrepo.HomePage;
import com.demo.objectrepo.ProductPage;

public class AddingProductsScenarios extends BaseClass {

	FileUtils fu = new FileUtils();
	
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	ProductListPage na = PageFactory.initElements(driver, ProductListPage.class);
	ProductPage pdp = PageFactory.initElements(driver, ProductPage.class);
	CartPopUp cp = PageFactory.initElements(driver, CartPopUp.class);
	CartPage cpp = PageFactory.initElements(driver, CartPage.class);
	

	@Test(priority = 0)
	public void addingProducts() throws Exception {
		// Select any product
		hp.selectNewArrivals();
		hp.selectFurtherOpts();
		na.handleErrorMsg();
		na.selectProduct();

		// Add to Cart
		pdp.selectSizeAcc();
		pdp.clickAddToCart();

		// Verify if product added to cart
		cp.verifyCartAddedMsg();
	}

	@Test(priority = 1)
	public void adjustQuantityOfItems() throws InterruptedException {
		cpp.changeQuantity();
	}

	@Test(priority = 2)
	public void adjustSize() throws InterruptedException  {
		cpp.changeSize();
	}
	
	@Test(priority = 3)
	public void applyPromoCode() throws Exception {
		cpp.applyPromoCode();
	}
	
	@Test(priority = 4)
	public void verifyProceedToCheckOutBtn() throws Throwable {
		Properties pOb = fu.getPropertiesObject();
		String url = pOb.getProperty("url");
		cpp.checkProceedToCheckOut();
		driver.get(url);
	}
	
	@Test(priority = 5)
	public void deleteProduct() throws Exception {
		cpp.removeProduct();
	}
}
