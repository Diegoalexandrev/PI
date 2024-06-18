package model;

public class TarefaComIntegrantes {
    private int id;
    private int status;
    private String nomeTarefa;
    private String nomesResponsavel;
    private String dataVencimento;

    public TarefaComIntegrantes(int id, String nomeTarefa, String nomesResponsavel, String dataVencimento, int status) {
        this.id=id;
        this.status=status;
        this.nomeTarefa = nomeTarefa;
        this.nomesResponsavel=nomesResponsavel;
        this.dataVencimento=dataVencimento;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getNomesResponsavel() {
        return nomesResponsavel;
    }

    public void setNomesResponsavel(String nomesResponsavel) {
        this.nomesResponsavel = nomesResponsavel;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
