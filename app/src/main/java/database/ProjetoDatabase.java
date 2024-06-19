package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dao.ComentarioDAO;
import dao.ProjetoDAO;
import dao.ProjetoUsuarioDAO;
import dao.TarefaDAO;
import dao.TarefaUsuarioDAO;
import dao.UsuarioDAO;
import model.ComentarioVO;
import model.ProjetoUsuarioVO;
import model.ProjetoVO;
import model.ResponsavelTarefa;
import model.TarefaUsuarioVO;
import model.TarefaVO;
import model.UsuarioVO;


@Database(entities = {UsuarioVO.class, ProjetoVO.class, ProjetoUsuarioVO.class, TarefaVO.class, ComentarioVO.class, TarefaUsuarioVO.class}, version = 10)
public abstract class ProjetoDatabase extends RoomDatabase {
    public abstract UsuarioDAO usuarioDAO();
    public abstract ProjetoDAO projetoDAO();
    public abstract ProjetoUsuarioDAO projetoUsuarioDAO();
    public abstract TarefaDAO tarefaDAO();
    public abstract ComentarioDAO comentarioDAO();
    public abstract TarefaUsuarioDAO tarefaUsuarioDAO();

}
