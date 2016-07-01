Questions to take care of?
==========================
Check setup directions - RJ's machine

Technologies Used
=================
* Java 1.8
* Spring Boot 1.3.5
* Maven 3.3.3
* JUnit 4
* JMockit 1.24
* MongoDB 3.3
* Docker 1.12.0-rc2-beta17
* Eclipse Neon

Setup
=====
Install/Start docker  
In Terminal Window 1  
`$ Download myRetail from github` - depends on your system  
`$ cd <workspace>/Target/myRetail`  
`$ mvn Install`  
`$ docker build -t myretail .`  
`$ docker-compose up`  
Note: This terminal window will display the logs. To run in background, use: docker-compose up -d  
Note: Control-C will shut down the instances or use docker stop if running in background  

In Terminal Window 2  
`$ docker ps` 	=> To confirm docker containers started  
`$ docker exec -it myretail_mongodb_1 bash`  
`# mongo`  
`> use myRetail`  
`> db.price.find()`  

JUnit Tests
===========
Due to the nature of this project (small proof of concept), the JUnit tests are actually integration tests which requires a MongoDB instance to be available.  Perform the Setup steps to have a running instance of MongoDB in Docker.  
On a larger project, an embeded MongoDB instance would be used.

Demonstration
=============
Use the Advanced Rest Client (ARC) in google to hit the RESTful service.  

Demonstrate GET request
-----------------------
URL: http://localhost:8080/myRetail/products/13860428  
Select request type: GET  
Click button: SEND  
JSON Response returned  
`{  
	"id": 13860428  
	"name": "The Big Lebowski [Blu-ray]"  
	"current_price": {  
		"id": 13860428  
		"value": 29.99  
		"currency_code": "USD"  
	}  
}`  

Demonstrate POST request
------------------------
URL: http://localhost:8080/myRetail/products/13860428  
Select request type: POST  
Set raw payload to:  
`{  
	"id": 13860428,  
	"value": "29.99",  
	"currency_code": "USD"  
}`  
Click button: SEND  
No JSON response returned  

Confirm update by repeating GET request above and checking price  

Demonstrate GET Request on unknown product
------------------------------------------
URL: http://localhost:8080/myRetail/products/99999999  
Select request type: GET  
Click button: SEND  
JSON Response returned  
`{  
	"id": 99999999  
}`  

List of known product ids
-------------------------
13860428, 15117729, 16483589, 16696652, 16752456, 15643793  

