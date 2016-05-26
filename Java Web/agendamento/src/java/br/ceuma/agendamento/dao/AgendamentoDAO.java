
package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.modelo.Agendamento;
import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AgendamentoDAO {
    
    private Connection conexao;
            
    public boolean agendar(Agendamento agendamento){
        
        boolean agendado = false;
        
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "UPDATE `horario` " + 
                "SET `id_usuario_agendamento`=? " +
                "WHERE `id_horario`=?";
                
        try{
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, agendamento.getUsuario().getId());
            stmt.setInt(2, agendamento.getHorario().getId());
            
            
            stmt.execute();
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
            agendado = true;
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        return agendado;
        
    }
    
    public boolean agendar(Usuario usuario, Horario horario){
        
        boolean agendado = false;
        
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "UPDATE `horario` " + 
                "SET `id_usuario_agendamento`=? " +
                "WHERE `id_horario`=?";
                
        try{
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, usuario.getId());
            stmt.setInt(2, horario.getId());
            
            
            stmt.execute();
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
            agendado = true;
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        return agendado;
        
    }    
    
    
    public void inserir(Agendamento agendamento){
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "insert into `agendamento` " + 
                "(`id_usuario`, `id_horario`, `aval_agendamento`)" + 
                "values (?,?,?)";
                
        try{
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        
            stmt.setInt(1, agendamento.getUsuario().getId());
            stmt.setInt(2, agendamento.getHorario().getId());
            stmt.setInt(3, agendamento.getAvalicao());
            
            stmt.execute();
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public List<Agendamento> buscar(){
        conexao = new ConexaoFactory().getConexao();
        List<Agendamento> agendamentos = null;
        
        String sql = "select * from agendamento";
         
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            agendamentos = new ArrayList<>();
            
            while(rs.next()){
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("id_agendamento"));
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                agendamento.setUsuario(user);
                Horario horario = new Horario();
                horario.setId(rs.getInt("id_horario"));
                agendamento.setHorario(horario);
                agendamento.setAvalicao(rs.getInt("aval_agendamento"));
                
                agendamentos.add(agendamento);
            }
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return agendamentos;
        
    }
    
}
