package com.example.alan.livro_room;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.alan.livro_room.modelo.Livro;
import com.example.alan.livro_room.util.LivroDao;

public class Cadastrar extends AppCompatActivity {

    EditText titulo;
    EditText ano;
    EditText autor;
    RatingBar nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        titulo = findViewById(R.id.titulo);
        ano = findViewById(R.id.ano);
        autor = findViewById(R.id.autor);
        nota = findViewById(R.id.nota);

        if (savedInstanceState != null){
            titulo.setText(savedInstanceState.getString("titulo"));
            autor.setText(savedInstanceState.getString("autor"));
            ano.setText(savedInstanceState.getString("ano"));
            nota.setRating(savedInstanceState.getFloat("nota"));
        }

    }


    public void cadastrarLivro(View v){

        EditText tituloEdit = findViewById(R.id.titulo);
        EditText autorEdit = findViewById(R.id.autor);
        EditText anoEdit = findViewById(R.id.ano);
        RatingBar notaRanting = findViewById(R.id.nota);

        if (verficar()) {
            AppDatabase db = AppDatabase.getDatabase(this);
            LivroDao livroD = db.livroDao();


            String stitulo = tituloEdit.getText().toString();
            String sautor = autorEdit.getText().toString();
            int sano = Integer.parseInt(anoEdit.getText().toString());
            float snota = notaRanting.getRating();
            int id = 0;

            Livro livro = new Livro(
                    stitulo
                    , sautor
                    , sano, snota, id);
            id++;
            livroD.inserir(livro);

            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        String stitulo = titulo.getText().toString();
        String sautor = autor.getText().toString();
        String sano = ano.getText().toString();
        float fnota = nota.getRating();

        outState.putString("titulo",stitulo);
        outState.putString("autor",sautor);
        outState.putString("ano",sano);
        outState.putFloat("nota",fnota);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("restart","restart");
    }

    private boolean verficar(){
        if(titulo.getText().toString().equals("") || autor.getText().toString().equals("")
                || ano.getText().toString().equals("")){
            Toast.makeText(this, "campos incompletos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void cancelar(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
