package lania.edu.mx.sicosvac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class menor_cartilla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor_cartilla);

        int menorr_id;

        String nombre = getIntent().getStringExtra("menormombre");
        String usuario = getIntent().getStringExtra("fecha_nac");
        menorr_id = getIntent().getIntExtra("id_menor",0);

        ((TextView) findViewById(R.id.nameTextmenorprofile)).setText(nombre);
        ((TextView) findViewById(R.id.txtInfoMenor)).setText(usuario);

    }
}
