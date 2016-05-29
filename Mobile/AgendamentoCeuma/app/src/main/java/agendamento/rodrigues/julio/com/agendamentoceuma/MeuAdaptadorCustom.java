package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Júlio on 25/02/2016.
 */
public class MeuAdaptadorCustom extends ArrayAdapter {

    public MeuAdaptadorCustom(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View linha;
        linha = convertView;
        DataHandler treinador;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linha = inflater.inflate(R.layout.celula_lista,parent,false);
            treinador = new DataHandler();
            treinador.textoAgendamento = (TextView) linha.findViewById(R.id.agenda);
            treinador.textoHora = (TextView) linha.findViewById(R.id.hora);
            treinador.textoData = (TextView) linha.findViewById(R.id.data);
            linha.setTag(treinador);
        }else{
            treinador = (DataHandler) linha.getTag();

        }

        MeuFornecedorDados fornecedor;
        fornecedor = (MeuFornecedorDados) this.getItem(position);
        treinador.textoAgendamento.setText(fornecedor.getAgenda());
        treinador.textoHora.setText(fornecedor.getHora());
        treinador.textoData.setText(fornecedor.getData());

        return linha;


    }


    private class DataHandler {
        TextView textoAgendamento;
        TextView textoHora;
        TextView textoData;
    }
}
