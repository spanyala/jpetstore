package org.mybatis.jpetstore.selenium;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
	@IncludeCategory(release.class)
	@ExcludeCategory(RegressionTests.class)
 
	@SuiteClasses( { VerifyProductChrome.class }) // Note that Categories is a kind of Suite
	public class TestSuite {
	 
	}

