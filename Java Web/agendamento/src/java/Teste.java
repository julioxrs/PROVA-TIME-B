
import br.ceuma.agendamento.bean.HorarioBean;
import br.ceuma.agendamento.dao.HorarioDAO;
import br.ceuma.agendamento.dao.UsuarioDAO;
import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.util.DataHoraUtil;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author n4010
 */
public class Teste {

    public static void testeUser() {
        Usuario u = new Usuario();
        u.setNome("Aluno");
        u.setTelefone("83764");
        u.setCpf("12445");
        u.setEmail("a@b");
        u.setSenha("123");
        UsuarioDAO ud = new UsuarioDAO();
        ud.inserir(u);
    }

    public static void exemploData() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
        System.out.println("Data brasileira: " + f.format(data));

        f = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Data sem o dia descrito: " + f.format(data));

        f = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data resumida 1: " + f.format(data));

        f = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data resumida 2: " + f.format(data));

    }

    public static void exemploData2() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        Date hora;

        //DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
        //System.out.println("Data brasileira: " + f.format(data));
        String h = new SimpleDateFormat("kk:mm:ss").format(data);
        String d = new SimpleDateFormat("dd/MM/yyyy").format(data);
        
        
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat fmt2 = new SimpleDateFormat("kk:mm:ss");
        
        Date dataUtil;
        java.sql.Date dataSQL;
        java.sql.Time timeSQL;
        try {
            dataUtil = new Date(fmt2.parse(h).getTime());
            timeSQL = new java.sql.Time(fmt2.parse(h).getTime());
            dataSQL = new java.sql.Date(fmt.parse(d).getTime());
        System.out.println("Hora: "+dataUtil);
        } catch (ParseException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hora = new Date();//new SimpleDateFormat().parse(d, new ParsePosition(1));
        //System.out.println("Hora: "+dataSQL);

    }

    public static void testaHorario() {

        Usuario u = new Usuario();
        u.setNome("Aluno");

        UsuarioDAO ud = new UsuarioDAO();
        ud.inserir(u);
    }
    
    public static void listaHorario() {

        /*
        HorarioBean hb = new HorarioBean();
        hb.listar();
        //List<Horario> hlista = hb.getHorarios();
        
        
        System.out.println(hb.getHorarios());
        */
        
        HorarioDAO h = new HorarioDAO();
        List<Horario> hlista = h.buscarDisponiveis();
        //System.out.println(hlista.toString());
        for (Horario hi:hlista)
            System.out.println(hi.getHora());
        /*
        Iterator it = h1.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
*/
    }

    private static void horaAtual() {
        //Date hora = new SimpleDateFormat("kk:mm:ss");//new Date(Calendar.getInstance().getTimeInMillis());
        Date data = new Date(Calendar.getInstance().getTimeInMillis());
        
        DataHoraUtil d = new DataHoraUtil();
        
        //System.out.println("Hora atual: "+hora.getTime());
        System.out.println("Data atual: "+d.dataAtualBD());
        
    }

    public static void main(String[] args) {
        horaAtual();

    }

    
}
