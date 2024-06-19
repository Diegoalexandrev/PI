
package com.a.pi3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.TarefaAdapter;
import model.ProjetoComIntegrantes;
import model.TarefaComIntegrantes;
import model.TarefaVO;
import viewmodel.TarefaViewModel;

public class TarefaActivity extends AppCompatActivity {

    private TarefaViewModel tarefaViewModel;
    private TarefaAdapter tarefaAdapter;
    private Button btnCreateTask;
    private int projetoId; // Declarar aqui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarefa_principal);

        // Receber o projetoId da Intent
        projetoId = getIntent().getIntExtra("PROJETO_ID", -1); // Atribuir à variável de instância

        tarefaAdapter = new TarefaAdapter(new ArrayList<>(), this, new TarefaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TarefaComIntegrantes tarefa) {
                // Implementar ação de clique
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(tarefaAdapter);

        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);
        tarefaViewModel.getTarefasByProjetoId(projetoId).observe(this, new Observer<List<TarefaComIntegrantes>>() {
            @Override
            public void onChanged(List<TarefaComIntegrantes> tarefaComIntegrantes) {
                if (tarefaComIntegrantes != null) {
                    tarefaAdapter.setTarefas(tarefaComIntegrantes);
                }
            }
        });

        setupCreateTaskButton();
    }

    private void setupCreateTaskButton() {
        // Encontrar o layout que contém o botão
        View informacoesTarefaProjeto = findViewById(R.id.people_buttons_layout);

        // Encontrar o botão dentro do layout informacoes_tarefa_projeto
        btnCreateTask = informacoesTarefaProjeto.findViewById(R.id.btn_create_task);
        btnCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar se o clique no botão é detectado
                Log.d("TarefaActivity", "Botão 'Criar nova tarefa' clicado");

                // Iniciar a NovaTarefaActivity com o projetoId correto
                Intent intent = new Intent(TarefaActivity.this, NovaTarefaActivity.class);
                intent.putExtra("PROJETO_ID", projetoId);
                startActivity(intent);
            }
        });
        Button outroBotao = informacoesTarefaProjeto.findViewById(R.id.btn_finalize_project);
        outroBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação quando o outro botão for clicado
                Toast.makeText(TarefaActivity.this, "Ainda não implementado!", Toast.LENGTH_SHORT).show();

                // Coloque a lógica desejada para este botão aqui
            }
        });
    }
}

