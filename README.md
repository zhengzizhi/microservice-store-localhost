## How to start this project (spring.profiles.active = development)
```
cd /opt/sources && git clone https://github.com/zhengzizhi/microservice-store-localhost.git

cd /opt/examples/microservice-store-localhost/discovery-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/auth-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/account-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/inventory-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/catalog-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/gateway-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/online-ui1-service && mvn clean && mvn spring-boot:run
cd /opt/examples/microservice-store-localhost/online-ui2-service && mvn clean && mvn spring-boot:run

http://localhost:8761

http://localhost:9893/v1/catalog
http://localhost:9999/catalog/v1/catalog
http://localhost:8781/api/catalog/v1/catalog
http://localhost:8782/api/catalog/v1/catalog

## login user and password (username = jack ,password = pass123)
http://localhost:8781/
http://localhost:8782/


http://localhost:8181/uaa/actuator
http://localhost:8181/uaa/actuator/health


curl -v -X GET \
  http://localhost:8181/uaa/v1/me \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache'
  
curl -v -X GET \
  http://localhost:9999/user/uaa/v1/me \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache'
   
curl -v -X GET \
  http://localhost:8781/api/user/uaa/v1/me \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache'
  
  
curl -v -X GET \
  http://localhost:9891/v1/accounts \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache'
 
  
curl -v -X GET \
  http://localhost:9999/account/v1/accounts \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache'
  

curl -v -X GET \
  http://localhost:8781/api/account/v1/accounts \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache' 
  
curl -v -X GET \
  http://localhost:8782/api/account/v1/accounts \
  -H 'authorization: Bearer d9bd6db3-7efd-4200-839b-7fb8a15505f2' \
  -H 'cache-control: no-cache' 

```
