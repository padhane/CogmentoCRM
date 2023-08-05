package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class LoginPageTest extends BaseClass {

	@Parameters({ "browserName" })
	@BeforeTest
	public void setUp(String browserName) {
		initialization(browserName);
	}

	@Test(priority = 1)
	public void loginFunctionality() throws InterruptedException {
		Thread.sleep(5000);
		WebElement wb1 = getDriver().findElement(By.xpath("//div[text()='Login']/preceding::input[2]"));
		wb1.sendKeys("padhane26@gmail.com");

		WebElement wb2 = getDriver().findElement(By.xpath("//div[text()='Login']/preceding::input[1]"));
		wb2.sendKeys("Praju26ayu");

		WebElement wb3 = getDriver().findElement(By.xpath("//div[text()='Login']"));
		wb3.click();
	}

	@AfterTest
	public void tearDown() {

	}
}
