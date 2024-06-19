package viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import database.DatabaseClient;
import model.TarefaComIntegrantes;
import model.TarefaVO;

public class TarefaViewModel extends AndroidViewModel {

    private LiveData<List<TarefaComIntegrantes>> tarefasComIntegrantes;
    private DatabaseClient databaseClient;
    private final ExecutorService executorService;

    public TarefaViewModel(@NonNull Application application) {
        super(application);
        databaseClient = DatabaseClient.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<TarefaComIntegrantes>> getTarefasByProjetoId(int projetoId) {
        tarefasComIntegrantes = databaseClient.getProjetoDatabase().tarefaUsuarioDAO().getTarefasByProjetoId(projetoId);
        return tarefasComIntegrantes;
    }

    public void insert(TarefaVO novaTarefa) {
        executorService.execute(() -> {
            try {
                databaseClient.getProjetoDatabase().tarefaDAO().addTarefa(novaTarefa);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
