package com.test.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HouseOverAndWindowHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://support.google.com/mail/answer/8494?co=GENIE.Platform%3DDesktop&hl=en");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.className("action-button")).click();
		System.out.println(driver.getTitle());

		String parentWindow = driver.getWindowHandle();

		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while (it.hasNext()) {
			
			String childWindow = it.next();
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pirate.captain");
				// driver.findElement(By.xpath("//span[text()='Next']")).click();

				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//span[text()='Create account']"))).click().build()
						.perform();

				WebElement clickonMyself = driver.findElement(By.className("VfPpkd-StrnGf-rymPhb-b9t22c"));

				Thread.sleep(1000);
				action.click(clickonMyself).build().perform();
				
				driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("pirate");
				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("pirate");
				driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("piratejacksparrow34");
				
				driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("piratejacksparrow@12");
				driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("piratejacksparrow@12");
				
				driver.findElement(By.className("VfPpkd-vQzf8d")).click();
				driver.findElement(By.id("phoneNumberId")).sendKeys("3000000001");
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				
				System.out.println(driver.getTitle());
				
				
				
				
//			WebDriverWait wait=new WebDriverWait(driver, 30);
//				wait.until(ExpectedConditions.)
				
				
				driver.close();
			}

		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}

}
