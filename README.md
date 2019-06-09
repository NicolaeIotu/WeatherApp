# WeatherApp

_Author_: IOTU NICOLAE  
_Email_: nicolae.g.iotu@gmail.com

An application which allows users to search locations and display corresponding live weather conditions.

** Description: ** The WeatherApp backend is build on Java 1.8.0 OpenJDK and exposes a RESTful API through two controllers: com.fasttrackit.weatherapp.web.CityController and com.fasttrackit.weatherapp.web.CurrentWeatherController. These controllers allow performing standard CRUD operations on database together with complex operations (e.g. populating cities tables, or querying online weather provider for updated weather conditions). The frontend is build using standard HTML, CSS and Javascript, and popular libraries such as Bootstrap and jQuery.

The database contains a table 'cities_table' which stores the name and details of cities as listed by the weather provider https://openweathermap.org. When an user is looking for a location name, only the local database is used. When the user requests the weather for a certain location, the local database is queried for updated weather conditions for that location. If the weather conditions are not found locally, or if the data is older than three hours, an request is made online to https://openweathermap.org. The data returned by https://openweathermap.org is first stored locally for later use, and subsequently returned to frontend as json, processed and displayed as html.

## How to Use
*	Register and get an app id from https://openweathermap.org
*	Enter this appid at class com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider
*	Create a database using the details specified at 'src/main/resources/application.properties'
*	Start the Spring Boot application
*	Populate 'cities\_table' by going to the [controllers Swagger-UI documentation](http://localhost:8080/swagger-ui.html "Swagger-UI") and calling the endpoint '/cities/populate/for/development/only/takes/long/time' using 'doFullPopulation = true' (this operation will take a while as over 22000 entries must be processed)
*	Go to the [home page](http://localhost:8080 "WeatherApp") and start using the WeatherApp

## Technologies used:

*   ** Services **
    *   Java 1.8.0 OpenJDK
    *   Apache Maven
    *   Spring Boot (runs app on embedded Apache Tomcat server)
	
*   ** Persistence **
    *	MySQL 8.0 Community Edition
    *	MySQL Workbench
    *	MySQL Connector/J 8.0
    
*	** Presentation **
    *	Javascript
    *	jQuery
    *	jQuery file-explore.js
    *	Bootstrap
    *	Bootstrap Select
    *	Ajax Bootstrap Select
    *	Bootstrap Toggle
    *	HTML
    *	CSS

Licenced under [Creative Commons Attribution-NonCommercial 4.0 International Public License](https://creativecommons.org/licenses/by-nc/4.0/ "Creative Commons Attribution-NonCommercial 4.0 International Public License").

&copy; 2019 IOTU NICOLAE, nicolae.g.iotu@gmail.com 