# quantas-airports-query-service
This is a simple web application created using Spring boot project. It is packaged as 'jar' for testing purposes. 
This project can easily be packaged into war by just changing the packaging type in the pom.xml.

# Contents
- AirportsServiceClient.java: This class consumes the airports API exposed by Quantas.
- Airport.java, Airports.java, Country.java, Location.java: Domain objects
- AirportQueryController.java: Restful Service to filter airport based on code, country, international and regional airports
- AirportsQueryControllerTest.java: Junit for controller.

# About Restful API
- API exposed t URL: /svc/v1/airports
- Query parameters code(string), country(string), showInternationalAirports(boolean) and showReginoalAirports(boolean) are supported.
- showInternationalAirports and showReginoalAirports query parameters are defaulted to "true".
- Empty string will be ignored and all query parameters are case sensitive.

# Pre-requisites to run
- Ensure Jdk 1.8 is installed JAVA_HOME is pointing to the installed version
- Ensure maven is installed and MVN_HOME is set.

# How to run
- Clone the project using: https://github.com/Vinaybs/quantas-airports-query-service.git
- Go to the project folder and execute the maven command: mvn spring-boot:run
- This will build the project and deploy the project in embedded tomcat container. 
- You will see a message saying Started QuantasAirportQueryServiceApplication
- Hit the browser with the URL: http://localhost:8080/svc/v1/airports to display all airports
- Example URL with some query parameters: http://localhost:8080/svc/v1/airports?country=NZ&code=CHC


