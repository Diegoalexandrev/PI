package com.a.pi3;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import model.ResponsavelTarefa;
import model.TarefaVO;
import viewmodel.NovaTarefaViewModel;
import viewmodel.TarefaViewModel;

public class NovaTarefaActivity extends AppCompatActivity {

    private static final String TAG = "NovaTarefaActivity";

    private EditText editNomeTarefa;
    private EditText editDataVencimento;
    private NovaTarefaViewModel novaTarefaViewModel;
    private RadioGroup radioGroupResponsaveis;
    private HashMap<String, Integer> responsavelMap;
    private int projetoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criacao_tarefa);

        novaTarefaViewModel = new ViewModelProvider(this).get(NovaTarefaViewModel.class);
        radioGroupResponsaveis = findViewById(R.id.radioGroupResponsaveis);
        responsavelMap = new HashMap<>();


        editDataVencimento = findViewById(R.id.editTextDataVencimento);
        editDataVencimento.setOnClickListener(view -> mostrarData());
        editNomeTarefa = findViewById(R.id.editTextNomeTarefa);

        Button btnSalvarTarefa = findViewById(R.id.buttonSalvarTarefa);
        btnSalvarTarefa.setOnClickListener(v -> salvarTarefa());


        projetoId = getIntent().getIntExtra("PROJETO_ID", -1);
        Log.d(TAG, "Projeto ID recebido: " + projetoId);

        novaTarefaViewModel.getIdsNomesIntegrantes(projetoId).observe(this, new Observer<List<ResponsavelTarefa>>() {
            @Override
            public void onChanged(List<ResponsavelTarefa> responsaveis) {
                updateResponsavelList(responsaveis);
                // Log para verificar os responsáveis retornados
                for (ResponsavelTarefa responsavel : responsaveis) {
                    Log.d(TAG, "Responsável: ID=" + responsavel.getId() + ", Nome=" + responsavel.getNomesIntegrantes());
                }
            }
        });
    }

    private void mostrarData() {
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog seletorDeDataDialog = new DatePickerDialog(this,
                (view, anoSelecionado, mesSelecionado, diaSelecionado) -> {
                    String dataSelecionada = String.format("%02d/%02d/%04d", diaSelecionado, mesSelecionado + 1, anoSelecionado);
                    editDataVencimento.setText(dataSelecionada);
                }, ano, mes, dia);

        seletorDeDataDialog.show();
    }


    private void updateResponsavelList(List<ResponsavelTarefa> responsaveis) {
        radioGroupResponsaveis.removeAllViews();
        responsavelMap.clear();


        for (ResponsavelTarefa responsavel : responsaveis) {
            List<String> idsResponsavel = responsavel.getId();

            for (int i = 0; i < idsResponsavel.size(); i++) {
                String idString = idsResponsavel.get(i);
                int idResponsavel = Integer.parseInt(idString.trim()); // Converte o ID para Integer

                List<String> nomesIntegrantes = responsavel.getNomesIntegrantes();
                String nome = nomesIntegrantes.get(i); // Obtém o nome correspondente

                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(nome.trim());
                radioGroupResponsaveis.addView(radioButton);
                radioButton.setId(idResponsavel);

                responsavelMap.put(nome.trim(), idResponsavel);
            }
        }

        radioGroupResponsaveis.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButtonSelecionado = findViewById(checkedId);
            if (radioButtonSelecionado != null) {
                String nomeResponsavel = radioButtonSelecionado.getText().toString();
                int idResponsavel = responsavelMap.get(nomeResponsavel);
                Toast.makeText(NovaTarefaActivity.this, "ID do Responsável selecionado: " + idResponsavel, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void salvarTarefa() {
        String nomeTarefa = editNomeTarefa.getText().toString().trim();
        String dataVencimento = editDataVencimento.getText().toString().trim();
        int idResponsavelSelecionado = radioGroupResponsaveis.getCheckedRadioButtonId();
        int status = 0;

        if (nomeTarefa.isEmpty() || dataVencimento.isEmpty() || idResponsavelSelecionado == -1) {
            Toast.makeText(this, "Preencha todos os campos e selecione um responsável", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButtonSelecionado = findViewById(idResponsavelSelecionado);
        if (radioButtonSelecionado == null) {
            Toast.makeText(this, "Selecione um responsável válido", Toast.LENGTH_SHORT).show();
            return;
        }
        String nomeResponsavel = radioButtonSelecionado.getText().toString();
        int idResponsavel = responsavelMap.get(nomeResponsavel);

        TarefaViewModel tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);

        TarefaVO novaTarefa = TarefaVO.criarTarefa(nomeTarefa, dataVencimento, status, projetoId, idResponsavel);

        tarefaViewModel.insert(novaTarefa);

        Toast.makeText(this, "Tarefa criada com sucesso", Toast.LENGTH_SHORT).show();

        finish();
    }
}
