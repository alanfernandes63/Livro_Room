package com.example.alan.livro_room;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
    }


    //Metoto utilizado para ir para tela de cadastro de livros
    public void cadastrarLivro(View v){
        Intent intent = new Intent(this,Cadastrar.class);
        startActivityForResult(intent,1);
    }

    //Metoto utilizado para ir para tela de que lista os livros
    public void listarLivros(View v){
        Intent intent = new Intent(this,Listar.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
            Snackbar.make(layout,"Salvo com sucesso",1000);
    }
}
