package model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_usuarios")

public class UsuarioVO {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String foto;

    public UsuarioVO(int id, String nome, String email, String senha, String foto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
    }
    public static UsuarioVO criarUsuario(String nome, String email, String senha, String foto) {
        return new UsuarioVO(0, nome, email, senha, foto); // id inicializado como 0 ou valor padrão
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

