🚀 Spring Boot RabbitMQ CRUD
-----------------------------
Um projeto completo demonstrando uma aplicação Spring Boot com RabbitMQ, PostgreSQL e Docker, implementando operações CRUD com mensageria assíncrona.

📋 Sobre o Projeto
------------------------------
Esta aplicação é um exemplo de como implementar uma arquitetura de microsserviços usando:

Spring Boot 3 para a API REST

RabbitMQ para mensageria assíncrona

PostgreSQL para persistência de dados

Docker para containerização

🏗️ Arquitetura
text
-----------------------------------
Client → Spring Boot API → PostgreSQL
                ↓
           RabbitMQ → Consumer
Fluxo de Funcionamento:
API recebe requisições CRUD de usuários

Dados são persistidos no PostgreSQL

Eventos são publicados no RabbitMQ

Consumidores processam eventos assincronamente

🛠️ Tecnologias Utilizadas
--------------------------------------
Java 17

Spring Boot 3.2.0

Spring Data JPA

Spring AMQP (RabbitMQ)

PostgreSQL

Docker & Docker Compose

Maven

📁 Estrutura do Projeto
------------------------------------
text
src/main/java/
├── config/
│   └── RabbitMQConfig.java          # Configuração do RabbitMQ
├── controller/
│   └── UserController.java          # Endpoints REST
├── service/
│   └── UserService.java             # Lógica de negócio
├── repository/
│   └── UserRepository.java          # Acesso a dados
├── model/
│   └── User.java                    # Entidade JPA
├── dto/
│   ├── UserRequest.java             # DTO de entrada
│   ├── UserResponse.java            # DTO de saída
│   └── UserEvent.java               # DTO para eventos
└── messaging/
    ├── UserEventProducer.java       # Produtor de mensagens
    └── UserEventConsumer.java       # Consumidor de mensagens






   
Envio de emails de boas-vindas

Atualização de caches

Logs de auditoria

Integrações com outros sistemas
