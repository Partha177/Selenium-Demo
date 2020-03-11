package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

public class LaunchBrowser {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\chrome_Folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Open web application
		driver.navigate().to("https://amazon.com");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.in")) {
			System.out.println("Amazon");
		} else {
			System.out.println(title);
		}
		
		String tagname = null;
		tagname = driver.findElement(By.cssSelector("#nav-link-accountList>span.nav-line-2")).getText();
		System.out.println(tagname);
		
		WebElement category = driver.findElement(By.cssSelector("#nav-link-accountList>span.nav-line-2"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(3000);
		
		WebElement account = driver.findElement(By.cssSelector("#nav_prefetch_yourorders>span.nav-text"));
		action.moveToElement(account).click().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Need help?")).click();
		Thread.sleep(3000);
		
		WebElement input = driver.findElement(By.id("ap_email"));
		input.sendKeys("9577124352");
		
		driver.findElement(By.className("a-button-input")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Conditions")).click();
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle();
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = " ";
		
		if(winHandle!=winHandle1) {
			winHandle2 = winHandle;
			driver.switchTo().window(winHandle2);
		}
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		
		
		//iFrame 
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
		textbox.sendKeys("Partha");
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}
