package com.demo.genericlib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonLib  {
	
public void handleDropDwn(WebElement ele,String text) {
	Select sel = new Select(ele);
	sel.selectByVisibleText(text);
}

public String fetchTheSelectedDropDownOption(WebElement ele,String text) {
	Select sel = new Select(ele);
	WebElement option =sel.getFirstSelectedOption();
	System.out.println("The selected "+text+" is: "+option.getText());
	return option.getText();
}

public void mouseHoverOperation(WebElement ele) {
	Actions act = new Actions(BaseClass.driver);
	act.moveToElement(ele).click().perform();
}

}
