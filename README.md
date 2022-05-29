open cmd in the project directory
first run ==> docker compose up -d
then run ==> docker build --tag=docker-file:latest .
then run ==> docker run -p8080:8080 docker-file:latest .
then import postman "Mini Project One.postman_collection" collection it has the rest calls
or just call POST http://localhost:8080/api/v1/uaa ==> with body {"email":"admin@admin.com", "password":"1"} then call GET http://localhost:8080/api/v1/job

Thanks