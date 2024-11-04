package com.example.app_disciplinas.ui.disciplinas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_disciplinas.R;
import com.example.app_disciplinas.model.Disciplina;

import java.util.List;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.DisciplinaViewHolder> {

    private List<Disciplina> disciplinas;

    public DisciplinaAdapter(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplinaList(List<Disciplina> novaLista) {
        this.disciplinas = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DisciplinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_disciplina, parent, false);
        return new DisciplinaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaViewHolder holder, int position) {
        Disciplina disciplina = disciplinas.get(position);
        holder.tvNome.setText(disciplina.getNome());
        holder.tvPeriodo.setText(disciplina.getPeriodo() + "º Período");
        holder.ivDificuldade.setImageResource(disciplina.getDificuldade());
    }

    @Override
    public int getItemCount() {
        return disciplinas.size();
    }

    static class DisciplinaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvPeriodo;
        ImageView ivDificuldade;

        public DisciplinaViewHolder(View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvPeriodo = itemView.findViewById(R.id.tvPeriodo);
            ivDificuldade = itemView.findViewById(R.id.ivDificuldade);
        }
    }
}
