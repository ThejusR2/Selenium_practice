package java_exe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test extends java_utils {
	WebDriver driver;
	
	@BeforeTest
	public void testcase1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(2000);
		WebElement col1=driver.findElement(By.xpath("//*[@name='username']"));
		java_utils.passingValuesUsingJS(col1, "Admin", driver);
		Thread.sleep(2000);
		WebElement col2=driver.findElement(By.xpath("//*[@name='password']"));
		java_utils.passingValuesUsingJS(col2, "admin123", driver);
		Thread.sleep(3000);
		WebElement col=driver.findElement(By.xpath("//*[@type='submit']"));
		java_utils.clickElementByJS(col, driver);
//    	java_utils.changeColor("red", col, driver);
//		java_utils.drawBorder(col, driver);
	}

}
