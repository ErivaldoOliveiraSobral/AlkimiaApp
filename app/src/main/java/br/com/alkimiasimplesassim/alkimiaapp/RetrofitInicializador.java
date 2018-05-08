package br.com.alkimiasimplesassim.alkimiaapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Android on 07/05/2018.
 */

public class RetrofitInicializador {

    OkHttpClient.Builder client = new OkHttpClient.Builder();
    private final Retrofit retrofit;
    public RetrofitInicializador(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://alkimiasimplesassim.com.br/api/listaProdutos/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public ProdutoService getProdutoService() {
        return (ProdutoService) retrofit.create(Produto.class);
    }
}
