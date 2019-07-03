package lania.edu.mx.sicosvac;

import android.util.Base64;
import android.util.Log;

import java.io.IOException;

import lania.edu.mx.sicosvac.db.APIService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static APIService apiService = null;
    //final static public String AUTH_DEF = "facilitador:cbi2018"; // default credentials
    final static public String AUTH_DEF = "administrador:cbi2018"; // default credentials

    public static APIService getApiService(){
        return getApiService( AUTH_DEF);
    }

    public static APIService getApiService(String USERPASS) {

        if (apiService==null) { // then also must be true retrofit == null

            Log.d("signIn", "Entro");
            //Prueba
            String BASE_URL =  "http://127.0.0.1:8084";
            Log.d("signIn", BASE_URL);

            //Real
            //String BASE_URL =  "http://13.57.222.27:9090";





            final String sessionEncoded;

            sessionEncoded = "Basic " + new String(Base64.encode(USERPASS.getBytes(), Base64.NO_WRAP));

            /* --------------------------- Create interceptor for set default Authorization --------------------------- */
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Interceptor.Chain chain) throws IOException {
                                    Request newRequest = chain.request().newBuilder().addHeader("Authorization", sessionEncoded).addHeader("Device-Type", "1").build();
                                    return chain.proceed(newRequest);
                                }
                            })
                    .build();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            apiService = retrofit.create(APIService.class);
        }
        return apiService;
    }
}
