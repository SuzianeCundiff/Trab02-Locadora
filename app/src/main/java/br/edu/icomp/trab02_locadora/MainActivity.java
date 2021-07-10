package br.edu.icomp.trab02_locadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDeDados;
    private ListView lista;
    private ArrayAdapter<String> itensAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS cliente(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome VARCHAR, cpf VARCHAR, data VARCHAR, endereco VARCHAR, telefone VARCHAR)");
        }catch (Exception e){
            e.printStackTrace();
        }

        lista = findViewById(R.id.Lista);


        try {
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM cliente ORDER BY id ", null);
            //recuperar id das colunas
            int cpf = cursor.getColumnIndex("cpf");
            int nome = cursor.getColumnIndex("nome");
            int telefone = cursor.getColumnIndex("telefone");
            int endereco = cursor.getColumnIndex("endereco");
            int data = cursor.getColumnIndex("data");
            //Adaptador

//            ArrayList<String> cpfs = new ArrayList<String>();
            ArrayList<String> nomes = new ArrayList<String>();

            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, nomes);
            lista.setAdapter(itensAdaptador);
            cursor.moveToFirst();
            while(cursor!=null){
                String a = "";
                a = "Nome: "+cursor.getString(cpf) + "\nCPF: "+ cursor.getString(nome) + "\nData: "+ cursor.getString(data) +
                        "\nEndereço: "+cursor.getString(endereco)+ "\nTelefone: "+cursor.getString(telefone);
//                Log.i("Resultado - ","nome: "+cursor.getString(nome));
//                Log.i("Resultado - ","cpf: "+cursor.getString(cpf));
                nomes.add(a);
//                cpfs.add(cursor.getString(cpf));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu_navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.cliente_cadastro){
            Intent intent = new Intent(this, Cadastrar.class);
            startActivity(intent);
            // Toast.makeText(this, "Cliente Cadastro", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.cliente_atualizacao){
            Toast.makeText(this, "Cliente Atualização", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.produto_cadastro){
            Toast.makeText(this, "Produto Cadastro", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.produto_atualizacao){
            Toast.makeText(this, "Produto Atualização", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}