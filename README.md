# 🛒 OpenCart E-Commerce Automation Framework

Welcome to the OpenCart Ecommerce Automation Framework!  
This is a robust, scalable Selenium-based automation testing framework designed for automating the OpenCart ecommerce platform. It follows best practices like Page Object Model (POM), Data-Driven Testing, Maven for build management, and TestNG for test orchestration.

---

## 📂 Project Structure

```plaintext
OpenCart-Ecommerce_Application/
├── src/                                # Source directory for main and test code
│   ├── main/                           # Contains application source code
│   │   ├── java/
│   │   │   ├── baseTest/               # Base test class for setup/teardown
│   │   │   │   └── BaseTest.java
│   │   │   ├── pageObjects/            # Page Object Model classes for each page
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── RegistrationPage.java
│   │   │   │   ├── MyAccountPage.java
│   │   │   │   └── AccountCreationSuccessfulPage.java
│   │   │   ├── utilities/              # Utility classes for common functionality
│   │   │   │   ├── ExcelUtility.java
│   │   │   │   ├── DataProviders.java
│   │   │   │   └── ExtentReportManager.java
│   ├── resources/                      # Resource files like configs and logs
│   │   ├── config.properties
│   │   └── log4j2.xml
│
├── test/                               # Test-related files and data
│   ├── java/
│   │   └── testCases/                  # Test classes implementing test logic
│   │       ├── TC001_AccountRegistrationTest.java
│   │       ├── TC002_LoginPageTest.java
│   │       └── TC003_LoginDataDrivenTest.java
│   ├── resources/
│   │   └── Opencart_LoginData.xlsx     # Excel test data for data-driven testing
│
├── logs/                               # Directory containing logs generated during test runs
│   └── automation.log
├── screenshots/                        # Screenshots of test failures for debugging
│   └── verify_account_registration_*.png
├── test-output/                        # TestNG output reports
│   └── Suite/
│       └── emailable-report.html
├── testSuites/                         # TestNG suite XML files for different test configurations
│   ├── crossBrowserTesting.xml
│   ├── grouping.xml
│   └── master.xml
├── pom.xml                             # Maven Project Object Model configuration file
```

## ⚙️ Tech Stack

- Selenium WebDriver (v4.30.0)
- TestNG (v7.11.0)
- Java Faker (v1.0.2)
- Log4j2 (v2.24.3)
- Apache POI (v5.4.0)
- WebDriverManager (v6.0.1)
- Extent Reports (via selcukes-extent-reports v2.3.13)
- Maven as Build Tool
- JavaSE-1.7

---

## 🚀 Key Features

- ✅ Modular architecture using Page Object Model (POM)  
- ✅ Data-driven testing with Apache POI  
- ✅ Integrated reporting with Extent Reports  
- ✅ Logging with Log4j2  
- ✅ TestNG XML suite management (grouping, parallel execution, cross-browser)  
- ✅ Screenshot capture on test failures  
- ✅ Easy integration with CI/CD tools  

---

## 🛠️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-repo/opencart-ecommerce-automation.git
cd opencart-ecommerce-automation
```

### 2. Build the Project using Maven

```bash
mvn clean install
```

### 3. Run Test Suites

```bash
mvn test -DsuiteXmlFile=testSuites/master.xml
```

---

## 🔑 TestNG XML Files

- 🧪 master.xml — Runs all core tests  
- 🧪 grouping.xml — Executes grouped tests (e.g., smoke, regression)  
- 🧪 crossBrowserTesting.xml — Enables parallel execution across browsers  

---

## 📊 Reports

- 📄 Test Report: `test-output/Suite/emailable-report.html`  
- 📁 Logs: `logs/automation.log`  
- 🖼️ Screenshots on Failure: Located in `screenshots/` directory  

---

## 📄 Data-Driven Testing

- 🗂️ Test Data File: `src/test/resources/Opencart_LoginData.xlsx`  
- 📊 Data Managed With: Apache POI  
- 🔍 Used in: `TC003_LoginDataDrivenTest.java`  

---

## 📌 Pre-requisites

- ☕ Java JDK 1.7 or higher  
- 🔧 Maven 3.6+  
- 🌐 Internet connection (for WebDriverManager to auto-download drivers)  

---

## ✨ Future Enhancements

- 🔄 Integrate with Jenkins/GitHub Actions  
- 🔌 Add support for REST API testing (using RestAssured)  
- 📧 Integrate email alerts via Apache Commons Email  
- 🐳 Dockerize the test execution  

---

## 🧠 Contributor Notes

- 🧪 Use Java Faker for generating dynamic and unique test data  
- ⚙️ Extend `BaseTest.java` for all new test classes  
- 🔁 Place reusable utilities in `BasePage.java` or `utilities/` package  

---

## 💬 Feedback & Contributions

Feel free to fork the repo, contribute new features, raise issues, and suggest improvements!  
Pull requests are always welcome! 😄

---
