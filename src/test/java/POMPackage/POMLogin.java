package POMPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class POMLogin extends BaseClass {
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button") WebElement loginButton;
	
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
		loginButton.click();
	}
}
