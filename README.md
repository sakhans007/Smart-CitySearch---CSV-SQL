# Smart-CitySearch---CSV-SQL
## Introduction

The project will create an application to populate a database from the provided Geo City Lite CSV file and allow the users to search for cities near a particular lat/long or another city. The application will start by loading the data from the csv file into the database, if it has not yet been loaded. Then the application allow the user to enter either lat/long or a city name. For lat/long it simply apply the nearby search to locate cities near the lat/long from the DB. In case of city name, it uses reverse search in the db to find out the lat/long for that city, before applying the same nearby search algorithm. 
    
## Tools / Software Requirement
    * Java
    * Hibernate
    * MySQL Database
    * Apache Commons for CSV
    * Intellij IDEA

## Description
Latitude defines how far north or south of the equator a point is positioned.  Points alongside the equator have latitudes of zero. The North Pole has a positive (north) latitude of 90, and the South Pole a negative (south) latitude of -90. Accordingly, northern-hemisphere locations have positive latitude, and southern-hemisphere locations have negative latitude. Longitude describes how far east a point is, from the prime meridian: an arbitrary line on the earth surface running from pole to pole.
Latitudes are values in the range [-90, 90]. Longitudes are values in the range (-180, 180]. These values are sometimes expressed in degrees, minutes, and seconds, rather than degrees and decimals.  If you’re planning to do calculations, convert the minutes and seconds to decimals first.
The user can provide either lat/long or a city name (reverse search the lat/long), which will be utilized to look for a certain number (based on user input) of nearby cities. Remember, since the earth is not flat, you cannot apply simple arithmetic operations to find out the nearby cities, instead use the “The Great Circle Distance Formula” to find out the nearby lat/long. A short sample SQL to do the same is as follows: 

## Distance Formula:
```
DEGREES(ACOS(COS(RADIANS(lat1)) * COS(RADIANS(lat2)) *
             COS(RADIANS(long1) - RADIANS(long2)) +
             SIN(RADIANS(lat1)) * SIN(RADIANS(lat2))))
```

The task is to implement the following:

    * Creating and populating a database table from the Geo City CSV file.
    * Developing an interface for user to search a city and find out its latitudes and longitudes.
    * Developing an interface for user to find out the specified number of cities nearby a target city or lat/long.
    * Creation of unit tests to evaluate your code.
    * Using a Version Control System (VCS) to manage your solutions.
