package com.example;

/**
 * Enumeração que representa os 4 naipes de um baralho tradicional.
 */
public enum Naipe {
    Clubs("Paus"),
    Diamonds("Ouros"),
    Hearts("Copas"),
    Spades("Espadas");

    private final String nomeEmPortugues;

    Naipe(String nomeEmPortugues) {
        this.nomeEmPortugues = nomeEmPortugues;
    }

    public String getNomeEmPortugues() {
        return nomeEmPortugues;
    }
}

