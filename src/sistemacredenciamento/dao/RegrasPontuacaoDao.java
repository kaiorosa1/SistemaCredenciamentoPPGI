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
import sistemacredenciamento.model.*;

/**
 *
 * @author Kaio Rosa
 */
public class RegrasPontuacaoDao {
    public void salvarRegras(RegrasPontuacao regras) {
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO RegrasPontuacao(dataInicio, dataFim, listaQualis, multiplicadorPeridicos,quantidadeDeAnosConsiderar, pontuacaoMinimaRecredenciamento)" +
"   VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, (Date) regras.getDataInicio()); 
            pstm.setDate(2, (Date) regras.getDataFim());
//            pstm.setDate(3, regras.getListaQualis()); how to pass a list as parameter
            pstm.setDouble(4,  regras.getMultiplicadorPeridicos());
            pstm.setInt(5,  regras.getQuantidadeDeAnosConsiderar());
            pstm.setDouble(6,  regras.getPontuacaoMinimaRecredenciamento());
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
    
    public List<RegrasPontuacao> listarRegras(){
        return null;
    }
}
