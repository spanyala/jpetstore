var selenium = require('selenium-webdriver'),
    AxeBuilder = require('axe-webdriverjs'),
    Key = selenium.Key;

var util = require('util');

var driver;

var fs = require('fs');

describe('Radio button demo', function() {

    beforeEach(function(done) {
        driver = new selenium.Builder()
            .forBrowser('chrome')
            .build();

        driver.get('http://jp-dev.salientcrgt-devops.com/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-4')
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


    it('should fetch the Koi page and analyze it', function (done) {
		driver.findElement(selenium.By.id("Catalog"))
            .then(function () {
                AxeBuilder(driver)
                    .analyze(function(results) {
                        console.log('Accessibility Violations: ', results.violations.length);
                        if (results.violations.length > 0) {
                            //console.log(util.inspect(results.violations, true, null));
			    var stream = fs.createWriteStream("testAddKoi.html");
       			    stream.once('open', function(fd) {
        			for (i=0; i<results.violations.length; i++) {
         				stream.write("Help: " + results.violations[i].help + "<br/>\n");
         				stream.write("Description:  " + results.violations[i].description + "<br/>\n");
         				//stream.write("impact:  " + results.violations[i].impact + "<br/>\n");
         				var myHtml = results.violations[i].nodes[0].html;
         				myHtml = myHtml.split("<").join("&lt;");
         				myHtml = myHtml.split(">").join("&gt;");
         				stream.write("&nbsp;&nbsp;&nbsp;&nbsp;HTML:  " + myHtml + "<br/>\n");
         				for (j=0; j< results.violations[i].nodes[0].any.length; j++) {
          					stream.write("&nbsp;&nbsp;&nbsp;&nbsp;Message:  " + results.violations[i].nodes[0].any[j].message + "<br/>\n");
         				}
	 				stream.write("<br/>\n");
        			}
        			stream.end();
			    });
                        }
                        expect(results.violations.length).toBe(0);
                        done();
                    })
            });
    });
});

describe('Radio button demo', function() {

    beforeEach(function(done) {
        driver = new selenium.Builder()
            .forBrowser('chrome')
            .build();

        driver.get('http://jp-dev.salientcrgt-devops.com/jpetstore/actions/Account.action?signonForm=')
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


    it('should go to the Login Page and analyze it', function (done) {
		driver.findElement(selenium.By.name("signon"))
            .then(function () {
                AxeBuilder(driver)
                    .analyze(function(results) {
                        console.log('Accessibility Violations: ', results.violations.length);
                        if (results.violations.length > 0) {
                            //console.log(util.inspect(results.violations, true, null));
				var stream = fs.createWriteStream("testPetLogin.html");
       			    stream.once('open', function(fd) {
        			for (i=0; i<results.violations.length; i++) {
         				stream.write("Help: " + results.violations[i].help + "<br/>\n");
         				stream.write("Description:  " + results.violations[i].description + "<br/>\n");
         				//stream.write("impact:  " + results.violations[i].impact + "<br/>\n");
         				var myHtml = results.violations[i].nodes[0].html;
         				myHtml = myHtml.split("<").join("&lt;");
         				myHtml = myHtml.split(">").join("&gt;");
         				stream.write("&nbsp;&nbsp;&nbsp;&nbsp;HTML:  " + myHtml + "<br/>\n");
         				for (j=0; j< results.violations[i].nodes[0].any.length; j++) {
          					stream.write("&nbsp;&nbsp;&nbsp;&nbsp;Message:  " + results.violations[i].nodes[0].any[j].message + "<br/>\n");
         				}
	 				stream.write("<br/>\n");
        			}
        			stream.end();
			    });
                        }
                        expect(results.violations.length).toBe(0);
                        done();
                    })
            });
    });
});
