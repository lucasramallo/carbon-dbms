<div align="center">
  <img width="1251" alt="Splash Screen" src="https://github.com/lucasramallo/carbon-dbms/assets/108425719/fbb033a4-3603-4e03-bfc0-8210b23543cb">
</div>

## 

CarbonDB é uma simulação de um Sistema de Gerenciamento de Banco de Dados (SGBD), implementado em Java. O objetivo é criar uma estrutura de dados capaz de armazenar e manipular dados, proporcionando um ambiente simulado para testes e experimentação de conceitos de banco de dados.

<br/>

![Capturar](https://github.com/lucasramallo/carbon-dbms/assets/108425719/39c24836-ade3-435f-8ca9-d913714f0b9d)

### Implementações

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [ ] Storage Engine (Em desenvolvimento)
- [ ] SQL Query parser and executor
- [ ] Write data

### Anotações
Cada tabela e índice no PostgreSQL é composto por um array de páginas. Uma página é uma estrutura de dados que existe para armazenar registros de tabelas ou ponteiros de índice. Uma página de banco de dados no PostgreSQL geralmente tem 8 KB, mas isso pode ser alterado durante a compilação do servidor. Como uma tabela não é ordenada no PostgreSQL, quando uma linha deve ser inserida em uma tabela, a linha é inserida na primeira página capaz de conter a linha. Para fazer isso, o PostgreSQL monitora o quão cheia está cada página de dados por meio de uma estrutura de dados conhecida como Mapa de Espaço Livre (FSM). A estrutura de dados FSM aloca um byte por página com a finalidade de esse byte acompanhar o quão cheia a página está. Caso não existam páginas na tabela com espaço livre suficiente para armazenar um registro de dados, uma nova página é alocada na tabela para armazená-lo.

