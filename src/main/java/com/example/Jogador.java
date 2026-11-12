package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa um jogador do jogo de 21.
 */
public class Jogador {
    private int pontos = 0;
    private final List<Carta> cartas = new ArrayList<>();
    private boolean parou = false;

    /**
     * Recebe uma carta do monte, adicionando-a à mão e acumulando a pontuação.
     */
    public void receberCarta(Carta carta) {
        if (carta != null) {
            cartas.add(carta);
            pontos += carta.getValor();
        }
    }

    /**
     * Sinaliza que o jogador decidiu parar de pedir cartas.
     */
    public void parar() {
        this.parou = true;
    }

    /**
     * Informa se o jogador já parou de jogar nesta rodada.
     */
    public boolean parou() {
        return parou;
    }

    /**
     * Retorna o total de pontos acumulados.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Retorna a lista de cartas na mão do jogador.
     */
    public List<Carta> getCartas() {
        return Collections.unmodifiableList(cartas);
    }

    /**
     * Verifica se o jogador ultrapassou os 21 pontos permitidos ("estourou").
     */
    public boolean estourou() {
        return pontos > 21;
    }

    /**
     * Limpa a mão e redefine o estado do jogador para um novo jogo.
     */
    public void resetar() {
        cartas.clear();
        pontos = 0;
        parou = false;
    }
}

