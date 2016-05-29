package br.ceuma.agendamento.dao;

import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.util.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// classe responsável pelo login no sistema
public class LoginDAO {

    private Connection conexao;

    public boolean logar(String email, String senha) {

        boolean podeLogar = false;

        conexao = new ConexaoFactory().getConexao();

        String sql = "select count(*) from usuario where email_usuario=?"
                + " and senha_usuario=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            rs.first();

            if (rs.getInt(1) >= 1) {
                podeLogar = true;
            }

            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return podeLogar;
    }

    public Usuario getDadosUsuario(Usuario usuario) {

        Usuario user = new Usuario();

        conexao = new ConexaoFactory().getConexao();

        String sql = "SELECT * from usuario"
                + " WHERE id_usuario=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, usuario.getId());

            ResultSet rs = stmt.executeQuery();

            rs.first();

            user.setId(rs.getInt("id_usuario"));
            user.setNome(rs.getString("nm_usuario"));
            user.setTelefone(rs.getString("tel_usuario"));
            user.setCpf(rs.getString("cpf_usuario"));
            user.setEmail(rs.getString("email_usuario"));
            user.setSenha(rs.getString("senha_usuario"));
            user.setTipoUsuario(rs.getInt("tipo_usuario"));

            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }

    public boolean logarDadosAluno(Usuario usuario) {

        boolean podeLogar = false;

        conexao = new ConexaoFactory().getConexao();

        String sql = "SELECT *, count(*) as qtde from usuario"
                + " WHERE email_usuario=?"
                + " AND senha_usuario=? AND tipo_usuario=0";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();

            rs.first();
            if (rs.getInt("qtde") >= 1) {
                podeLogar = true;
            }

            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nm_usuario"));
            usuario.setTelefone(rs.getString("tel_usuario"));
            usuario.setCpf(rs.getString("cpf_usuario"));
            usuario.setEmail(rs.getString("email_usuario"));
            usuario.setSenha(rs.getString("senha_usuario"));
            usuario.setTipoUsuario(rs.getInt("tipo_usuario"));

            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return podeLogar;
    }

    //para qualquer tipo de usuario que acesse o sistema
    public boolean logarDadosTodosUsuarios(Usuario usuario) {

        boolean podeLogar = false;

        conexao = new ConexaoFactory().getConexao();

        String sql = "SELECT *, count(*) as qtde from usuario"
                + " WHERE email_usuario=?"
                + " AND senha_usuario=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();

            rs.first();
            if (rs.getInt("qtde") >= 1) {
                podeLogar = true;
            }

            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nm_usuario"));
            usuario.setTelefone(rs.getString("tel_usuario"));
            usuario.setCpf(rs.getString("cpf_usuario"));
            usuario.setEmail(rs.getString("email_usuario"));
            usuario.setSenha(rs.getString("senha_usuario"));
            usuario.setTipoUsuario(rs.getInt("tipo_usuario"));

            stmt.close();
            new ConexaoFactory().fechaConexao(conexao);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return podeLogar;
    }
}
