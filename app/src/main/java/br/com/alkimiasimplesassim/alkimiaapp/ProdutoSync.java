package br.com.alkimiasimplesassim.alkimiaapp;

import java.util.List;

/**
 * Created by Android on 07/05/2018.
 */

public class ProdutoSync {
    private List<Produto> produto;
    private String momentoDaUltimaModificacao;

    public String getMomentoDaUltimaModificacao() {
        return momentoDaUltimaModificacao;
    }

    public List<Produto> getAlunos() {
        return produto;
    }
}
