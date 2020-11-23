package com.example.armobile.models;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.armobile.R;
import com.google.android.material.textfield.TextInputEditText;

public class DadosPessoaisHolder extends RecyclerView.ViewHolder {
    private TextInputEditText textViewNome;
    private TextInputEditText textViewEmail;
    private TextInputEditText textViewDataNascimento;
    private TextInputEditText textViewIdade;

    public DadosPessoaisHolder(View view){
        super(view);
        CardView cardView = view.findViewById(R.id.cardView);
        ConstraintLayout constraintLayout = cardView.findViewById(R.id.constraintLayout);
        textViewNome = constraintLayout.findViewById(R.id.textInputLayoutNome).findViewById(R.id.editTextTextNome);
        textViewEmail = constraintLayout.findViewById(R.id.textInputLayoutEmail).findViewById(R.id.editTextTextEmail);
        textViewDataNascimento = constraintLayout.findViewById(R.id.textInputLayoutDataNascimento).findViewById(R.id.editTextTextDataNascimento);
        textViewIdade = constraintLayout.findViewById(R.id.textInputLayoutIdade).findViewById(R.id.editTextTextIdade);
    }

    public TextInputEditText getTextViewNome(){
        return this.textViewNome;
    }

    public TextInputEditText getTextViewEmail(){
        return this.textViewEmail;
    }

    public TextInputEditText getTextViewDataNascimento(){
        return this.textViewDataNascimento;
    }

    public TextInputEditText getTextViewIdade(){
        return this.textViewIdade;
    }
}
