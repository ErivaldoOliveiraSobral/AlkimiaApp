package br.com.alkimiasimplesassim.alkimiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.List;

import br.com.alkimiasimplesassim.alkimiaapp.ProdutoSync;
import br.com.alkimiasimplesassim.alkimiaapp.RetrofitInicializador;
import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelaInicialActivity extends AppCompatActivity {

    public List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

    }

    @Override
    protected void onResume() {
        super.onResume();

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
                }
            }

            @Override
            public void onFailure(Call<ProdutoSync> call, Throwable t) {
                Log.e("OnFailure", t.getMessage());
            }
        });
    }
}
