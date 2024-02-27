# SGU - Sistema de Gerenciamento de Usuários [Back-end]

O SGU (Sistema de Gerenciamento de Usuários) é uma aplicação web desenvolvida com Angular no front-end, Java com Spring Boot no back-end e PostgreSQL como banco de dados. O principal objetivo deste sistema é fornecer funcionalidades básicas para o gerenciamento de perfis de administradores do sistema ou funcionários.

## Funcionalidades

- CRUD de usuários: O administrador pode realizar operações de criação, leitura, atualização e deleção de usuários.
- Autenticação e Autorização: O sistema oferece autenticação de usuários e autorização baseada em papéis para garantir que apenas administradores tenham acesso às operações de gerenciamento de usuários.

## Tecnologias Utilizadas

- Angular 16
- Java 17
- Spring Boot 3
- PostgreSQL

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado o seguinte:

- Angular CLI
- Java Development Kit (JDK)
- PostgreSQL

## Front-end

O front-end deste projeto está disponível em [angular-sgu-frontend](https://github.com/GiselleBarbosa/angular-sgu-frontend/tree/main). Certifique-se de configurar e executar o frontend após de iniciar o back-end.

## Executando a Aplicação

1. Clone este repositório para o seu ambiente local.
2. Navegue até o diretório do frontend e execute `npm install` para instalar as dependências.
3. Inicie o front-end com o comando `ng serve`.
4. Navegue até o diretório do backend e execute a aplicação Spring Boot.
5. Certifique-se de ter uma instância do PostgreSQL em execução com o esquema de banco de dados apropriado.

## Configuração do Banco de Dados

O esquema do banco de dados está disponível no diretório `database`. Inicialmente, você pode usar o JSON Server para simular o banco de dados enquanto o PostgreSQL não está disponível. Certifique-se de configurar corretamente o banco de dados antes de iniciar a aplicação.

### Utilizando JSON Server (opcional)

Se você ainda não configurou o PostgreSQL, pode utilizar o JSON Server como uma opção temporária. Navegue até o diretório `database` e execute o comando `json-server --watch db.json --port 3000` para iniciar o JSON Server. Isso iniciará um servidor de mock que simula o comportamento do banco de dados.

Certifique-se de migrar para o PostgreSQL assim que possível para garantir uma configuração adequada do banco de dados em produção.

## Visualização do Mapa do Site

Você pode visualizar o mapa do site abaixo:

![Mapa do Site](https://raw.githubusercontent.com/GiselleBarbosa/angular-sgu-frontend/main/src/assets/docs/mapa_site.png)

## Visualização da Modelagem de Dados

Você pode visualizar uma prévia da modelagem de dados abaixo:

![Modelagem de Dados](https://raw.githubusercontent.com/GiselleBarbosa/angular-sgu-frontend/main/src/assets/docs/modelagem_inicial.png)

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, correções de bugs ou novas funcionalidades.

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
