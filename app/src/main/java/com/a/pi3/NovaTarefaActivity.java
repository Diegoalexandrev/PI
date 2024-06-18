package com.a.pi3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import model.TarefaVO;
import viewmodel.TarefaViewModel;

public class NovaTarefaActivity extends AppCompatActivity {

    private EditText editNomeTarefa;
    private EditText editDataVencimento;
    private EditText editResponsavel;

    private TarefaViewModel tarefaViewModel;
    private int projetoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criacao_tarefa);

        projetoId = getIntent().getIntExtra("PROJETO_ID", -1);

        editNomeTarefa = findViewById(R.id.editTextNomeTarefa);
        editDataVencimento = findViewById(R.id.editTextDataVencimento);
        editResponsavel = findViewById(R.id.editTextResponsavelId);

        Button btnSalvarTarefa = findViewById(R.id.buttonSalvarTarefa);
        //btnSalvarTarefa.setOnClickListener(v -> salvarTarefa());
    }
/*
    private void salvarTarefa() {
        String nomeTarefa = editNomeTarefa.getText().toString().trim();
        String dataVencimento = editDataVencimento.getText().toString().trim();
        String responsavel = editResponsavel.getText().toString().trim();

        if (nomeTarefa.isEmpty() || dataVencimento.isEmpty() || responsavel.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Criar objeto TarefaVO com os dados inseridos
        TarefaVO novaTarefa = new TarefaVO(nomeTarefa, dataVencimento, projetoId, responsavel);

        // Inserir a nova tarefa usando o ViewModel
        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);
        tarefaViewModel.insert(novaTarefa);

        // Informar ao usuário que a tarefa foi criada
        Toast.makeText(this, "Tarefa criada com sucesso", Toast.LENGTH_SHORT).show();

        // Fechar a atividade e retornar para TarefaActivity
        finish();
    }

 */
}
