package org.fifa.quiniela.quinielajsfprimefaces.modelo;

import okhttp3.ResponseBody;
import org.fifa.quiniela.quinielajsfprimefaces.data.Partido;
import org.fifa.quiniela.quinielajsfprimefaces.data.ResponsePartidos;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DatabaseRepositoryImpl {
    private static DatabaseRepositoryImpl instance;
    private DatabaseClient client;

    private DatabaseRepositoryImpl(String url, Long timeout) {
        client = new DatabaseClient(url, timeout);
    }

    public static DatabaseRepositoryImpl getInstance(String url, Long timeout) {
        if (instance == null) {
            synchronized (DatabaseRepositoryImpl.class) {
                if (instance == null) {
                    instance = new DatabaseRepositoryImpl(url, timeout);
                }
            }
        }
        return instance;
    }

    public ResponsePartidos consultarPartidos() throws IOException {
        Call<ResponsePartidos> call = client.getInstance().consultarPartidos();
        Response<ResponsePartidos> response = call.execute();
        return response.isSuccessful()?response.body():null;
    }

    public boolean crearPartido(Partido nuevo) throws IOException {
        Call<ResponseBody> call = client.getInstance().crearPartido(nuevo);
        Response<ResponseBody> response = call.execute();
        return response.isSuccessful();
    }
}
