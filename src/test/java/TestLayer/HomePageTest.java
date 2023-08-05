package TestLayer;


import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class HomePageTest extends BaseClass {
	@Test(priority = 2)
	public void validateHomePageTitle() {
		String actualTitle = getDriver().getTitle();
		Assert.assertEquals(actualTitle, "Cogmento CRM");

	}

	@Test(priority = 3)
	public void validateHomePageUrl() {
		String actualUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("cogmento"));
	}
}
