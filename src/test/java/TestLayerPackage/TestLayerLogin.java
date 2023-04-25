package TestLayerPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import POMPackage.POMLogin;
import TestData.ExcelSheet;

public class TestLayerLogin extends BaseClass {
	
	POMLogin login;
	
	public TestLayerLogin() {
		super();
	}
	
	@BeforeMethod  
	public void initialsetup() {
		initiate();
		screenshots("Login");
		login = new POMLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));*/
	}
	
	@Test (priority=1)
	public void verifyTitle() {
		String title = login.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"OrangeHRM");
	}
	
	@Test (priority=2)
	public void validLogin() throws InterruptedException {

		login.typeUsername(prop.getProperty("username"));
		login.typePassword(prop.getProperty("password"));
		login.clickButton();
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] LoginDetails() {
		Object result [][] = ExcelSheet.readdata("Sheet1");
		return result;
	}
	@Test (priority=3, dataProvider="LoginDetails")
	public void Login(String name, String password) throws InterruptedException {
	
		login.typeUsername(name);
		login.typePassword(password);
		login.clickButton();
		Thread.sleep(2000);
	}
	
	/*@DataProvider(name="getdata")
	public Object[][] data() {
		return new Object[][] {{"Admin1"},{"Admin2"},{"Admin3"}};
	}
	@Test(priority=4, dataProvider="getdata")
	public void Param(String keywords) throws InterruptedException {
	login.typeUsername(keywords);
		Thread.sleep(2000);
	}*/
	
	@AfterMethod
	public void AfterMethod() {
		driver.close();
}
}
