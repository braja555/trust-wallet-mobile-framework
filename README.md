# TrustWallet Android Application Automation

## Overview
This project is a demonstrative automation suite provided by the Trust Wallet development team, targeting the automation of "Create New Wallet" test scenarios for the Trust Wallet native Android application. 
The focus is primarily on UI functionality testing. Significant enhancements and restructurings have been applied to the original framework, detailed below.

## Framework Enhancements
* Automated initiation of the Appium server, facilitating seamless CI/CD integration.
* Implementation of the Page Object Model for enhanced maintainability.
* Integration of Extent reports for comprehensive testing insights.
* Incorporation of TestNG annotations and listeners for better test management.
* Configuration data now dynamically sourced from JSON and property files.

## Automated Test Scenarios
* Test creation of a new wallet with manual backup verification.
* Test creation of a new wallet with the option to skip backup.
* Test backup process of secret phrase verification.
* Test negative scenarios in the new wallet creation process.
* Test the selection of an incorrect secret phrase during backup verification.

## Requirements
* Java 11
* Maven v3.9
* Appium v2.0
* Android SDK 
* Node.js
* Set Java, Maven and Android in Environmental path

## Execution Commands
To run the tests, execute one of the following commands in your terminal:

To perform a clean installation and execute the specified TestNG suite:

    ** mvn clean install -Dtestngfile={testng}

To perform a clean installation, execute the specified TestNG suite, and retry failed tests up to a maximum count:

    ** mvn clean install -Dtestngfile={testng} -DmaxRetryCount=2
  



         
