package br.com.alkimiasimplesassim.alkimiaapp.services;

import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;
import br.com.alkimiasimplesassim.alkimiaapp.retrofit.sync.ProdutoSync;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Android on 07/05/2018.
 */

public interface ProdutoService {
    @POST("pedidos")
    Call<Void> insere(@Body Produto produto);

    @GET("pedidos")
    Call<ProdutoSync> listaProdutos();
}
