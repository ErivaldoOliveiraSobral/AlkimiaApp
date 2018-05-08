package br.com.alkimiasimplesassim.alkimiaapp;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Android on 07/05/2018.
 */

public class ProdutoService {
    @POST("produtos")
    Call insere() {
        return null;
    }
}
