package lania.edu.mx.sicosvac.db;

import java.util.List;

import lania.edu.mx.sicosvac.db.pojo.Menor;
import lania.edu.mx.sicosvac.db.pojo.User;
import lania.edu.mx.sicosvac.db.pojo.notificacion;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    // Login

    @POST("/sicosvac/tutores/login")
    @FormUrlEncoded
    Call<User> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("/sicosvac/menores/listaMenores/{id_tutor}")
    Call<List<Menor>> getMenores(
            @Path("id_tutor") int id_tutor

    );

    @GET("/sicosvac/notificaciones/listaNotificaciones/{id_tutor}")
    Call<List<notificacion>> getNotificaciones(
            @Path("id_tutor") int id_tutor

    );

}
