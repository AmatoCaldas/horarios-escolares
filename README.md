# 🏫 Gerador de Horários Escolares - Spring Boot Web

Este projeto é um sistema web desenvolvido em **Java com Spring Boot** para **gerar automaticamente os horários de aulas de uma escola**, com base na disponibilidade de professores e na necessidade de cada turma.

A aplicação não utiliza banco de dados persistente por padrão, mas conta com um repositório em memória para simular o armazenamento durante a sessão. Ideal para testes, prototipação ou implantação em pequenos ambientes escolares.

---

## 🚀 Funcionalidades

- ✏️ Cadastro de professores com:
  - Nome
  - Matéria lecionada
  - Disponibilidade semanal (ex: `Segunda-08:00`)
  - Número máximo de aulas

- 📘 Cadastro de turmas com:
  - Nome da turma
  - Número de aulas semanais

- ⚙️ Geração automática de horários com:
  - Distribuição das aulas considerando a disponibilidade dos professores
  - Priorização de blocos de aulas seguidas
  - Respeito ao limite de aulas por professor

- 📊 Visualização dos horários por turma em uma tabela organizada com **Bootstrap 5**

---

## 💡 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3
  - Spring MVC
  - Spring Thymeleaf
- Bootstrap 5
- HTML5 + CSS3
- Repositório em memória (sem banco de dados fixo)

---

## 📂 Estrutura do Projeto

