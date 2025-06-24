package model;

public class Jogador {
    private String nome;

    // Construtor com validação recomendada
    public Jogador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do jogador não pode ser vazio ou nulo.");
        }
        this.nome = nome.trim();
    }

    // Getter para obter o nome do jogador
    public String getNome() {
        return nome;
    }

    // Sobrescrever toString é útil para exibir o jogador em mensagens
    @Override
    public String toString() {
        return nome;
    }
}
