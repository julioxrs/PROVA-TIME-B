
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.modelo.Horario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

@ViewScoped
@ManagedBean
// classe implementada para o modo selection do DataTable
public class HorarioDataModel extends ListDataModel<Horario>
        implements SelectableDataModel<Horario>{
    
    public HorarioDataModel(){
        
    }
    
    public HorarioDataModel(List<Horario> datas){
        super(datas);
    }
    
    @Override
    public Horario getRowData(String rowKey){
        List<Horario> list = (List<Horario>) getWrappedData();
        
        for(Horario obj:list){
            if (obj.getId().equals(Integer.valueOf(rowKey)))
                return obj;
        }
        
        return null;
    }
    
    @Override
    public Integer getRowKey(Horario obj){
        return obj.getId();
    }
   
}
