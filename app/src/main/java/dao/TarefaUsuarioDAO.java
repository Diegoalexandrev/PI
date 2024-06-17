package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

import model.TarefaUsuarioVO;
import model.TarefaComIntegrantes;

@Dao
public interface TarefaUsuarioDAO {

    // Inserir um relacionamento entre tarefa e usuário
    @Insert
    void addTarefaUsuario(TarefaUsuarioVO tarefaUsuario);

    // Obter todos os relacionamentos entre tarefas e usuários
    @Query("SELECT * FROM tarefausuario")
    List<TarefaUsuarioVO> getAllTarefaUsuarios();

    // Obter usuários de uma tarefa específica
    @Query("SELECT * FROM tarefausuario WHERE tarefaId = :tarefaId")
    List<TarefaUsuarioVO> getUsuariosByTarefaId(int tarefaId);

    // Obter tarefas de um usuário específico
    @Query("SELECT * FROM tarefausuario WHERE usuarioId = :usuarioId")
    List<TarefaUsuarioVO> getTarefasByUsuarioId(int usuarioId);

    // Obter todos os relacionamentos entre tarefas e usuários como LiveData
    @Query("SELECT * FROM tarefausuario")
    LiveData<List<TarefaUsuarioVO>> getAllTarefaUsuariosLiveData();

    // Obter usuários de uma tarefa específica como LiveData
    @Query("SELECT * FROM tarefausuario WHERE tarefaId = :tarefaId")
    LiveData<List<TarefaUsuarioVO>> getUsuariosByTarefaIdLiveData(int tarefaId);

    // Obter tarefas de um usuário específico como LiveData
    @Query("SELECT * FROM tarefausuario WHERE usuarioId = :usuarioId")
    LiveData<List<TarefaUsuarioVO>> getTarefasByUsuarioIdLiveData(int usuarioId);

    // Deletar um relacionamento específico
    @Delete
    void deleteTarefaUsuario(TarefaUsuarioVO tarefaUsuario);

    // Deletar todos os relacionamentos
    @Query("DELETE FROM tarefausuario")
    void deleteAllTarefaUsuarios();

    // Obter lista de tarefas com os respectivos integrantes
    @Query("SELECT t.nome AS nomeTarefa, GROUP_CONCAT(u.nome, ', ') AS nomesIntegrantes " +
            "FROM tarefa t " +
            "LEFT JOIN tarefausuario tu ON t.id = tu.tarefaId " +
            "LEFT JOIN tb_usuarios u ON tu.usuarioId = u.id " +
            "GROUP BY t.nome")
    LiveData<List<TarefaComIntegrantes>> getTarefasComIntegrantes();
}
