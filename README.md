# Cinema API

## 🎯 Objetivo
Implementar uma api **REST** capaz de simular o que acontece em um cinema, onde:
- Temos a lista de filmes;
- Sessões de cada filme, indicando `sala`, `filme` e `data/horário`.

## 💡 Funcionalidades
### Filmes
- Inserir um novo filme -> método `addMovie`
- Obter a lista de filmes -> método `getAllMovies`
- Atualizar as informações de um filme -> método `updateMovie`
- Remover um filme da lista -> método `deleteMovie`

### Sessões
- Registrar uma nova sessão de filme -> método `addSession`
- Obter todas as sessões disponíveis -> método `getAllSessions`
- Atualizar as informações de uma sessão -> método `updateSession`
- Remover uma sessão de filme -> método -> `deleteSession`


## 🧩 Implementação do CRUD
Com as funcionalidades já descritas, podemos perceber a implementação do CRUD, com as quatro operações
básicas em um sistema de interação com banco de dados:
- **C**: CREATE
- **R**: READ
- **U**: UPDATE
- **D**: DELETE

## 💻 Tecnologias Utilizadas
- ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg??style=for-the-badge&logo=openjdk&logoColor=white) (JDK 17+)
- Framework ![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white)
- `Maven` para gerenciamento de dependências
