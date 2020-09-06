# CodeChallenge-MultiFileParser
File Parser Utilities to parse different file types


Objective
==========
To Design and Develop Scalable CSV File Parser

Design Approach
==============
Factory Pattern :-Create File Parser service according to file Type(derived based on file extension).
Strategy Pattern :Algorithms/Logic for parsing is abstracted and implementation is provided in the
   				  Child class.
Spring Data JPA/Hibernate :Provides database portability feature
Note:This project can be extended as RestAPI by providing endpoint in the
Controller class -FileParserController & thus could be used by multiple projects

Tools Used
===========
openJDK11 (Also compatible with JDK8)
Maven v3.6.3
Spring-boot framework (**With Embedded tomcat enabled-Its almost production ready)
Spring data JPA/Hibernate framework
Mysql server(Local instance)
Junit5( for Unit Testing)

How To?
=======
a)Build/install Project
------------------------
1.Open Command/Terminal window
2.Navigate to project root folder(containing pom.xml file)
3.Execute command : mvn clean install

b)Run Test (Junit)
-------------
1.Open Command/Terminal window
2.Navigate to Project root folder( folder containing pom.xml file)
3.Run command -> mvn test

c)Run Project
--------------
 1.Open Command/Terminal window
 2.Navigate to Project target folder( folder containing FileParserAPI-0.0.1-SNAPSHOT.jar file)
 3.Run command -> java -jar FileParserAPI-0.0.1-SNAPSHOT.jar <<csv fileName>>
 example:java -jar FileParserAPI-0.0.1-SNAPSHOT.jar sales.csv
 Note:file directory can be configured in application.properties file.
 example:file.upload.directory=C:/temp/ [change to server directory]
 
 Assumption
 1.There will be always Header in the CSV file and column mapping is done
 as per headers.hence there is validation also provided to check csv file column headers
 
 2.SQLException occuring due unique contraints etc are only logged in the console
 at the moement.It could be extended to write to another file or database
  
 
