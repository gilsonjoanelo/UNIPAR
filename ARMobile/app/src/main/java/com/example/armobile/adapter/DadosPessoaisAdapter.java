package com.example.armobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.armobile.R;
import com.example.armobile.models.DadosPessoais;
import com.example.armobile.models.DadosPessoaisHolder;

import java.util.List;

public class DadosPessoaisAdapter extends RecyclerView.Adapter<DadosPessoaisHolder> {
    private List<DadosPessoais> dadosPessoais;

    public DadosPessoaisAdapter(List<DadosPessoais> dadosPessoais){
        this.dadosPessoais = dadosPessoais;
    }

    @Override
    public int getItemCount() {
        return dadosPessoais.size();
    }

    @NonNull
    @Override
    public DadosPessoaisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dados_pessoais_card, parent,false);
        return new DadosPessoaisHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DadosPessoaisHolder holder, int position) {
        holder.getTextViewNome().setText(dadosPessoais.get(position).getNome());
        holder.getTextViewEmail().setText(dadosPessoais.get(position).getEmail());
        holder.getTextViewDataNascimento().setText(dadosPessoais.get(position).getDataNascimento());
        holder.getTextViewIdade().setText(dadosPessoais.get(position).getIdade());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
