# 🧙‍♀️ O Tomo Mágico do Herói Desocupado (RPG em Terminal)

Projeto acadêmico desenvolvido em grupo durante o curso de Análise e Desenvolvimento de Sistemas. Trata-se de um RPG de texto rodando inteiramente no terminal, onde o jogador pode criar personagens, explorar masmorras, lutar contra monstros e gerenciar seu inventário.

## 🤝 Sobre o Projeto e Aprendizado em Equipe

Este projeto foi construído de forma colaborativa com colegas de diferentes níveis de conhecimento, incluindo desenvolvedores com anos de experiência no mercado. 

Como estudante nos semestres iniciais, minha principal vivência neste projeto foi a **leitura e compreensão de código avançado**, além do entendimento prático de como estruturar a lógica de um sistema completo. Acompanhar a construção desse RPG me ajudou a consolidar conceitos fundamentais, como:

* **CRUD na prática:** Entender a lógica de Criar, Ler, Atualizar e Deletar personagens armazenados em listas na memória (`ArrayList`).
* **Estruturas de Controle de Fluxo:** Compreender o uso de laços de repetição (`while`, `for`) para manter o jogo rodando e o sistema de combate funcionando turno a turno.
* **Tratamento de Exceções:** Ver na prática como evitar que o programa quebre quando o usuário digita um dado inesperado (uso de `try-catch`).
* **Trabalho em Equipe:** Acompanhar o fluxo de desenvolvimento de um software em grupo, respeitando a arquitetura pensada por desenvolvedores mais experientes.

## ⚙️ Funcionalidades do Jogo

* **Gerenciamento de Heróis:** Criação, edição, visualização e exclusão de personagens com diferentes classes (Assassino, Bárbaro, Paladino).
* **Sistema de Combate e Exploração:** Eventos aleatórios que podem resultar em ganho de ouro, descanso ou batalhas contra monstros e lobos.
* **Economia Básica:** Loja de itens para comprar melhorias de força e poções de vida.
* **Chefe Final:** Um desafio de "endgame" que exige que o jogador treine e se equipe antes de tentar a vitória.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java
* **Interface:** Terminal de Comando (CLI)

## 🎮 Como rodar o jogo na sua máquina

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado.
2. Clone este repositório ou baixe o arquivo `Rpg.java`.
3. Abra o terminal na pasta onde o arquivo está e compile o código:
   ```bash
   javac Rpg.java
