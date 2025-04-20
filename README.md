# Projeto Microserviços com Spring Boot, Kafka e Docker Compose

Este projeto é uma arquitetura de microserviços baseada no **Apache Kafka**, oferecendo uma solução robusta para comunicação assíncrona entre os serviços. Ele inclui múltiplos microserviços, como **Email Service**, **Order Service**, **Stock Service** e **Base Domains**, todos desenvolvidos com **Spring Boot** e integrados através de Kafka, garantindo alta escalabilidade e eficiência.

## 📂 Estrutura do Projeto

O repositório é composto por diversos módulos, cada um com sua responsabilidade no ecossistema de microserviços:

- **base-domains**: Contém as entidades e modelos de domínio comuns, compartilhados entre os outros módulos.
- **email-service**: Responsável pelo envio de e-mails e integração com Kafka para processamento assíncrono de mensagens.
- **order-service**: Gerencia o ciclo de vida dos pedidos, incluindo criação, atualização e rastreamento de status.
- **stock-service**: Controla o inventário de produtos e realiza operações de gerenciamento de estoque.

A raiz do projeto é o **microservices-root**, que orquestra todos os outros módulos e configura a infraestrutura comum.

## 🛠 Tecnologias Usadas

- **Java 21**: A versão do JDK utilizada.
- **Spring Boot 3.4.4**: Framework para desenvolvimento de microserviços.
- **Apache Kafka**: Sistema de mensagens assíncronas para comunicação entre serviços.
- **Maven**: Gerenciador de dependências e build.
- **Docker**: Containerização dos serviços.
- **Docker Compose**: Orquestração de containers.
- **Swagger**: Documentação da API (Order Service).
- **Spring Boot Actuator**: Monitoramento e métricas.

## 🚀 Funcionalidades Principais

- **Comunicação Assíncrona com Kafka**: Comunicação eficiente entre serviços.
- **Envio de Emails**: Processamento assíncrono de notificações.
- **Gestão de Pedidos**: Ciclo completo de vida dos pedidos.
- **Gerenciamento de Estoque**: Controle de inventário em tempo real.

## ⚙️ Configuração do Ambiente

### 📋 Pré-requisitos

- Java 21+
- Docker e Docker Compose
- Apache Kafka (ou cluster Kafka)

### 🐳 Execução com Docker Compose

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

    
#### Configuração do Kafka
O Kafka e o ZooKeeper são configurados para se comunicar dentro da rede do Docker.

O Kafka estará disponível na porta 9092, e os serviços podem se comunicar através desta porta.

Conectando-se aos Microserviços
Cada serviço está disponível na seguinte URL:

Email Service: http://localhost:8081

Order Service: http://localhost:8082

Stock Service: http://localhost:8083

#### 📖 Swagger para Documentação da API
O Swagger foi implementado para documentar e testar interativamente a API do Order Service. Após iniciar os containers, você pode acessar o Swagger UI para explorar os endpoints da API:

Order Service Swagger: http://localhost:8082/swagger-ui.html

A documentação gerada pelo Swagger fornece uma interface amigável para testar os endpoints e visualizar as respostas das requisições.

#### 📊 Spring Boot Actuator
O Spring Boot Actuator está configurado para fornecer informações de monitoramento e gerenciamento dos microserviços, incluindo endpoints de health check, metrics, auditoria e muito mais. Esses endpoints são acessíveis para garantir que o sistema esteja funcionando corretamente em ambiente de produção.

Exemplos de endpoints Actuator disponíveis:

Serviço | Health Check | Métricas
- Email Service | http://localhost:8081/actuator/health | http://localhost:8081/actuator/metrics
- Order Service | http://localhost:8082/actuator/health | http://localhost:8082/actuator/metrics
- Stock Service | http://localhost:8083/actuator/health | http://localhost:8083/actuator/metrics


Esses endpoints são cruciais para monitorar a integridade e a performance dos microserviços em tempo real.

####  Autor

Leandro Barreto de Brito
-  Desenvolvedor Backend | Engenheiro de Software
-  📧 leandrobarreto.barreto@gmail.com
-  📍 Brasília - DF

