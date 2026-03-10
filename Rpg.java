import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rpg {

    // Função para o Menu Principal
    private static void exibirMenu() {
        String linhaSuperior = "✨===================================✨";
        String linhaInferior = "---------------------------------------";

        System.out.println("\n" + linhaSuperior);
        System.out.println("🧙‍♀️ O TOMO MÁGICO DO HERÓI DESOCUPADO 🏹");
        System.out.println(linhaInferior);

        System.out.printf(" %-3s | %-15s | %s\n", "ID", "AÇÃO", "DESCRIÇÃO (O que diabos você fará?)");
        System.out.println(linhaInferior);

        System.out.printf(" %-3s | %-15s | %s\n", "1", " CRIAÇÃO", "Invoque um herói do Vazio (ou do teclado).");
        System.out.printf(" %-3s | %-15s | %s\n", "2", " VISUALIZAR", "Checar se o herói ainda existe. (Lista de espera)");
        System.out.printf(" %-3s | %-15s | %s\n", "3", " MODIFICAR", "Dar um 'upgrade' ou mudar o nome de novo.");
        System.out.printf(" %-3s | %-15s | %s\n", "4", " EXCLUIR", "Apagar permanentemente (Sem Ctrl+Z, cuidado!).");
        System.out.printf(" %-3s | %-15s | %s\n", "5", " JOGAR!", "Finalmente! Mandar o coitado para a masmorra.");
        System.out.printf(" %-3s | %-15s | %s\n", "6", " SAIR", "Fugir para a vida real (até a próxima).");

        System.out.println(linhaInferior);
        System.out.print("🔮 Digite a sua escolha, ó Mestre (1-6): ");
    }

    private static void exibirMenuAcoes() {
        String linhaSuperior = "⚔️===================================🛡️";
        String linhaInferior = "---------------------------------------";

        System.out.println("\n" + linhaSuperior);
        System.out.println("⚔️ A TÁVOLA DE AÇÕES DO AVENTUREIRO 🗺️");
        System.out.println(linhaInferior);

        System.out.printf(" %-3s | %-15s | %s\n", "ID", "AÇÃO", "OBJETIVO (O que você fará?)");
        System.out.println(linhaInferior);

        System.out.printf(" %-3s | %-15s | %s\n", "1", " TREINAR", "Aumente seus atributos em combate (XP garantido).");
        System.out.printf(" %-3s | %-15s | %s\n", "2", " EXPLORAR", "Aventure-se em busca de itens e ouro (risco de morte!).");
        System.out.printf(" %-3s | %-15s | %s\n", "3", " DESCANSAR", "Recupere energia perdida (e salve o progresso).");
        System.out.printf(" %-3s | %-15s | %s\n", "4", " VER STATUS", "Cheque seu equipamento, níveis e estatísticas atuais.");
        System.out.printf(" %-3s | %-15s | %s\n", "5", " ENFRENTAR BOSS", "O teste final de poder! (Prepare-se para o fim).");
        System.out.printf(" %-3s | %-15s | %s\n", "6", " LOJA", "Compre espadas e poções para fortalecer sua jornada.");

        System.out.println(linhaInferior);
        System.out.print("🛡️ Escolha sua ação, bravo herói (1-6): ");
    }


    // --- CLASSE PERSONAGEM ---
    static class Personagem {
        String nome, classe;
        int vida, forca, velocidade, id;

        Personagem(int id, String nome, String classe, int vida, int forca, int velocidade) {
            this.id = id;
            this.nome = nome;
            this.classe = classe;
            this.vida = vida;
            this.forca = forca;
            this.velocidade = velocidade;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Nome: " + nome + " | Classe: " + classe + " (Vida: " + vida + " | Força: " + forca + " | Velocidade: " + velocidade + ")";
        }
    }

    // --- MÉTODO MAIN ---
    public static void main(String[] args) {
        boolean terminar = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personagem> personagens = new ArrayList<>();
        int proximoId = 1;

        while (!terminar) {

            exibirMenu();

            String escolha = scanner.nextLine().trim();

            // === CRIAR PERSONAGEM ===
            if (escolha.equalsIgnoreCase("1") || escolha.equalsIgnoreCase("Criar Personagem") || escolha.equalsIgnoreCase("Criar") || escolha.equalsIgnoreCase("C")) {

                System.out.println("===== CRIAR PERSONAGEM =====");
                System.out.println("Digite o nome do seu personagem:");
                String nome = scanner.nextLine();
                // ... (resto da lógica de criação de personagem) ...

                while (nome.trim().isEmpty()) {
                    System.out.println("Seu personagem precisa ter um nome! Digite novamente:");
                    nome = scanner.nextLine();
                }

                System.out.println("Escolha sua classe entre Bárbaro, Assassino, Paladino:");
                String classe = scanner.nextLine();

                while (!classe.equalsIgnoreCase("Assassino") && !classe.equalsIgnoreCase("Paladino") && !classe.equalsIgnoreCase("Bárbaro") && !classe.equalsIgnoreCase("Barbaro")) {
                    System.out.println("Classe inválida! Digite: Bárbaro, Assassino ou Paladino:");
                    classe = scanner.nextLine();
                }

                Personagem p = null;
                if (classe.equalsIgnoreCase("Assassino")) {
                    p = new Personagem(proximoId, nome, classe, 15, 9, 30);
                } else if (classe.equalsIgnoreCase("Bárbaro") || classe.equalsIgnoreCase("Barbaro")) {
                    p = new Personagem(proximoId, nome, classe, 30, 25, 10);
                } else if (classe.equalsIgnoreCase("Paladino")) {
                    p = new Personagem(proximoId, nome, classe, 20, 15, 15);
                }

                proximoId++;
                personagens.add(p);
                System.out.println("Personagem criado: " + nome + " (Classe: " + classe + ")");
            }

            // === LISTAR PERSONAGENS ===
            else if (escolha.equalsIgnoreCase("2") || escolha.equalsIgnoreCase("Listar") || escolha.equalsIgnoreCase("L")) {

                System.out.println("===== LISTAGEM DE PERSONAGENS =====");
                if (personagens.isEmpty()) {
                    System.out.println("Nenhum personagem criado ainda.");
                } else {
                    for (int i = 0; i < personagens.size(); i++) {
                        System.out.println((i + 1) + ") " + personagens.get(i));
                    }
                }
            }

            // === EDITAR PERSONAGEM ===
            else if (escolha.equalsIgnoreCase("3") || escolha.equalsIgnoreCase("Editar") || escolha.equalsIgnoreCase("E")) {
                // ... (Lógica de edição de personagem) ...

                System.out.println("===== EDITAR PERSONAGEM =====");
                if (personagens.isEmpty()) {
                    System.out.println("Nenhum personagem criado ainda.");
                } else {
                    Personagem personagemEncontrado = null;
                    while (personagemEncontrado == null) {
                        System.out.println("Digite o ID do personagem que deseja editar:");
                        String entrada = scanner.nextLine();

                        if (entrada.trim().isEmpty()) {
                            System.out.println("Você não digitou nenhum ID! Tente novamente.");
                            continue;
                        }

                        int idEscolhido;
                        try {
                            idEscolhido = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido! Por favor, digite um número válido.");
                            continue;
                        }

                        for (Personagem p : personagens) {
                            if (p.id == idEscolhido) {
                                personagemEncontrado = p;
                                break;
                            }
                        }

                        if (personagemEncontrado == null) {
                            System.out.println("Nenhum personagem encontrado com esse ID. Tente novamente.");
                        }
                    }

                    System.out.println("Digite o novo nome (ou pressione Enter para manter o mesmo):");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.trim().isEmpty()) {
                        personagemEncontrado.nome = novoNome;
                    }

                    System.out.println("Digite a nova classe (Bárbaro, Assassino ou Paladino) ou pressione Enter para manter:");
                    String novaClasse = scanner.nextLine();
                    if (!novaClasse.trim().isEmpty()) {
                        while (!novaClasse.equalsIgnoreCase("Assassino") && !novaClasse.equalsIgnoreCase("Paladino") && !novaClasse.equalsIgnoreCase("Bárbaro") && !novaClasse.equalsIgnoreCase("Barbaro")) {
                            System.out.println("Classe inválida! Digite: Bárbaro, Assassino ou Paladino:");
                            novaClasse = scanner.nextLine();
                        }

                        personagemEncontrado.classe = novaClasse;

                        if (novaClasse.equalsIgnoreCase("Assassino")) {
                            personagemEncontrado.vida = 15;
                            personagemEncontrado.forca = 9;
                            personagemEncontrado.velocidade = 30;
                        } else if (novaClasse.equalsIgnoreCase("Bárbaro") || novaClasse.equalsIgnoreCase("Barbaro")) {
                            personagemEncontrado.vida = 30;
                            personagemEncontrado.forca = 25;
                            personagemEncontrado.velocidade = 10;
                        } else if (novaClasse.equalsIgnoreCase("Paladino")) {
                            personagemEncontrado.vida = 20;
                            personagemEncontrado.forca = 15;
                            personagemEncontrado.velocidade = 15;
                        }
                    }
                }
            }

            // === DELETAR PERSONAGEM ===
            else if (escolha.equalsIgnoreCase("4") || escolha.equalsIgnoreCase("Deletar") || escolha.equalsIgnoreCase("D")) {
                // ... (Lógica de deletar personagem) ...

                System.out.println("===== DELETAR PERSONAGEM =====");
                if (personagens.isEmpty()) {
                    System.out.println("Nenhum personagem criado ainda.");
                } else {
                    Personagem personagemEncontrado = null;
                    while (personagemEncontrado == null) {
                        System.out.println("Digite o ID do personagem que deseja deletar:");
                        String entrada = scanner.nextLine();

                        if (entrada.trim().isEmpty()) {
                            System.out.println("Você não digitou nenhum ID! Tente novamente.");
                            continue;
                        }

                        int idEscolhido;
                        try {
                            idEscolhido = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido! Digite um número válido.");
                            continue;
                        }

                        for (Personagem p : personagens) {
                            if (p.id == idEscolhido) {
                                personagemEncontrado = p;
                                break;
                            }
                        }

                        if (personagemEncontrado == null) {
                            System.out.println("Nenhum personagem encontrado com esse ID. Tente novamente.");
                        }
                    }

                    System.out.println("Tem certeza que deseja deletar o personagem: " + personagemEncontrado.nome + "? (S/N)");
                    String confirmacao = scanner.nextLine();
                    if (confirmacao.equalsIgnoreCase("S") || confirmacao.equalsIgnoreCase("Sim")) {
                        personagens.remove(personagemEncontrado);
                        System.out.println("Personagem deletado com sucesso!");
                    } else {
                        System.out.println("Operação cancelada. *Uffa* " + personagemEncontrado.nome + " ficou com medo.");
                    }
                }
            }

            // === INICIAR AVENTURA (5) ===
            else if (escolha.equalsIgnoreCase("5") || escolha.equalsIgnoreCase("Iniciar") || escolha.equalsIgnoreCase("A") || escolha.equalsIgnoreCase("I")) {

                if (personagens.isEmpty()) {
                    System.out.println("Nenhum personagem criado ainda.");
                } else {
                    Personagem personagemEscolhido = null;

                    while (personagemEscolhido == null) {
                        System.out.println("Digite o ID do personagem para iniciar a aventura:");
                        String entrada = scanner.nextLine();

                        if (entrada.trim().isEmpty()) {
                            System.out.println("Você não digitou nenhum ID! Tente novamente.");
                            continue;
                        }

                        int idEscolhido;
                        try {
                            idEscolhido = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido! Por favor, digite um número válido.");
                            continue;
                        }

                        for (Personagem p : personagens) {
                            if (p.id == idEscolhido) {
                                personagemEscolhido = p;
                                break;
                            }
                        }

                        if (personagemEscolhido == null) {
                            System.out.println("Nenhum personagem encontrado com esse ID. Tente novamente.");
                        }
                    }

                    System.out.println("\nVocê escolheu: " + personagemEscolhido.nome + ".");
                    System.out.println("O selo ancestral foi rompido, e um poder sombrio corrompe o coração de Eldoria.");
                    System.out.println("Somente os dignos poderão erguer suas espadas e restaurar o equilíbrio.\n");

                    boolean emAventura = true;
                    int ouro = 0;
                    int energia = 100;

                    List<String> inventario = new ArrayList<>();
                    int quantidadePocoes = 0;


                    while (emAventura) {
                        exibirMenuAcoes();
                        String acao = scanner.nextLine().trim();

                        switch (acao) {
                            case "1", "Treinar" -> {
                                if (energia >= 20) {
                                    personagemEscolhido.forca += 5;
                                    energia -= 20;
                                    System.out.println(personagemEscolhido.nome + " treinou intensamente e aprimorou suas habilidades!");
                                    System.out.println("Força atual: " + personagemEscolhido.forca + " | Energia: " + energia + "\n");
                                } else {
                                    System.out.println("Você está exausto demais para treinar. Descanse um pouco.\n");
                                }
                            }

                            case "2", "Explorar" -> {
                                System.out.println(personagemEscolhido.nome + " parte para explorar as terras sombrias de Eldoria...");
                                int evento = (int) (Math.random() * 4);

                                switch (evento) {
                                    case 0 -> {
                                        System.out.println("Você encontrou um baú antigo e ganhou 10 de ouro!");
                                        ouro += 10;
                                    }
                                    case 1 -> {
                                        System.out.println("Um lobo feroz aparece!");
                                        int vidaLobo = 25;
                                        int ataqueLobo = 6;

                                        boolean emCombate = true;

                                        while (emCombate && energia > 0 && vidaLobo > 0) {
                                            System.out.println("\n=== Combate contra Lobo ===");
                                            System.out.println("Sua energia: " + energia + " | Força: " + personagemEscolhido.forca);
                                            System.out.println("Vida do lobo: " + vidaLobo);
                                            System.out.println("Escolha sua ação: (Atacar / Defender / Usar Poção / Fugir)");

                                            String acaoCombate = scanner.nextLine().trim();

                                            switch (acaoCombate.toLowerCase()) {
                                                case "atacar" -> {
                                                    int danoJogador = personagemEscolhido.forca / 2 + (int)(Math.random() * 4);
                                                    vidaLobo -= danoJogador;
                                                    System.out.println("Você ataca e causa " + danoJogador + " de dano!");

                                                    if (vidaLobo > 0) {
                                                        energia -= ataqueLobo;
                                                        System.out.println("O lobo contra-ataca e você perde " + ataqueLobo + " de energia!");
                                                    }
                                                }

                                                case "defender" -> {
                                                    int danoReduzido = ataqueLobo / 2;
                                                    energia -= danoReduzido;
                                                    System.out.println("Você se defende! O lobo ainda causa " + danoReduzido + " de dano.");
                                                }

                                                case "usar poção" -> {
                                                    if (quantidadePocoes > 0) {
                                                        quantidadePocoes--;
                                                        energia = Math.min(100, energia + 30);
                                                        inventario.remove("Poção"); // remove uma poção do inventário
                                                        System.out.println("Você usa uma poção e restaura 30 de energia!");
                                                        System.out.println("Poções restantes: " + quantidadePocoes);
                                                    } else {
                                                        System.out.println("Você não tem poções disponíveis!");
                                                    }
                                                }


                                                case "fugir" -> {
                                                    System.out.println("Você foge da batalha! O lobo desaparece na floresta...");
                                                    emCombate = false;
                                                }

                                                default -> System.out.println("Ação inválida! Escolha Atacar, Defender, Usar Poção ou Fugir.");
                                            }

                                            if (vidaLobo <= 0) {
                                                System.out.println("\nVocê derrotou o lobo!");
                                                personagemEscolhido.forca += 3;
                                                ouro += 5;
                                                System.out.println("Recompensa: +3 Força, +5 Ouro.");
                                                emCombate = false;
                                            }

                                            if (energia <= 0) {
                                                System.out.println("\nVocê foi derrotado pelo lobo...");
                                                emCombate = false;
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("Um monstro selvagem surge das sombras!");
                                        int vidaMonstro = 40;
                                        int ataqueMonstro = 10;

                                        boolean emCombate = true;

                                        while (emCombate && energia > 0 && vidaMonstro > 0) {
                                            System.out.println("\n=== Combate contra Monstro ===");
                                            System.out.println("Sua energia: " + energia + " | Força: " + personagemEscolhido.forca);
                                            System.out.println("Vida do monstro: " + vidaMonstro);
                                            System.out.println("Escolha sua ação: (Atacar / Defender / Usar Poção / Fugir)");

                                            String acaoCombate = scanner.nextLine().trim();

                                            switch (acaoCombate.toLowerCase()) {
                                                case "atacar" -> {
                                                    int danoJogador = personagemEscolhido.forca / 2 + (int)(Math.random() * 6);
                                                    vidaMonstro -= danoJogador;
                                                    System.out.println("Você ataca e causa " + danoJogador + " de dano!");

                                                    if (vidaMonstro > 0) {
                                                        energia -= ataqueMonstro;
                                                        System.out.println("O monstro contra-ataca e você perde " + ataqueMonstro + " de energia!");
                                                    }
                                                }

                                                case "defender" -> {
                                                    int danoReduzido = ataqueMonstro / 2;
                                                    energia -= danoReduzido;
                                                    System.out.println("Você se defende! O monstro ainda causa " + danoReduzido + " de dano.");
                                                }

                                                case "usar poção" -> {
                                                    if (quantidadePocoes > 0) {
                                                        quantidadePocoes--;
                                                        energia = Math.min(100, energia + 30);
                                                        inventario.remove("Poção"); // remove uma poção do inventário
                                                        System.out.println("Você usa uma poção e restaura 30 de energia!");
                                                        System.out.println("Poções restantes: " + quantidadePocoes);
                                                    } else {
                                                        System.out.println("Você não tem poções disponíveis!");
                                                    }
                                                }


                                                case "fugir" -> {
                                                    System.out.println("Você foge da batalha! O monstro desaparece nas sombras...");
                                                    emCombate = false;
                                                }

                                                default -> System.out.println("Ação inválida! Escolha Atacar, Defender, Usar Poção ou Fugir.");
                                            }

                                            if (vidaMonstro <= 0) {
                                                System.out.println("\nVocê derrotou o monstro!");
                                                personagemEscolhido.forca += 5;
                                                ouro += 10;
                                                System.out.println("Recompensa: +5 Força, +10 Ouro.");
                                                emCombate = false;
                                            }

                                            if (energia <= 0) {
                                                System.out.println("\nVocê foi derrotado pelo monstro...");
                                                emCombate = false;
                                            }
                                        }
                                    }

                                    case 3 -> {
                                        System.out.println("Você encontra um sábio viajante. Ele compartilha sabedoria e restaura sua energia em 30 pontos!");
                                        energia = Math.min(100, energia + 30);
                                    }
                                }
                                System.out.println();
                            }

                            case "3", "Descansar" -> {
                                System.out.println("Você faz uma pausa em uma clareira tranquila e recupera suas forças...");
                                energia = Math.min(100, energia + 40);
                                System.out.println("Energia restaurada para: " + energia + "\n");
                            }

                            case "4", "Ver Status" -> {
                                System.out.println("\n=== Status de " + personagemEscolhido.nome + " ===");
                                System.out.println("Força: " + personagemEscolhido.forca);
                                System.out.println("Energia: " + energia);
                                System.out.println("Ouro: " + ouro);
                                System.out.println("Inventário: " + inventario);
                                System.out.println("Poções: " + quantidadePocoes + "\n");
                            }

                            case "5", "Boss" -> {
                                System.out.println("\n⚔️  O confronto final começou!");
                                System.out.println(personagemEscolhido.nome + " encara o poder sombrio em uma batalha decisiva!");

                                if (personagemEscolhido.forca >= 60 && energia >= 40) {
                                    System.out.println("\n Você canaliza todo o seu poder e derrota a criatura ancestral!");
                                    System.out.println("As trevas se dissipam, e o reino de Eldoria é libertado.");
                                    System.out.println("\n Vitória! O povo cantará o seu nome por gerações!\n");
                                    emAventura = false;
                                } else {
                                    System.out.println("\nVocê lutou bravamente, mas o poder sombrio era forte demais...");
                                    personagens.remove(personagemEscolhido);

                                    if (personagens.isEmpty()) {
                                        System.out.println("\nTodos os heróis caíram. O reino foi consumido pela escuridão...");
                                        System.out.println("🕯 Fim de jogo.");
                                        System.exit(0);
                                    } else {
                                        System.out.println("\nDeseja reencarnar e tentar novamente? (S/N)");
                                        String resposta = scanner.nextLine().trim();
                                        if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")) {
                                            emAventura = false;
                                        } else {
                                            System.out.println("Você desistiu. O reino sucumbe às trevas...");
                                            System.exit(0);
                                        }
                                    }
                                }
                            }

                            case "6", "Loja" -> {
                                boolean naLoja = true;
                                while (naLoja) {
                                    System.out.println("\n=== Loja do Mercador ===");
                                    System.out.println("1 - Comprar Espada (+10 Força) - 20 ouro");
                                    System.out.println("2 - Comprar Poção (+30 Energia) - 15 ouro");
                                    System.out.println("3 - Sair da Loja");
                                    String escolhaLoja = scanner.nextLine().trim();

                                    switch (escolhaLoja) {
                                        case "1" -> {
                                            if (ouro >= 20) {
                                                ouro -= 20;
                                                personagemEscolhido.forca += 10;
                                                inventario.add("Espada");
                                                System.out.println("Você comprou uma Espada! Força aumentada em +10.");
                                            } else {
                                                System.out.println("Você não tem ouro suficiente!");
                                            }
                                        }
                                        case "2" -> {
                                            if (ouro >= 15) {
                                                ouro -= 15;
                                                quantidadePocoes++;
                                                inventario.add("Poção");
                                                System.out.println("Você comprou uma Poção! Agora você tem " + quantidadePocoes + " poções.");
                                            } else {
                                                System.out.println("Você não tem ouro suficiente!");
                                            }
                                        }
                                        case "3" -> {
                                            System.out.println("Você saiu da loja.");
                                            naLoja = false;
                                        }
                                        default -> System.out.println("Opção inválida!");
                                    }
                                }
                            }

                            default -> System.out.println("Ação inválida! Digite Treinar, Explorar, Descansar, Status, Boss ou Loja.\n");
                        }
                    }
                }
            }


            // === SAIR (6) ===
            else if (escolha.equalsIgnoreCase("6") || escolha.equalsIgnoreCase("Sair") || escolha.equalsIgnoreCase("S")) {
                System.out.println("Até a próxima!");
                terminar = true;
            }

            // === OPÇÃO INVÁLIDA ===
            else {
                System.out.println("Esta não é uma escolha válida!");
            }
        }
        SwingUtilities.invokeLater(janelaGUI::new);
        scanner.close();
    }
}