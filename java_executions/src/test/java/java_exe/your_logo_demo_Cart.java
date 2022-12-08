package java_exe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class your_logo_demo_Cart extends java_utils {
	WebDriver driver;
	
	@BeforeTest
	public void testcase1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(3000);
		WebElement tc=driver.findElement(By.xpath("//*[@name='email']"));
		java_utils.passingValuesUsingJS(tc, "thej1@gmail.com", driver);
		WebElement tc1=driver.findElement(By.xpath("//*[@id='passwd']"));
		java_utils.passingValuesUsingJS(tc1, "78945623", driver);
		WebElement tc2=driver.findElement(By.xpath("//*[@name='SubmitLogin']"));
		java_utils.scrollIntoView(tc2, driver);
		WebElement tc3=driver.findElement(By.xpath("//*[@name='SubmitLogin']"));
		java_utils.clickElementByJS(tc3, driver);
	}
	
	@Test 
	public void testcase3() throws InterruptedException {
		Thread.sleep(3000);
		WebElement tc4=driver.findElement(By.xpath("//*[@title='T-shirts']"));
		java_utils.clickElementByJS(tc4, driver);
		WebElement tc5=driver.findElement(By.xpath("//*[@title='Add to cart']"));
		java_utils.scrollIntoView(tc5, driver);
		WebElement tc6=driver.findElement(By.xpath("//*[@title='Add to cart']"));
		java_utils.clickElementByJS(tc6, driver);
		Thread.sleep(3000);
		WebElement tc7=driver.findElement(By.xpath("//*[@title='Proceed to checkout']"));
		java_utils.clickElementByJS(tc7, driver);
		Thread.sleep(2000);
		WebElement tc8=driver.findElement(By.xpath("//*[@class='step_current  first']"));
		java_utils.scrollIntoView(tc8, driver);
		WebElement tc9=driver.findElement(By.xpath("//*[@class='label label-success']"));
		java_utils.drawBorder(tc9, driver);
	}

}
