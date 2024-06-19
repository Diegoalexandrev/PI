package database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient instance;
    private ProjetoDatabase projetoDatabase;

    private DatabaseClient(Context context) {
        this.context = context;

        // Criação do banco de dados Room
        projetoDatabase = Room.databaseBuilder(context, ProjetoDatabase.class, "GESTAO_PROJETO_DB")
                .fallbackToDestructiveMigration()
                .build();
    }
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    public ProjetoDatabase getProjetoDatabase() {
        return projetoDatabase;
    }

    public void close() {
        if (projetoDatabase != null) {
            projetoDatabase.close();
            projetoDatabase = null;
            instance = null;
        }
    }
}
