package model;

public class ComentarioUsuarioVO {
    private String nome;
    private String dataHora;
    private String texto;


    public ComentarioUsuarioVO(String nome, String dataHora, String texto) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
