package database;

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
            ProjetoVO projetoVO = ProjetoVO.criarProjeto("PI 3", 0, "andamento", "2024-12-12");
            ProjetoVO projetoVO1 = ProjetoVO.criarProjeto("PDM", 50, "andamento", "2024-12-12");
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
            TarefaVO tarefaVO = TarefaVO.criarTarefa("Adicionar Novos casos de Uso", "2024-12-12", 0, 1,1);
            TarefaVO tarefaVO1 = TarefaVO.criarTarefa("Criar mais telos no Protótipo", "2024-06-17", 0, 1, 2);
            TarefaVO tarefaVO2 = TarefaVO.criarTarefa("Organizar as Regras de Negócio", "2024-06-18", 0, 1, 3);

            TarefaVO tarefaVO3 = TarefaVO.criarTarefa("Corrigir Bugs", "2024-12-12", 0, 2,2);
            TarefaVO tarefaVO4 = TarefaVO.criarTarefa("Baixar Android Studio na Máquina do IESB", "2024-06-17", 0, 2, 2);
            TarefaVO tarefaVO5 = TarefaVO.criarTarefa("Adicionar funcionalidades de Login", "2024-06-18", 0, 2, 2);

            tarefaDAO.addTarefa(tarefaVO);
            tarefaDAO.addTarefa(tarefaVO1);
            tarefaDAO.addTarefa(tarefaVO2);
            tarefaDAO.addTarefa(tarefaVO3);
            tarefaDAO.addTarefa(tarefaVO4);
            tarefaDAO.addTarefa(tarefaVO5);

            TarefaUsuarioDAO tarefaUsuarioDAO = db.tarefaUsuarioDAO();

            TarefaUsuarioVO tarefaUsuarioVO = TarefaUsuarioVO.criarTarefaUsuario(1, 1);
            TarefaUsuarioVO tarefaUsuarioVO1 = TarefaUsuarioVO.criarTarefaUsuario(1, 2);
            TarefaUsuarioVO tarefaUsuarioVO2 = TarefaUsuarioVO.criarTarefaUsuario(1, 3);
            TarefaUsuarioVO tarefaUsuarioVO3 = TarefaUsuarioVO.criarTarefaUsuario(2, 2);
            TarefaUsuarioVO tarefaUsuarioVO4 = TarefaUsuarioVO.criarTarefaUsuario(2, 3);
            TarefaUsuarioVO tarefaUsuarioVO5 = TarefaUsuarioVO.criarTarefaUsuario(3, 1);

            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO);
            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO1);
            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO2);
            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO3);
            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO4);
            tarefaUsuarioDAO.addTarefaUsuario(tarefaUsuarioVO5);




        });
    }
}
