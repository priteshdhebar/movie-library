# movie-library

Getting java.lang.IllegalStateException: No instances available for MOVIE-SERVICE(tried with http://localhost:2222 and http://127.0.0.1:2222) but no luck

## Deployment

## Using an IDE

Do below process sequentially as MovieLibraryDiscovery.java will start Eureka server and then MovieLibraryClient.java will consume the micro services from that server

1. Find and Open com.microservices.config.discovery.MovieLibraryDiscovery.java -> right click and run as java application

2. Find and Open com.microservices.config.client.MovieLibraryClient.java -> right click and run as java application


## Command Line

i have made one utility class from where depend of value passed it will invoke respective main method of above mentioned classes.

1. open CMD, Shell etc -> mvn clean install or mvn clean package

2. java -jar target/moive-library-0.0.1.jar server

3. on new CMD,Shell -> java -jar target/moive-library-0.0.1.jar movielibraryservice


eureka server dashboard 		  :     http://localhost:1111/
to execute movie micro service    :  	http://localhost:2222/movie/1
