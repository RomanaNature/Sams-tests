package com.nature.SciamTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RomanaTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://test-www.scientificamerican.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/my-account/order-history/?slatAction=public:account.logout");
    driver.findElement(By.linkText("Sign In")).click();
    driver.findElement(By.name("emailAddress")).clear();
    driver.findElement(By.name("emailAddress")).sendKeys("anamary022@gmail.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("nature123");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.linkText("View Order Details")).click();
    driver.findElement(By.linkText("Scientific American Print Subscription")).click();
    driver.findElement(By.cssSelector("a.cover > img")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Download Full Issue PDF")).click();
    Thread.sleep(2000);
    Actions oAction=new Actions(driver);
    WebElement oWE;
	oAction.moveToElement(oWE);
    oAction.contextClick(oWE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
   Set<String> sHandlers= driver.getWindowHandles();
   for(String sHandler:sHandlers);
    {
   
    String sHandler;
	if(driver.switchTo().window(sHandler).getTitle().equals("Open with"));
  {
 driver.switchTo().window(sHandler);
  WebElement oWE1=driver.findElement(By.linkText("OK"));
   oWE1.click();
  
              }  
            }
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
