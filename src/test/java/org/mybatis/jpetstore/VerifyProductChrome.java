package org.mybatis.jpetstore;

import java.util.regex.Pattern;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import atu.testrecorder.ATUTestRecorder;



public class VerifyProductChrome {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private ATUTestRecorder recorder;
  String className="";

  @Before
  public void setUp() throws Exception {
	  String className = this.getClass().getName();
	  File dir=new File("target\\surefire-reports\\"+className+"\\");
	   if (!dir.exists()) {
	       dir.mkdir();
	   }

	  
	  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "http://54.152.107.21:9090";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }

  @Test
  public void testUnit() throws Exception {
	 
	  
		 //recorder=new VideoRecord();
	 //recorder.startRecording(className);
	   DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	   Date date = new Date();
	 recorder =new ATUTestRecorder("target\\surefire-reports\\"+className+"\\", className+"-"+dateFormat.format(date), false);
	 recorder.start();
    driver.get(baseUrl + "/jpetstore/actions/Account.action?signonForm=");
    Thread.sleep(2000);
    driver.findElement(By.name("signon")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#SidebarContent > a > img")).click();
    Thread.sleep(2000);
   
    
//    WebElement element=driver.findElement(By.linkText("FI-FW-01")); 
//    String str=element.getText();
//     if (str.equals("FI-FW-01")){
//    	 
//    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//    	// File dir=new File("target\\surefire-reports\\"+className);
//    	FileUtils.copyFile(scrFile, new File("target\\surefire-reports\\"+className+"\\"+className+".png"));
//     }
//	   
   
    
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
    recorder.stop();
   
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
