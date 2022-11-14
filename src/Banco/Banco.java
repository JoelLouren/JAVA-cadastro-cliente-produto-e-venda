
package Banco;

/**
 *
 * @author Beth
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Banco {
    
    
    
    
    
        private Connection conexao;
    private String mensagem_erro;
    private boolean status_conexao;
    private Statement acesso;
    private ResultSet informacoes;

    public boolean getStatus() {
        return status_conexao;
    }

    public String getMensagemErro() {
        return mensagem_erro;
    }
    
    
    public void conectar(String banco, String usuario, String senha) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+banco;
            conexao = DriverManager.getConnection( url, usuario, senha);
            mensagem_erro = " ERRO 1111 TESTE ";
            status_conexao = true;
        }
        catch ( ClassNotFoundException cnfex )
            { mensagem_erro = "Falha ao ler o driver JDBC:"+cnfex.toString();
              status_conexao = false;
        }
        catch ( SQLException sqlex )
            { mensagem_erro = "BANCO DE DADOS DESCONECTADO ! :"+sqlex.toString();
              status_conexao = false;
        }
        catch ( Exception ex )
            { mensagem_erro = "Outro erro:"+ex.toString();
              status_conexao = false;
        }
    }

    public int manipular(String sql) {
        int result;
        try {
            acesso = conexao.createStatement();
            result = acesso.executeUpdate( sql );
            //System.out.println(sql+" Banco manipular()");
            acesso.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            mensagem_erro = "Erro no código SQL";
            return -1;
        }
    }

    public ResultSet consultar(String sql) {
        
        try {
            acesso = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                               ResultSet.CONCUR_READ_ONLY);
            informacoes = acesso.executeQuery( sql );
            //System.out.println("********************************************"+sql);
            return informacoes;
        }
        catch (SQLException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            mensagem_erro = "Erro no código SQL";
            return null;
        }
    }
    

}
