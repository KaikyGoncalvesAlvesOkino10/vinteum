package com.example;

/**
 * Representa o oponente controlado pelo computador (a "Mesa" / Dealer).
 * Aplica o princípio de Herança e Polimorfismo, sobrescrevendo a regra de parada:
 * O computador para automaticamente quando atinge 17 ou mais pontos.
 */
public class Computador extends Jogador {

    @Override
    public boolean parou() {
        return super.parou() || getPontos() >= 17;
    }
}

