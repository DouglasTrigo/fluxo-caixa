# Projeto Fluxo de Caixa

Backend da aplicação Fluxo de Caixa constrúida com microsserviços

## Tecnologias

- Java 8
- Spring Boot
- Spring Data
- Spring Security
- Swagger
- Lombok
- Mapstruct
- MYSQL
- Docker
- Junit
- Mockito

## Informações

A aplicação é composta por três microsserviços, o microsserviço debito, credito e saldo. Dois deles fazem consulta direta ao banco de dados.

Abaixo o desenho de como a aplcação está atualmente

![](https://user-images.githubusercontent.com/11529081/237992889-8e39d548-db14-4e35-929d-95ee618a788d.PNG)

## Testes unitários

O projeto contepla testes unitários conforme imagens abaixo

### Testes unitários credito

![](https://user-images.githubusercontent.com/11529081/238053342-b48e2cea-654e-4210-a5b6-c18cf436602d.PNG)

### Testes unitários debito

![](https://user-images.githubusercontent.com/11529081/238053337-29f7aaac-afdf-4927-a1ef-50abd59602af.PNG)

### Testes unitários saldo

![](https://user-images.githubusercontent.com/11529081/238053344-cb57a3e6-abcc-4e20-b76e-773bac57701d.PNG)

## Pré requisito para executar localmente

Ter o docker instalado

## Subindo o projeto localmente

Para executar o projeto localmente, deve-se entrar na pasta do projeto e executar os comandos abaixo

`docker build --build-arg JAR_FILE=credito-0.0.1-SNAPSHOT.jar -t ms-credito -f Dockerfile .`

`docker build --build-arg JAR_FILE=debito-0.0.1-SNAPSHOT.jar -t ms-debito -f Dockerfile .`

`docker build --build-arg JAR_FILE=saldo-0.0.1-SNAPSHOT.jar -t ms-saldo -f Dockerfile .`

Os comandos acima vão gerar as imagens que contém os microsserviços.

Depois de executar os comandos acima, ainda no mesmo local, deve-se executar o comando abaixo

`docker-compose up`

O comando acima vai executar o docker-compose, subir duas base de dados MYSQL e subir os três microssrviços

## Chamando os microsserviços via Postman

Os microsserviços estão usando autenticação basic, para conseguir chamá-los pode-se usar a collection do postman, nela estão as credenciais necessárias para executar as chamadas.

O microsserviço de crédito tem 3 serviços, o que credita um valor, o de verificar os valores creditados e outro para limpar os registros

O microsserviço de débito tem 3 serviços, o que debita um valor, o de verificar os valores debitados e outro para limpar os registros

O microsserviço de saldo retorna um balanço entre os créditos e débitos, por exemplo. Se no dia eu creditei R$ 100,00 e depois debitei R$ 20,00, meu saldo será de R$ 80,00