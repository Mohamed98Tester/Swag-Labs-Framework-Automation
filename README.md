# Swag-Labs-Framework-Automation

Page Object Model automation framework for the Swag Labs (saucedemo.com) e-commerce
demo site, covering the full purchase flow end to end.

## What it does
- Page objects for Login, Home, Cart, Checkout (info + overview), and Finish pages
- A `DriverFactory` for WebDriver setup and shared `Utilities` (data handling, logging)
- TestNG suites per flow plus a combined regression suite (`TestRunner/*.xml`)
- Test data driven from JSON/properties files
- Execution reported through Allure

## Tech stack
- Java
- Selenium WebDriver
- TestNG
- Allure Reporting
- Maven
