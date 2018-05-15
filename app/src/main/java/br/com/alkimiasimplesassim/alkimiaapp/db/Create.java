package br.com.alkimiasimplesassim.alkimiaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Create extends SQLiteOpenHelper {

    private static final String NOME_DB = "alkimia_bd";
    private static final int VERSAO_DB = 1;
    private static final String NOME_TABELA = "produtos";

    private static final String PATH_DB = "/data/user/0/br.com.alkimiasimplesassim.alkimiaapp/database/produtos";
    private Context context;
    private SQLiteDatabase db;

    public Create(Context context, SQLiteDatabase.CursorFactory factory) {
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

    public boolean createTable() {
        openDB();
        boolean retorno = false;
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
        try {
            db.execSQL(createTable);
            retorno = true;
        } catch (Exception e) {
            Log.e("ERRO:", e.getMessage());
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
