# 🧪 BankBot - Selenium Automation Framework

## 📌 Project Overview

BankBot is a Selenium-based automation framework designed to test key functionalities of a banking web application (Guru99 demo site).
The framework follows the Page Object Model (POM) design pattern to ensure maintainability, scalability, and reusability.

---

## 🚀 Features

* Page Object Model (POM) design
* Parallel test execution using TestNG
* Data-driven testing using Excel
* Screenshot capture on failure
* Extent Reports integration
* Retry mechanism for tests

---

## 🛠 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports

---

## 📂 Project Structure

```
BankBot/
│
├── src
│   │
│   ├── main/java
│   │   │
│   │   ├── base
│   │   │   └── BasePage.java              → Common Selenium methods (click, type, wait, alerts)
│   │   │
│   │   ├── pages
│   │   │   ├── LoginPage.java             → Handles login actions
│   │   │   ├── HomePage.java              → Handles navigation
│   │   │   ├── NewCustomerPage.java       → Create new customer
│   │   │   ├── EditCustomerPage.java      → Edit customer details
│   │   │   ├── NewAccountPage.java        → Create new account
│   │   │   ├── EditAccountPage.java       → Edit account type
│   │   │   ├── FundTransferPage.java      → Perform fund transfer
│   │   │   └── BalanceEnquiryPage.java    → Check account balance
│   │   │
│   │   └── utils
│   │       ├── ConfigReader.java          → Reads config.properties values
│   │       ├── ExcelUtil.java             → Reads test data from Excel
│   │       ├── ExtentManager.java         → Manages Extent Report setup
│   │       └── ScreenshotUtil.java        → Captures screenshots
│   │
│   ├── test/java
│   │   │
│   │   ├── base
│   │   │   └── BaseTest.java              → WebDriver setup and teardown
│   │   │
│   │   ├── tests
│   │   │   ├── LoginTest.java             → Login test cases
│   │   │   ├── ValidationTest.java        → Form validation tests
│   │   │   ├── CustomerTest.java          → Customer module tests
│   │   │   ├── AccountTest.java           → Account module tests
│   │   │   └── FundTransferTest.java      → Fund transfer tests
│   │   │
│   │   ├── listeners
│   │   │   ├── TestListener.java          → Screenshot + reporting on test events
│   │   │   └── RetryListener.java         → Applies retry logic on failure
│   │   │
│   │   └── utils
│   │       └── RetryAnalyzer.java         → Defines retry count logic
│   │
│   └── test/resources
│       │
│       ├── testdata
│       │   └── LoginData.xlsx             → Test data for login
│       │
│       └── config.properties              → Environment configuration
│
├── reports
│   └── ExtentReport.html                  → Execution report
│
├── screenshots
│   └── (generated files)                  → Failure screenshots
│
├── pom.xml                               → Maven dependencies
│
└── testng.xml                            → Test execution configuration
```

---

## 🧪 Test Modules Covered

### 🔹 1. User Authentication

* Verify login with valid credentials
* Verify login failure with invalid credentials
* Verify logout redirects to the login page
* Validate blank field errors

### 🔹 2. Customer Management

* Create new customer
* Validate success message
* Edit customer details
* Verify duplicate email error

### 🔹 3. Account Management

* Create account
* Verify account creation
* Edit account type
* Verify with invalid customer Id

### 🔹 4. Fund Transfer

* Transfer funds between accounts
* Verify balance is updated after the transfer
* Validate invalid payee error

### 🔹 5. Form Validation

* Empty field validation
* Numeric field validation
* Future date of birth validation

---

## ⚙️ Configuration

Edit `config.properties`:

```
baseUrl = https://demo.guru99.com/V4/
browser = chrome
timeout = 10
username = your_username
password = your_password

```

---

## ▶️ How to Run Tests

### Using Maven

```bash
mvn test
```

### Using TestNG XML

```
Right-click → testng.xml → Run As → TestNG Suite
```

---

## 📊 Reports & Screenshots

* 📄 Extent Report → `/reports/ExtentReport.html`
* 📸 Screenshots → `/screenshots/` (on failure only)

---

## ⚠️ Known Issues (Guru99 Demo Site)

* Edit Account and Balance Enquiry may throw **HTTP 500 error**

👉 These are handled gracefully using try-catch in tests.

---

## 🔄 Retry Mechanism

Failed tests are automatically retried using:

* `RetryAnalyzer`
* `RetryListener`

---

## 👩‍💻 Author

Vaishnavi

---

## 📌 Conclusion

### Emoji for Conclusion

📌

---

## Conclusion

This project implements a robust Selenium automation framework using the Page Object Model to test key banking functionalities. It ensures scalability and reliability through features like parallel execution, reporting, and error handling.

---
