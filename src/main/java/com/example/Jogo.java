package com.example;

/**
 * Classe principal que gerencia as regras e o andamento da partida de 21.
 * Coordena os jogadores (humano e computador) e o monte de cartas.
 */
public class Jogo {
    public Jogador jogador;
    public Computador computador;
    protected Monte monte;

    public Jogo() {
        this.monte = new Monte();
        this.monte.embaralhar();
        this.jogador = new Jogador();
        this.computador = new Computador();
    }

    /**
     * Distribui uma carta do monte para o jogador especificado,
     * caso o jogador ainda não tenha parado e o jogo não tenha terminado.
     */
    public Carta distribuirCartaParaJogador(Jogador j) {
        if (j == null || j.parou() || acabou()) {
            return null;
        }
        Carta carta = monte.virar();
        if (carta != null) {
            j.receberCarta(carta);
        }
        return carta;
    }

    /**
     * Método alternativo para compatibilidade com diferentes convenções de nomenclatura.
     */
    public Carta distribuiCartaParaJogador(Jogador j) {
        return distribuirCartaParaJogador(j);
    }

    /**
     * Verifica se o jogador ultrapassou os 21 pontos.
     */
    public boolean estourou(Jogador j) {
        return j != null && j.estourou();
    }

    /**
     * O jogo termina se:
     * 1. Ambos os participantes pararam de pedir cartas; OU
     * 2. O jogador humano estourou (> 21 pontos); OU
     * 3. O computador estourou (> 21 pontos).
     */
    public boolean acabou() {
        boolean ambosPararam = jogador.parou() && computador.parou();
        return ambosPararam || jogador.estourou() || computador.estourou();
    }

    /**
     * Avalia o estado final do jogo e retorna o resultado para o jogador humano.
     */
    public String resultado() {
        boolean jogadorEstourou = jogador.estourou();
        boolean computadorEstourou = computador.estourou();
        int pontosJogador = jogador.getPontos();
        int pontosComputador = computador.getPontos();

        if (jogadorEstourou && computadorEstourou) {
            return "Empatou";
        }
        if (jogadorEstourou) {
            return "Você perdeu!";
        }
        if (computadorEstourou) {
            return "Você ganhou!";
        }
        if (pontosJogador > pontosComputador) {
            return "Você ganhou!";
        }
        if (pontosJogador < pontosComputador) {
            return "Você perdeu!";
        }
        return "Empatou";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Computador getComputador() {
        return computador;
    }

    public Monte getMonte() {
        return monte;
    }
}

