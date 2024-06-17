package model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_projetos")
public class ProjetoVO {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "progresso")
    private int progresso;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "data_vencimento")
    private String dataVencimento;

    public ProjetoVO() {
    }

    // Método estático de fábrica para criar instâncias de ProjetoVO
    public static ProjetoVO criarProjeto(String nome, int progresso, String status, String dataVencimento) {
        ProjetoVO projeto = new ProjetoVO();
        projeto.setNome(nome);
        projeto.setProgresso(progresso);
        projeto.setStatus(status);
        projeto.setDataVencimento(dataVencimento);
        return projeto;
    }

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

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
