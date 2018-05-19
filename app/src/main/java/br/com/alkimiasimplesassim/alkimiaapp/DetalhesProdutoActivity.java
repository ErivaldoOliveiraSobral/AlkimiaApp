package br.com.alkimiasimplesassim.alkimiaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alkimiasimplesassim.alkimiaapp.dao.ProdutoDAO;
import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;

public class DetalhesProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        List itens = new ArrayList();

        // Traz objeto vindo de outra activity
        Intent intent = getIntent();
        Produto produto = (Produto) intent.getSerializableExtra("produto");

        Log.i("Produto: ", produto.getProduto());

        itens.add("Nº PEDIDO: " + produto.getNumeroPedido());
        itens.add("PRODUTO: " + produto.getProduto());
        itens.add("PORÇÃO: " + produto.getPeso());
        itens.add("COMPRADOR: " + produto.getNomeUsuario());
        itens.add("END.: " + produto.getEndereco());
        itens.add("BAIRRO: " + produto.getBairro());
        itens.add("CIDADE: " + produto.getCidade());
        itens.add("ESTADO: " + produto.getEstado());
        itens.add("CEP: " + produto.getCep());
        itens.add("PAÍS: " + produto.getPais());
        itens.add("TEL.: " + produto.getTelefone());
        itens.add("EMAIL: " + produto.getEmail());
        itens.add("PREÇO: " + produto.getPreco());
        itens.add("STATUS: " + produto.getStatus());


        // Pega a ListView
        ListView produtoView = findViewById(R.id.lvDetalhesProdutos);

        // Renderiza Itens
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        produtoView.setAdapter(arrayAdapter);

    }
}
