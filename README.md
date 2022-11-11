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

* /src/main/java...
  * **/cucumberSteps** - contains classes with tests that use Cucumber library.
  * **/driver** - contains classes for driver management, creates Chrome and Firefox drivers.
  * **/MySQL** - contains classes for work with SQL table.
  * **/pageFactory** - contains classes for implementing the Page Factory pattern.
  * **/pageObjects** - contains test logic with the implementation of the Page Objects pattern.
  * **/propertyHelper** - contains a PropertyReader to read from properties,These properties are used in Listener.
  * **/testNgUtils** - contains Listeners.
* src//main/**resources** - contains properties files with data for tests (url, browser type ...).


* **/src/test/java** - contains packages with tests
* **/src/test/resources** - contains xml files then used to run tests; and contains properties for Allure Report and configurations for log4j reporting.
* **/src/test/resources/features** - contains feature files for Cucumber tests.


* **Dockerfile** - a file with instructions needed to create a container image.
* **Jenkins** - Jenkins configuration file.
* **pom.xml** - contains information about the project and configuration details used by Maven to build the project.
---

