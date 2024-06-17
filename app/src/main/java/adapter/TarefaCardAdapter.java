package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.a.pi3.R;

import java.util.ArrayList;
import java.util.List;

import model.TarefaComIntegrantes;

public class TarefaCardAdapter extends RecyclerView.Adapter<TarefaCardAdapter.TarefaCardViewHolder> {

    private static final String TAG = "TarefaCardAdapter";

    private Context context;
    private List<TarefaComIntegrantes> tarefasComIntegrantes;

    public TarefaCardAdapter(Context context) {
        this.context = context;
        this.tarefasComIntegrantes = new ArrayList<>(); // Inicializando com uma lista vazia
    }

    public void setTarefasComIntegrantes(List<TarefaComIntegrantes> tarefasComIntegrantes) {
        this.tarefasComIntegrantes = tarefasComIntegrantes;
        notifyDataSetChanged(); // Notifica o RecyclerView que os dados mudaram
    }

    @NonNull
    @Override
    public TarefaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.item_tarefa_card, parent, false);
        return new TarefaCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaCardViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: position = " + position);
        TarefaComIntegrantes tarefaComIntegrantes = tarefasComIntegrantes.get(position);

        holder.textNomeTarefa.setText(tarefaComIntegrantes.getNomeTarefa());
        holder.textIntegrantes.setText("Integrantes: " + tarefaComIntegrantes.getNomesIntegrantes());
        // Aqui você pode adicionar outras informações da tarefa, como data de vencimento e status, se necessário
    }

    @Override
    public int getItemCount() {
        return tarefasComIntegrantes.size();
    }

    public static class TarefaCardViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeTarefa;
        TextView textIntegrantes;

        public TarefaCardViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeTarefa = itemView.findViewById(R.id.textNomeTarefa);
            textIntegrantes = itemView.findViewById(R.id.textIntegrantes);
        }
    }
}
