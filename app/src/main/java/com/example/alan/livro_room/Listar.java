package com.example.alan.livro_room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alan.livro_room.R;
import com.example.alan.livro_room.modelo.Livro;
import com.example.alan.livro_room.util.LivroDao;

import java.util.ArrayList;
import java.util.List;

public class Listar extends AppCompatActivity {
    TextView titulo;
    TextView autor;
    TextView ano;
    TextView nota;
    List<Livro> livros;
    Livro livro;
    int cont;

    Button anterior;
    Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        livros = new ArrayList<Livro>();
        titulo = findViewById(R.id.titulo);
        autor = findViewById(R.id.autor);
        ano = findViewById(R.id.ano);
        nota = findViewById(R.id.nota);


        AppDatabase bh = AppDatabase.getDatabase(this);
        LivroDao livroDao = bh.livroDao();
        livros = livroDao.listall();

        livro = new Livro();

        anterior = findViewById(R.id.button5);
        proximo = findViewById(R.id.button6);

        if (livros != null) {
            if (!livros.isEmpty())
                livro = livros.get(cont);
        }

        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        ano.setText(livro.getAno() + "");
        nota.setText(livro.getNota() + "");


        if(cont + 1 == livros.size())
            disabilitarBotao(proximo);
        if (livro.getId() == 0)
            disabilitarBotao(anterior);
    }


    public void proximo(View v){
        cont++;
        livro = livros.get(cont);


        if(cont + 1 == livros.size())
            disabilitarBotao(v);
        anterior.setEnabled(true);

        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        ano.setText(livro.getAno() + "");
        nota.setText(livro.getNota() + "");
        ;
    }

    public void anterior(View v){
        cont--;
        livro = livros.get(cont);
        if (cont - 1 == 0)
            disabilitarBotao(v);
        proximo.setEnabled(true);
        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        ano.setText(livro.getAno() + "");
        nota.setText(livro.getNota() + "");
    }
    //metodo para desabilitar botao
    private void disabilitarBotao(View v){
        v.setEnabled(false);
    }
}
