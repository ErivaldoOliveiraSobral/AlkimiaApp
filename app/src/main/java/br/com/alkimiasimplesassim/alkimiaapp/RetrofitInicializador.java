package br.com.alkimiasimplesassim.alkimiaapp;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Android on 07/05/2018.
 */

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador{
        retrofit = new Retrofit.Builder()
                .baseUrl("https://alkimiasimplesassim.com.br/api/listaProdutos/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }
}
