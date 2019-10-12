# base repo para apis con tomcat

Ejecutar ./run.sh para compilar, generar imagen docker, ejecutar contenedor con postgres y ejecutar api en local

Ejecutar imagen docker de este ejemplo:
```docker run -p 8080:8080 binarysearch/piros-base:dev```

Comprobar que se esta ejecutando correctamente
```curl -d '{"name":"Antonio"}' -H "Content-Type: application/json" -X POST http://localhost:8080/example```