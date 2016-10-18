package org.mybatis.jpetstore;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;



public class VerifyDogsLink {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private VideoRecord recorder;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
		
	    driver = new InternetExplorerDriver();
	    baseUrl = "http://54.152.107.21:9090/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVerifyDogsLink() throws Exception {
		 recorder=new VideoRecord();
		 recorder.startRecording();
	  driver.get(baseUrl + "/jpetstore/actions/Account.action?signonForm=");
	  Thread.sleep(2000);
    driver.findElement(By.name("signon")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='SidebarContent']/a[2]/img")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Sign Out")).click();
    Thread.sleep(2000);
    recorder.stopRecording();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
