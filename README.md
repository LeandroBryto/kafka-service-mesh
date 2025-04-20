# Kafka Service Mesh

Este projeto é uma arquitetura de microserviços baseada no **Apache Kafka**, oferecendo uma solução robusta para comunicação assíncrona entre os serviços. Ele inclui múltiplos microserviços, como **Email Service**, **Order Service**, **Stock Service** e **Base Domains**, todos desenvolvidos com **Spring Boot** e integrados através de Kafka, garantindo alta escalabilidade e eficiência.

## Estrutura do Projeto

O repositório é composto por diversos módulos, cada um com sua responsabilidade no ecossistema de microserviços:

- **base-domains**: Contém as entidades e modelos de domínio comuns, compartilhados entre os outros módulos.
- **email-service**: Responsável pelo envio de e-mails e integração com Kafka para processamento assíncrono de mensagens.
- **order-service**: Gerencia o ciclo de vida dos pedidos, incluindo criação, atualização e rastreamento de status.
- **stock-service**: Controla o inventário de produtos e realiza operações de gerenciamento de estoque.

A raiz do projeto é o **microservices-root**, que orquestra todos os outros módulos e configura a infraestrutura comum.

## Tecnologias Usadas

- **Java 21**: A versão do JDK utilizada.
- **Spring Boot 3.4.4**: Framework para desenvolvimento de microserviços.
- **Apache Kafka**: Sistema de mensagens assíncronas utilizado para comunicação entre os microserviços.
- **Maven**: Gerenciador de dependências e ferramenta de build.
- **Docker**: Containerização dos serviços para fácil execução em diferentes ambientes.
- **Docker Compose**: Orquestração de múltiplos containers Docker para configurar, iniciar e interagir com os microserviços.
- **Swagger**: Utilizado para documentação da API e interação com os endpoints (implementado no **Order Service**).
- **Spring Boot Actuator**: Fornece funcionalidades de monitoramento e gerenciamento de microserviços, como métricas e controle de saúde.

## Funcionalidades

- **Comunicação Assíncrona com Kafka**: Todos os microserviços se comunicam de forma eficiente através do Apache Kafka.
- **Envio de Emails**: O `email-service` é responsável pelo envio de e-mails e integração com outros microserviços para processamento de notificações.
- **Gestão de Pedidos**: O `order-service` gerencia o ciclo de vida dos pedidos, incluindo a criação, atualização e rastreamento de status.
- **Gerenciamento de Estoque**: O `stock-service` monitora e gerencia o estoque de produtos, realizando operações de controle de inventário.

## Configuração do Ambiente

### Pré-requisitos

- **Java 21** ou superior.
- **Docker** e **Docker Compose** instalados.
- **Apache Kafka** (ou um cluster Kafka em execução).

### Como Rodar os Microserviços com Docker Compose

A configuração de todo o ambiente de microserviços é facilitada pelo uso do **Docker Compose**. O arquivo `docker-compose.yml` permite iniciar todos os containers necessários para a execução do projeto.

#### Passos para Execução:

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/kafka-service-mesh.git
   cd kafka-service-mesh
#### Suba os containers com Docker Compose:

Execute o seguinte comando para iniciar todos os serviços, incluindo o Kafka, ZooKeeper e seus microserviços:

docker-compose up --build


#### Acesse os serviços:

Email Service: Exposto na porta 8081

Order Service: Exposto na porta 8082

Stock Service: Exposto na porta 8083

O Kafka estará configurado para rodar nas portas padrão 9092 (Kafka) e 2181 (ZooKeeper).

#### Docker Compose
Aqui está um exemplo básico de arquivo docker-compose.yml para orquestrar os containers necessários para o funcionamento do Kafka, ZooKeeper e microserviços:

version: '3'
services:
  kafka:
    image: wurstmeister/kafka:latest
    environment:
      KAFKA_ADVERTISED_LISTENERS: INSIDE://kafka:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL: PLAINTEXT
      KAFKA_LISTENERS: INSIDE://0.0.0.0:9092
      KAFKA_LISTENER_NAMES: INSIDE
      KAFKA_LISTENER_PORT: 9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_LISTENER_INTERNAL: INSIDE
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    networks:
      - kafka-network

  zookeeper:
    image: wurstmeister/zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
    ports:
      - "2181:2181"
    networks:
      - kafka-network

  email-service:
    build: ./email-service
    depends_on:
      - kafka
    ports:
      - "8081:8081"
    networks:
      - kafka-network

  order-service:
    build: ./order-service
    depends_on:
      - kafka
    ports:
      - "8082:8082"
    networks:
      - kafka-network

  stock-service:
    build: ./stock-service
    depends_on:
      - kafka
    ports:
      - "8083:8083"
    networks:
      - kafka-network

networks:
  kafka-network:
    driver: bridge
    
#### Configuração do Kafka
O Kafka e o ZooKeeper são configurados para se comunicar dentro da rede do Docker.

O Kafka estará disponível na porta 9092, e os serviços podem se comunicar através desta porta.

Conectando-se aos Microserviços
Cada serviço está disponível na seguinte URL:

Email Service: http://localhost:8081

Order Service: http://localhost:8082

Stock Service: http://localhost:8083

####  Swagger para Documentação da API
O Swagger foi implementado para documentar e testar interativamente a API do Order Service. Após iniciar os containers, você pode acessar o Swagger UI para explorar os endpoints da API:

Order Service Swagger: http://localhost:8082/swagger-ui.html

A documentação gerada pelo Swagger fornece uma interface amigável para testar os endpoints e visualizar as respostas das requisições.

#### Spring Boot Actuator
O Spring Boot Actuator está configurado para fornecer informações de monitoramento e gerenciamento dos microserviços, incluindo endpoints de health check, metrics, auditoria e muito mais. Esses endpoints são acessíveis para garantir que o sistema esteja funcionando corretamente em ambiente de produção.

Exemplos de endpoints Actuator disponíveis:

Health: http://localhost:8081/actuator/health

Metrics: http://localhost:8081/actuator/metrics

Esses endpoints são cruciais para monitorar a integridade e a performance dos microserviços em tempo real.

