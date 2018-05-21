package br.com.alkimiasimplesassim.alkimiaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar =(Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                txtUsuario =(EditText) findViewById(R.id.txtUsuario);
                txtSenha =(EditText) findViewById(R.id.txtSenha);

                String nome = txtUsuario.getText().toString();
                String senha = txtSenha.getText().toString();

                //Toast.makeText(MainActivity.this, "Usuário: " + nome + "; Senha: " + senha, Toast.LENGTH_LONG).show();
                if (nome.equals("admin") && senha.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,"Senha inválida", Toast.LENGTH_LONG).show();
                }
            }
        };
    }
}
