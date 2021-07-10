package br.edu.icomp.trab02_locadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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