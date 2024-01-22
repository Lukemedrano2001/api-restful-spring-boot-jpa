# API RESTful Spring Boot JPA (Java Persistence API)

Este projeto é uma API RESTful desenvolvida em Spring Boot em conjunto com o JPA para gerenciar informações de funcionários.


## Paradigmas utilizados: Orientação a objeto


## RESTful e Status HTTP

### REST (Representational State Transfer):
- `O que é?` É um estilo de arquitetura para projetar serviços na web.
- `Como funciona?` Usa padrões HTTP para criar, ler, atualizar e excluir (CRUD) recursos.
- `Recursos?` São as coisas que você deseja manipular (ex: dados de funcionários).
- `Stateless?` Cada requisição é independente, sem memória do estado anterior.


### RESTful:
- `O que é?` É a aplicação dos princípios REST na construção de serviços.
- `Como funciona?` Usa URLs para identificar recursos e métodos HTTP para operações (GET para obter, POST para criar, etc.).
- `Exemplo?` Se a URL é "/funcionarios" e você faz um GET, deveria obter dados dos funcionários.


Alguns status HTTP abordados:
- **200 OK:** Requisição bem-sucedida.
- **201 Created:** Recurso criado com sucesso.
- **404 Not Found:** Recurso não encontrado.
- **400 Bad Request:** Requisição inválida.
- **500 Internal Server Error:** Erro interno do servidor.


## Tecnologias Utilizadas
| Tecnologia           | Descrição  |
|----------------------|------------|
| Spring Boot          | Framework para criação de aplicativos Java baseados em Spring. Facilita o desenvolvimento, produção e manutenção. |
| Spring Data JPA       | Parte do projeto Spring Data, fornece suporte para persistência de dados em aplicativos Java usando JPA. |
| Spring Web            | Módulo Spring para criar aplicativos web. Suporta o desenvolvimento de aplicativos web RESTful. |
| Spring Boot DevTools  | Fornece ferramentas de desenvolvimento adicionais para melhorar a experiência de desenvolvimento com o Spring Boot. |
| Spring Boot Validation| Fornece suporte para validação de dados no Spring Boot. |
| Flyway               | Ferramenta de controle de versão de banco de dados. Suporta evolução de banco de dados usando migrações. |
| PostgreSQL           | Banco de dados relacional de código aberto, conhecido por sua confiabilidade e desempenho. |
| Spring Boot Starter Test | Oferece suporte a testes no ambiente Spring Boot. |


## Estrutura do Projeto
  - **`DDD`**: O projeto segue alguns conceitos do Domain-Driven Design para estruturar o projeto, tais como: Domain, Entidades, Repository, Services.
  - **`src/main/java`**: Contém o código-fonte Java.
  - **`controllers`**: Controladores REST.
  - **`dominio.dto`**: DTOs para transferência de dados.
  - **`dominio.entitidades`**: Entidades do domínio.
  - **`dominio.repositorios`**: Repositórios JPA.
  - **`exceptions`**: Tratamento de exceções globais.
  - **`services.interfaces`**: Interfaces de serviços.
  - **`services.implementacoes`**: Implementações de serviços.
  - **`src/main/resources`**: Contém os recursos, como arquivos de propriedades e scripts SQL.


## Princípios SOLID

O projeto segue os princípios SOLID da seguinte maneira:

- **S (Princípio da Responsabilidade Única):**
  - As classes têm responsabilidades únicas e bem definidas, como controllers, serviços, entidades, interfaces, repositórios, exceptions.

- **O (Princípio Aberto/Fechado):**
  - O código é aberto para extensão, fechado para modificação, seguindo a arquitetura Spring Boot.

- **L (Princípio da Substituição de Liskov):**
  - Este princípio não é diretamente aplicável a classes concretas.

- **I (Princípio da Segregação de Interface):**
  - As interfaces são coesas e específicas para suas operações, como `ICreateFuncionarioService`, `IReadFuncionariosService`, etc.

- **D (Princípio da Inversão de Dependência):**
  - As classes dependem de abstrações (interfaces), promovendo a inversão de dependência.


## Configurações do Banco de Dados
- spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
- spring.datasource.username=seu_usuario
- spring.datasource.password=sua_senha


## Outras Configurações
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
- spring.jpa.properties.hibernate.id.new_generator_mappings=false

- spring.jackson.date-format=yyyy/MM/dd
- spring.jackson.time-zone=America/Sao_Paulo

- spring.flyway.baseline-on-migrate=true


## License
Este projeto está licenciado sob a Licença MIT.
