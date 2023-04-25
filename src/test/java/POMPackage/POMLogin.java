package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class POMLogin extends BaseClass {
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(linkText=" Login ") WebElement loginButton;
	
	public POMLogin() {
		PageFactory.initElements(driver,this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public void typeUsername(String name) {
		username.sendKeys(name);
	}
	public void typePassword(String password1) {
		password.sendKeys(password1);
	}
	public void clickButton() {
		
	}
}
