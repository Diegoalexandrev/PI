package model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import model.ProjetoVO;
import model.TarefaVO;
import model.UsuarioVO;

@Entity(tableName = "comentario",
        foreignKeys = {
                @ForeignKey(entity = UsuarioVO.class, parentColumns = "id", childColumns = "usuario_id"),
                @ForeignKey(entity = TarefaVO.class, parentColumns = "id", childColumns = "tarefa_id"),
                @ForeignKey(entity = ProjetoVO.class, parentColumns = "id", childColumns = "projeto_id")
        })

public class ComentarioVO {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "texto")
    private String texto;

    @ColumnInfo(name = "date_time")
    private String dateTime;

    @ColumnInfo(name = "usuario_id")
    private int usuarioId;

    @ColumnInfo(name = "tarefa_id")
    private int tarefaId;

    @ColumnInfo(name = "projeto_id")
    private int projetoId;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(int tarefaId) {
        this.tarefaId = tarefaId;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    // Método estático de fábrica para criar instâncias de ComentarioVO
    public static ComentarioVO criarComentario(String texto, String dateTime, int usuarioId, int tarefaId, int projetoId) {
        ComentarioVO comentario = new ComentarioVO();
        comentario.setTexto(texto);
        comentario.setDateTime(dateTime);
        comentario.setUsuarioId(usuarioId);
        comentario.setTarefaId(tarefaId);
        comentario.setProjetoId(projetoId);
        return comentario;
    }
}
