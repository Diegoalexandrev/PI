package model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "tarefausuario",
        primaryKeys = {"tarefaId", "usuarioId"},
        foreignKeys = {
                @ForeignKey(entity = TarefaVO.class, parentColumns = "id", childColumns = "tarefaId"),
                @ForeignKey(entity = UsuarioVO.class, parentColumns = "id", childColumns = "usuarioId")
        })
public class TarefaUsuarioVO {

    @ColumnInfo(name = "tarefaId")
    private int tarefaId;

    @ColumnInfo(name = "usuarioId")
    private int usuarioId;

    public TarefaUsuarioVO(int tarefaId, int usuarioId) {
        this.tarefaId = tarefaId;
        this.usuarioId = usuarioId;
    }

    public int getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(int tarefaId) {
        this.tarefaId = tarefaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public static TarefaUsuarioVO criarTarefaUsuario(int tarefaId, int usuarioId) {
        TarefaUsuarioVO tarefaUsuarioVO = new TarefaUsuarioVO(tarefaId, usuarioId);
        return tarefaUsuarioVO;
    }
}
