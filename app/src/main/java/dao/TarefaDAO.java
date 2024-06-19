package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import model.TarefaVO;

@Dao
public interface TarefaDAO {
    @Insert
    void addTarefa(TarefaVO tarefa);

    @Query("SELECT * FROM tarefa")
    LiveData<List<TarefaVO>> getAllTarefasLiveData();

    @Query("SELECT * FROM tarefa WHERE projeto_id = :projetoId")
    LiveData<List<TarefaVO>> getTarefasByProjetoIdLiveData(int projetoId);

    @Query("SELECT * FROM tarefa WHERE responsavel_id = :responsavelId")
    LiveData<List<TarefaVO>> getTarefasByResponsavelIdLiveData(int responsavelId);

    @Query("SELECT * FROM tarefa WHERE status = :status")
    LiveData<List<TarefaVO>> getTarefasByStatusLiveData(int status);

    @Query("SELECT * FROM tarefa WHERE projeto_id = :projetoId AND status = :status")
    LiveData<List<TarefaVO>> getTarefasByProjetoIdAndStatusLiveData(int projetoId, int status);
}
