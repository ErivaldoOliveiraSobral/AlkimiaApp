package br.com.alkimiasimplesassim.alkimiaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Android on 07/05/2018.
 */

public interface ProdutoService {
    @POST("listaProdutos")
    Call<Void> insere(@Body Produto produto);

    @GET("listaProdutos")
    Call<List<Produto>> listaProdutos();
}
