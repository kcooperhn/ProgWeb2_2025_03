package org.fifa.quiniela.quinielajsfprimefaces.modelo;

import org.fifa.quiniela.quinielajsfprimefaces.data.ResponsePartidos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DatabaseRepository {
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/ords/ingenieria_uth/quinielauth/partidos")
    Call<ResponsePartidos> consultarPartidos();
}
