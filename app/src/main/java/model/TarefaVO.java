package model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarefa",
        foreignKeys = {
                @ForeignKey(entity = ProjetoVO.class, parentColumns = "id", childColumns = "projeto_id"),
                @ForeignKey(entity = UsuarioVO.class, parentColumns = "id", childColumns = "responsavel_id")
        })
public class TarefaVO {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "data_vencimento")
    private String dataVencimento;

    @ColumnInfo(name = "status")
    private int status; // Alterado para int

    @ColumnInfo(name = "projeto_id")
    private int projetoId;

    @ColumnInfo(name = "responsavel_id")
    private int responsavelId;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getStatus() { // Alterado para int
        return status;
    }

    public void setStatus(int status) { // Alterado para int
        this.status = status;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(int responsavelId) {
        this.responsavelId = responsavelId;
    }

    // Método estático de fábrica para criar instâncias de TarefaVO
    public static TarefaVO criarTarefa(String nome, String dataVencimento, int status, int projetoId, int responsavelId) { // Alterado para int
        TarefaVO tarefa = new TarefaVO();
        tarefa.setNome(nome);
        tarefa.setDataVencimento(dataVencimento);
        tarefa.setStatus(status); // Alterado para int
        tarefa.setProjetoId(projetoId);
        tarefa.setResponsavelId(responsavelId);
        return tarefa;
    }
}
