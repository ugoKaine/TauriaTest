package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Factorial_calculation {

	public WebDriver driver;

	@Test
	public void verify_factorial() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://localhost:6464/");
		driver.manage().window().maximize();
		

		String input = "7";
		driver.findElement(By.xpath("//*[@id=\"number\"]")).sendKeys(input);
		driver.findElement(By.xpath("//*[@id=\"getFactorial\"]")).click();
		
		Thread.sleep(3000);


		String output = (driver.findElement(By.xpath("//*[@id=\"resultDiv\"]")).getText());
		String result = output.replace("The factorial of " + input + " is: ", "");

		String actualfactorial = String.valueOf(getFactorial(7));

		Assert.assertEquals(result, actualfactorial);
		
	

	}

	private int getFactorial(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int result = 1;
		while (n > 1) {
			result = result * n;
			n--;
		}
		return result;
	}
	
	@AfterTest
	
	public void teardown ()
	{
		driver.close();
		
	}


}
