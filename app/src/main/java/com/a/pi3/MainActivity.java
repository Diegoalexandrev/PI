package com.a.pi3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.ProjetoCardAdapter;
import database.CarregaDados;
import model.ProjetoComIntegrantes;
import viewmodel.UsuarioViewModel;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private UsuarioViewModel usuarioViewModel;
    private ProjetoCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        CarregaDados carregaDados = new CarregaDados(this);
        carregaDados.carregarDados();

    }

    @Override
    protected void onStart() {
        super.onStart();

        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
       adapter = new ProjetoCardAdapter(this, new ArrayList<>(), new ProjetoCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProjetoComIntegrantes projeto) {

                //Toast.makeText(MainActivity.this, "Card clicado: " + projeto.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TarefaActivity.class);
                intent.putExtra("PROJETO_ID", projeto.getId());
                startActivity(intent);

                }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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
