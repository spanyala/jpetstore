var selenium = require('selenium-webdriver'),
    AxeBuilder = require('axe-webdriverjs'),
    Key = selenium.Key;

var util = require('util');

var driver;

describe('Checkout demo', function() {

    beforeEach(function(done) {
        driver = new selenium.Builder()
            .forBrowser('chrome')
            .build();

        driver.get('http://odims-dev.salientcrgt-devops.com/odims/login')
            .then(function () {
                done();
            });
    });

    // Close website after each test is run (so it is opened fresh each time)
    afterEach(function(done) {
        driver.quit().then(function () {
            done();
        });
    });


    it('...should go to the checkout page and analyze it', function (done) {
		driver.findElement(selenium.By.name("username")).sendKeys("joe.consumer");
		driver.findElement(selenium.By.name("password")).sendKeys("asdf");
		//driver.findElement(selenium.By.linkText("Login")).click();
		driver.findElement(selenium.By.xpath("//input[@value='Login']")).click();
		driver.findElement(selenium.By.className("product-info"))
            .then(function () {
                AxeBuilder(driver)
                    .analyze(function(results) {
                        console.log('Accessibility Violations on the Checkout page: ', results.violations.length);
                        if (results.violations.length > 0) {
							for (var i = 0; i < results.violations.length; i++) {
								console.log(results.violations[i].description);
							}
                        }
                        expect(results.violations.length).toBe(0);
                        done();
                    })
            });
    });
	
});