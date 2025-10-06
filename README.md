# 💣 Campo Minado Console

Um jogo clássico de **Campo Minado** implementado em **Java** para rodar no **console**, com suporte a **cores ANSI** para melhorar a experiência no terminal.

Projeto desenvolvido como exercício prático durante o curso de **Java da Cod3r**.

---

## 🎯 Por que esse projeto?

- Praticar os fundamentos da **Programação Orientada a Objetos (POO)** em Java
- Trabalhar com **tratamento de exceções**, **listas**, **streams** e **recursão**
- Criar uma aplicação **interativa** no terminal
- Revisar conceitos de **organização de pacotes** em um projeto Java realista

## 📂 Organização do Projeto

A estrutura de diretórios segue uma separação clara entre **modelo**, **visão** e **exceções**:

```
campo-minado-java/
├── src/br/com/campominado/
│ ├── excecao/
│ │ ├── ExplosaoException.java
│ │ └── SairException.java
│ │
│ ├── modelo/
│ │ ├── Campo.java
│ │ └── Tabuleiro.java
│ │
│ └── visao/
│ ├── TabuleiroConsole.java
│ └── Aplicacao.java
│
├── test/br/com/campominado/modelo/
│ └── CampoTeste.java
│
├── .gitignore
├── README.md
```
- **modelo/** → Lógica do jogo (campo, tabuleiro, regras)
- **visao/** → Interface de interação no console
- **excecao/** → Exceções personalizadas usadas no fluxo do jogo
- **test/** → Testes unitários (JUnit)

---

## 🕹️ Como rodar o projeto no terminal

### 1. Clonar o repositório
```bash
git clone https://github.com/pitercoding/campo-minado-console.git
cd campo-minado-console
```
### 2. Compilar os arquivos .java
```bash
javac br/com/campominado/**/*.java
```
### 3. Executar o jogo
```bash
java br.com.campominado.visao.Aplicacao
```

## 🎨 Recursos do jogo

- Campo minado funcional rodando no console
- **Cores ANSI** para melhorar a visualização:
    - 🚩 Bandeiras em **amarelo**
    - 💣 Minas em **vermelho**
    - 🔢 Números com cores diferentes:
        - `1` → azul
        - `2` → verde
        - `3` → vermelho
        - ... e assim por diante
- Possibilidade de **abrir campos**, **marcar/desmarcar bandeiras** e **reiniciar a partida**
- Tratamento de explosão com **`ExplosaoException`**
- Digite `sair` a qualquer momento para encerrar o jogo (**`SairException`**)

## 🧪 Testes
O projeto contém testes unitários com JUnit em `CampoTeste.java`.

Para rodar os testes:
```bash
cd test
# Exemplo com JUnit 5:
java -jar junit-platform-console-standalone.jar -cp . --scan-classpath
```
## 📜 Licença
Este projeto é licenciado sob a **licença MIT**.

## ✨ Créditos
Projeto desenvolvido como prática durante o **Curso de Java da Cod3r**.
Adaptado e expandido para incluir cores no console e organização completa do projeto.
