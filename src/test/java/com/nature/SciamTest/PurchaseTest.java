package com.nature.SciamTest;

import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchaseTest {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private int ran;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.bin","/usr/bin/Firefox.exe");
		// baseUrl = "http://test-www.scientificamerican.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPurchase() throws Exception {
		// driver.get(baseUrl +
		// "/store/subscribe/scientific-american-digital/?responseKey=");
		driver.manage().window().maximize();
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("network.http.phishy-userpass-length", 255);
		driver.get("https://web:guest@test-www.scientificamerican.com/store/subscribe/scientific-american-digital/?responseKey=");
		Assert.assertEquals("Not the proper status code!", 200, Integer.parseInt(driver.findElement(By.id("web_response")).getAttribute("content")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='SAD']/div/p/img[2]")).click();
		// driver.findElement(By.name("selectRegion")).click();
		// new
		// Select(driver.findElement(By.id("Select"))).selectByVisibleText("United States - $59.00");
		// select = new
		// Select(driver.findElement(By.id(By.id("Select"))).selectByVisibleText("United States - $59.00");
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("ama");
		Thread.sleep(1000);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("smith");
		Thread.sleep(1000);
		driver.findElement(By.id("emailAddress")).clear();
		ran = 100 + (int) (Math.random() * ((1000 - 100) + 1));
		driver.findElement(By.id("emailAddress")).sendKeys(
				"amasmith" + ran + "@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("emailAddressConfirm")).clear();
		driver.findElement(By.id("emailAddressConfirm")).sendKeys(
				"amasmith" + ran + "@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("screenName")).clear();
		driver.findElement(By.id("screenName")).sendKeys("ama" + ran);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("nature123");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordConfirm")).clear();
		driver.findElement(By.id("passwordConfirm")).sendKeys("nature123");
		Thread.sleep(1000);
		driver.findElement(By.id("List_OptIn_External1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("acceptedTC")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("submitCreateAccount")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("ama smith");
		Thread.sleep(1000);
		driver.findElement(By.id("shippingStreetAddress")).clear();
		driver.findElement(By.id("shippingStreetAddress")).sendKeys(
				"198 34 43 st");
		Thread.sleep(1000);
		driver.findElement(By.id("shippingCity")).clear();
		driver.findElement(By.id("shippingCity")).sendKeys("New York");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("stateCode")))
				.selectByVisibleText("New York");
		Thread.sleep(1000);
		driver.findElement(By.id("shippingPostalCode")).clear();
		driver.findElement(By.id("shippingPostalCode")).sendKeys("11417");
		Thread.sleep(1000);
		driver.findElement(By.id("submitFulfillment")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("creditCardNumber")).clear();
		driver.findElement(By.id("creditCardNumber")).sendKeys(
				"4112344112344113");
		Thread.sleep(1000);
		driver.findElement(By.id("nameOnCreditCard")).clear();
		driver.findElement(By.id("nameOnCreditCard")).sendKeys("ama smith");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ccMonth")))
				.selectByVisibleText("12");
		Thread.sleep(1000);
		driver.findElement(By.id("securityCode")).clear();
		driver.findElement(By.id("securityCode")).sendKeys("411");
		Thread.sleep(1000);
		driver.findElement(By.id("submitBilling")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='shoppingCartHeader']/div[2]/div/span[2]/ul/li[1]/a"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='myAccountCol']/ul/li[2]/a"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@id='orderListingBlock']/table/tbody/tr[2]/td[4]/a"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@id='orderDetailBlock']/div[4]/table/tbody/tr[2]/td[2]/div/p/span[1]/a"))
				.click();
		Thread.sleep(5000);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
