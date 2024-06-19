
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
    private Button btnCriarTarefa;
    private int projetoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarefa_principal);

        projetoId = getIntent().getIntExtra("PROJETO_ID", -1);
        tarefaAdapter = new TarefaAdapter(new ArrayList<>(), this, new TarefaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TarefaComIntegrantes tarefa) {
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

        View informacoesTarefaProjeto = findViewById(R.id.informacoes_tarefa);

        btnCriarTarefa= informacoesTarefaProjeto.findViewById(R.id.btn_criar_tarefa);
        btnCriarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TarefaActivity", "Botão 'Criar nova tarefa' clicado");
                Intent intent = new Intent(TarefaActivity.this, NovaTarefaActivity.class);
                intent.putExtra("PROJETO_ID", projetoId);
                startActivity(intent);
            }
        });
        Button btnFinalizarTarefa = informacoesTarefaProjeto.findViewById(R.id.btn_finalizar_projeto);
        btnFinalizarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TarefaActivity.this, "Ainda não implementado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

