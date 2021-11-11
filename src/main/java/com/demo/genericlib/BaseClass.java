package com.demo.genericlib;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.demo.objectrepo.HomePage;

public class BaseClass {
	
	public static WebDriver driver;
	
	FileUtils fu = new FileUtils();
	CommonLib cl = new CommonLib();
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	private By login = By.xpath("//span[text()='Login']");
	private By username = By.name("email");
	private By password = By.name("password");
	private By loginn = By.xpath("//span[text()='Log In']/..//button[@type='submit']");
	
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginnButton() {
		return driver.findElement(loginn);
	}
	public WebElement getLoginButton() {
		return driver.findElement(login);
	}
	
	
	@BeforeTest
	public void launchBrowser() throws Throwable {
		Properties pOb = fu.getPropertiesObject();
		String url = pOb.getProperty("url");
		System.setProperty("webdriver.chrome.driver", "/home/priya/Downloads/chromedriver");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void loginToApp() throws Throwable {
		Properties pOb = fu.getPropertiesObject();
		String emailid = pOb.getProperty("email");
		String pwd = pOb.getProperty("password");
		
		getLoginButton().click();
		getUsername().clear();
		getUsername().sendKeys(emailid);
		getPassword().clear();
		getPassword().sendKeys(pwd);
		getLoginnButton().click();
		Thread.sleep(8000);
	}
	
	@AfterClass
	public void AFconfig() {
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
