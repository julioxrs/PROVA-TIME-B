
package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AgendamentoDAO {
    
    private Connection conexao;
    
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
    
}
