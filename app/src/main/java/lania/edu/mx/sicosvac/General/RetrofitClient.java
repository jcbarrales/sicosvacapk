package lania.edu.mx.sicosvac.General;

import lania.edu.mx.sicosvac.db.APIService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static APIService API_SERVICE;

    public static APIService getApiService() {

        // Creamos un interceptor y le indicamos el log level a usar
        String baseUrl = "http://34.219.163.213:8084";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API_SERVICE = retrofit.create(APIService.class);
        }

        return API_SERVICE;
    }



}
