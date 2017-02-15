package org.mybatis.jpetstore.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)



@CucumberOptions(
		 features = "src/test/java/org/mybatis/jpetstore/cucumber/HomePage.feature" ,
		format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber/HomePage.json"},
		tags= "@HomePage"
		)

public class HomePageTest {		
}