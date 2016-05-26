
package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// classe responsável pelo login no sistema
public class LoginDAO {
    
    private Connection conexao;
    
     public boolean logar(String nome, String senha){
                
        boolean podeLogar = false;
        
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "select count(*) from usuario where nm_usuario=?"+
                " and senha_usuario=?";
                
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            rs.first();
                        
            if (rs.getInt(1) >= 1)
                podeLogar = true;                     
          
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return podeLogar;
    }
    
}
