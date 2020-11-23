package com.example.armobile.ui.dados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.armobile.R;
import com.example.armobile.adapter.DadosPessoaisAdapter;
import com.example.armobile.models.DadosPessoais;
import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DadosPessoaisFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<DadosPessoais> dadosPessoaisList;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        inicializarDados();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dados_pessoais, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        MaterialButton button = root.findViewById(R.id.buttonVoltar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.nav_home);
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        DadosPessoaisAdapter adapter = new DadosPessoaisAdapter(dadosPessoaisList);
        recyclerView.setAdapter(adapter);
    }

    private void inicializarDados(){
        dadosPessoaisList = new ArrayList<>();

        String dataNascimento = "17/12/1981";
        int idade = calcularIdade(dataNascimento);
        dadosPessoaisList.add(new DadosPessoais("Gilson Joanelo", "gilsonjoanelo@gmail.com", dataNascimento, String.valueOf(idade)));
    }

    private int calcularIdade(String dataNascimento){
        try {
            Date data=new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(data);
            Calendar calendarAtual = Calendar.getInstance();
            int idade = calendarAtual.get(Calendar.YEAR)-calendar.get(Calendar.YEAR);
            calendar.add(Calendar.YEAR, idade);
            if(calendarAtual.before(calendar)){
                idade--;
            }
            return  idade;
        }catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(getActivity(), "Ocoreru uma falha na tentativa de calcular a idade", Toast.LENGTH_LONG).show();
            return 0;
        }
    }
}