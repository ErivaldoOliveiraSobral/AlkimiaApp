package br.com.alkimiasimplesassim.alkimiaapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;

public class Read extends SQLiteOpenHelper {

    private static final String NOME_DB = "alkimia_bd";
    private static final int VERSAO_DB = 1;
    private static final String NOME_TABELA = "produtos";

    private static final String PATH_DB = "/data/user/0/br.com.alkimiasimplesassim.alkimiaapp/database/produtos";
    private Context context;
    private SQLiteDatabase db;

    public Read(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.context = context;
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Produto> getProdutos() {
        openDB();
        ArrayList<Produto> prodArray = new ArrayList<>();
        String sql = "SELECT * FROM " + NOME_TABELA;

        try {
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    Produto produto = new Produto();
                    produto.setId(cursor.getString(0));
                    produto.setNumeroPedido(cursor.getString(1));
                    produto.setProduto(cursor.getString(2));
                    produto.setPeso(cursor.getString(3));
                    produto.setNomeUsuario(cursor.getString(4));
                    produto.setBairro(cursor.getString(5));
                    produto.setCidade(cursor.getString(6));
                    produto.setPais(cursor.getString(7));
                    produto.setEstado(cursor.getString(8));
                    produto.setTelefone(cursor.getString(9));
                    produto.setEmail(cursor.getString(10));
                    produto.setPreco(cursor.getString(11));
                    produto.setStatus(cursor.getString(12));

                    prodArray.add(produto);
                } while (cursor.moveToNext());
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("ERRO: ", e.getMessage());
            return null;
        } finally {
            db.close();
        }
        return prodArray;
    }

    public void openDB() {
        if (!db.isOpen())
            db = context.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
    }
}
