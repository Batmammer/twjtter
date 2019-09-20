# twjtter
Quick Twitter app with Java
Application uses Java 8, Spring Boot 2.1.8 and H2 Database, but can be easly converted to other SQL Database. 
Usage:
Just build with Maven and use like normal Spring Boot/Java application.
In evry call use parameter user which simulates session.

curl -d '{"message":"Sample message 1"}' -H "Content-Type: application/json" -X POST http://localhost:8080/twjtter/wall?user=user1
This call adds post for user1 (user will be created if doesn't exists) 

curl http://localhost:8080/twjtter/wall/my?user=user2
This shows posts for user2

curl http://localhost:8080/twjtter/wall/my?user=user2
This shows timeline (followed users posts) for user2

curl -X PUT http://localhost:8080/twjtter/follow/user1?user=user2
This call makes user2 to follow user1, you cannot follow yourself

curl -X DELETE http://localhost:8080/twjtter/follow/user1?user=user2
This call makes user2 to unfollow user1

Known issues:
-no tests (unit/integration), sorry not enough time
-user is not validated (but message is) 



