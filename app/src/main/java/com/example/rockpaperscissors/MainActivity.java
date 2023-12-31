package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
    verificarGanhador("Pedra");
    }


    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }


    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoriaApp(){
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);


        ImageView imagemapp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "Pedra" :
                imagemapp.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemapp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemapp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;

    }

    public void verificarGanhador (String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoresultado = findViewById(R.id.text_resultado);

        if(
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ){
            textoresultado.setText("Você perdeu :( ");

        }else if(
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ){
            textoresultado.setText("Você Ganhou :) ");
        }else{
            textoresultado.setText("Empatamos ;)");
        }

    }

}