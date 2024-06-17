package viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import database.DatabaseClient;
import model.ProjetoComIntegrantes;
import model.ProjetoUsuarioVO;
import model.ProjetoVO;
import model.UsuarioVO;

import java.util.List;

public class UsuarioViewModel extends AndroidViewModel {

    private LiveData<List<ProjetoComIntegrantes>> projetosComIntegrantes;

    private DatabaseClient databaseClient;

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        databaseClient = DatabaseClient.getInstance(application);
        projetosComIntegrantes = databaseClient.getProjetoDatabase().projetoUsuarioDAO().getProjetosComIntegrantes();
    }
    public LiveData<List<ProjetoComIntegrantes>> getProjetosComIntegrantes() {
        return projetosComIntegrantes;
    }

}
