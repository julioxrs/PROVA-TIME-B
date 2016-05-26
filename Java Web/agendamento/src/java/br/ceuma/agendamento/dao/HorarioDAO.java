
package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HorarioDAO {
     private Connection conexao;
    
    
    public void inserir(Horario horario){
        
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "insert into `horario` " + 
                "(`hora_horario`, `data_horario`, `disp_horario`, `id_usuario_agendamento`)" + 
                "values (?,?,?,?)";
                
        try{
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setTime(1, new java.sql.Time(horario.getHora().getTime()));
            stmt.setDate(2, new java.sql.Date(horario.getData().getTime()));
            stmt.setInt(3, horario.getDisponivel());
            
            stmt.execute();
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public List<Horario> buscarDisponiveis(){
        conexao = new ConexaoFactory().getConexao();
        List<Horario> horarios = null;
        
        String sql = "select * from horario where disp_horario=0";
         
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            horarios = new ArrayList<>();
            
            while(rs.next()){
                Horario horario = new Horario();
                horario.setId(rs.getInt("id_horario"));
                horario.setHora(rs.getTime("hora_horario")); // apesar de ser do tipo Time no BD, é possível recuperar o valor já em formato Date
                horario.setData(rs.getDate("data_horario"));
                horario.setDisponivel(rs.getInt("disp_horario"));
                                
                horarios.add(horario);
            }
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return horarios;
        
    }
    
    public List<Horario> buscarTodos(){
        conexao = new ConexaoFactory().getConexao();
        List<Horario> horarios = null;
        
        String sql = "select * from horario";
         
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            horarios = new ArrayList<>();
            
            while(rs.next()){
                Horario horario = new Horario();
                horario.setId(rs.getInt("id_horario"));
                horario.setHora(rs.getTime("hora_horario")); // apesar de ser do tipo Time no BD, é possível recuperar o valor já em formato Date
                horario.setData(rs.getDate("data_horario"));
                horario.setDisponivel(rs.getInt("disp_horario"));
                
                horarios.add(horario);
            }
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return horarios;
        
    }
    
    
}
