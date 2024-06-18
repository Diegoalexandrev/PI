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
import model.TarefaComIntegrantes;
import model.TarefaVO;
import android.util.Log;


public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private List<TarefaComIntegrantes> tarefas;
    private Context context;
    private TarefaAdapter.OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(TarefaComIntegrantes tarefa);
    }

    public TarefaAdapter(List<TarefaComIntegrantes> tarefas, Context context, OnItemClickListener listener) {
        this.tarefas = tarefas;
        this.context = context;
        this.listener = listener;
    }

    public void setTarefas(List<TarefaComIntegrantes> tarefas) {
        this.tarefas = tarefas;
        notifyDataSetChanged(); // Notifica o RecyclerView para atualizar a exibição
    }


    // Este método é chamado quando o RecyclerView precisa criar um novo ViewHolder para exibir um item da lista.
    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarefa_card, parent, false);
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        TarefaComIntegrantes tarefa = tarefas.get(position);

        holder.textNomeTarefa.setText("Tarefa: " + tarefa.getNomeTarefa());
        holder.textDataVencimento.setText("Data de Vencimento: " + tarefa.getDataVencimento());
        holder.textResponsavel.setText("Responsável: " + tarefa.getNomesResponsavel());

    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    // ViewHolder class to hold each item's view
    public static class TarefaViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeTarefa;
        TextView textDataVencimento;
        TextView textResponsavel;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeTarefa = itemView.findViewById(R.id.textNomeTarefa);
            textDataVencimento = itemView.findViewById(R.id.textDataVencimento);
            textResponsavel = itemView.findViewById(R.id.textResponsavel);
        }

        // Bind data to views inside ViewHolder
        public void bind(final TarefaComIntegrantes tarefa, final OnItemClickListener listener) {
            textNomeTarefa.setText(tarefa.getNomesResponsavel());
            textDataVencimento.setText(tarefa.getDataVencimento());
            textResponsavel.setText(tarefa.getNomesResponsavel());
        }
    }







    // Method to update the list of tarefas

}
