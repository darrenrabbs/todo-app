# todo-app
A Simple Rest Todo service using Kotlin and Spring Boot

curl -w "\n" -X GET http://localhost:8080/task 

echo ""

curl -w "\n" -X POST \
-H "Content-Type: application/json" \
-d '{"description": "write code"}' http://localhost:8080/task

curl -w "\n" -X POST \
-H "Content-Type: application/json" \
-d '{"description": "test"}' http://localhost:8080/task 

echo ""

curl -w "\n" -X GET http://localhost:8080/task

echo ""

curl -w "\n" -X DELETE http://localhost:8080/task/1

curl -w "\n" -X DELETE http://localhost:8080/task/10

echo ""

curl -w "\n" -X GET http://localhost:8080/task


# References

https://auth0.com/blog/developing-restful-apis-with-kotlin/


