package org.mybatis.jpetstore.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)



@CucumberOptions(
		 features = "src/test/java/org/mybatis/jpetstore/cucumber/LogOut.feature" ,
		format = {"json:target/sureFire-reports/cucumber/LogOut.json"},
		tags= "@LogOut"
		)

public class LogOutTest {
		
}
