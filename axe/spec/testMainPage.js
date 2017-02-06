var selenium = require('selenium-webdriver'),
    AxeBuilder = require('axe-webdriverjs'),
    Key = selenium.Key;

var util = require('util');

var driver;

describe('Petstore demo', function() {

    beforeEach(function(done) {
        driver = new selenium.Builder()
            .forBrowser('chrome')
            .build();

        driver.get('http://jp-dev.salientcrgt-devops.com/jpetstore/actions/Catalog.action')
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


	    it('should just fetch the home page and analyze the whole page', function (done) {
        driver.findElement(selenium.By.css('body.home')).then(function (element) {
            return element.getAttribute('class').then(function (className) {
                expect(className.indexOf('home')).toBe(0);
            });
        }).then(function () {
                AxeBuilder(driver)
                    .analyze(function(results) {
                        console.log('Accessibility Violations: ', results.violations.length);
                        if (results.violations.length > 0) {
                            console.log(util.inspect(results.violations, true, null));
                        }
                        expect(results.violations.length).toBe(0);
                        done();
                    })
            });
    });
});