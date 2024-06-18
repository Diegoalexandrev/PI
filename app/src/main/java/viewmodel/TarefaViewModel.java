package viewmodel;

import static androidx.fragment.app.FragmentManager.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import database.DatabaseClient;
import model.ProjetoComIntegrantes;
import model.TarefaComIntegrantes;

public class TarefaViewModel extends AndroidViewModel {

    private LiveData<List<TarefaComIntegrantes>> tarefasComIntegrantes;
    private DatabaseClient databaseClient;
    public TarefaViewModel(@NonNull Application application) {
        super(application);
        databaseClient = DatabaseClient.getInstance(application);
    }
    public LiveData<List<TarefaComIntegrantes>> getTarefasByProjetoId(int projetoId) {
        tarefasComIntegrantes = databaseClient.getProjetoDatabase().tarefaUsuarioDAO().getTarefasByProjetoId(projetoId);
        return tarefasComIntegrantes;
    }

}
