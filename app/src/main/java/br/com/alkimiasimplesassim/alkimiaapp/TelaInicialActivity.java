package br.com.alkimiasimplesassim.alkimiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class TelaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final retrofit2.Call<List<Produto>> call = new RetrofitInicializador().getProdutoService().listaProdutos();
/*
        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Produto>> call, Response<List<Produto>> response) {
                Produto produtoArray = (Produto) response.body();
                Toast.makeText(TelaInicialActivity.this, "Caiu: ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(retrofit2.Call<List<Produto>> call, Throwable throwable) {
                Log.e("onFailure chamado", throwable.getMessage());
            }
        });*/
    }
}
