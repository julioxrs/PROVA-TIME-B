
package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    private Connection conexao;
    
    
    public void inserir(Usuario usuario){
        conexao = new ConexaoFactory().getConexao();
        
        String sql = "insert into `usuario` " + 
                "(`nm_usuario`, `tel_usuario`, `cpf_usuario`, `email_usuario`, `senha_usuario`, `tipo_usuario`)" + 
                "values (?,?,?,?,?,?)";
                
        try{
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setInt(6, usuario.getTipoUsuario());
            
            stmt.execute();
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    public List<Usuario> buscar(){
        conexao = new ConexaoFactory().getConexao();
        List<Usuario> usuarios = null;
        
        String sql = "select * from usuario";
         
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            usuarios = new ArrayList<>();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setTelefone( rs.getString("tel_usuario"));
                usuario.setCpf(rs.getString("cpf_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                
                usuarios.add(usuario);
            }
            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return usuarios;
        
    }
    
   
}
