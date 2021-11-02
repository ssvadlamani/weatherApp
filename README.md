# WeatherApp with CI/CD pipeline

Weather application with CI/CD

### Features

 - Get the weather report

 
### Endpoints

 - `/weather/<location>"` rest endpoint, get the weather report.
 -  Ex: http://localhost:8080/weather/berlin


## CI/CD pipeline 

The Weather pipeline is configured to:

  1. Clone project
  2. Build the project
  3. Build Docker image
  4. Push image to `hub.docker.com`


## Build configuration

This project is set up using Maven. Build configuration can be found at `pom.xml`.

##### Running the project
 
  `mvn clean install -Dmaven.test.skip=true`
 `mvn spring-boot:run`
