# 1. Purpose

This a test automation project for Economist job portal which is developed using cucumber JVM & Selenium

# 2. Getting Started

One need to have JVM on his machine, and access to the central maven repo for getting the required libraries

# 3. Usage Guide

a) Clone this project to your local.
b) url for the application, runMode & id needs to be set in config.json file present in the properties folder in project classpath. 
c) For execution: There are two ways in which one can execute test.
 * From IDE directly, configuring the GenericRunner.Java with the test (@Tags) that one wants to execute and running it IDE(Eclipse,etc) itself.
 *Command line execution: To run the test that are tagged as functional from command line, first we need to navigate to project directory and then issue the command 
  mvn test -Dcucumber.options="--tags @functional"

# 4. Contact details

- Vivek Narula [viveknarula02@gmail.com]

# 5. Current Status

In Current state the project supports parallel execution as well as different browsers like Chrome, Firefox and HTMLUnit. In future we are trying to add the support for Safari as well.

# 7. Technology Stack

The framework is developed using open source technologies like cucumber JVM, Selenium Webdriver & Rest Assured. 