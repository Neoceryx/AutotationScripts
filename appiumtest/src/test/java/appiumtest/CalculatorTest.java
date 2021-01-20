package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> driver;	

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting Test...");
			
			OpenCalculator();
			
		} catch (MalformedURLException e) {			
			System.out.println("Error Ocurred....");
			e.printStackTrace();
		}

	}
		
	public static void OpenCalculator() throws MalformedURLException {
		
		DesiredCapabilities _cap = new DesiredCapabilities();
		
		_cap.setCapability("deviceName", "moto e(6) plus");
		_cap.setCapability("udid", "ZT22234M2L");
		_cap.setCapability("platformName", "Android");
		_cap.setCapability("platformVersion", "9");
		
		_cap.setCapability("appPackage", "com.google.android.calculator");
		_cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		URL _appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(_appiumUrl,_cap);		
		System.out.println("Application Is Open... ");
		
		// For testing the add, functionality
		SumOfNumbersTesting();		
				
	}	
	
	public static void SumOfNumbersTesting() {
		
		// Get Elements from Screen
		MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		MobileElement three =  driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		MobileElement result = driver.findElement(By.className("android.widget.TextView"));
		
		// Press buttons simulation
		two.click();
		plus.click();
		three.click();
		equals.click();
		
		String OperationResult = result.getText();
		
		System.out.println("Result is: " + OperationResult);
		System.out.println("Test Completed...");

	}

}
