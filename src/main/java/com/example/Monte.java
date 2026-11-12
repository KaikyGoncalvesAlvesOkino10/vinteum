package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa o monte (baralho) do jogo, contendo as 52 cartas tradicionais.
 */
public class Monte {
    private final List<Carta> cartas = new ArrayList<>();

    public Monte() {
        reiniciar();
    }

    /**
     * Preenche o monte com as 52 cartas (13 cartas para cada um dos 4 naipes).
     */
    public void reiniciar() {
        cartas.clear();
        for (Naipe naipe : Naipe.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, naipe));
            }
        }
    }

    /**
     * Embaralha as cartas do monte.
     */
    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    /**
     * Remove e retorna a carta do topo do monte. Retorna null se estiver vazio.
     */
    public Carta virar() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0);
    }

    /**
     * Retorna a quantidade de cartas restantes no monte.
     */
    public int getQuantidadeCartas() {
        return cartas.size();
    }

    /**
     * Verifica se ainda há cartas no monte.
     */
    public boolean temCartas() {
        return !cartas.isEmpty();
    }
}

