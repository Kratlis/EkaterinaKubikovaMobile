# 3rd homework

## Preparation

Before running tests, you should configure the URL for connecting to [the mobile cloud](https://mobilecloud.epam.com/).

For this, please, write your token for connecting to EPAM mobile cloud into the [test.properties file](src/test/resources/test.properties) (src/test/resources/test.properties).

## Running
This testing project has six modes:
1. testing local native Android application

        mvn test -P 'native'

2. testing local Google Chrome search

        mvn test -P 'web'

3. testing cloud native Android application

        mvn test -P 'cloud_native_android'

4. testing cloud native iOS application

        mvn test -P 'cloud_native_ios'

5. testing cloud Google Chrome search

        mvn test -P 'cloud_web_android'

6. testing cloud Google search in Safari

        mvn test -P 'cloud_web_ios'

## Description

### Native app
It tests EPAMTestApp application:
* it's possible to register
* it's possible to log in after you registered
* after logging in the BudgetActivity page opens.

### Google Search
It tests serching in Google Chrome browser
* a search for the word "EPAM" shows relevant results.
