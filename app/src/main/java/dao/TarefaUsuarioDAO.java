package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

import model.ResponsavelTarefa;
import model.TarefaComIntegrantes;
import model.TarefaUsuarioVO;

@Dao
public interface TarefaUsuarioDAO {

    @Insert
    void addTarefaUsuario(TarefaUsuarioVO tarefaUsuarioVO);
    @Query("SELECT t.id AS id, " +
            "t.nome AS nomeTarefa, " +
            "t.data_vencimento AS dataVencimento, " +
            "t.status AS status, " +
            "u.nome AS nomesResponsavel " +
            "FROM tarefa AS t " +
            "LEFT JOIN tb_usuarios AS u ON t.responsavel_id = u.id " +
            "WHERE t.projeto_id = :projetoId")
    LiveData<List<TarefaComIntegrantes>> getTarefasByProjetoId(int projetoId);

    @Query("SELECT "
            + "GROUP_CONCAT(tb_usuarios.id) AS id, "
            + "GROUP_CONCAT(tb_usuarios.nome, ', ') AS nomesIntegrantes, "
            + "tb_projetos.data_vencimento AS dataVencimento "
            + "FROM projeto_usuario "
            + "INNER JOIN tb_projetos ON projeto_usuario.projeto_id = tb_projetos.id "
            + "INNER JOIN tb_usuarios ON projeto_usuario.usuario_id = tb_usuarios.id "
            + "WHERE tb_projetos.id = :projetoId "
            + "GROUP BY tb_projetos.id, tb_projetos.nome, tb_projetos.data_vencimento "
            + "ORDER BY tb_projetos.nome")

    LiveData<List<ResponsavelTarefa>> getIdsNomesIntegrantes(int projetoId);

}
