package br.com.alkimiasimplesassim.alkimiaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;

public class Delete extends SQLiteOpenHelper {

    private static final String NOME_DB = "alkimia_bd";
    private static final int VERSAO_DB = 1;
    private static final String NOME_TABELA = "produtos";

    private static final String PATH_DB = "/data/user/0/br.com.alkimiasimplesassim.alkimiaapp/database/produtos";
    private Context context;
    private SQLiteDatabase db;

    public Delete(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean dropTable() {
        openDB();
        boolean retorno = false;
        String drop = "DROP TABLE IF EXISTS " + NOME_TABELA;
        try {
            db.execSQL(drop);
            retorno = true;
        } catch (Exception e) {
            Log.i("ERRO: ", e.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }

    public boolean deleteProduto(Produto produto) {
        openDB();
        boolean retorno = false;
        String deleteProduto = "Nome = '" + produto.getProduto() + "'";
        try {
            db.delete(NOME_TABELA, deleteProduto, null);
            retorno = true;
        } catch (Exception e) {
            Log.i("ERRO: ", e.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }

    public void openDB() {
        if (!db.isOpen())
            db = context.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);

    }
}
