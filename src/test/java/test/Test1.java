package test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	@Test(priority=1)
	public void register() {
		
        WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://magento.com");
		driver.findElement(By.id("gnav_557")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("nandini");
		driver.findElement(By.id("lastname")).sendKeys("lokesh");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("fa-question-circle"))).perform();
		
		
		driver.findElement(By.id("email_address")).sendKeys("nandinilokesh@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("YesMSystems");
		
		Select cp=new Select(driver.findElement(By.id("company_type")));
		//cp.selectByIndex(2);
		//cp.selectByValue("development");
		cp.selectByVisibleText("Provides deployment, customization and integration services to merchants");
		
		Select role=new Select(driver.findElement(By.id("individual_role")));
		role.selectByIndex(2);
		
		Select cp2=new Select(driver.findElement(By.id("country")));
		cp2.selectByValue("AS");
		
		driver.findElement(By.id("password")).sendKeys("welcome");
		driver.findElement(By.id("password-confirmation")).sendKeys("welcome");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("#recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03 > div > div > iframe")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();
		
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
		
			driver.findElement(By.id("agree_terms")).click();
		
        }
		driver.quit();
	}
		
	
	    @Test(priority=2)
		public void login() throws InterruptedException {
			
	        WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://magento.com");
			driver.findElement(By.id("gnav_557")).click();
			driver.findElement(By.id("email")).sendKeys("mailtobujji@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("welcome");
			driver.findElement(By.id("send2")).click();
			
			Thread.sleep(3000);
			
			String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
			System.out.println(error);
			
			if(error.equals("Invalid login or password."))
			{
				System.out.println("Test Pass");
			}
			
			driver.quit();
   }
}