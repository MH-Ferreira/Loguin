
# Sistema de Login e Cadastro com Spring Boot

Sistema de autenticação desenvolvido com Spring Boot que implementa um fluxo completo de login e cadastro de usuários, com interface moderna e responsiva.

## 📚 Estrutura Detalhada do Projeto

### 📂 Estrutura de Pacotes
```
src/
<p></p>├── main/ 
<p></p>├── java/ 
<p></p>│ └── br.applogin.login/ 
<p></p>├── controller/ 
<p></p>├── model/ 
<p></p>├── repository/ 
<p></p>├── service/ 
<p></p>└── LoginApplication.java 
<p></p>└── resources/ 
<p></p>├── templates/ 
<p></p>├── static/ 
<p></p>└── application.properties
``` 

### 📁 Detalhamento das Pastas

#### `src/main/java/br/applogin/login/`
Contém todo o código-fonte Java da aplicação organizado nos seguintes pacotes:

##### 1. `controller/`
Controladores que gerenciam as requisições HTTP:
```
java LoginController.java
- GET /login: Exibe página de login
- POST /logar: Processa autenticação
- GET /cadastroUsuario: Exibe página de cadastro
- POST /cadastroUsuario: Processa novo cadastro
- POST /sair: Realiza logout
``` 

##### 2. `model/`
Entidades JPA que representam as tabelas do banco de dados:
```
java Usuario.java Atributos:
- Long id
- String nome
- String email
- String senha
``` 

##### 3. `repository/`
Interfaces de acesso ao banco de dados:
```
java UsuarioRepository.java Métodos:
- findByEmail(): Busca usuário por email
- login(): Autenticação do usuário
``` 

##### 4. `service/`
Camada de serviços com regras de negócio:
```
java CookieService.java Funcionalidades:
- Gerenciamento de cookies
- Controle de sessão
``` 

#### `src/main/resources/`
Recursos da aplicação:

##### 1. `templates/`
Arquivos HTML do Thymeleaf:
```
login.html
- Formulário de login
- Validação client-side
- Links de navegação
- Mensagens de erro

cadastro.html
- Formulário de cadastro
- Validações em tempo real
- Feedback visual
``` 

##### 2. `application.properties`
Configurações do Spring Boot:
```
properties
# Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/applogin spring.datasource.username=root spring.datasource.password=root
# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true
# Thymeleaf
spring.thymeleaf.cache=false
``` 

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 21**: Linguagem de programação principal
- **Spring Boot**: Framework para desenvolvimento da aplicação
- **Spring MVC**: Camada web e REST
- **Spring Data JPA**: Persistência de dados
- **Hibernate**: ORM para mapeamento objeto-relacional
- **MySQL**: Banco de dados relacional

### Frontend
- **Thymeleaf**: Engine de templates
- **HTML5**: Estruturação das páginas
- **CSS3**: Estilização moderna e responsiva
- **JavaScript**: Interações client-side

## 🔧 Configuração do Ambiente

### Pré-requisitos
- JDK 21
- Maven 3.8+
- MySQL 8.0+
- IDE (recomendado: IntelliJ IDEA)

### Passos para Configuração

1. **Clone o Repositório**
```
bash git clone [https://seu-repositorio.git](https://seu-repositorio.git) cd nome-do-projeto
``` 

2. **Configure o Banco de Dados**
```
sql CREATE DATABASE applogin; USE applogin;
CREATE TABLE usuario ( id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL UNIQUE, senha VARCHAR(255) NOT NULL );
latex_unknown_tag
``` 

3. **Configure o application.properties**
```
properties
# Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/applogin?createDatabaseIfNotExist=true spring.datasource.username=seu_usuario spring.datasource.password=sua_senha
# JPA
spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true
``` 

4. **Execute o Projeto**
```
bash mvn spring-boot:run
``` 

## 📱 Funcionalidades Detalhadas

### 1. Sistema de Login
- Autenticação por email e senha
- Validação de credenciais
- Gestão de sessão via cookies
- Mensagens de erro personalizadas
- Redirecionamento após login bem-sucedido

### 2. Cadastro de Usuários
- Validação em tempo real dos campos
- Verificação de email duplicado
- Feedback visual de sucesso/erro
- Redirecionamento após cadastro
- Botão de retorno para login

### 3. Segurança
- Validação server-side
- Proteção contra SQL Injection
- Sanitização de inputs
- Gestão segura de cookies
- Controle de sessão

## 🎨 Interface e Design

### Componentes Visuais
- Containers responsivos
- Formulários estilizados
- Botões com feedback visual
- Mensagens de erro/sucesso
- Ícones intuitivos

### Classes CSS Principais
```
css .login-container .form-group .submit-button .error-message .back-link
``` 

## 📦 Dependências Principais
```
xml    org. springframework. boot   spring-boot-starter-web   
<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- MySQL Connector -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<!-- Thymeleaf -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
dependencies
dependency
groupid
groupid
artifactid
artifactid
dependency
dependencies
``` 

## 🧪 Testes

### Testes Unitários
- Validação de usuário
- Autenticação
- Manipulação de cookies

### Testes de Integração
- Fluxo de cadastro
- Fluxo de login
- Persistência de dados

## 📈 Melhorias Futuras

1. **Segurança**
   - Implementar Spring Security
   - Adicionar autenticação 2FA
   - Criptografia de senha mais robusta

2. **Funcionalidades**
   - Recuperação de senha
   - Perfil de usuário
   - Upload de avatar

3. **Interface**
   - Tema escuro
   - Animações
   - Mais feedback visual

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Contribuição

1. Faça um Fork do projeto
2. Crie sua Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## ✒️ Autores

* **Matheus ferreira** - *Desenvolvimento* - [SeuUsuario](https://github.com/SeuUsuario)


