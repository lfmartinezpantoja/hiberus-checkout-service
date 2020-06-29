# hiberus-checkout-service

Este servicio es el encargado de la administración de ordenes de compra, el servicio y los servicios usados por 
este fueron desarrollados usando java 1.8, maven y el framework spring boot en su version 2.3.1, 
el servicio recibe una orden de compra y realiza las siguientes acciones:
1. valida si el cliente existe usando el servicio hiberus-client-service
2. realiza el calculo del  monto total a pagar  y el total de productos usando el servicio hiberus-bill-service.
3. realiza la lgoisitica necesaria de la orden de compra 


Para correr el servicio se deben seguir las siguientes instrucciones: 
1. Descargar los repositorios: hiberus-commons-service, hiberus-config-server, hiberus-client-service, hiberus-bill-service, hiberus-logistic-service y  hiberus-checkout-service.
3. Antes de obtener las imagenes de docker de los servicios es necesario correr una base de datos mysql 
para los servicios, para ello en ese caso se propone usar un imagen docker y correr el siguiente comando:
sudo docker run -p 3306:3306 --name hiberus -e MYSQL_ROOT_PASSWORD=P4ssW0rdH1b3rus -d mysql:5.7.5
Los servicios estan configurados en el hiberus-config-server usando el usuario root y  la constraseña anterior.
2. Los servicios poseen un puglin de docker que permite obtenerla imagen de cada uno de los servicios bajo el estandar:  
hiberus/{nombre-servicio}:0.0.1-SNAPSHOT, para ello se debe ejecutar mvn clean install en cada proyecto.
4. Una vez obtenidas todas la imagenes de docker se debe corre cada una de las imagenes de la siguiente manera:
docker run -d -p {portService}:{portService}  hiberus/{nombre-servicio}:0.0.1-SNAPSHOT
donde portService es el puerto de cada uno de los servicios definidos en el hiberus-config-server
5. Para que el servicio funcione adecuadamente se debe usar al menos un cliente existente el la base de datos, 
para ello se debe usar la colección de postman del repositorio hiberus-files, ahí se encuentra la peticion client ,
la cual crea un cliente el cual servira para posteriormente ejecutar la peticion checkout.



