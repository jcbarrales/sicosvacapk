package lania.edu.mx.sicosvac.db;

import lania.edu.mx.sicosvac.db.pojo.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    // Login
    @FormUrlEncoded
    @POST("/sicosvac/tutores/login")
    Call<User> login(
            @Field("username") String username,
            @Field("password") String password
    );
}
