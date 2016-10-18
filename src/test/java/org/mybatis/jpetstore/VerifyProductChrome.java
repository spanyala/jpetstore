package org.mybatis.jpetstore;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class VerifyProductChrome {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private VideoRecord recorder;

  @Before
  public void setUp() throws Exception {
	
	  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://54.152.107.21:9090//jpetstore/actions/Account.action?signonForm=";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUnit() throws Exception {
		 recorder=new VideoRecord();
	 recorder.startRecording();	
    driver.get(baseUrl + "/jpetstore/actions/Account.action?signonForm=");
    Thread.sleep(2000);
    driver.findElement(By.name("signon")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#SidebarContent > a > img")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("FI-FW-01")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.linkText("Add to Cart")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Proceed to Checkout")).click();  
    Thread.sleep(2000);
    driver.findElement(By.name("newOrder")).click();   
    Thread.sleep(2000);
    driver.findElement(By.linkText("Confirm")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Sign Out")).click();
    Thread.sleep(2000);
    recorder.stopRecording();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    driver.close();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
