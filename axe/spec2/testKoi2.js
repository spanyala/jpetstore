var selenium = require('selenium-webdriver'),
    AxeBuilder = require('axe-webdriverjs'),
    Key = selenium.Key;

var util = require('util');

var driver;

describe('Radio button demo', function() {

    beforeEach(function(done) {
        driver = new selenium.Builder()
            .forBrowser('chrome')
            .build();

        driver.get('http://jp-dev.salientcrgt-devops.com/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-FW-01')
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


    it('should go to the Koi page and analyze it', function (done) {
		driver.findElement(selenium.By.id("Catalog"))
            .then(function () {
                AxeBuilder(driver)
                    .analyze(function(results) {
                        console.log('Accessibility Violations on the Koi page: ', results.violations.length);
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