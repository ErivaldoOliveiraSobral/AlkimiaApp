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
    @POST("produto")
    Call<Void> insere(@Body Produto produto);

    @GET
    Call<List<Produto>> listaProdutos();
}
