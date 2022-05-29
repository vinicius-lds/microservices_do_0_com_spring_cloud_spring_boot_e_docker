docker run --name=postgres -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres 
docker run -p 9411:9411 -d openzipkin/zipkin:2.23.2 -name zipkin

mvn spring-boot:build-image
