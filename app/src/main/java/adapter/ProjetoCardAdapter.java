package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.pi3.R;

import java.util.List;

import model.ProjetoComIntegrantes;

public class ProjetoCardAdapter extends RecyclerView.Adapter<ProjetoCardAdapter.ProjetoCardViewHolder> {

    private List<ProjetoComIntegrantes> projetos;
    private Context context;

    public ProjetoCardAdapter(Context context, List<ProjetoComIntegrantes> projetos) {
        this.context = context;
        this.projetos = projetos;
    }

    public void setProjetos(List<ProjetoComIntegrantes> projetos) {
        this.projetos = projetos;
        notifyDataSetChanged(); // Notifica o RecyclerView para atualizar a exibição
    }

    @NonNull
    @Override
    public ProjetoCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_projeto_card, parent, false);
        return new ProjetoCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjetoCardViewHolder holder, int position) {
        ProjetoComIntegrantes projeto = projetos.get(position);

        holder.textNomeProjeto.setText(projeto.getNomeProjeto());
        holder.textIntegrantes.setText(projeto.getNomesIntegrantes());
        holder.textDataVencimento.setText("Data de Vencimento: " + projeto.getDataVencimento());
        holder.textProgresso.setText("Progresso: " + projeto.getProgresso() + "%");
        // Não utilize holder.textTarefas aqui, isso será tratado no adaptador de tarefas
    }

    @Override
    public int getItemCount() {
        return projetos.size();
    }

    public static class ProjetoCardViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeProjeto;
        TextView textIntegrantes;
        TextView textDataVencimento;
        TextView textProgresso;

        public ProjetoCardViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeProjeto = itemView.findViewById(R.id.textNomeProjeto);
            textIntegrantes = itemView.findViewById(R.id.textIntegrantes);
            textDataVencimento = itemView.findViewById(R.id.textDataVencimento);
            textProgresso = itemView.findViewById(R.id.textProgresso);
        }
    }
}