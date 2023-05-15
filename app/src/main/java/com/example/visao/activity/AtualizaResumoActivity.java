package com.example.visao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.visao.R;
import com.example.visao.api.ApiClient;
import com.example.visao.api.AulaService;
import com.example.visao.model.Aula;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtualizaResumoActivity extends AppCompatActivity {

    TextView txtDias;
    TextView txtHoras;
    TextView txtCidade;
    TextView txtEstado;
    TextView txtCep;
    TextView txtCurso;
    TextView txtResumo;
    Button btnAtualiza;
    AulaService aulaService;
    int id;

    Aula aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atualiza_resumo);
        aulaService = ApiClient.getAulaService();
        txtDias = (TextView) findViewById(R.id.txtDias2);
        txtHoras = (TextView) findViewById(R.id.txtHoras2);
        txtCidade = (TextView) findViewById(R.id.txtCidade2);
        txtEstado = (TextView) findViewById(R.id.txtEstado2);
        txtCep = (TextView) findViewById(R.id.txtCep2);
        txtCurso = (TextView) findViewById(R.id.txtCurso2);
        txtResumo = (TextView) findViewById(R.id.txtResumo2);
        btnAtualiza = (Button) findViewById(R.id.btnAtualizar);
        atualizarDados();
        btnAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aula.setResumo(txtResumo.getText().toString());
                Call<Aula> call = aulaService.putAula(id,aula);
                Intent i = new Intent(AtualizaResumoActivity.this, ListaAulasActivity.class);
                startActivity(i);
            }
        });
    }

    private void atualizarDados(){
        id = getIntent().getIntExtra("id", 0);
        Log.i("Aula ID: ", ""+id);
        Call<Aula> call = aulaService.getAulaById(id);
        call.enqueue(new Callback<Aula>() {
            @Override
            public void onResponse(Call<Aula> call, Response<Aula> response) {
                Log.i("chamada: ",response.body().toString());
                aula = response.body();
                txtDias.setText(aula.getDias());
                txtHoras.setText(aula.getHoras());
                txtCidade.setText(aula.getCidade());
                txtEstado.setText(aula.getEstado());
                txtCep.setText(aula.getCep());
                txtCurso.setText(aula.getCurso());
                txtResumo.setText(aula.getResumo());
            }

            @Override
            public void onFailure(Call<Aula> call, Throwable t) {

            }
        });
    }
}
