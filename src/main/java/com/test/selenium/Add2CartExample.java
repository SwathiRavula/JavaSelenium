package com.test.selenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add2CartExample {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class = 'product']"));
	

		String[] items = { "Tomato", "Beetroot", "Brinjal", "Mango","Brocolli", "Grapes" };

		List<String> expectedItems = Arrays.asList(items);
		
		int count =0;

		for (int i = 0; i < allProducts.size(); i++) {

			
			String actuallItems =  driver.findElements(By.xpath("//h4[@class='product-name']")).get(i).getText();

			String[] splitItem = actuallItems.split("-");
			

			if (expectedItems.contains(splitItem[0].trim())) {

				count++;
				
			driver.findElements(By.cssSelector("div.product-action")).get(i).click();
			
			if(count == items.length) {
			break;
			}
			
			}
			
			

		}

		// driver.quit();

	}

}
