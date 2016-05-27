
package br.ceuma.agendamento.util;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;


public class DataHoraUtil {
    
    public Date dataAtualBD(){
        return new Date(Calendar.getInstance().getTimeInMillis());
        
    }
    
    public Time horaAtualBD(){
        return new Time(Calendar.getInstance().getTimeInMillis());
    }
    
}
