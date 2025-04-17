A basic application with microservices architecture having the following components:
  Product MS - Also acting as a Kafka Producer
  Order MS
  Inventory MS
  Eureka server for Service discovery & Registration
  API Gateway.
  Notification MS - Acts as a Kafka Consumer
  Core module has common modules between products MS and Notification MS.
  H2 database was used as an in-memory Db 
  
Postman was used to post data and test hitting the endpoints.

Business logic has mainly been overlooked, the project is a demo project to understand microservice flow and basic integration with Kafka.

The project has Kafka integrated, the products microservice also acts as a kafka producer, producing an event "product-created-event" when a product is successfully created and is consumed by the Notification consumer microservice.


