package br.com.alkimiasimplesassim.alkimiaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;

public class ProdutoDAO extends SQLiteOpenHelper  {
    private static final String NOME_DB = "alkimiaBD";
    private static final int VERSAO_DB = 1;
    private static final String NOME_TABELA = "produtos";

    private static final String PATH_DB = "/data/user/0/br.com.alkimiasimplesassim.alkimiaapp/database/produtos";
    private Context context;
    private SQLiteDatabase db;

    public ProdutoDAO(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + NOME_TABELA + "("
                +"Id TEXT,"
                +"NumeroPedido TEXT,"
                +"Produto TEXT,"
                +"Peso TEXT,"
                +"NomeUsuario TEXT,"
                +"Endereco TEXT,"
                +"Bairro TEXT,"
                +"Cidade TEXT,"
                +"Cep TEXT,"
                +"Pais TEXT,"
                +"Estado TEXT,"
                +"Telefone TEXT,"
                +"Email TEXT,"
                +"Preco TEXT,"
                +"Status TEXT"
                +")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = "DROP TABLE IF EXISTS " + NOME_TABELA;
        db.execSQL(drop);
    }

    public void insere(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Id", produto.getId());
        cv.put("NumeroPedido", produto.getNumeroPedido());
        cv.put("Produto", produto.getProduto());
        cv.put("Peso", produto.getPeso());
        cv.put("NomeUsuario", produto.getNomeUsuario());
        cv.put("Endereco", produto.getEndereco());
        cv.put("Bairro", produto.getBairro());
        cv.put("Cidade", produto.getCidade());
        cv.put("Cep", produto.getCep());
        cv.put("Pais", produto.getPais());
        cv.put("Estado", produto.getEstado());
        cv.put("Telefone", produto.getTelefone());
        cv.put("Email", produto.getEmail());
        cv.put("Preco", produto.getPreco());
        cv.put("Status", produto.getStatus());

        db.insert(NOME_TABELA, null, cv);
    }

    public List<Produto> busca() {
        String select = "SELECT * FROM " + NOME_TABELA;
        List<Produto> produtos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        while (cursor.moveToNext()) {
            Produto p = new Produto();

            p.setId(cursor.getString(cursor.getColumnIndex("Id")));
            p.setNumeroPedido(cursor.getString(cursor.getColumnIndex("NumeroPedido")));
            p.setProduto(cursor.getString(cursor.getColumnIndex("Produto")));
            p.setPeso(cursor.getString(cursor.getColumnIndex("Peso")));
            p.setNomeUsuario(cursor.getString(cursor.getColumnIndex("NomeUsuario")));
            p.setEndereco(cursor.getString(cursor.getColumnIndex("Endereco")));
            p.setBairro(cursor.getString(cursor.getColumnIndex("Bairro")));
            p.setCidade(cursor.getString(cursor.getColumnIndex("Cidade")));
            p.setCep(cursor.getString(cursor.getColumnIndex("Cep")));
            p.setPais(cursor.getString(cursor.getColumnIndex("Pais")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("Estado")));
            p.setTelefone(cursor.getString(cursor.getColumnIndex("Telefone")));
            p.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            p.setPreco(cursor.getString(cursor.getColumnIndex("Preco")));
            p.setStatus(cursor.getString(cursor.getColumnIndex("Status")));

            produtos.add(p);
        }
        cursor.close();

        return produtos;
    }

    public void limpar() {
        String clear = "DELETE FROM " + NOME_TABELA;
        db.execSQL(clear);
    }
}
