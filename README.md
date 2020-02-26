# forcelate-crud
Spring Boot CRUD Application with JWT Authentication

### Postman
* postman collection is saved in postman directory

### Run
* Run Application
* Run Postman
* Verify request / response

### Queries

* Get authorization token:

*curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"Artur","email":"sobaka@gmail.com", "password":"mypass"}' \
  http://localhost:8080/registration*

* Save user:

*curl --header "Content-Type: application/json" \
  --header "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ" \
  --request POST \
  --data '{"name":"Julia","age":"31"}' \
  http://localhost:8080/api/user/save*

* Save article:

*curl --header "Content-Type: application/json" \
  --header "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ" \
  --request POST \
  --data '{"text":"article text","color":"green", "userId":"1"}' \
  http://localhost:8080/api/article/save*

* Find all users that older than some age:

*curl --header "Content-Type: application/json" \
  --header "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ" \
  --request GET \
  http://localhost:8080/api/user/age/18*

* Find all users that have articles with some color(red or green):

*curl --header "Content-Type: application/json" \
  --header "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ" \
  --request GET \
  http://localhost:8080/api/user/color/green*

* Find unique names of users that have more than 3 articles:

*curl --header "Content-Type: application/json" \
  --header "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ" \
  --request GET \
  http://localhost:8080/api/user/name*

