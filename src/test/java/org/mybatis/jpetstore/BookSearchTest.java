package org.mybatis.jpetstore;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 

@RunWith(Cucumber.class)

@CucumberOptions(
		 features = "src/test/java/org/mybatis/jpetstore/search_book.feature" ,
		// glue={"org.mybatis.jpetstore.BookSearchSteps"},
		// dryRun =true
		//,monochrome = false,
		format = {"json:target/surefire-reports/cucumber.json"}
		)

public class BookSearchTest {
	
}