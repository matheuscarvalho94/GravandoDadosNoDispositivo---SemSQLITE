package com.example.usuario.gravandodadosnodispositivo;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button botao;
    private TextView meutexto;
    private EditText camponome;
    private EditText campoidade;

    private static String MINHAS_PREFERENCIAS = "Minhas Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaosalvar);
        meutexto = (TextView) findViewById(R.id.textonome);
        campoidade = (EditText) findViewById(R.id.campoidade);
        camponome = (EditText) findViewById(R.id.camponome);

        SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS,0);

        if (sharedPreferences.contains("nome")){
            String nomeusuario = sharedPreferences.getString("nome","");
            Integer idadeusuario = sharedPreferences.getInt("idade",0);

            meutexto.setText("Nome: " + nomeusuario + " Idade: " + idadeusuario);
        }else {
            meutexto.setText("Insira seus Dados!");
        }

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("nome", camponome.getText().toString());
                editor.putString("idade", Integer.parseInt(campoidade.getText().toString()));
                editor.commit();
            }
        });

    }
}
