package com.example.primeiraaplicacao;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtF_nome;

    @FXML TextField txtF_sobrenome;

    @FXML
    private Label lbl_mensagem;

    @FXML
    private void exibirMensagem(){
        String nome = txtF_nome.getText().trim();
        String sobrenome = txtF_sobrenome.getText().trim();

        if (nome.isBlank() || sobrenome.isBlank()){
            lbl_mensagem.setText("Por favor, dígite um nome e sobrenome");
        } else {
            lbl_mensagem.setText("Olá, " + nome + " "+sobrenome + "!");
        }
    }

    @FXML
    private void limparCampos(){
        txtF_nome.setText("");
        txtF_sobrenome.setText("");
        lbl_mensagem.setText("");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}