package dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import model.UsuarioVO;

@Dao
public interface UsuarioDAO {
    @Insert
    void addUsuario(UsuarioVO usuario);

    @Query("SELECT * FROM tb_usuarios")
    LiveData<List<UsuarioVO>> getTodosUsuariosLiveData();
}
