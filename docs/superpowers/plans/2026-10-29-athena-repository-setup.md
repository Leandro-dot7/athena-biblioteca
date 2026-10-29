# Athena Repository and Backlog Setup Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans (the user authorized hands-on execution). Track steps with checkboxes.

**Goal:** Create a separate public GitHub repository for Athena, correct its backlog links, and prepare the current Java project for the first student commit.

**Architecture:** Keep `Leandro-dot7/sac-pos-venda-n8n` unchanged. Create `Leandro-dot7/athena-biblioteca` with a `main` README, recreate the Athena issues in that repository, attach them to the existing Athena Project, and push the local Java project on `feature/cadastro-livro`.

**Tech Stack:** GitHub, IntelliJ IDEA, Java 21, Spring Boot 4.1.2, Gradle, Git.

**Spec:** `docs/superpowers/specs/2026-10-29-athena-repository-design.md`

## Global Constraints

- New repository visibility: public.
- Keep all content and issues in `Leandro-dot7/sac-pos-venda-n8n` unchanged.
- Recreate the eight Athena issues as planning records; do not implement issues #2–#8 in this turn.
- Do not delete old issues; only remove their cards from the Athena Project.
- Grant Write access to `cleniosilva`, `Doradrigues`, `Gabrielle-Corteze`, and `NorthonCoelho`.
- The student code branch is `feature/cadastro-livro`; target is `main`.
- Keep the initial project commit authored by `Leandro-dot7` and do not open the PR until the other three student commits are present.
- Exclude `.idea/`, `.gradle/`, `build/`, and `*.iml` from the project commit.
- Do not run tests or builds for this repository-setup task.

## Review Focus

- Source isolation: confirm no write occurs in the WhatsApp repository (Task 1–3).
- Backlog fidelity: check each recreated issue title/body against its original issue URL (Task 2).
- Board correctness: check the Athena Project contains the new-repository cards and no old-repository cards (Task 3).
- Git scope: inspect staged paths and ensure IDE/build output is excluded (Task 4).
- Attribution: verify the new commit author resolves to `Leandro-dot7` (Task 4).

---

### Task 1: Create the Athena repository and collaborator access

**Files:**
- GitHub repository: `Leandro-dot7/athena-biblioteca`
- GitHub default branch: `main`

**Interfaces:**
- Consumes: GitHub account `Leandro-dot7`; collaborator logins from the approved design.
- Produces: public repository URL, `main` branch with README, and collaborator access for the four listed accounts.

- [ ] Create the public repository `athena-biblioteca` under `Leandro-dot7`, initializing `main` with `README.md`.
- [ ] Grant Write access to `cleniosilva`, `Doradrigues`, `Gabrielle-Corteze`, and `NorthonCoelho`.
- [ ] Verify the repository is public, `main` exists, and each collaborator has the intended role or a pending invitation.

### Task 2: Recreate the Athena backlog issues

**Files:**
- GitHub issues in `Leandro-dot7/athena-biblioteca`.

**Interfaces:**
- Consumes: original issues `Leandro-dot7/sac-pos-venda-n8n#1` through `#8`.
- Produces: eight new issues with matching titles and bodies in the Athena repository.

- [ ] Create each new issue using the exact title and body from its corresponding original issue (#1–#8).
- [ ] Verify the new issue count, titles, and bodies against the originals; do not modify or close the originals.

### Task 3: Correct the Athena Project board

**Files:**
- GitHub Project: `Leandro-dot7` project `Athena`, Backlog view.

**Interfaces:**
- Consumes: the eight new issue URLs from Task 2.
- Produces: Athena board cards linked to `Leandro-dot7/athena-biblioteca`.

- [ ] Add the eight new Athena-repository issues to the existing Athena Project.
- [ ] Remove the eight old SAC-repository cards from that Project only.
- [ ] Verify every Backlog card links to `Leandro-dot7/athena-biblioteca` and the SAC issues still exist unchanged.

### Task 4: Connect the IntelliJ project and make the initial student commit

**Files:**
- Existing project root: `C:\Users\LeoFurlanetto\Desktop\athena-biblioteca`
- Include: `.gitattributes`, `.gitignore`, `build.gradle`, Gradle Wrapper files, `settings.gradle`, `HELP.md`, `src/`, `GUIA_CONTRIBUICOES_ATHENA.md`, and the design/plan documents.
- Exclude: `.idea/`, `.gradle/`, `build/`, `athena-biblioteca.iml`.

**Interfaces:**
- Consumes: repository `main` from Task 1.
- Produces: branch `feature/cadastro-livro` containing the initial Java project state, pushed under Leandro's GitHub identity.

- [ ] Update `GUIA_CONTRIBUICOES_ATHENA.md` to name the new public repository and remove the temporary warning that its URL is unknown.
- [ ] In the existing project root, initialize Git, fetch the new remote `main`, and create `feature/cadastro-livro` from `origin/main`.
- [ ] Stage only the included source, Gradle, and guide/design files; inspect staged paths before committing.
- [ ] Commit as `Leandro-dot7` with message `feat: inicia base do cadastro de livros`.
- [ ] Push `feature/cadastro-livro` and verify the remote branch, commit author, and clean working tree.

### Task 5: Handoff the remaining student contributions

**Files:**
- `GUIA_CONTRIBUICOES_ATHENA.md`

- [ ] Leave the PR unopened until Isadora, Gabrielle, and Northon each add their assigned commit to `feature/cadastro-livro`.
- [ ] The team opens one PR to `main` and requests review from Clênio after all four student commits are present.
