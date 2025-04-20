## Projeto Microserviços com Spring Boot, Kafka e Docker Compose

Este repositório contém um projeto de microserviços utilizando **Spring Boot**, **Kafka**, **Docker Compose**, **Swagger**, **Spring Boot Actuator** e **Testes Unitários**. O projeto inclui serviços de envio de e-mails, gerenciamento de pedidos e controle de estoque. Todos os microserviços se comunicam via Kafka e estão configurados para rodar com Docker Compose.

---

## 🛠 Tecnologias Utilizadas

- **Spring Boot** para desenvolvimento dos microserviços.
- **Kafka** como sistema de mensagens assíncronas.
- **Docker** e **Docker Compose** para orquestração dos containers.
- **JUnit 5** e **Mockito** para testes unitários.
- **Swagger** para documentação e testes da API.
- **Spring Boot Actuator** para monitoramento e métricas de saúde.

---

## 📁 Estrutura do Projeto

O projeto segue uma arquitetura de microserviços composta pelos seguintes módulos:

1. **Email Service**: Responsável pelo envio de e-mails.
2. **Order Service**: Gerencia os pedidos dos clientes.
3. **Stock Service**: Gerencia o estoque de produtos.
4. **Kafka**: Sistema de mensageria que integra os microserviços.

---

## 🚀 Iniciando o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
