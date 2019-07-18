/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio Rosa
 */
public class TesteDBConnection {
   
//     teste se esta conectando com o banco
    public static void testeConnection() throws ClassNotFoundException {
        // TODO code application logic here
        try {
            Connection conn = DBConnection.conectarMysql();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!!");         
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao conectar\n"+ex);
        }
    }
}
