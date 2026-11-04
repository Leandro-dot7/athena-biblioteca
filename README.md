# Athena Biblioteca

Projeto da disciplina de Engenharia de Software para o cadastro de livros de uma biblioteca. A aplicação é uma API em Java com Spring Boot.

## Arquitetura em camadas

```text
Cliente (requisição HTTP)
          |
          v
LivroController
          |
          v
LivroService
          |
          v
LivroRepository
          |
          v
Lista de livros em memória
```

- **Model:** `Livro` representa os dados de um livro: título, autor e quantidade.
- **Controller:** `LivroController` recebe as requisições HTTP e devolve as respostas.
- **Service:** `LivroService` valida os dados e coordena o cadastro e a busca.
- **Repository:** `LivroRepository` armazena os livros e realiza a busca por título.

A separação em camadas mantém cada parte com uma responsabilidade, facilitando a manutenção e os testes.

## Funcionalidades

- `POST /livros`: cadastra um livro com título, autor e quantidade maior ou igual a 1.
- `GET /livros?titulo=Hobbit`: busca livros pelo título, sem diferenciar letras maiúsculas e minúsculas.

Exemplo de dados para cadastro:

```json
{
  "titulo": "O Hobbit",
  "autor": "J. R. R. Tolkien",
  "quantidade": 3
}
```

Os livros são guardados em memória e são perdidos ao reiniciar a aplicação. O projeto ainda não possui interface visual.

## Como executar

É necessário ter o **Java 21** instalado. No terminal do IntelliJ, na pasta do projeto, execute:

```powershell
.\gradlew.bat bootRun
```

Para executar os testes no Windows:

```powershell
.\gradlew.bat test
```
