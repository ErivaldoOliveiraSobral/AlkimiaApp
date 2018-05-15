package br.com.alkimiasimplesassim.alkimiaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.alkimiasimplesassim.alkimiaapp.model.Produto;

public class Update extends SQLiteOpenHelper {

    private static final String NOME_DB = "alkimia_bd";
    private static final int VERSAO_DB = 1;
    private static final String NOME_TABELA = "produtos";

    private static final String PATH_DB = "/data/user/0/br.com.alkimiasimplesassim.alkimiaapp/database/produtos";
    private Context context;
    private SQLiteDatabase db;

    public Update(Context context, SQLiteDatabase.CursorFactory factory) {
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

    public boolean insertProduto(Produto produto) {
        boolean retorno = false;
        openDB();
        try {
            ContentValues cv = new ContentValues();
            cv.put("Id", produto.getId());
            cv.put("NumeroPedido", produto.getNumeroPedido());
            cv.put("Produto", produto.getProduto());
            cv.put("Peso", produto.getPeso());
            cv.put("NomeUsuario", produto.getNomeUsuario());
            cv.put("Bairro", produto.getBairro());
            cv.put("Cidade", produto.getCidade());
            cv.put("Pais", produto.getPais());
            cv.put("Estado", produto.getEstado());
            cv.put("Telefone", produto.getTelefone());
            cv.put("Email", produto.getEmail());
            cv.put("Preco", produto.getPreco());
            cv.put("Status", produto.getStatus());

            db.insert(NOME_TABELA, null, cv);
            retorno = true;
        } catch (Exception e) {
            Log.e("ERRO: ", e.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }

    public boolean updateProduto(Produto produto) {
        boolean retorno = false;
        openDB();
        String where = "NomeUsuario = '" + produto.getNomeUsuario() + "'";
        try {
            ContentValues cv = new ContentValues();
            cv.put("Id", produto.getId());
            cv.put("NumeroPedido", produto.getNumeroPedido());
            cv.put("Produto", produto.getProduto());
            cv.put("Peso", produto.getPeso());
            cv.put("NomeUsuario", produto.getNomeUsuario());
            cv.put("Bairro", produto.getBairro());
            cv.put("Cidade", produto.getCidade());
            cv.put("Pais", produto.getPais());
            cv.put("Estado", produto.getEstado());
            cv.put("Telefone", produto.getTelefone());
            cv.put("Email", produto.getEmail());
            cv.put("Preco", produto.getPreco());
            cv.put("Status", produto.getStatus());

            db.update(NOME_TABELA, cv, where, null);
            retorno = true;
        } catch (Exception e) {
            Log.e("ERRO: ", e.getMessage());
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
