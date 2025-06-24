"package app;

import model.Jogador;
import model.Palavra;
import service.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entradas do teclado (nome do jogador)
        Scanner scanner = new Scanner(System.in);

        String nome;

        // Loop que garante que o jogador informe um nome válido (não vazio)
        while (true) {
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine().trim(); // remove espaços antes/depois

            if (!nome.isEmpty()) {
                break; // sai do loop se o nome for válido
            }

            // Mensagem de aviso caso o jogador pressione Enter sem digitar o nome
            System.out.println("O nome não pode estar vazio. Tente novamente.");
        }

        // Cria um novo objeto Jogador com o nome informado
        Jogador jogador = new Jogador(nome);

        // Instancia o objeto Palavra, que será responsável por gerar a palavra secreta
        Palavra palavra = new Palavra();

        // Cria o jogo passando os objetos jogador e palavra
        Jogo jogo = new Jogo(palavra, jogador);

        // Inicia a lógica do jogo (loop de chutes, verificação de vitória/derrota etc.)
        jogo.iniciarJogo();
    }
}
