package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import model.ProjetoComIntegrantes;
import model.ProjetoUsuarioVO;

@Dao
public interface ProjetoUsuarioDAO {
    @Insert
    void addProjetoUsuario(ProjetoUsuarioVO projetoUsuario);
    @Query("SELECT tb_projetos.id as id, " +
            "tb_projetos.nome AS nomeProjeto, " +
            "GROUP_CONCAT(tb_usuarios.nome, ', ') AS nomesIntegrantes, " +
            "tb_projetos.progresso, " +
            "tb_projetos.data_vencimento AS dataVencimento " +
            "FROM projeto_usuario " +
            "INNER JOIN tb_projetos ON projeto_usuario.projeto_id = tb_projetos.id " +
            "INNER JOIN tb_usuarios ON projeto_usuario.usuario_id = tb_usuarios.id " +
            "GROUP BY tb_projetos.id, tb_projetos.nome " +
            "ORDER BY tb_projetos.nome")
    LiveData<List<ProjetoComIntegrantes>> getProjetosComIntegrantes();
}

