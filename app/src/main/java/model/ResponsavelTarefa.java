package model;

import java.util.Arrays;
import java.util.List;

public class ResponsavelTarefa {
    private  String id;
    private String nomesIntegrantes;
    private String dataVencimento;


    public ResponsavelTarefa(String id, String nomesIntegrantes, String dataVencimento) {
        this.id = id;
        this.nomesIntegrantes = nomesIntegrantes;
        this.dataVencimento = dataVencimento;
    }

    public List<String> getId() {
        String[] idArray = id.split(",");
        return Arrays.asList(idArray);
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getNomesIntegrantes() {
        String[] nomesArray = nomesIntegrantes.split(",");
        return Arrays.asList(nomesArray);
    }

    public void setNomesIntegrantes(String nomesIntegrantes) {
        this.nomesIntegrantes = nomesIntegrantes;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
