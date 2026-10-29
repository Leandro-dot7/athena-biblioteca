# Guia de contribuição — Athena Biblioteca

Repositório do projeto: <https://github.com/Leandro-dot7/athena-biblioteca>

O grupo terá quatro commits, um por aluno, na branch `feature/cadastro-livro`. As contribuições serão feitas em sequência nessa branch para evitar que duas pessoas alterem os mesmos arquivos ao mesmo tempo. Depois que os quatro commits estiverem publicados, o grupo abrirá um único Pull Request para `main`, com revisão do professor Clênio Silva (`cleniosilva`).

## Divisão das tarefas

1. **Leandro (`Leandro-dot7`) — commit inicial:** publicar a estrutura já criada, incluindo `Livro`, `LivroRepository`, a classe principal e os arquivos Gradle.
2. **Isadora (`Doradrigues`) — serviço:** criar `LivroService` e implementar as regras de validação do cadastro, seguindo a issue #1.
3. **Gabrielle (`Gabrielle-Corteze`) — controlador:** criar `LivroController` para receber as operações de cadastro e busca e chamar o serviço.
4. **Northon (`NorthonCoelho`) — testes:** criar testes para cadastro válido, dados inválidos e consulta do livro cadastrado.

**Clênio é o revisor do Pull Request**, não um dos quatro autores dos commits dos alunos. Cada aluno deve usar sua própria conta GitHub e configurar sua identidade Git antes de commitar.

## Observações sobre a issue #1

O backlog exige quantidade de exemplares igual ou maior que 1, validação dos campos obrigatórios e disponibilidade do livro na busca após o cadastro. Porém, a issue não especifica quais campos são obrigatórios. O modelo atual possui título, autor e quantidade; título e autor são uma sugestão inicial, não uma regra confirmada. A exigência de desabilitar um botão também pressupõe uma interface visual, que ainda não aparece no projeto atual. Confirmem esses pontos com o professor antes de tratá-los como requisitos fechados.

## Primeiro commit — Leandro, no IntelliJ

A pasta atual contém o projeto Java, mas não tinha controle Git local. O repositório remoto já foi criado com a branch `main` e um README. Para ligar a pasta existente ao repositório:

1. Abra `C:\Users\LeoFurlanetto\Desktop\athena-biblioteca` no IntelliJ.
2. Abra a aba **Terminal** do IntelliJ e configure seu nome e e-mail de commit (use o e-mail associado à sua conta GitHub):

   ```bash
   git config --global user.name "Leandro Romano"
   git config --global user.email "seu-email-do-github"
   ```

3. Inicialize o Git e conecte o remoto:

   ```bash
   git init
   git remote add origin https://github.com/Leandro-dot7/athena-biblioteca.git
   git fetch origin
   git switch -c feature/cadastro-livro --track origin/main
   ```

4. No IntelliJ, confira os arquivos alterados. Inclua os arquivos do projeto, o guia e os documentos de planejamento combinados. Não inclua `.idea/`, `.gradle/`, `build/` nem `athena-biblioteca.iml`.
5. Abra **Git → Commit** (atalho `Ctrl+K`), selecione os arquivos e use a mensagem `feat: inicia base do cadastro de livros`.
6. Faça o commit e depois **Git → Push** (atalho `Ctrl+Shift+K`). Na primeira publicação, confirme o envio da branch `feature/cadastro-livro`.

Se o comando `git init` já tiver sido executado, não o repita sem conferir a pasta `.git`. Se o remoto `origin` já existir, confira o endereço com `git remote -v` antes de adicioná-lo novamente.

## Demais commits — IntelliJ

Cada integrante deve aguardar a pessoa anterior publicar seu commit e, então:

1. Entrar no repositório `athena-biblioteca` com a própria conta GitHub. Se ainda não tiver acesso, aceitar o convite do repositório.
2. Clonar o repositório no IntelliJ: **File → New → Project from Version Control**, colar o endereço acima e escolher **Clone**.
3. Atualizar as referências com **Git → Fetch**. No seletor de branches, escolher `origin/feature/cadastro-livro` e fazer checkout para criar a branch local `feature/cadastro-livro`.
4. Configurar a identidade Git da própria conta no terminal do IntelliJ, se ainda não estiver configurada:

   ```bash
   git config --global user.name "Seu Nome"
   git config --global user.email "seu-email-do-github"
   ```

5. Fazer somente a tarefa atribuída. Abrir **Git → Commit** (`Ctrl+K`), revisar os arquivos selecionados e escrever uma mensagem objetiva, por exemplo:
   - Isadora: `feat: adiciona validacao do cadastro de livros`
   - Gabrielle: `feat: adiciona controlador de livros`
   - Northon: `test: adiciona testes do cadastro de livros`
6. Fazer o commit e publicar com **Git → Push** (`Ctrl+Shift+K`). Avisar o próximo integrante que a branch está atualizada.

Trabalhem um por vez nessa branch compartilhada. Antes de começar, façam **Git → Pull** para receber o commit anterior. Se houver conflito, parem e combinem a resolução antes de continuar.

## Pull Request

Depois de confirmar que os quatro commits dos alunos estão em `feature/cadastro-livro`:

1. No GitHub, abram um Pull Request comparando `feature/cadastro-livro` com `main`.
2. Descrevam o que foi feito e peçam revisão de **Clênio Silva (`cleniosilva`)**.
3. Só usem `Closes #1` na descrição se todos os critérios de aceitação da issue estiverem atendidos.

Não abram o Pull Request antes de os quatro commits estarem publicados.
