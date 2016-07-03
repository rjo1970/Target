Technologies Used
=================
* Java 1.8
* Spring Boot 1.3.5
* Maven 3.3.3
* JUnit 4
* JMockit 1.24
* MongoDB 3.3
* Docker 1.12.0-rc2-beta17
* Docker-Compose 1.8.0-rc1
* Eclipse Neon

Setup
=====
Install/Start docker  
In Terminal Window 1  
`$ Download myRetail from github` - depends on your system  
`$ cd <workspace>/Target/myRetail`  
`$ mvn install -Dmaven.test.skip=true`  
`$ docker build -t myretail .`  
`$ docker-compose up`  
Note: This terminal window will display the logs. To run in background, use: docker-compose up -d  
Note: Control-C should shut down the instances or use docker stop if running in background  

In Terminal Window 2  
`$ docker ps` 	=> To confirm docker containers started  
`$ docker exec -it myretail_mongodb_1 bash`
`# mongo`  
`> use myRetail`  
`> db.price.find()`  

JUnit Tests
===========
Due to the nature of this project (small proof of concept), the JUnit tests are actually integration tests which requires a MongoDB instance to be available. On a larger project, an embeded MongoDB instance would be used. 

In Terminal Window 1  
`$ docker run -it -p 27017:27017 mongo --storageEngine wiredTiger`  

In Terminal Window 2  
`$ mvn clean test`  
 

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
Select application type: application/json
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

Demonstrate POST request on different product
---------------------------------------------
URL: http://localhost:8080/myRetail/products/99999999  
Select request type: POST  
Select application type: application/json
Set raw payload to:  
`{  
	"id": 13860428,  
	"value": "39.99",  
	"currency_code": "USD"  
}`  
Click button: SEND  
Status: 500 Internal Server Error  
JSON response returned  
`{
	"timestamp": 1467555025459
	"status": 500
	"error": "Internal Server Error"
	"exception": "java.lang.RuntimeException"
	"message": "A price update request for id 99999999 attempted to update the price for id 13860428"
	"path": "/myRetail/products/99999999"
}`  

Confirm no price saved on 99999999 by repeating GET request for item 99999999 and checking price  
Confirm no update on 13860428 by repeating GET request for item 13860428 and checking price (29.99)

Demonstrate GET Request on product with no pricing
--------------------------------------------------
URL: http://localhost:8080/myRetail/products/16752456  
Select request type: GET  
Click button: SEND  
JSON Response returned  
`{  
	"id": 16752456
	"name": "Lego&reg; Super Heroes The Tumbler 76023"
}`  

List of known product ids
-------------------------
13860428, 15117729, 16483589, 16696652, 16752456 (no pricing info), 15643793  

