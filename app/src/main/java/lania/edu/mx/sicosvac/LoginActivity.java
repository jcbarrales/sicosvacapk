package lania.edu.mx.sicosvac;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void  login (View view){
        Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();

        final String username = ((TextView) findViewById(R.id.username_input)).getText().toString();
        final String password = ((TextView) findViewById(R.id.password_input)).getText().toString();

        if(username.equals( "" )){ ((TextView) findViewById(R.id.username_input)).setError( getResources().getString(R.string.enter_username) ); return;}
        if(password.equals( "" )){ ((TextView) findViewById(R.id.password_input)).setError( getResources().getString(R.string.enter_password) ); return;}

        SplashActivity.signIn(username,password, this);
    }
}
