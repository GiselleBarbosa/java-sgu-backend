## SGU - Sistema de Gerenciamento de Usuários [Back-end]

O SGU (Sistema de Gerenciamento de Usuários) é uma aplicação web desenvolvida com Angular no front-end, Java com Spring Boot no back-end e PostgreSQL como banco de dados. O principal objetivo deste sistema é fornecer funcionalidades básicas para o gerenciamento de perfis de administradores do sistema ou funcionários.

### Funcionalidades

- CRUD de usuários: O administrador pode realizar operações de criação, leitura, atualização e deleção de usuários.
- Autenticação e Autorização: O sistema oferece autenticação de usuários e autorização baseada em papéis para garantir que apenas administradores tenham acesso às operações de gerenciamento de usuários.

### Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL
- Docker
- Swagger

### Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado o seguinte:

- Docker
- Docker Compose
- Maven

### Executando a Aplicação

1. Clone este repositório para o seu ambiente local.
2. Navegue até o diretório raiz do projeto.
3. Execute o comando `mvn clean package` para gerar o arquivo JAR da aplicação.
4. Execute o comando `docker-compose up` para iniciar a aplicação. Isso irá iniciar tanto o back-end quanto o banco de dados PostgreSQL em contêineres Docker.

### Swagger UI

A documentação da API pode ser visualizada através do Swagger UI. Acesse [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/) para explorar os endpoints e suas descrições.

### Visualização da Modelagem de Dados

Você pode visualizar uma prévia da modelagem de dados abaixo:

![Modelagem de Dados](https://raw.githubusercontent.com/GiselleBarbosa/angular-sgu-frontend/main/src/assets/docs/modelagem_inicial.png)

### Front-end

O front-end deste projeto está disponível em [angular-sgu-frontend](https://github.com/GiselleBarbosa/angular-sgu-frontend/tree/main). Certifique-se de configurar e executar o frontend após de iniciar o back-end.

### Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, correções de bugs ou novas funcionalidades.

### Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
