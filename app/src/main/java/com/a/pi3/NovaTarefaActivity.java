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

        // Inicializa a ViewModel
        novaTarefaViewModel = new ViewModelProvider(this).get(NovaTarefaViewModel.class);

        // Inicializa o RadioGroup dos responsáveis
        radioGroupResponsaveis = findViewById(R.id.radioGroupResponsaveis);

        // Inicializa o HashMap
        responsavelMap = new HashMap<>();

        // Configura o DatePickerDialog para o editTextDataVencimento
        editDataVencimento = findViewById(R.id.editTextDataVencimento);
        editDataVencimento.setOnClickListener(view -> showDatePickerDialog());

        // Inicializa o EditText para o nome da tarefa
        editNomeTarefa = findViewById(R.id.editTextNomeTarefa);

        // Configura o listener para o botão salvar
        Button btnSalvarTarefa = findViewById(R.id.buttonSalvarTarefa);
        btnSalvarTarefa.setOnClickListener(v -> salvarTarefa());

        // Obtém o projetoId passado pela intent
        projetoId = getIntent().getIntExtra("PROJETO_ID", -1);
        Log.d(TAG, "Projeto ID recebido: " + projetoId);

        // Observa o LiveData para os responsáveis e atualiza a UI quando houver mudanças
        novaTarefaViewModel.getIdsNomesIntegrantes(projetoId).observe(this, new Observer<List<ResponsavelTarefa>>() {
            @Override
            public void onChanged(List<ResponsavelTarefa> responsaveis) {
                // Atualiza a UI com os responsáveis retornados
                updateResponsavelList(responsaveis);
                // Log para verificar os responsáveis retornados
                for (ResponsavelTarefa responsavel : responsaveis) {
                    Log.d(TAG, "Responsável: ID=" + responsavel.getId() + ", Nome=" + responsavel.getNomesIntegrantes());
                }
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year1);
                    editDataVencimento.setText(selectedDate);
                }, year, month, day);

        datePickerDialog.show();
    }

    private void updateResponsavelList(List<ResponsavelTarefa> responsaveis) {
        radioGroupResponsaveis.removeAllViews(); // Remove qualquer RadioButton existente
        responsavelMap.clear(); // Limpa o HashMap antes de adicionar novos dados

        // Adiciona os RadioButtons ao RadioGroup
        for (ResponsavelTarefa responsavel : responsaveis) {
            List<String> idsResponsavel = responsavel.getId(); // Obtém a lista de IDs em formato de string

            // Adiciona cada nome de integrante como um RadioButton separado
            for (int i = 0; i < idsResponsavel.size(); i++) {
                String idString = idsResponsavel.get(i);
                int idResponsavel = Integer.parseInt(idString.trim()); // Converte o ID para Integer

                List<String> nomesIntegrantes = responsavel.getNomesIntegrantes();
                String nome = nomesIntegrantes.get(i); // Obtém o nome correspondente

                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(nome.trim()); // Define o texto do RadioButton como o nome do integrante
                radioGroupResponsaveis.addView(radioButton);
                radioButton.setId(idResponsavel); // Utiliza o ID do responsável como ID do RadioButton

                // Armazena a relação nome-ID no HashMap
                responsavelMap.put(nome.trim(), idResponsavel);
            }
        }

        // Configura o listener para capturar a escolha do usuário
        radioGroupResponsaveis.setOnCheckedChangeListener((group, checkedId) -> {
            // Lógica para lidar com a seleção do RadioButton
            RadioButton radioButtonSelecionado = findViewById(checkedId);
            if (radioButtonSelecionado != null) {
                String nomeResponsavel = radioButtonSelecionado.getText().toString();
                int idResponsavel = responsavelMap.get(nomeResponsavel);

                Toast.makeText(NovaTarefaActivity.this, "ID do Responsável selecionado: " + idResponsavel, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void salvarTarefa() {
        // Aqui você pode implementar a lógica para salvar a tarefa
        String nomeTarefa = editNomeTarefa.getText().toString().trim();
        String dataVencimento = editDataVencimento.getText().toString().trim();
        int idResponsavelSelecionado = radioGroupResponsaveis.getCheckedRadioButtonId();
        int status = 0;

        if (nomeTarefa.isEmpty() || dataVencimento.isEmpty() || idResponsavelSelecionado == -1) {
            Toast.makeText(this, "Preencha todos os campos e selecione um responsável", Toast.LENGTH_SHORT).show();
            return;
        }

        // Encontrar o RadioButton selecionado
        RadioButton radioButtonSelecionado = findViewById(idResponsavelSelecionado);
        if (radioButtonSelecionado == null) {
            Toast.makeText(this, "Selecione um responsável válido", Toast.LENGTH_SHORT).show();
            return;
        }
        String nomeResponsavel = radioButtonSelecionado.getText().toString();
        int idResponsavel = responsavelMap.get(nomeResponsavel);

        // Exemplo de log para verificar a escolha do usuário
        Log.d(TAG, "Responsável selecionado: ID=" + idResponsavel + ", Nome=" + nomeResponsavel);


        // Exemplo de log para verificar os dados antes de criar a instância de TarefaVO
        Log.d(TAG, "Dados da Tarefa a ser salva:");
        Log.d(TAG, "Nome da Tarefa: " + nomeTarefa);
        Log.d(TAG, "Data de Vencimento: " + dataVencimento);
        Log.d(TAG, "Projeto ID: " + projetoId);
        Log.d(TAG, "Status: " + status);
        Log.d(TAG, "ID do Responsável: " + idResponsavel);

        TarefaViewModel tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);

        // Cria uma nova instância de TarefaVO usando o método estático criarTarefa
        TarefaVO novaTarefa = TarefaVO.criarTarefa(nomeTarefa, dataVencimento, status, projetoId, idResponsavel);


        // Chama o método insert do ViewModel para salvar a nova tarefa
        tarefaViewModel.insert(novaTarefa);

        // Informar ao usuário que a tarefa foi criada
        Toast.makeText(this, "Tarefa criada com sucesso", Toast.LENGTH_SHORT).show();

        // Fechar a atividade e retornar para a TarefaActivity, se necessário
        finish();
    }
}
