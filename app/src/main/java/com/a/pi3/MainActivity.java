package com.a.pi3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.ProjetoCardAdapter;
import adapter.TarefaCardAdapter;
import database.CarregaDados;
import model.ProjetoComIntegrantes;
import viewmodel.UsuarioViewModel;

public class MainActivity extends AppCompatActivity {

    private UsuarioViewModel usuarioViewModel;
    private ProjetoCardAdapter adapter; // Ajustando o tipo do adapter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        CarregaDados carregaDados = new CarregaDados(this);
        carregaDados.carregarDados();

        // Inicializando o ViewModel
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        // Inicializando o adapter com uma lista vazia e passando o contexto da MainActivity
        adapter = new ProjetoCardAdapter(this, new ArrayList<>());

        // Configurando o RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Observando as mudanças nos projetos com integrantes
        usuarioViewModel.getProjetosComIntegrantes().observe(this, new Observer<List<ProjetoComIntegrantes>>() {
            @Override
            public void onChanged(List<ProjetoComIntegrantes> projetosComIntegrantes) {
                if (projetosComIntegrantes != null) {
                    adapter.setProjetos(projetosComIntegrantes);
                }
            }
        });
    }
}
