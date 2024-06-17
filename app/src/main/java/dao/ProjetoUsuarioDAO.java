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

    @Query("SELECT * FROM projeto_usuario")
    List<ProjetoUsuarioVO> getAllProjetoUsuarios();

    @Query("SELECT * FROM projeto_usuario WHERE projeto_id = :projetoId")
    List<ProjetoUsuarioVO> getUsuariosByProjetoId(int projetoId);

    @Query("SELECT * FROM projeto_usuario WHERE usuario_id = :usuarioId")
    List<ProjetoUsuarioVO> getProjetosByUsuarioId(int usuarioId);

    @Query("SELECT * FROM projeto_usuario")
    LiveData<List<ProjetoUsuarioVO>> getAllProjetoUsuariosLiveData();

    @Query("SELECT " +
            "tb_projetos.nome AS nomeProjeto, " +
            "GROUP_CONCAT(tb_usuarios.nome, ', ') AS nomesIntegrantes, " +
            "tb_projetos.progresso, " +
            "tb_projetos.data_vencimento AS dataVencimento " +  // Adicionando a data de vencimento à seleção
            "FROM projeto_usuario " +
            "INNER JOIN tb_projetos ON projeto_usuario.projeto_id = tb_projetos.id " +
            "INNER JOIN tb_usuarios ON projeto_usuario.usuario_id = tb_usuarios.id " +
            "GROUP BY tb_projetos.nome " +
            "ORDER BY tb_projetos.nome")
    LiveData<List<ProjetoComIntegrantes>> getProjetosComIntegrantes();
}

