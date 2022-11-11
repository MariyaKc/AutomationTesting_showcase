# Automation Testing Showcase

## About
### Java project for test automation, covering functional, GUI and API testing. 

### Applications tested:

* [Saucedemo](https://saucedemo.com/) - demo showcase, for testing login processes and shopping cart. 
* [Moodpanda](https://moodpanda.com) - website tested with using Selenide and BDD.
* [Herokuapp](https://the-internet.herokuapp.com) - website that includes a set of common test automation scenarios.
* [RabotaBy](https://rabota.by) - website tested with using BDD.
* [Reqres](https://reqres.in/) - website for API testing.
* **HtmlPage** and **Snipp** - demonstration of creating Html pages and working with tables.
* **SQL** -  demonstration of working with SQL table.

---

### Technology:
* Java 11
* Maven

### Tools & Frameworks:

* [TestNG](https://testng.org/) - Framework
* [Selenium](https://www.selenium.dev/) - Framework
* [Selenide](https://selenide.org) - Framework
* [Cucumber](https://cucumber.io) - Framework implementing the BDD approach
* [REST Assured](https://rest-assured.io/) - for API Testing
* [GSON](https://github.com/google/gson) - library that allows to convert JSON objects to Java objects and vice versa
* [Log4j](https://logging.apache.org/log4j/2.x/) - Java logging library
* [Allure Reports](http://allure.qatools.ru/) - Reporting System
* **Lombok** - Library for shortening code in classes and extending the functionality of the Java
* **Listenrs** - interface for Logs & Customizable TestNG Reports
---
### Architecture:
* **/files** - includes html pages, requests,jsonschema and test files.

* /src/main/java.../
  * **cucumberSteps** - contains classes with tests that use Cucumber library.
  * **driver** - contains classes for driver management, creates Chrome and Firefox drivers.
  * **MySQL** - contains classes for work with SQL table.
  * **pageFactory** - contains classes for implementing the Page Factory pattern.
  * **pageObjects** - contains test logic with the implementation of the Page Objects pattern.
  * **propertyHelper** - contains a PropertyReader to read from properties,These properties are used in Listener.
  * **testNgUtils** - contains Listeners.
* src//main/**resources** - contains properties files with data for tests (url, browser type ...).


* **/test/java** - contains packages with tests
* **/src/test/resources** - contains xml files then used to run tests; and contains properties for Allure Report and configurations for log4j reporting.
* **/src/test/resources/features** - contains feature files for Cucumber tests.


* **Dockerfile** - a file with instructions needed to create a container image.
* **Jenkinsfile** - Jenkins configuration file.
* **pom.xml** - contains information about the project and configuration details used by Maven to build the project.
---
### How to run tests :
The tests are run via **Run Configurations** .xml files or from **Terminal**

* To run tests via the **terminal**, use the command

      mvn clean test -DsuiteXml="XmlName" -Dconfig="propertyFileName"

Where ::  
* **propertyFileName** - the name of the property file corresponding to the suite with tests
* **XmlName** - name suite with tests to run

For example :: 

      mvn clean test -DsuiteXml="Saucedemo" -Dconfig="saucedemo"

To run tests via Run Configurations, right-click on the .xml file and select **"Modify Run Configuration..."**

In the window that opens, specify the **properties** to run, for example: 

<img width="723" alt="tests run" src="https://user-images.githubusercontent.com/111488221/201338242-4cec053a-c45f-44b8-9328-8f8bb89ee562.png">

After that click to run suite::

 <img width="360" alt="run" src="https://user-images.githubusercontent.com/111488221/201338266-cd30bf23-bf72-4d40-906f-d171cb15300c.png">

* **LOGS ::** 
* * All tests at runtime write a log that provides additional information about what happened if they failed. These files are located in target/logs


* **ALLURE ::** 
* * Results for allure reports are located in target/allure results. For view allure-report run this command in Terminal:

       allure serve target/allure-results

If the tests fall, a screenshot will be taken and attached to the Allure Report

* **DOCKER ::**
* * To run tests in a container, use the command in the terminal :

        sudo docker image build -t selenium-tests:0.0.1 .

The suite with the tests to run can be changed in the Dockerfile



