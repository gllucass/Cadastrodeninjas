# Cadastro de Ninjas - Universo de Naruto

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellowgreen)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)

## 📖 Sobre o Projeto

**Cadastro de Ninjas** é uma aplicação Full-Stack desenvolvida em Java com Spring Boot que simula um sistema de registro para uma aldeia ninja. O projeto permite o gerenciamento completo (CRUD) de Ninjas e das Missões que podem ser atribuídas a eles.

A aplicação foi construída com uma arquitetura robusta e organizada, separando as responsabilidades em duas interfaces principais:
1.  Uma **Interface Web (UI)** renderizada no servidor com **Thymeleaf**, para gerenciamento visual e amigável.
2.  Uma **API REST** documentada com **Swagger/OpenAPI**, permitindo a integração com outros sistemas.

---

## ✨ Funcionalidades

### Gerenciamento de Ninjas
- **CRUD Completo:** Crie, liste, atualize e exclua ninjas.
- **Listagem Paginada:** Visualização de todos os ninjas em uma tabela clara e organizada.
- **Atribuição de Missões:** Associe uma missão existente a um ninja no momento da criação ou edição através de um menu de seleção.
- **Detalhes Rápidos:** Visualize os detalhes completos de um ninja, incluindo sua missão, através de um modal sem sair da página.

### Gerenciamento de Missões
- **CRUD Completo:** Crie, liste, atualize e exclua missões.
- **Validação de Exclusão:** Sistema inteligente na interface que impede a exclusão de uma missão caso ela esteja atribuída a um ou mais ninjas, exibindo um alerta informativo.
- **Navegação Integrada:** Links de navegação que permitem alternar facilmente entre o gerenciamento de ninjas e missões.

---

## 🛠️ Arquitetura e Tecnologias Utilizadas

O projeto segue os princípios de uma arquitetura em camadas (Layered Architecture) para garantir a separação de responsabilidades, manutenibilidade e escalabilidade.

- **`Controller / ControllerUI`**: Camada responsável por receber as requisições HTTP, tanto para a API REST quanto para a interface web.
- **`Service`**: Onde reside a lógica de negócio da aplicação.
- **`Repository`**: Camada de acesso a dados, utilizando Spring Data JPA para abstrair as operações com o banco.
- **`Model (Entity)`**: Representação das tabelas do banco de dados como objetos Java (JPA Entities).
- **`DTO (Data Transfer Object)`**: Objetos que carregam os dados entre as camadas, evitando a exposição das entidades.
- **`Mapper`**: Conversores para mapear DTOs para Entidades e vice-versa.
- **`Converter`**: Componente customizado do Spring para converter automaticamente o ID de uma missão vindo do formulário para o objeto `MissoesModel` completo.

**Principais Tecnologias:**
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA & Hibernate**: Persistência de dados e ORM.
- **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
- **Thymeleaf**: Template engine para a renderização da interface web no servidor.
- **SpringDoc OpenAPI (Swagger)**: Documentação automática e interativa da API REST.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Lombok**: Para reduzir código boilerplate em models e DTOs.
- **Bootstrap 5 & Font Awesome**: Para estilização e ícones na interface web.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **JDK 17** ou superior.
- **Apache Maven** 3.8 ou superior.

### Passos para Execução
1.  Clone o repositório:
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    ```
2.  Navegue até o diretório raiz do projeto:
    ```bash
    cd CadastroDeNinjas
    ```
3.  Execute o projeto com o Maven:
    ```bash
    mvn spring-boot:run
    ```
A aplicação estará rodando em `http://localhost:8080`.

---

## 🔗 Acessando a Aplicação

- **Interface Web - Gerenciar Ninjas:**
    - `http://localhost:8080/ninjas/ui/listar`

- **Interface Web - Gerenciar Missões:**
    - `http://localhost:8080/missoes/ui/listar`

- **Documentação da API (Swagger UI):**
    - `http://localhost:8080/swagger-ui.html`

---

## 📚 Endpoints da API REST

### Ninjas (`/ninjas`)
| Método | Endpoint                | Descrição                                 |
|--------|-------------------------|-------------------------------------------|
| `GET`  | `/listar`               | Retorna uma lista de todos os ninjas.       |
| `GET`  | `/listar/{id}`          | Busca um ninja específico pelo seu ID.      |
| `POST` | `/criar`                | Cria um novo ninja no sistema.            |
| `PUT`  | `/alterar/{id}`         | Atualiza os dados de um ninja existente.  |
| `DELETE`| `/deletar/{id}`         | Exclui um ninja pelo seu ID.                |

### Missões (`/missoes`)
| Método | Endpoint                | Descrição                               |
|--------|-------------------------|-------------------------------------------|
| `GET`  | `/listar`               | Retorna uma lista de todas as missões.    |
| `GET`  | `/listar/{id}`          | Busca uma missão específica pelo seu ID.   |
| `POST` | `/criar`                | Cria uma nova missão no sistema.          |
| `PUT`  | `/alterar/{id}`         | Atualiza os dados de uma missão existente.|
| `DELETE`| `/deletar/{id}`         | Exclui uma missão pelo seu ID.            |

---


## 👨‍💻 Autor

Feito por **Geraldo Lucas**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)]([https://www.linkedin.com/in/geraldo-lucas])
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)]([https://github.com/gllucass])