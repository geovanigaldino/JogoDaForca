package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Palavra {
    // Lista fixa com as palavras possíveis (poderia vir de arquivo ou banco futuramente)
    private final List<String> palavras = Arrays.asList("faca", "garfo", "colher", "prato", "pote", "tigela", "panela");
    private String palavraSecreta;
    private String palavraComChute;

    // Sorteia uma palavra da lista e inicializa a versão oculta com underscores
    public void gerarPalavraSecreta() {
        Random random = new Random();
        int index = random.nextInt(this.palavras.size());
        this.palavraSecreta = this.palavras.get(index);
        this.palavraComChute = "_".repeat(this.palavraSecreta.length());
    }

    // Revela a letra correta nas posições correspondentes
    public void revelarLetra(String letra) {
        if (letra == null || letra.length() != 1) {
            throw new IllegalArgumentException("Informe apenas uma letra.");
        }
        StringBuilder novaPalavra = new StringBuilder(this.palavraComChute);
        for (int i = 0; i < this.palavraSecreta.length(); i++) {
            if (this.palavraSecreta.charAt(i) == letra.charAt(0)) {
                novaPalavra.setCharAt(i, letra.charAt(0));
            }
        }
        this.palavraComChute = novaPalavra.toString();
    }

    // Verifica se a palavra já foi totalmente descoberta
    public boolean palavraCompleta() {
        return !this.palavraComChute.contains("_");
    }

    // Getters para acesso controlado
    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public String getPalavraComChute() {
        return palavraComChute;
    }
}
