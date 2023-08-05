package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	private static ThreadLocal<WebDriver> driverThreadlocal = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		// get the driver from ThreadLocal Class
		return driverThreadlocal.get();
	}

	public void initialization(String browserName) {
		WebDriver driver = null;

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		// set the driver in ThreadLocal class
		driverThreadlocal.set(driver);

		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

	}

}
