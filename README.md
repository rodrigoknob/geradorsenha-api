# Passos para executar o backend do gerador de senhas

Primeiramente, é necessário ter o postgres instalado na máquina

## se tiver o docker instalado, digite os seguintes comandos

para baixar a imagem postgres

### `docker pull postgres  `

para criar o docker postgres

### ` docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres`

para executar o docker postgres

### `docker exec -it postgres psql -U postgres --password`

então digita a senha: postgres

Você vai ter se conectado com o docker postgres, então digite

create database gerenciador_senha;

### `caso não executar por docker`

crie um banco de dados com o nome: gerenciador_senha;

e coloque ele para rodar na porta 5432:5432


### ` clone o respositório`

é necessário ter o java instalado

com o banco já rodando
você pode abrir o projeto com o eclipse, ou netbeans, ou outra IDE que preferir
e ir no arquivo src/main/java, no pacote com.gerador_senha.api_rest, clicar com o botão
direito em cima do arquivo ApiRestApplication.java e rodar como aplicação java

ou, caso tiver o maeven instalado na máquina

abra o terminal na raiz do projeto e digite: mvn clean package
espere executar todo o processo

caso tudo ocorreu bem, irá gerar uma pasta target na raiz do projeto, com vários arquivos

então abra o terminal nessa pasta e digite:

java -jar api_rest-0.0.1-SNAPSHOT.jar

com isso, a api estará rodando no localhost na porta 8080

após, é só rodar a aplicação do frontend, e conseguirá usar o projeto de gerador de senha






