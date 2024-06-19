package viewmodel;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

import model.ResponsavelTarefa;
import database.DatabaseClient;

public class NovaTarefaViewModel extends AndroidViewModel {

    private LiveData<List<ResponsavelTarefa>> responsavelTarefa;
    private DatabaseClient databaseClient;

    public NovaTarefaViewModel(@NonNull Application application) {
        super(application);
        databaseClient = DatabaseClient.getInstance(application);

    }
    public LiveData<List<ResponsavelTarefa>> getIdsNomesIntegrantes(int projetoId){
        responsavelTarefa = databaseClient.getProjetoDatabase().tarefaUsuarioDAO().getIdsNomesIntegrantes(projetoId);
        return responsavelTarefa;
    }

}
