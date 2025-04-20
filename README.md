# Kafka Service Mesh

Este repositório contém uma série de microserviços para gerenciar diferentes funcionalidades de um sistema baseado em Kafka, incluindo serviços de email, gerenciamento de pedidos e controle de estoque. O sistema é construído usando o Spring Boot e Kafka, com foco em escalabilidade e integração eficiente.

## Estrutura do Projeto

O projeto é composto por vários módulos Maven, cada um responsável por uma funcionalidade específica:

- **base-domains**: Contém as entidades de domínio comuns usadas pelos outros módulos.
- **email-service**: Responsável pelo envio de emails usando o Spring Boot Mail e integração com Kafka para mensagens assíncronas.
- **order-service**: Gerencia pedidos e integra com outros microserviços para processar e atualizar o status dos pedidos.
- **stock-service**: Controla o estoque, incluindo a atualização da quantidade de itens e o gerenciamento de inventário.
- **microservices-root**: O módulo raiz, que integra todos os serviços e configura o ambiente do projeto.

## Tecnologias Usadas

- **Java 21**: A versão do JDK utilizada.
- **Spring Boot 3.4.4**: Framework para desenvolvimento rápido de microserviços.
- **Apache Kafka**: Sistema de mensagens assíncronas utilizado para comunicação entre os microserviços.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Lombok**: Biblioteca para reduzir o boilerplate de código (como getters, setters, etc.).
- **JUnit**: Framework para testes unitários.

## Como Rodar o Projeto

### Pré-requisitos

Certifique-se de que você tem as seguintes ferramentas instaladas:

- **Java 21** ou superior.
- **Apache Maven**.
- **Apache Kafka** (ou uma instância do Kafka rodando).

### Passos para Execução

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/kafka-service-mesh.git
    cd kafka-service-mesh
    ```

2. Compilar o projeto e rodar os microserviços:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. O microserviço `email-service` será iniciado e poderá ser acessado conforme configurado no `application.properties`.

4. Certifique-se de que o Kafka está rodando na máquina local ou em um servidor remoto, e que as configurações de conectividade estão corretas.

## Endpoints

### Email Service

- **POST /send-email**: Envia um email para um ou mais destinatários. 

   Exemplo de payload:

    ```json
    {
      "to": ["destinatario1@exemplo.com", "destinatario2@exemplo.com"],
      "subject": "Assunto do Email",
      "body": "Corpo do email"
    }
    ```

### Outros serviços (Order e Stock) possuem funcionalidades semelhantes de gerenciamento de pedidos e controle de estoque.

## Testes

O projeto inclui testes automatizados que garantem a funcionalidade dos microserviços. Para rodar os testes, use o seguinte comando Maven:

```bash
mvn test
