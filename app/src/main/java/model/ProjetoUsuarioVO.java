package model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "projeto_usuario",
        foreignKeys = {
                @ForeignKey(entity = ProjetoVO.class, parentColumns = "id", childColumns = "projeto_id"),
                @ForeignKey(entity = UsuarioVO.class, parentColumns = "id", childColumns = "usuario_id")
        })
public class ProjetoUsuarioVO {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "projeto_id")
    private int projetoId;

    @ColumnInfo(name = "usuario_id")
    private int usuarioId;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Método estático de fábrica para criar instâncias de ProjetoUsuarioVO
    public static ProjetoUsuarioVO criarProjetoUsuario(int projetoId, int usuarioId) {
        ProjetoUsuarioVO projetoUsuarioVO = new ProjetoUsuarioVO();
        projetoUsuarioVO.setProjetoId(projetoId);
        projetoUsuarioVO.setUsuarioId(usuarioId);
        return projetoUsuarioVO;
    }
}
