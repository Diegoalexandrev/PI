package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

import model.TarefaComIntegrantes;
import model.TarefaUsuarioVO;

@Dao
public interface TarefaUsuarioDAO {

    @Insert
    void addTarefaUsuario(TarefaUsuarioVO tarefaUsuarioVO);

    //Verificar se esta correto

    @Query("SELECT t.id AS id, " +
            "t.nome AS nomeTarefa, " +
            "t.data_vencimento AS dataVencimento, " +
            "t.status AS status, " +
            "u.nome AS nomesResponsavel " +  // Corrigido para nomesResponsavel
            "FROM tarefa AS t " +
            "LEFT JOIN tb_usuarios AS u ON t.responsavel_id = u.id " +  // Faz o join com a tabela tb_usuarios
            "WHERE t.projeto_id = :projetoId")
    LiveData<List<TarefaComIntegrantes>> getTarefasByProjetoId(int projetoId);







}
