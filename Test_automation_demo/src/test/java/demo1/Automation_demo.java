package demo1;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_demo {
	WebDriver driver;
	String url="https://www.youtube.com/";
	@BeforeTest 
	public void tc1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc2() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='wikipedia-search-input']")).sendKeys("google");
		driver.findElement(By.xpath("//*[@class='wikipedia-search-button']")).click();
		Thread.sleep(2000);
		Actions action= new Actions(driver);
		action.click(driver.findElement(By.linkText("Google Chrome")));
	}
	
	@Test
	public void tc3() throws InterruptedException {
		driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
		Thread.sleep(1000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void tc4() throws InterruptedException {
		Thread.sleep(2000);
		driver.getWindowHandles();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
		Thread.sleep(2000);
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();	
	}

}
