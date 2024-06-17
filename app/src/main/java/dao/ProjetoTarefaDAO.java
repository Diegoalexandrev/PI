package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import model.TarefaVO;
import model.TarefaUsuarioVO;

@Dao
public interface ProjetoTarefaDAO {

    // Consulta para obter a lista de tarefas e integrantes por projeto
    @Query("SELECT tb_projetos.nome AS nomeProjeto, " +
            "GROUP_CONCAT(t.nome || ' (' || u.nome || ')' , '; ') as listaTarefasIntegrantes " +
            "FROM tb_projetos " +
            "INNER JOIN projeto_usuario pu ON tb_projetos.id = pu.projeto_id " +
            "INNER JOIN tb_usuarios u ON pu.usuario_id = u.id " +
            "LEFT JOIN tarefa t ON tb_projetos.id = t.projeto_id AND u.id = t.responsavel_id " +
            "WHERE tb_projetos.id = :projetoId " +
            "GROUP BY tb_projetos.nome")
    LiveData<List<String>> getTarefasIntegrantesPorProjeto(int projetoId);

    // Inserir uma nova tarefa
    @Insert
    void inserirTarefa(TarefaVO tarefaVO);

    // Inserir uma nova relação entre tarefa e usuário (responsável)
    @Insert
    void inserirTarefaUsuario(TarefaUsuarioVO tarefaUsuarioVO);
}
