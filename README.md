## Test Automation Basic Demo
This project was created to demonstrate my ability to build automated functional, and integration test framework from scratch.

	* Integration Testing:
		found in "src/test/java/integration" demonstrates initial code which can be used to build a scalable integration test automation framework for a REST API using Rest-Assured. It tests the API: https://swapi.dev/api


## How to execute the tests
	Single test:
	* Navigate to the project root folder using terminal or commandline.
	
	* To run a single API test, i.e. the GetFilmTest. Execute the following: 
		gradle test --tests integration.testSuite.film.GetFilmTest
	
	Test Suite:
	* To run API tests:
		gradle test -Psuite1 
	
## Reporting
	This project uses Extent Report to automatically generate the test report. Reports can be found in the extentReports folder in the root directory