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
