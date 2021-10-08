# 2nd homework


This testing project has two modes:
1. testing native application
2. testing Google Chrome search

## Native app
It tests EPAMTestApp application:
* it's possible to register
* it's possible to log in after you registered
* after logging in the BudgetActivity page opens.

For running this test use maven command:

`mvn test -P 'native'`

## Google Search
It tests serching in Google Chrome browser
* a search for the word "EPAM" shows relevant results.

For running this test use maven command:

`mvn test -P 'web'`
