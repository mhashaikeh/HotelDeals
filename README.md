Setting Up local Sandbox:

I will give the details on a Linux Machine.

#Requirments:
1- Java8 or above.
2- Maven.
3- Tomcat Server 8.5 or above.

#Installation:

Assuming the tomcat path is (usr/local/tomcat/)

1- Make a folder (hotel_deals) for the logging into the path: /usr/local/tomcat/logs/
2- Start the tomcat.
3- On the command lines enter into the project root path (ex: /home/user/workspace/HotelDeals/).
4- Execute the maven command (mvn clean install).
5- Copy the generated war file (/home/user/workspace/HotelDeals/hotel-deals_webapp/target/hotel_deals.war) to the tomcat webapps folder (/usr/local/tomcat/webapps).
6- Access the application on the browser by typing the following URL (http://localhost:8080/hotel_deals/home).
