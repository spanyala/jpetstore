package org.mybatis.jpetstore.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 

@RunWith(Cucumber.class)



@CucumberOptions(
		 features = "src/test/java/cucumber/search_book.feature" ,
		format = {"json:target/sureFire-reports/cucumber/cucumber.json"}
		)


public class BookSearchTest {
	
}