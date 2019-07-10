package lania.edu.mx.sicosvac;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

import lania.edu.mx.sicosvac.db.APIService;
import lania.edu.mx.sicosvac.db.pojo.User;
import lania.edu.mx.sicosvac.General.AESUtils;
import lania.edu.mx.sicosvac.General.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final AsyncTask task = new DownloadInfoTask().execute();

        Thread timerThread  = new Thread() {
            public void run() {
                try {
                    sleep(800);
                    while(!task.getStatus().equals(AsyncTask.Status.FINISHED)){
                        sleep(100);
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            }
        };
        timerThread.start();
    }

    // TODO: initial task must be done here. It will be useful when new services arrive.
    private class DownloadInfoTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try{

            } catch(Exception ex){
                Log.e("SplashActivity", "IOException when downloading general info:  " + ex.toString());
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Void... voids){
        }

        @Override
        protected void onPostExecute(Void v){
        }
    }

    // Método para validar el login del tutor.
    public static void signIn(final String username, final String password, final Activity context){

        APIService apiService =  RetrofitClient.getApiService(); // call using same credentials for header.


        //Vamos a encriptar la contraseña que escribió el usuario en formato MDF5
        String encrypted = "";
        try {
            encrypted = AESUtils.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Call<User> loginCall = apiService.login(username,encrypted);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                 Log.d("signIn", String.valueOf(response.code()));
                if(response.code() == 200){

                    //Obtenemos los valores del servicio y los guardamos en el objeto User
                    User user = response.body();


                    //Preparamos la información para activar la pantalla de tutor_profile
                    Intent intent = new Intent(context, tutor_profile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    intent.putExtra("nombre",user.getNombre() + " " + user.getApellidos());
                    intent.putExtra("usuario",user.getUsuario() );
                    intent.putExtra("tutor_id",user.getId_tutor() );


                    context.startActivity(intent);
                    context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    context.finish();
                    Log.d("signIn", "Fin de intent");

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Login", "Failure on Login: " + t.getMessage());
                showSimpleAlertDialog(  "Verifica tu conexión y vuelve a intentarlo", context);
            }
        });



    }

    public static void showSimpleAlertDialog(String message, Context context){
        final AlertDialog.Builder alertDialogDelete = new AlertDialog.Builder(context);
        alertDialogDelete.setTitle("Login");
        alertDialogDelete.setCancelable(false);
        alertDialogDelete.create();
        alertDialogDelete.setMessage(message);
        alertDialogDelete.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}
        });
        alertDialogDelete.show();
    }


    public static void logout(Activity context){

        context.startActivity(new Intent(context, LoginActivity.class));
        context.finish();
    }

}