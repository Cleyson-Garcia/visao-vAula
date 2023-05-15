package com.example.visao.api;

import com.example.visao.model.Aula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AulaService {

    @GET("agenda")
    Call<List<Aula>> getAula();

    @GET("agenda/{id}")
    Call<Aula> getAulaById(@Path("id")int id);

    @PUT("agenda/{id}")
    Call<Aula> putAula(@Path("id")int id, @Body Aula aula);
}