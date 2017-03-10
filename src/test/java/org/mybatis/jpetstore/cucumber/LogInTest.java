package org.mybatis.jpetstore.cucumber;


import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.selenium.RegressionTests;
import org.mybatis.jpetstore.selenium.release;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)



@CucumberOptions(
		features = "src/test/java/org/mybatis/jpetstore/cucumber/LogIn.feature" ,
		format = {"pretty", "html:target/cucumber-html-report", "json:target/surefire-reports/Login.json"},
		tags= "@Login"
		)

@Category(release.class)

public class LogInTest {
		
}
