## SGU - Sistema de Gerenciamento de Usuários [Back-end]

O SGU (Sistema de Gerenciamento de Usuários) é uma aplicação web desenvolvida com Angular no front-end, Java com Spring Boot no back-end e PostgreSQL como banco de dados. O principal objetivo deste sistema é fornecer funcionalidades básicas para o gerenciamento de perfis de administradores do sistema ou funcionários.

### Funcionalidades

- CRUD de usuários: O administrador pode realizar operações de criação, leitura, atualização e deleção de usuários.
- Autenticação e Autorização: O sistema oferece autenticação de usuários e autorização baseada em papéis para garantir que apenas administradores tenham acesso às operações de gerenciamento de usuários.

### Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL

### Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado o seguinte:

- Angular CLI
- Java Development Kit (JDK)
- PostgreSQL

### Front-end

O front-end deste projeto está disponível em [angular-sgu-frontend](https://github.com/GiselleBarbosa/angular-sgu-frontend/tree/main). Certifique-se de configurar e executar o frontend após de iniciar o back-end.

### Executando a Aplicação

1. Clone este repositório para o seu ambiente local.
2. Certifique-se de ter uma instância do PostgreSQL em execução com o esquema de banco de dados apropriado.
3. Navegue até o diretório do backend e execute a aplicação Spring Boot.
4. Para iniciar a aplicação, certifique-se de ter todas as dependências necessárias configuradas e execute o comando adequado para iniciar o servidor Spring Boot.

### Configuração do Banco de Dados

Se você ainda não configurou o PostgreSQL, pode utilizar o JSON Server como uma opção temporária. Navegue até o diretório `database` e execute o comando `json-server --watch db.json --port 3000` para iniciar o JSON Server. Isso iniciará um servidor de mock que simula o comportamento do banco de dados.

Certifique-se de migrar para o PostgreSQL assim que possível para garantir uma configuração adequada do banco de dados em produção.

### Swagger UI

A documentação da API pode ser visualizada através do Swagger UI. Acesse [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/) para explorar os endpoints e suas descrições.

### Visualização da Modelagem de Dados

Você pode visualizar uma prévia da modelagem de dados abaixo:

![Modelagem de Dados](https://raw.githubusercontent.com/GiselleBarbosa/angular-sgu-frontend/main/src/assets/docs/modelagem_inicial.png)

### Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, correções de bugs ou novas funcionalidades.

### Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).