# Selenium Boilerplate: 
This java project contains the essentials to get started with selenium quickly without having to go through the hassle of downloading individual dependencies one by one.
Inside this Project:

Automated posting on Linkedin
Automated Bookmyshow to get List of Links
Automated IMDB to get ratings
Automated IMDB to get recommended Movies Link
Automated Search Amazon page
Automated Windows handling Activity
Automated Switch between Iframes 

## What does this project use?
   This project uses gradle , webdriver manager , selenium v4 

## Pre-requesites: 
   * git: https://github.com/git-guides/install-git
   * Java : https://www.java.com/en/download/help/download_options.html
   * Gradle: https://docs.gradle.org/current/userguide/installation.html

## Getting started: 

   1. clone this repo to your machine using git clone
   2. To build the project: 
   _MacOS_ / _Linux_
         ```
         ./gradlew build
         ```
      _Windows_
      ```
      gradlew.bat build
      ```

   3. To run the project: 
   _MacOS_ / _Linux_
      ```
      ./gradlew run
      ```
      _Windows_
      ```
      gradlew.bat run
      ```
## Writing your test case:

   *Test cases are part of the /src/main/java/demo/TestCases.java file.*
   ### Defining new test case: 
   1. Open TestCases.java file
   2. Create a copy of the function testCase01()
   3. Update the contents of the newly created method with your own custom logic

   ### Calling the newly created test case:
   1. open /src/App.java
   2. notice the TODO block: 
   ```
   //TODO: call your test case functions one after other here
   ```
   3. Call the newly created methods under the TODO block




