A basic application with microservices architecture having Product, Order, Inventory services with a Eureka server for service discovery and API Gateway.
A H2 database was used as an in-memory db and postman was used to post data and test hitting the endpoints.
Business logic has mainly been overlooked, the project is a demo project to understand microservice flow and basic integration with kafka.
The project has kafka integrated, the products microservice also acts as a kafka producer, producing an event "product-created-event" when a product is successfully created and is consumed by the Notification consumer microservice.
A core module has common modules between products MS and Notification MS.
