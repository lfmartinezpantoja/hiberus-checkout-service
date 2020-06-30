# hiberus-checkout-service

This service is in charge of the administration of purchase orders, the service and the services used by these 
were developed using java 1.8, maven and the spring boot framework in version 2.3.1,
The service receives a purchase order and performs the following actions:
1. validate if the client exists using the hiberus-client-service
2. calculates the total amount to pay and the total products using the hiberus-bill-service.
3. complete the necessary documentation of the purchase order using hiberus-logistic-service


To run the service, the following instructions must be followed:
1. Download the repositories: hiberus-commons-service, hiberus-config-server, hiberus-client-service,
hiberus-bill-service, hiberus-logistic-service and hiberus-checkout-service, there is an optional repository
called hiberus-files that contains the postman collection to create a client and send a checkout request, in addition 
to a script to create the necessary database.
3. Before obtaining the docker images of the services, it is necessary to run a mysql database
for services, for this in this case it is proposed to use a docker image and run the following command:
sudo docker run -p 3306: 3306 --name hiberus -e MYSQL_ROOT_PASSWORD = P4ssW0rdH1b3rus -d mysql: 5.7.5
The services are configured in the hiberus-config-server using the root user and the previous password.
2. The services have a docker puglin that allows obtaining the image of each of the services under the standard:
hiberus/{service-name}: 0.0.1-SNAPSHOT, to do this you must run mvn clean install on each project.
It should be noted that to run and / or obtain the image of each service, the hiberus-config-server service must be running.
So it should always be the first service to run.
4. Once all the docker images have been obtained, each one of the images must be run as follows:
docker run -d -p {portService}:{portService} hiberus/{service-name}:0.0.1-SNAPSHOT
where portService is the port of each of the services defined in the hiberus-config-server
5. For the service to work properly, at least one existing client must be used in the database,
for this you must use the postman collection of the hiberus-files repository, there is the client request,
which creates a client which will serve to later execute the checkout request.

ABOUT SERVICES:

The services communicate using the spring boot http feing client, in addition the different layers of the services are separated into controller, DTOs, repositories, model, error, expection, services and the implementation of the service. The hiberus commons service keeps the DTOs, model and Feing clients of all the services centralized, on the other hand all the services use the spring configuration server which allows to keep all the configuration of the services externally.
