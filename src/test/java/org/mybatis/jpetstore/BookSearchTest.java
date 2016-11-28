package org.mybatis.jpetstore;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
	    format = "pretty",
	    features = "src/test/java/org/mybatis/jpetstore/search_book.feature" 
	)

public class BookSearchTest {
}