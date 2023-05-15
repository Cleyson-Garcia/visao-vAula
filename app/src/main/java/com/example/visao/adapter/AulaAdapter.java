package com.example.visao.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visao.R;
import com.example.visao.activity.AtualizaResumoActivity;
import com.example.visao.activity.AtualizaResumoActivity;
import com.example.visao.api.ApiClient;
import com.example.visao.api.AulaService;
import com.example.visao.model.Aula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AulaAdapter extends RecyclerView.Adapter<AulaAdapter.AulaViewHolder> {

    private final List<Aula> aulas;
    Context context;

    public AulaAdapter(List<Aula> aulas, Context context) {
        this.aulas = aulas;
        this.context = context;
    }

    @NonNull
    @Override
    public AulaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AulaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_aula,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AulaViewHolder holder, int position) {
        holder.getTxtDias().setText(aulas.get(position).getDias());
        holder.getTxtHoras().setText(aulas.get(position).getHoras());
        holder.getTxtCidade().setText(aulas.get(position).getCidade());
        holder.getTxtEstado().setText(aulas.get(position).getEstado());
        holder.getTxtCep().setText(aulas.get(position).getCep());
        holder.getTxtCurso().setText(aulas.get(position).getCurso());
        holder.getTxtResumo().setText(aulas.get(position).getResumo());
        holder.getBtnEditarResumo().setOnClickListener(view -> editar(position));
    }

    private void editar(int position) {
        int id = aulas.get(position).getId();
        Intent i = new Intent(context, AtualizaResumoActivity.class);
        i.putExtra("id",id);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return aulas != null ? aulas.size() : 0;
    }

    public class AulaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtDias;
        private TextView txtHoras;
        private TextView txtCidade;
        private TextView txtEstado;
        private TextView txtCep;
        private TextView txtCurso;
        private TextView txtResumo;
        private ImageButton btnEditarResumo;


        public AulaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDias = (TextView) itemView.findViewById(R.id.txtDias);
            txtHoras = (TextView) itemView.findViewById(R.id.txtHoras);
            txtCidade = (TextView) itemView.findViewById(R.id.txtCidade);
            txtEstado = (TextView) itemView.findViewById(R.id.txtEstado);
            txtCep = (TextView) itemView.findViewById(R.id.txtCep);
            txtCurso = (TextView) itemView.findViewById(R.id.txtCurso);
            txtResumo = (TextView) itemView.findViewById(R.id.txtResumo);
            btnEditarResumo = (ImageButton) itemView.findViewById(R.id.btnEditarResumo);
        }

        public TextView getTxtDias() {
            return txtDias;
        }

        public void setTxtDias(TextView txtDias) {
            this.txtDias = txtDias;
        }

        public TextView getTxtHoras() {
            return txtHoras;
        }

        public void setTxtHoras(TextView txtHoras) {
            this.txtHoras = txtHoras;
        }

        public TextView getTxtCidade() {
            return txtCidade;
        }

        public void setTxtCidade(TextView txtCidade) {
            this.txtCidade = txtCidade;
        }

        public TextView getTxtEstado() {
            return txtEstado;
        }

        public void setTxtEstado(TextView txtEstado) {
            this.txtEstado = txtEstado;
        }

        public TextView getTxtCep() {
            return txtCep;
        }

        public void setTxtCep(TextView txtCep) {
            this.txtCep = txtCep;
        }

        public TextView getTxtCurso() {
            return txtCurso;
        }

        public void setTxtCurso(TextView txtCurso) {
            this.txtCurso = txtCurso;
        }

        public TextView getTxtResumo() {
            return txtResumo;
        }

        public void setTxtResumo(TextView txtResumo) {
            this.txtResumo = txtResumo;
        }

        public ImageButton getBtnEditarResumo() {
            return btnEditarResumo;
        }

        public void setBtnEditarResumo(ImageButton btnEditarResumo) {
            this.btnEditarResumo = btnEditarResumo;
        }
    }
}

