package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.TimeUtils;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public BaseClass() {
		
	try {
        FileInputStream file = new FileInputStream("C:\\Users\\lavpr\\eclipse-workspace\\Practice\\src\\test\\java\\ConfigPackage\\config.properties");
        prop.load(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException a) {
		a.printStackTrace();
	}
	}
	public static void initiate() {
		String browser = prop.getProperty("browser");
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}
	public static void screenshots(String Filename) {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcfile, new File("C:\\Users\\lavpr\\eclipse-workspace\\Practice\\src\\test\\java\\screenshots\\Screenshots" + Filename +".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
