package com.example.visao.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.visao.R;
import com.example.visao.adapter.AulaAdapter;
import com.example.visao.api.AulaService;
import com.example.visao.api.ApiClient;
import com.example.visao.model.Aula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaAulasActivity extends AppCompatActivity {
    AulaService aulaService;
    RecyclerView recyclerView;
    List<Aula> listaAula;
    AulaAdapter adapter;

    TextView txtNomeProfessor;
    int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aulas);
        aulaService = ApiClient.getAulaService();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerAulas);
        txtNomeProfessor = (TextView) findViewById(R.id.txtNomeProfessor);
    }
    @Override
    protected void onResume(){
        super.onResume();
        obterAulas();
    }
    private void obterAulas(){
        code = getIntent().getIntExtra("id", 0);
        Log.i("prof code: ", ""+code);
        Call<List<Aula>> call = aulaService.getAula();
        call.enqueue(new Callback<List<Aula>>() {
            @Override
            public void onResponse(Call<List<Aula>> call, Response<List<Aula>> response) {
                Log.i("chamada: ",response.body().toString());
                listaAula = response.body();

                configurarRecycler(listaAula);
            }

            @Override
            public void onFailure(Call<List<Aula>> call, Throwable t) {

            }
        });
    }

    private void configurarRecycler(List<Aula> listaAula) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AulaAdapter(listaAula, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}