# ExternalSystem
Представляет собой сервис источник за изменениями БД которого мы следим через CDC

По адресу http://localhost:8888/swagger-ui/index.html мы можем увидеть сваггер МС

# Connector
Сервис настраивающий коннектор Debezium для CDC и преобразующий эвенты в сущности и сохраняющий их в свою БД,

которая играет роль outbox для дальнейшего стриминга в Kafka

# Other/ стек
* В docker-compose содержится всё необходимое для корректной работы
* 
  http://localhost:5051 по этому адресу можно подключиться к pgAdmin-web-ui с кредами админа из compose
* java 17
* Maven
* Liquibase 
* Kafka
* Debezium
* Quartz
* Mapstruct
* Swagger
* Lombok
