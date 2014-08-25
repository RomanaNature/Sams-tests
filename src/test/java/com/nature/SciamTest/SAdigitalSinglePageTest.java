package com.nature.SciamTest;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SAdigitalSinglePageTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
@Before
public void setUp() throws Exception {
	
    driver = new FirefoxDriver();
    baseUrl = "https://www.guerrillamail.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void SAdigitaltest1() throws Exception {
	driver.manage().window().maximize();  
    driver.get(baseUrl + "/en/");
    driver.findElement(By.id("inbox-id")).click();  //Click on the button 
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[type=\"text\"]")).clear();
    int ran = 100 + (int)(Math.random()*((1000-100)+1));
    driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Romana"+ran);// Type email id
    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[@id='inbox-id']/button")).click();  //click on the set button
    Thread.sleep(2000);
    //driver.findElement(By.cssSelector("td.td2")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='inbox-id']")).click();
   
//copy the email address
	driver.findElement(By.xpath("//*[@id='inbox-id']/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
    driver.findElement(By.xpath("//*[@id='inbox-id']/button[1]")).click(); 

	
//Open Scientific American in a new tab and Subscribe
    //driver.get("https://test-www.scientificamerican.com/store/subscribe/scientific-american-digital/?responseKey=");
    driver.manage().window().maximize();
    FirefoxProfile profile = new FirefoxProfile(); 
    profile.setPreference("network.http.phishy-userpass-length", 255); 
    driver.get("https://web:guest@test-www.scientificamerican.com/store/subscribe/scientific-american-digital/?responseKey="); 
    Assert.assertEquals("Not the proper status code!", 200, Integer.parseInt(driver.findElement(By.id("web_response")).getAttribute("content")));
    driver.findElement(By.xpath("//*[@id='SAD']/div/p/img[2]")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys("Romana");
    Thread.sleep(1000);
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("Sheikh");
    Thread.sleep(1000);
             
//Paste Email address
    driver.findElement(By.id("emailAddress")).clear();
    WebElement element2 = driver.findElement(By.id("emailAddress"));
    WebElement element3 = driver.findElement(By.id("emailAddressConfirm"));
    Actions action= new Actions(driver);
    action.contextClick(element2).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).sendKeys("@guerrillamail.com").build().perform();

    Thread.sleep(1000);
    driver.findElement(By.id("emailAddressConfirm")).clear();
    action.contextClick(element3).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).sendKeys("@guerrillamail.com").build().perform();
    Thread.sleep(1000);
    driver.findElement(By.id("screenName")).clear();
    driver.findElement(By.id("screenName")).sendKeys("Romana"+ran);
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
    driver.findElement(By.id("name")).sendKeys("Romana Sheikh");
    Thread.sleep(1000);
    driver.findElement(By.id("shippingStreetAddress")).clear();
    driver.findElement(By.id("shippingStreetAddress")).sendKeys("167 34th st");
    Thread.sleep(1000);
    driver.findElement(By.id("shippingCity")).clear();
    driver.findElement(By.id("shippingCity")).sendKeys("Ozone park");
    Thread.sleep(1000);
    new Select(driver.findElement(By.id("stateCode"))).selectByVisibleText("New York");
    Thread.sleep(1000);
    driver.findElement(By.id("shippingPostalCode")).clear();
    driver.findElement(By.id("shippingPostalCode")).sendKeys("11416");
    Thread.sleep(1000);
    driver.findElement(By.id("submitFulfillment")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("nameOnCreditCard")).clear();
             driver.findElement(By.id("nameOnCreditCard")).sendKeys("Romana Sheikh");
            Thread.sleep(1000);
            driver.findElement(By.id("creditCardNumber")).clear();
           driver.findElement(By.id("creditCardNumber")).sendKeys("4112344112344113");
            Thread.sleep(1000);
           new Select(driver.findElement(By.id("ccMonth"))).selectByVisibleText("12");
             Thread.sleep(1000);
            driver.findElement(By.id("securityCode")).clear();
            driver.findElement(By.id("securityCode")).sendKeys("411");
            Thread.sleep(1000);
            driver.findElement(By.id("submitBilling")).click();
            Thread.sleep(1000);
             driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(4000);
            //driver.switchTo().window(ScientificAmerican); //cntrl to parent window
             
 //Open Guerrillamail to Verify email
             driver.get("https://www.guerrillamail.com/en/inbox");
             driver.manage().window().maximize();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//*[@id='inbox-id']")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//*[@id='inbox-id']/button[1]")).click();
             Thread.sleep(1000);
           
            driver.findElement(By.xpath("html/body/div[4]/div[3]/form/table/tbody/tr[2]/td[3]")).click();  //click on Email tab
             //driver.findElement(By.className("td3")).click(); //clicked on the first email on the list
             //driver.findElement(By.linkText("here")).click();  //click on the email title to open the email
            String selectAll = Keys.chord(Keys.SHIFT,Keys.RETURN);
            driver.findElement(By.linkText("here")).sendKeys(selectAll);
          
//Go to Scientific American my account and open the magazine in PDF
             driver.get("http://test-www.scientificamerican.com/my-account/");
             driver.manage().window().maximize();
             driver.findElement(By.linkText("Order History")).click();
             driver.findElement(By.linkText("View Order Details")).click();
             driver.findElement(By.linkText("Scientific American Digital Subscription")).click();
             driver.findElement(By.cssSelector("a.cover > img")).click();
             driver.findElement(By.linkText("Download Full Issue PDF")).click();
             Thread.sleep(5000);
             driver.close();
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


   
  


  



  
	             
  
