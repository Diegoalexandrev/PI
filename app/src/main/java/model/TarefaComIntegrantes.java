package model;

public class TarefaComIntegrantes {
    private String nomeTarefa;
    private String nomesIntegrantes;

    public TarefaComIntegrantes(String nomeTarefa, String nomesIntegrantes) {
        this.nomeTarefa = nomeTarefa;
        this.nomesIntegrantes = nomesIntegrantes;
    }

    // Getters e Setters
    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getNomesIntegrantes() {
        return nomesIntegrantes;
    }

    public void setNomesIntegrantes(String nomesIntegrantes) {
        this.nomesIntegrantes = nomesIntegrantes;
    }
}
