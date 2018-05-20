package br.com.alkimiasimplesassim.alkimiaapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import br.com.alkimiasimplesassim.alkimiaapp.dao.ProdutoDAO;
import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;
import br.com.alkimiasimplesassim.alkimiaapp.retrofit.RetrofitInicializador;
import br.com.alkimiasimplesassim.alkimiaapp.retrofit.sync.ProdutoSync;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelaInicialActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sincronizar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        ListView lvProdutos = findViewById(R.id.lvProdutos);

        // Faz a chamada para o Web Service e salva no banco de dados
        //chamadaREST(this);

        ProdutoDAO dao = new ProdutoDAO(this);
        List<Produto> produtos = dao.busca();
        dao.close();

        listar(lvProdutos, produtos);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.menu_sincronizar:

                Toast.makeText(this, "Sincronizado", Toast.LENGTH_SHORT).show();

                ProdutoDAO dao = new ProdutoDAO(this);
                dao.limpar();

                chamadaREST(this);
                ListView lvProdutos = findViewById(R.id.lvProdutos);
                List<Produto> produtos = dao.busca();
                dao.close();

                listar(lvProdutos, produtos);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void chamadaREST(final Context context) {
        Call<ProdutoSync> produtoSyncCall = new RetrofitInicializador().getProdutoService().listaProdutos();
        produtoSyncCall.enqueue(new Callback<ProdutoSync>() {
            @Override
            public void onResponse(Call<ProdutoSync> call, Response<ProdutoSync> response) {
                List<Produto> produtos = response.body().getProduto();
                ProdutoDAO dao = new ProdutoDAO(context);
                for (Produto p : produtos) {
                    dao.insere(p);
                }
                dao.close();
            }

            @Override
            public void onFailure(Call<ProdutoSync> call, Throwable t) {
                Log.e("ERRO: ", t.getMessage());
            }
        });
    }

    private void listar(ListView lvProdutos, List lista) {

        ArrayAdapter<Produto> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lvProdutos.setAdapter(arrayAdapter);

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produto p = (Produto) adapterView.getItemAtPosition(i);

                Intent detalhesProduto = new Intent(TelaInicialActivity.this, DetalhesProdutoActivity.class);
                detalhesProduto.putExtra("produto", p);
                startActivity(detalhesProduto);
            }
        });
    }
}
