package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML private HBox mesaDoJogador;
    @FXML private HBox mesaDoComputador;
    @FXML private ImageView monte;

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;

    private Jogo jogo;

    @FXML
    public void initialize() {
        novoJogo();
    }

    public void turno() {
        if (jogo == null || jogo.acabou()) {
            return;
        }

        // Se o jogador não parou, ele recebe uma carta
        if (!jogo.jogador.parou()) {
            jogo.distribuirCartaParaJogador(jogo.jogador);
        }

        // Se o jogador já parou, o computador joga até atingir o critério de parada (ou estourar)
        if (jogo.jogador.parou()) {
            while (!jogo.computador.parou() && !jogo.acabou()) {
                jogo.distribuirCartaParaJogador(jogo.computador);
            }
        } else {
            // Caso contrário, o computador joga o seu turno normal
            if (!jogo.computador.parou() && !jogo.acabou()) {
                jogo.distribuirCartaParaJogador(jogo.computador);
            }
        }

        atualizar();

        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
        }
    }

    public void atualizar() {
        pontosJogador.setText("Jogador: " + jogo.jogador.getPontos());
        pontosMesa.setText("Mesa: " + jogo.computador.getPontos());

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.jogador.getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.computador.getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    public void novoJogo() {
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta() {
        if (jogo == null || jogo.acabou()) {
            return;
        }
        turno();
    }

    public void parar() {
        if (jogo == null || jogo.acabou()) {
            return;
        }
        jogo.jogador.parar();
        turno();
    }

    private ImageView imagemCarta(Carta carta) {
        ImageView iv = new ImageView(App.class.getResource(carta.imagePath()).toString());
        iv.setFitHeight(95);
        iv.setFitWidth(77);
        iv.setPreserveRatio(true);
        return iv;
    }
}
