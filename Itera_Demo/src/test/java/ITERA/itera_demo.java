package ITERA;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class itera_demo {
	public static String url1= "https://www.youtube.com";
	public static String url2="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//    public static String url3="https://demo.guru99.com/test/newtours/";
	WebDriver driver;
	
	@BeforeTest
	public void testcase1() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.getWindowHandles();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url1);
		System.out.println("Your url opened is: "+driver.getTitle());
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url2);
		System.out.println("Your url opened is: "+driver.getTitle());
		Thread.sleep(2000);
		
		ArrayList<String> newtab=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(newtab);
		 driver.switchTo().window(newtab.get(0));
		 System.out.println("Page title: "+driver.getTitle());
		 Thread.sleep(2000);
		 
		 driver.switchTo().window(newtab.get(1));
		 System.out.println("Page title: "+driver.getTitle());
		 Thread.sleep(2000);
		 
		 driver.switchTo().window(newtab.get(2));
		 System.out.println("Page title: "+driver.getTitle());
		 Thread.sleep(2000);
		 driver.close();
		 
		 Thread.sleep(2000);
		 
		 driver.switchTo().window(newtab.get(1));
		 driver.close();
		
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='FirstName']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//*[@name='Surname']")).sendKeys("Dravid");
		driver.findElement(By.xpath("//*[@name='E_post']")).sendKeys("RahulDravid@mail.com");
		driver.findElement(By.xpath("//*[@name='Mobile']")).sendKeys("7778889995");
		driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("Rahul19");
		driver.findElement(By.xpath("//*[@class='form-control text-box single-line password']")).sendKeys("777546");
		driver.findElement(By.xpath("//*[@name='ConfirmPassword']")).sendKeys("777546");
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		
	}
	
	@Test
	public void testcase3() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//*[@class='form-control text-box single-line']")).sendKeys("Rahul19");
		driver.findElement(By.xpath("//*[@class='form-control text-box single-line password']")).sendKeys("777546");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		
	}
	
	@Test(enabled = true)
	public void testcase4() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//*[@name='Name']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//*[@name='Company']")).sendKeys("Mech");
		driver.findElement(By.xpath("//*[@name='Address']")).sendKeys("777");
		driver.findElement(By.xpath("//*[@name='City']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//*[@name='Phone']")).sendKeys("7787458964");
		driver.findElement(By.xpath("//*[@name='Email']")).sendKeys("Mech@mail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@value='Create']")).click();
	}
	
	@Test
	public void testcase5() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='searching']")).sendKeys("Rahul");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@value='Search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='btn btn-outline-danger']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@value='Delete']")).click();
		Thread.sleep(1000);
	}
	
	@Test
	public void testcase6() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Links present are "+links.size());
		Thread.sleep(2000);
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
//			System.out.println(links.get(i).getAttribute("href"));
		}	
	}
	
	@Test
	public void testcase7() throws InterruptedException {
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.linkText("Test Automation"))).build().perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testcase8() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='option2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='monday']")).click();
		Thread.sleep(3000);
		
		Actions action1=new Actions(driver);
		WebElement ele= driver.findElement(By.xpath("//*[@class='custom-select']"));
		action1.click(ele).build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
		action1.sendKeys(ele,Keys.ENTER).click().build().perform();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void testcase9() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
