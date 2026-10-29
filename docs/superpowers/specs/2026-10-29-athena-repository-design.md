# Athena Repository Setup — Design

## Intent and goals
Create a separate public GitHub repository for the Java library project, correct the Athena Backlog so its eight cards point to issues in that repository, and prepare the current Java code for the first student commit. The WhatsApp automation repository remains untouched.

## Chosen approach
Create `Leandro-dot7/athena-biblioteca` as a public repository, seed `main` with a README, and create the eight Athena issues there from the existing issue descriptions. Add the new issues to the existing Athena Project board and remove the old issue cards from that board only. Preserve the original issues and all files in `Leandro-dot7/sac-pos-venda-n8n`.

## Contribution workflow
Connect the local IntelliJ project to the new repository, create `feature/cadastro-livro` from `main`, and commit the current Java/Gradle project as Leandro (`Leandro-dot7`). Grant Write access to the listed collaborators. The four students add one commit each to the feature branch; after those commits, the team opens one PR to `main` for Clênio to review.

## Scope and constraints
- The current local folder is `C:\Users\LeoFurlanetto\Desktop\athena-biblioteca` and has no `.git` directory.
- The GitHub account connected to this session is `Leandro-dot7`.
- The eight backlog issues are copied as planning records only; stories #2–#8 are not implemented in this cycle.
- Do not delete, close, or edit any issue or file in the WhatsApp project.
- Do not stage generated `.idea/`, `.gradle/`, `build/`, or `.iml` files.
- Do not open or merge the class PR until the team has made its four commits.

## Alternatives considered
- Keep the current board cards pointing to the WhatsApp repository: fewer changes, but the Athena backlog stays linked to the wrong project.
- Create the Java repository and recreate the Athena issue records there: this changes issue numbers/history, but keeps the two projects separated and fixes the board links. This is the approved approach.
