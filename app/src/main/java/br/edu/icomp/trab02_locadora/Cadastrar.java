package br.edu.icomp.trab02_locadora;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;


import br.edu.icomp.trab02_locadora.databinding.ActivityCadastrarBinding;

public class Cadastrar extends AppCompatActivity {

    private ActivityCadastrarBinding binding;
    private EditText nome, cpf, data, endereco, telefone;
    private Button cadastrar, cancelar;

    private SQLiteDatabase bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
        super.onCreate(savedInstanceState);

        binding = ActivityCadastrarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        nome = findViewById(R.id.fieldNomeCliente);
        cadastrar = findViewById(R.id.buttonCadastrar);

        cpf = findViewById(R.id.fieldCpfCliente);
        data = findViewById(R.id.dateFieldCliente);

        endereco = findViewById(R.id.fieldEnderecoCliente);
        telefone = findViewById(R.id.fieldTelefoneCliente);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("Key",nome.getText().toString());
                String a = "";

                a = nome.getText().toString() + cpf.getText().toString() + data.getText().toString()
                        + endereco.getText().toString() + telefone.getText().toString();
                try{
                    bancoDeDados.execSQL("INSERT INTO cliente (nome,cpf,data,endereco,telefone) VALUES('" + nome.getText().toString() + "','"+ cpf.getText().toString() +"','"+ data.getText().toString() +"','"+ endereco.getText().toString() +"','"+ telefone.getText().toString() +"')");
                    Log.e("Key","OK");
                }catch (Exception e){
                    e.printStackTrace();
                }
//                nome.getText().toString();
//                cpf.getText().toString();
//                data.getText().toString();
//                endereco.getText().toString();
//                telefone.getText().toString();
//                nome.getText().toString();

                Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        cancelar = findViewById(R.id.buttonCancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });






    }
}