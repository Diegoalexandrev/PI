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

}
