package org.fifa.quiniela.quinielajsfprimefaces.modelo;

import okhttp3.ResponseBody;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.ResponsePartidos;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DatabaseRepository {
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/ords/ingenieria_uth/quinielauth/partidos")
    Call<ResponsePartidos> consultarPartidos();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/ords/ingenieria_uth/quinielauth/partidos")
    Call<ResponseBody> crearPartido(@Body Partido nuevo);
}
