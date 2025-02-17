# Page Object Model (POM) Automation Framework

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://java.com)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-orange)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red)](https://testng.org)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue)](https://maven.apache.org)

A robust test automation framework following the Page Object Model design pattern for web application testing.

## Features

- **Page Object Model** design pattern implementation
- Multi-browser support (Chrome, Firefox, Edge)
- Configuration management using properties files
- Extent Reports integration for detailed reporting
- Screenshot capture on test failure
- Log4j2 logging implementation
- Data-driven testing support
- Cross-platform execution support

## Prerequisites

- Java JDK 17+
- Maven 3.6+
- Chrome/Firefox/Edge browser installed
- IDE (IntelliJ/Eclipse)

## Framework Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── pages/          # Page classes
│   │   ├── utilities/      # Helper classes
│   │   └── managers/       # Driver management
│   └── resources/
│       ├── config.properties
│       └── log4j2.xml
└── test/
    ├── java/
    │   ├── tests/          # Test classes
    │   └── listeners/      # TestNG listeners
    └── resources/
        └── testdata/       # Test data files


Installation
**Clone the repository:**

git clone git@github.com:YogiSDET/PageObjectModel.git

**Navigate to project directory:
**
cd PageObjectModel

**Update dependencies:
**
mvn clean install

**Configuration**
Update src/main/resources/config.properties:

**properties**
browser=chrome
baseUrl=https://your-test-url.com
timeout=30
headless=false
Running Tests
**Run all tests:**

mvn clean test
**Run specific test group:**
mvn test -Dgroups=smoke
**
Run with different browser:
**
mvn test -Dbrowser=firefox

**Reports
**After test execution, find HTML reports in:
target/extent-reports/

**Sample report:**
Extent Report Demo <!-- Add actual screenshot link -->

**Logging
**Framework uses Log4j2 for logging. Configure in:

src/main/resources/log4j2.xml
Logs are generated in:

logs/application.log
Best Practices
Follow naming conventions:

Page classes: HomePage.java, LoginPage.java

Test classes: LoginTests.java, CheckoutTests.java

Store locators in page classes only

Use utility classes for common functions

Add clear test descriptions:

@Test(description = "Verify successful login with valid credentials")
