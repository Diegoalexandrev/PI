package database;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import dao.ProjetoDAO;
import dao.ProjetoUsuarioDAO;
import dao.TarefaDAO;
import dao.TarefaUsuarioDAO;
import dao.UsuarioDAO;
import model.ProjetoUsuarioVO;
import model.ProjetoVO;
import model.TarefaUsuarioVO;
import model.TarefaVO;
import model.UsuarioVO;

public class CarregaDados {

    private FragmentActivity activity;
    private final ExecutorService executorService;

    public CarregaDados(FragmentActivity activity) {
        this.activity = activity;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void carregarDados() {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("dadosCarregados", Context.MODE_PRIVATE);
        boolean dadosJaCarregados = sharedPreferences.getBoolean("dadosCarregados", false);

        if (!dadosJaCarregados) {
            executorService.execute(() -> {
                ProjetoDatabase db = DatabaseClient.getInstance(activity.getApplicationContext()).getProjetoDatabase();

                UsuarioDAO usuarioDAO = db.usuarioDAO();
                UsuarioVO usuarioVO = UsuarioVO.criarUsuario("Diego", "diego.silva@iesn.edu.br", "senha123", "imagem2");
                UsuarioVO usuarioVO1 = UsuarioVO.criarUsuario("Joao", "joao.pedro@iesn.edu.br", "senha123", "imagem2");
                UsuarioVO usuarioVO2 = UsuarioVO.criarUsuario("Leonardo", "leonardo.pedro@iesn.edu.br", "senha123", "imagem2");
                usuarioDAO.addUsuario(usuarioVO);
                usuarioDAO.addUsuario(usuarioVO1);
                usuarioDAO.addUsuario(usuarioVO2);

                ProjetoDAO projetoDAO = db.projetoDAO();
                ProjetoVO projetoVO = ProjetoVO.criarProjeto("PI 3", 81, "andamento", "24/06/2024");
                ProjetoVO projetoVO1 = ProjetoVO.criarProjeto("PDM", 50, "andamento", "21/07/2024");
                projetoDAO.addProjeto(projetoVO);
                projetoDAO.addProjeto(projetoVO1);

                ProjetoUsuarioDAO projetoUsuarioDAO = db.projetoUsuarioDAO();
                ProjetoUsuarioVO projetoUsuarioVO = ProjetoUsuarioVO.criarProjetoUsuario(1, 1);
                ProjetoUsuarioVO projetoUsuarioVO1 = ProjetoUsuarioVO.criarProjetoUsuario(1, 2);
                ProjetoUsuarioVO projetoUsuarioVO2 = ProjetoUsuarioVO.criarProjetoUsuario(1, 3);
                ProjetoUsuarioVO projetoUsuarioVO3 = ProjetoUsuarioVO.criarProjetoUsuario(2, 2);
                ProjetoUsuarioVO projetoUsuarioVO4 = ProjetoUsuarioVO.criarProjetoUsuario(2, 3);

                projetoUsuarioDAO.addProjetoUsuario(projetoUsuarioVO);
                projetoUsuarioDAO.addProjetoUsuario(projetoUsuarioVO1);
                projetoUsuarioDAO.addProjetoUsuario(projetoUsuarioVO2);
                projetoUsuarioDAO.addProjetoUsuario(projetoUsuarioVO3);
                projetoUsuarioDAO.addProjetoUsuario(projetoUsuarioVO4);

                TarefaDAO tarefaDAO = db.tarefaDAO();
                TarefaVO tarefaVO = TarefaVO.criarTarefa("Adicionar Novos casos de Uso", "18/06/2024", 0, 1, 1);
                TarefaVO tarefaVO1 = TarefaVO.criarTarefa("Criar mais telas no Protótipo", "19/06/2024", 0, 1, 2);
                TarefaVO tarefaVO2 = TarefaVO.criarTarefa("Organizar as Regras de Negócio", "20/06/2024", 0, 1, 3);

                TarefaVO tarefaVO3 = TarefaVO.criarTarefa("Corrigir Bugs", "18/07/2024", 0, 2, 2);
                TarefaVO tarefaVO4 = TarefaVO.criarTarefa("Baixar Android Studio na Máquina do IESB", "09/07/2024", 0, 2, 2);
                TarefaVO tarefaVO5 = TarefaVO.criarTarefa("Adicionar funcionalidades de Login", "13/07/2024", 0, 2, 3);

                tarefaDAO.addTarefa(tarefaVO);
                tarefaDAO.addTarefa(tarefaVO1);
                tarefaDAO.addTarefa(tarefaVO2);
                tarefaDAO.addTarefa(tarefaVO3);
                tarefaDAO.addTarefa(tarefaVO4);
                tarefaDAO.addTarefa(tarefaVO5);

                // Após carregar os dados, marque como carregados
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("dadosCarregados", true);
                editor.apply();
            });
        }
    }
}
