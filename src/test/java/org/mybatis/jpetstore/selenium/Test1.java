package org.mybatis.jpetstore.selenium;

import com.thoughtworks.selenium.*;  
import org.junit.*;  
//import com.testingbot.*;  
  
  
public class Test1 {
// empty
}

/*
public class Test1 extends TestingBotTestCase {  
  public void setUp() throws Exception {  
    TestingBotSelenium selenium = new TestingBotSelenium(  
            "hub.testingbot.com",  
            4444,  
            "firefox",  
            "http://www.google.com/");  
    selenium.start("version=10;platform=WINDOWS;screenshot=false");  
    this.selenium = selenium;  
  }  
  public void testGoogle() throws Exception {  
    this.selenium.open("/");  
    assertEquals("Google", this.selenium.getTitle());  
  }  
  
  public void tearDown() throws Exception {  
    this.selenium.stop();  
  }  
}  
*/

/*
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class Test1 extends SeleneseTestCase {
    public void setUp() throws Exception {
        setUp("http://localhost:8080/", "*iexplore");
    }
    public void testTemp_script() throws Exception {
        selenium.open("/BrewBizWeb/");
        selenium.click("link=Start The BrewBiz Example");
        selenium.waitForPageToLoad("30000");
        selenium.type("name=id", "bert");
        selenium.type("name=Password", "biz");
        selenium.click("name=dologin");
        selenium.waitForPageToLoad("30000");
    }
}
*/
