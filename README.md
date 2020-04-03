# UserRegistration
To implement a REST endpoint for the register operation based on the given interface specifications -Implement a simple way for the web application to remember already registered users (no real persistence needed, in-memory is sufficient) -Implement a way to use the given 'ExclusionService' interface to simulate the business logic of validating the user against an exclusion list.

Please find the cURL commands for the POST request

curl -X POST -H "Content-Type: application/json" -d "{ \"userName\": \"TestUser1\", \"password\": \"6Aef5\", \"dateOfBirth\": \"1934-06-30\", \"ssn\": \"687654321\" }" http://localhost:8080/userService/user

curl -X POST -H "Content-Type: application/json" -d "{ \"userName\": \"TestUser2\", \"password\": \"uAeh4\", \"dateOfBirth\": \"1964-03-25\", \"ssn\": \"687654321\" }" http://localhost:8080/userService/user

curl -X POST -H "Content-Type: application/json" -d "{ \"userName\": \"TestUser2\", \"password\": \"J4t6i\", \"dateOfBirth\": \"1984-11-12\", \"ssn\": \"387654321\" }" http://localhost:8080/userService/user

curl -X POST -H "Content-Type: application/json" -d "{ \"userName\": \"TestUser4\", \"password\": \"M7tk4\", \"dateOfBirth\": \"1917-05-02\", \"ssn\": \"787654321\" }" http://localhost:8080/userService/user
