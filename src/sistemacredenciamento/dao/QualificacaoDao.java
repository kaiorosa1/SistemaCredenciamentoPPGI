/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import sistemacredenciamento.connection.DBConnection;
import sistemacredenciamento.model.Qualificacao;

/**
 *
 * @author Kaio Rosa
 */
public class QualificacaoDao {
    public void salvarQualificacao(Qualificacao qualificacao){
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO qualificacao(ano,veiculo,qualis) VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, qualificacao.getAno()); 
            // set siglas com foreign key?
            pstm.setString(2, qualificacao.getVeiculoQualificacao().getSigla()); // see this one 
            pstm.setString(3,qualificacao.getQualis().getSiglaQualis()); // see this one
            pstm.execute();

        } catch (Exception e) {

            e.getMessage();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
            }
        }
       
    }
    public List<Qualificacao> listarQualificacao(){
        return null;
    }
}
