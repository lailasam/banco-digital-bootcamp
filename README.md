## Bootcamp Santander DIO

Projeto sugerido no bootcamp de Java do Santander DIO.

## Banco digital

Descrição do projeto:

Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).

M# Requisitos do Projeto: Banco Digital em Java

Este documento descreve os requisitos funcionais e não funcionais para a construção de um pequeno projeto de banco digital em Java, com o objetivo de simular operações bancárias básicas.

## 📋 Requisitos Funcionais (RF)

Os requisitos funcionais definem o que o sistema deve fazer.

### Gerenciamento de Contas
* **RF1:** O sistema deve permitir a criação de contas de dois tipos: **Conta Corrente** e **Conta Poupança**.
* **RF2:** Cada conta deve ser associada a um **Cliente**.
* **RF3:** Ao criar uma conta, o sistema deve gerar automaticamente um **número de agência** e **número de conta** únicos.
* **RF4:** O sistema deve permitir a consulta de saldo de uma conta específica.

### Operações Bancárias
* **RF5:** O sistema deve permitir o **depósito** de um valor em uma conta.
* **RF6:** O sistema deve permitir o **saque** de um valor de uma conta, validando se há saldo suficiente.
    * **RF6.1:** Caso não haja saldo, uma mensagem de erro deve ser exibida.
* **RF7:** O sistema deve permitir a **transferência** de um valor entre contas, validando o saldo da conta de origem.
* **RF8:** O sistema deve permitir que o **saldo** da conta poupança aumente conforme uma taxa e tempo determinados.
* **RF9:** O sistema deve registrar e exibir o **extrato** de cada conta, listando todas as transações (depósitos, saques, transferências).

### Gerenciamento de Clientes
* **RF10:** O sistema deve permitir o cadastro de um **Cliente**, contendo atributos como nome e CPF.
* **RF11:** O sistema deve garantir que o CPF do cliente seja único.

---

## ⚙️ Requisitos Não Funcionais (RNF)

Os requisitos não funcionais descrevem como o sistema deve funcionar, focando em atributos de qualidade.

### Qualidade do Código
* **RNF1:** O código deve ser implementado seguindo os princípios da **Programação Orientada a Objetos (POO)**: Encapsulamento, Herança e Polimorfismo.
* **RNF2:** O projeto deve ser organizado em pacotes lógicos (ex: `modelo`, `servico`, `main`).
* **RNF3:** O código deve ser legível e utilizar comentários onde a lógica for complexa.
* **RNF4:** O sistema deve utilizar **tratamento de exceções** (como `try-catch`) para lidar com erros, como saldo insuficiente ou valores inválidos.

### Tecnologia e Ambiente
* **RNF5:** A aplicação deve ser desenvolvida em **Java** (versão 8 ou superior).
* **RNF6:** A interface do usuário deve ser via **linha de comando (console)**.
* **RNF7 (Opcional):** O sistema deve utilizar um **sistema de persistência de dados** simples (listas em memória).

### Usabilidade e Experiência do Usuário (UX)
* **RNF8:** A aplicação deve apresentar um menu claro de opções para a interação do usuário.
* **RNF9:** O sistema deve exibir mensagens claras e informativas ao usuário após cada operação, seja de sucesso ou de falha.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
