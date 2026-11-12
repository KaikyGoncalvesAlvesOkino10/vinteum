package com.example;

import java.util.Objects;

/**
 * Representa uma carta do baralho com um número (1 a 13) e um naipe.
 */
public class Carta {
    private final int numero;
    private final Naipe naipe;

    private static final String[] NOMES_CARTAS = {
        "", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
    };

    public Carta(int numero, Naipe naipe) {
        if (numero < 1 || numero > 13) {
            throw new IllegalArgumentException("O número da carta deve estar entre 1 e 13. Valor fornecido: " + numero);
        }
        this.numero = numero;
        this.naipe = Objects.requireNonNull(naipe, "O naipe não pode ser nulo.");
    }

    /**
     * Retorna o número ordinal da carta (1 a 13).
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o naipe da carta.
     */
    public Naipe getNaipe() {
        return naipe;
    }

    /**
     * Retorna a pontuação da carta no jogo de 21:
     * - Ás vale 1 ponto.
     * - Cartas de 2 a 10 valem seu valor facial.
     * - Valete (11), Dama (12) e Rei (13) valem 10 pontos.
     */
    public int getValor() {
        return (numero > 10) ? 10 : numero;
    }

    /**
     * Retorna o caminho relativo do recurso de imagem da carta.
     * Exemplo: "classic-cards/AceSpades.png", "classic-cards/10Hearts.png".
     */
    public String imagePath() {
        return "classic-cards/" + NOMES_CARTAS[numero] + naipe.name() + ".png";
    }

    @Override
    public String toString() {
        return NOMES_CARTAS[numero] + " de " + naipe.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carta)) return false;
        Carta carta = (Carta) o;
        return numero == carta.numero && naipe == carta.naipe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, naipe);
    }
}

