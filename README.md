

curl http://localhost:8080/
curl -H "Content-Type: application/json" -X POST -d '{
    "firstName": "Darren",
    "lastName": "Testing"
}'  http://localhost:8080/
curl -X DELETE http://localhost:8080/1
curl -H "Content-Type: application/json" -X PUT -d '{
    "id": 6,
    "firstName": "Paddy",
    "lastName": "Testing"
}'  http://localhost:8080/6
