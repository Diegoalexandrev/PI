package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import model.ComentarioUsuarioVO;
import model.ComentarioVO;

@Dao
public interface ComentarioUsuarioDAO {
    @Insert
    void addComentario(ComentarioUsuarioVO comentarioUsuarioVO);
        @Query("SELECT u.nome AS nome, c.date_time AS dataHora, c.texto AS texto " +
            "FROM comentario c " +
            "INNER JOIN tb_usuarios u ON c.usuario_id = u.id " +
            "WHERE c.projeto_id = :projetoId AND c.tarefa_id = :tarefaId")
    LiveData<List<ComentarioUsuarioVO>> getComentariosUsuariosByProjetoETarefa(int projetoId, int tarefaId);
}


