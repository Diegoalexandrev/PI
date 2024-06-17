package model;

public class ProjetoComIntegrantes {
    private String nomeProjeto;
    private String nomesIntegrantes;
    private int progresso;
    private String dataVencimento;
    private String listaTarefasIntegrantesFormatada; // String formatada com as tarefas e integrantes

    public ProjetoComIntegrantes(String nomeProjeto, String nomesIntegrantes, int progresso, String dataVencimento, String listaTarefasIntegrantesFormatada) {
        this.nomeProjeto = nomeProjeto;
        this.nomesIntegrantes = nomesIntegrantes;
        this.progresso = progresso;
        this.dataVencimento = dataVencimento;
        this.listaTarefasIntegrantesFormatada = listaTarefasIntegrantesFormatada;
    }

    // Getters e setters

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

    public String getListaTarefasIntegrantesFormatada() {
        return listaTarefasIntegrantesFormatada;
    }

    public void setListaTarefasIntegrantesFormatada(String listaTarefasIntegrantesFormatada) {
        this.listaTarefasIntegrantesFormatada = listaTarefasIntegrantesFormatada;
    }
}
