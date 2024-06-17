package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a.pi3.R;

import java.util.ArrayList;
import java.util.List;

import model.ProjetoUsuarioVO;

public class ProjetosUsuariosAdapter extends BaseAdapter {

    private Context context;
    private List<ProjetoUsuarioVO> projetosUsuarios;

    public ProjetosUsuariosAdapter(Context context, List<ProjetoUsuarioVO> projetosUsuarios) {
        this.context = context;
        this.projetosUsuarios = (projetosUsuarios != null) ? projetosUsuarios : new ArrayList<>(); // Initialize with empty list if null
    }


    // Retorna o número de itens na lista projetosUsuarios.
    @Override
    public int getCount() {
        return projetosUsuarios.size();
    }

    //Retorna o objeto ProjetoUsuarioVO na posição especificada.
    @Override
    public ProjetoUsuarioVO getItem(int position) {
        return projetosUsuarios.get(position);
    }

    //Retorna o ID do item na posição especificada. Neste caso, retorna a própria posição.
    @Override
    public long getItemId(int position) {
        return position;
    }


    //Este método é responsável por inflar a view de cada item da lista (R.layout.item_projeto_usuario) e preencher os dados correspondentes.
    //Utiliza um padrão de ViewHolder para melhorar a eficiência, minimizando as chamadas para findViewById() através da reutilização de views.
    //Define os textos dos TextViews dentro do item da lista com os dados de ProjetoUsuarioVO.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_projeto_usuario, parent, false);
            holder = new ViewHolder();
            holder.nomeProjeto = view.findViewById(R.id.nomeProjeto);
            holder.nomeUsuario = view.findViewById(R.id.nomeUsuario);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ProjetoUsuarioVO projetoUsuario = getItem(position);

        holder.nomeProjeto.setText("Projeto: " + projetoUsuario.getProjetoId());
        holder.nomeUsuario.setText("Usuário: " + projetoUsuario.getUsuarioId());

        return view;
    }

    //Este método é chamado para atualizar a lista de ProjetoUsuarioVO exibida pelo adaptador.
    //Atualiza a lista interna (this.projetosUsuarios) com a nova lista fornecida como parâmetro
    // e notifica o adaptador (notifyDataSetChanged()) para que a interface do usuário seja atualizada.

    public void atualizarLista(List<ProjetoUsuarioVO> projetosUsuarios) {
        this.projetosUsuarios = projetosUsuarios != null ? projetosUsuarios : new ArrayList<>(); // Ensure non-null list
        notifyDataSetChanged();
    }

    //ma classe interna estática (ViewHolder) que mantém referências aos elementos da interface do item de
    // lista (nomeProjeto e nomeUsuario). Isso otimiza o desempenho ao reciclar views durante o deslocamento da lista.

    static class ViewHolder {
        TextView nomeProjeto;
        TextView nomeUsuario;
    }
}
