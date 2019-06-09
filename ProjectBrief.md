
# WeatherApp Project Brief

_Author_: IOTU NICOLAE  
_Email_: nicolae.g.iotu@gmail.com


## Project Subject: Weather Application
An application which allows users to search locations and display corresponding live weather conditions.


** Project Description: ** The WeatherApp backend is build on Java 1.8.0 OpenJDK and exposes a RESTful API through two controllers: com.fasttrackit.weatherapp.web.CityController and com.fasttrackit.weatherapp.web.CurrentWeatherController. These controllers allow performing standard CRUD operations on database together with complex operations (e.g. populating cities tables, or querying online weather provider for updated weather conditions). The frontend is build using standard HTML, CSS and Javascript, and popular libraries such as Bootstrap and jQuery.

The database contains a table 'cities_table' which stores the name and details of cities as listed by the weather provider https://openweathermap.org. When an user is looking for a location name, only the local database is used. When the user requests the weather for a certain location, the local database is queried for updated weather conditions for that location. If the weather conditions are not found locally, or if the data is older than three hours, an request is made online to https://openweathermap.org. The data returned by https://openweathermap.org is first stored locally for later use, and subsequently returned to frontend as json, processed and displayed as html.

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


&copy; 2019 IOTU NICOLAE, nicolae.g.iotu@gmail.com 