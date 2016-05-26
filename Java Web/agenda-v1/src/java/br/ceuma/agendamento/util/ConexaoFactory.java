
package br.ceuma.agendamento.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoFactory {
    private final String URL = "jdbc:mysql://localhost/agendamento";
    private final String USUARIO = "ceuma";
    private final String SENHA = "1234";
    
   
    
    public Connection getConexao(){
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(conexao == null)
                conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            
            System.out.println("Conectou! ");
        }catch(SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro do Class.forName: "+ex);
        }
        
        return conexao;
    }
    
    public void fechaConexao(Connection conexao){
        if(conexao != null)
            try{
                conexao.close();
                conexao = null;
                System.out.println("Fechou Conexao! ");
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
    }
    
}
