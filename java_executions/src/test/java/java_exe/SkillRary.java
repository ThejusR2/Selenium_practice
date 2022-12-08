package java_exe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillRary extends java_utils {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void tc1() {
		WebDriverManager.chromedriver().setup();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
	}
	
	@Test
	public void tc2() throws InterruptedException {
		Thread.sleep(2000);
		WebElement c1=driver.findElement(By.xpath("//*[@name='email']"));
		java_utils.passingValuesUsingJS(c1, "admin", driver);
		
		WebElement c2=driver.findElement(By.id("password"));
		java_utils.passingValuesUsingJS(c2, "admin", driver);
		Thread.sleep(2000);
		WebElement c3=driver.findElement(By.xpath("//*[@class='login_Btn']"));
		java_utils.clickElementByJS(c3, driver);
	}
	
	@Test
	public void tc3() throws InterruptedException {
		Thread.sleep(2000);
		WebElement c4=driver.findElement(By.xpath("//*[@class='hidden-xs']"));
		java_utils.clickElementByJS(c4, driver);
		Thread.sleep(2000);
		WebElement c5= driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/ul/li[2]/div[2]/a"));
		java_utils.clickElementByJS(c5, driver);
	}
	

}
