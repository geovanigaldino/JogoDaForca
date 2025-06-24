package service;

import model.Jogador;
import model.Palavra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private final Palavra palavra;
    private final Jogador jogador;

    // Construtor recebe os objetos necessários para iniciar o jogo
    public Jogo(Palavra palavra, Jogador jogador) {
        this.palavra = palavra;
        this.jogador = jogador;
    }

    // Método principal que executa a lógica do jogo
    public void iniciarJogo() {
        int numeroChutes = 10;
        List<String> chutes = new ArrayList<>();
        palavra.gerarPalavraSecreta();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nOlá " + jogador.getNome() + ", bem-vindo ao Jogo da Forca!");
        System.out.println("Você tem " + numeroChutes + " chutes para adivinhar a palavra secreta.");
        System.out.println(palavra.getPalavraComChute() + "\n");

        // Loop principal do jogo
        while (!palavra.palavraCompleta() && chutes.size() < numeroChutes) {
            System.out.println("Digite seu chute: ");
            String chute = scanner.nextLine().trim().toLowerCase();

            // Validação: apenas uma letra por vez
            if (chute.length() != 1 || !Character.isLetter(chute.charAt(0))) {
                System.out.println("Por favor, digite apenas uma letra.");
                continue;
            }

            // Verifica se a letra já foi chutada
            if (chutes.contains(chute)) {
                System.out.println("Você já chutou essa letra. Tente novamente!");
                continue;
            }

            chutes.add(chute);
            palavra.revelarLetra(chute);

            System.out.println("Palavra: " + palavra.getPalavraComChute());
            System.out.println("Letras chutadas: " + chutes);

            // Verificação de vitória ou derrota
            if (palavra.palavraCompleta()) {
                System.out.println("\nParabéns " + jogador.getNome() + "! Você venceu!");
            } else if (chutes.size() == numeroChutes) {
                System.out.println("Poxa " + jogador.getNome() +
                        ", você perdeu! A palavra secreta era '" + palavra.getPalavraSecreta() + "'.");
            }
        }
    }
}
