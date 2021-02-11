[![Build Status](https://travis-ci.org/jeanLuizInsight/desafio-conquer.svg?branch=main)](https://travis-ci.org/jeanLuizInsight/desafio-conquer)

# Aplicação Web para consulta ao Portal da Transparencia do Governo Federal

Descrição: Aplicação Web utilizada para desafio Full Stack Developer da Conquer.

## :computer: Desafio
Projeto utilizado para o usuário realizar consulta na API REST do Portal da Transparência do Governo Federal, informando um intervalo de meses, e então obter em arquivo no formato .csv os dados de pagamento efetuados via cartão agrupando o saldo por municipio.

## :rocket: Conceitos e tecnologias
* Spring Boot 2.4.2;
* Maven;
* Java 8;
* Flyway DB;
* JPA e MySQL;
* Bean Validation;
* Client REST para realizar solicitações à API;
* Jackson Databind e Jersey (mapeamento do schema da API utilizado com json);
* Apache Commons CSV;
* Thymeleaf;
* Layout com Bootstrap;
* Testes unitários - JUnit 5, Mockito e Mocks;
* Integração contínua com Travis CI;

## :wrench: Rodando a aplicação
Requisitos:

* Servidor MySQL configurado com usuário root e senha ae3Fresqor10@ rodando local na porta 3306 ou alterar a URL do datasource no resource application.properties do projeto;
* Spring Tool Suite 4 (STS);
* Java 8;

Instruções:

* Certifique-se de que o servidor MySQL está executando;
* Importe o projeto no STS como uma aplicação maven e inicie pelo serviço habilitado na aba Boot Dashboard;

## :bookmark: Melhorias a serem feitas
* Adicionar todos os campos disponíveis nos filtros da API ao formulário na página de consulta;
* Adicionar controle de logs na aplicação;
