# RestAPI
First of all, I used start.spring.io to initialize and generate a REST API Project, and get all the dependencies with the respective jar files.
Creation of Rest API using Spring and Spring Boot\
RestApiApplication.java is the entry point to run this REST API. It will do the component scan and will for all the configurations automatically.\
Configure all the dependencies in the pom.xml file.\
UserDAO is the Data Access Object that will map the API calls to the persistence layer.\
UserController will be the REST Controller that will have all the URL mappings and all the necessary functions will be written here.\
UserNotFoundException is the exception class that will be thrown in case the user won't be found.\
Inside /RestAPI -> src/test/java -> com.example.RestAPI, there is the class RestApiApplicationTests.java that is for testing the API using JUNIT, for now just for testing purpose, it checks the get user request, i.e. it will check if we provide the API "http://localhost:8080/users" then is it giving all the user data as the json response.\
There is also a full documentation with swagger that specifies what should be the format of the request/response. The URL in order to access this in this code is : http://localhost:8080/swagger-ui.html#/ . A screenshot for this is below:\
For now this code will only deal with JSON response.\
This API can be tested in the POSMAN application.\
Provide the urls:\
  http://localhost:8080/users with method as GET in POSTMAN to get the desired response. This will give all the users.\
  http://localhost:8080/users/1 This will give a specific user as a response whose id is 1.\
  http://localhost:8080/users with the method as POST to add any user, provide the new user as a json object in the request body.\
  http://localhost:8080/users/1  with the method as DELETE to delete the user with id 1.\
  http://localhost:8080/users with the method as PUT to update any user, provide the updated user as a json object in the request body.
