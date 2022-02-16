# Business Framework Middelware - Backend: Tigris

This project evolved due to an assignment at a university.

## Code usage

Please execute the following stept to run the code:

1. Open your programming environment (e.g. Eclipse or IntelliJ)
2. In the programming environment, open the backend project
3. Run the Application class

## Code structure

The structure of the project is as follows:

  - The project code is in the com.businessframework package
  - Package com.businessframework:
      - Package config: Configuration of the object mapper responsible for mapping JSON to Java objects
      - Package db: Consists of additional packages for data exchange and processing with the database 
      - Package model: Consists of Java model classes
      - Package pages: Consists of the Java classes for the data structure to the frontend pages
      - Application class: Runs the Spring Application
      - Mapping Controller class: Defines the HTTP interfaces that can be called from the backend
      
## Structure of the data traffic
The main construct is always the same and differs only in the associated classes.

1. Data is retrieved from the RestDb via the REST interfaces 
2. Using developed methods, the data is processed into the structure required by the frontend 
2. The reformatted data is provided via an interface defined in the mapping controller and called up by the frontend 

## Contributors in the backend
- @MiriamTrautmann
    - Miriam Trautmann
- @ThorLinus
    - Frederik Schröder
    
## Used configuration

The project uses Spring's default configuration to deploy the Spring Application (https://spring.io/). 

## Building Tool

The project uses the building tool Maven version 11 (https://maven.apache.org/).

## GitHub Repository 

The current backend code is available at: 
