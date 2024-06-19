package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import model.ProjetoVO;

@Dao
public interface ProjetoDAO {
    @Insert
    void addProjeto(ProjetoVO projeto);

    @Query("SELECT * FROM tb_projetos")
    List<ProjetoVO> getAllProjetos();

    @Query("SELECT * FROM tb_projetos")
    LiveData<List<ProjetoVO>> getAllProjetosLiveData();
}
