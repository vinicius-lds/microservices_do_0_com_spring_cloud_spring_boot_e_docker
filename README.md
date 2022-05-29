[![Continuous Integration with github](https://github.com/vinicius-lds/microservices_do_0_com_spring_cloud_spring_boot_e_docker/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/vinicius-lds/microservices_do_0_com_spring_cloud_spring_boot_e_docker/actions/workflows/docker-publish.yml)


docker run --name=postgres -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres 
docker run -p 9411:9411 -d openzipkin/zipkin:2.23.2 -name zipkin

mvn spring-boot:build-image
