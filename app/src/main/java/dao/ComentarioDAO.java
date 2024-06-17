package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import model.ComentarioVO;

@Dao
public interface ComentarioDAO {
    @Insert
    void addComentario(ComentarioVO comentario);

    @Query("SELECT * FROM comentario")
    LiveData<List<ComentarioVO>> getAllComentariosLiveData();

    @Query("SELECT * FROM comentario WHERE tarefa_id = :tarefaId")
    LiveData<List<ComentarioVO>> getComentariosByTarefaIdLiveData(int tarefaId);

    @Query("SELECT * FROM comentario WHERE usuario_id = :usuarioId")
    LiveData<List<ComentarioVO>> getComentariosByUsuarioIdLiveData(int usuarioId);

    @Query("SELECT * FROM comentario WHERE id = :comentarioId LIMIT 1")
    LiveData<ComentarioVO> getComentarioByIdLiveData(int comentarioId);
}
