package Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Buttons  {
	
	@Test
	public void ButtonOperation() {
		
		WebDriverManager.chromedriver().setup(); 
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.navigate().to("http://leafground.com/home.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@class ='wp-categories-icon svg-image']/following::h5[3]")).click();
		
		//click  image
		driver.findElement(By.xpath("//*[@class='large-6 small-12 columns']/img")).click();
		driver.navigate().back();
		
		
		driver.navigate().refresh();
		
		//identify the broken image
		WebElement img = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));
		
		if (img.getAttribute("naturalWidth").equals("0"))
		{
		 
			System.out.println("Image is broken");
		      
		}
		
		String destination = driver.findElement(By.partialLinkText(" without clicking me?")).getAttribute("href");
			
		System.out.println(destination);
		
		//Verify broken link
		
		driver.findElement(By.linkText("Verify am I broken?")).click();
        
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		if(title.contains("404")) {
			
			System.out.println("Link is broken");
		}
		
		driver.navigate().back();
		
		// Refreshing to ovoid stale element exception
		driver.navigate().refresh();
		
		
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		
		driver.navigate().back();
		
		driver.navigate().refresh();
		
		
		  int count = driver.findElements(By.tagName("a")).size();
		  
		  System.out.println(count);
		  
		  driver.quit();
		 
	}
	  
	 	
}