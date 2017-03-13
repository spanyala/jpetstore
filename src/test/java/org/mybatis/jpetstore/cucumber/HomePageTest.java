package org.mybatis.jpetstore.cucumber;


import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mybatis.jpetstore.selenium.RegressionTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)



@CucumberOptions(
		 features = "src/test/java/org/mybatis/jpetstore/cucumber/HomePage.feature" ,
		format = {"pretty", "json:target/surefire-reports/HomePage.json"},
		tags= "@HomePage"
		)

@Category(RegressionTests.class)
public class HomePageTest {		
}
