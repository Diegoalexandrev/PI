package controller;

import android.content.Context;

import java.util.List;

import database.DatabaseClient;
import model.ProjetoUsuarioVO;
import model.ProjetoVO;
import model.UsuarioVO;

public class UsuarioController {

    private Context context;

    public UsuarioController(Context context) {
        this.context = context;
    }

    public List<ProjetoUsuarioVO> getProjetosUsuarios() {
        return DatabaseClient.getInstance(context).getProjetoDatabase().projetoUsuarioDAO().getAllProjetoUsuarios();
    }

    public List<UsuarioVO> getUsuarios() {
        return DatabaseClient.getInstance(context).getProjetoDatabase().usuarioDAO().getAllUsuarios();
    }

    public List<ProjetoVO> getProjetos() {
        return DatabaseClient.getInstance(context).getProjetoDatabase().projetoDAO().getAllProjetos();
    }
}
