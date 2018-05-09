package br.com.alkimiasimplesassim.alkimiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;
import br.com.alkimiasimplesassim.alkimiaapp.retrofit.RetrofitInicializador;
import br.com.alkimiasimplesassim.alkimiaapp.retrofit.sync.ProdutoSync;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelaInicialActivity extends AppCompatActivity {

    public List<Produto> produtos;
    public ArrayList<String> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView listaProdutos = (ListView) findViewById(R.id.lvProdutos);
        Call<ProdutoSync> produtoSyncCall = new RetrofitInicializador().getProdutoService().listaProdutos();

        produtoSyncCall.enqueue(new Callback<ProdutoSync>() {
            @Override
            public void onResponse(Call<ProdutoSync> call, Response<ProdutoSync> response) {
                Log.i("onResponse", "Deu Certo:");
                ProdutoSync body = response.body();
                produtos = body.getProduto();
                for (Produto produto:
                     produtos) {
                    Log.i("", "Usuário: " + produto.getNomeUsuario() + " Produto: " + produto.getProduto());
                    lista.add(produto.getProduto());
                }
            }

            @Override
            public void onFailure(Call<ProdutoSync> call, Throwable t) {
                Log.e("OnFailure", t.getMessage());
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );

        listaProdutos.setAdapter(arrayAdapter);
    }
}
