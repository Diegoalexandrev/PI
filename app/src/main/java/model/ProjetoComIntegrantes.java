package model;

import androidx.room.PrimaryKey;

public class ProjetoComIntegrantes {

    private int id;
    private String nomeProjeto;
    private String nomesIntegrantes;
    private int progresso;
    private String dataVencimento;

    public ProjetoComIntegrantes(int id, String nomeProjeto, String nomesIntegrantes, int progresso, String dataVencimento) {
        this.id=id;
        this.nomeProjeto = nomeProjeto;
        this.nomesIntegrantes = nomesIntegrantes;
        this.progresso = progresso;
        this.dataVencimento = dataVencimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getNomesIntegrantes() {
        return nomesIntegrantes;
    }

    public void setNomesIntegrantes(String nomesIntegrantes) {
        this.nomesIntegrantes = nomesIntegrantes;
    }
    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
