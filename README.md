# base repo para apis con tomcat

Ejecutar ./run.sh para compilar, generar imagen docker, ejecutar contenedor con postgres y ejecutar api en local

Ejecutar imagen docker de este ejemplo:
```(docker network create --attachable develop_network || true ) &&

docker run -d -p 5432:5432 --network=develop_network --network-alias=db postgres:11.3 &&

docker run -p 8080:8080 --network=develop_network binarysearch/piros-base:dev```

Comprobar que se esta ejecutando correctamente
```curl -d '{"name":"Antonio"}' -H "Content-Type: application/json" -X POST http://localhost:8080/example```