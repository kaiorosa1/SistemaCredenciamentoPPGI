/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sistemacredenciamento.connection.DBConnection;
import sistemacredenciamento.model.*;

/**
 *
 * @author Kaio Rosa
 */
public class RegrasPontuacaoDao {

    /* salvarRegras salva regras no banco de dados */
    public void salvarRegras(RegrasPontuacao regras) {
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO RegrasPontuacao(dataInicio, dataFim, listaQualis, multiplicadorPeridicos,quantidadeDeAnosConsiderar, pontuacaoMinimaRecredenciamento)"
                + " VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, (Date) regras.getDataInicio());
            pstm.setDate(2, (Date) regras.getDataFim());
//            pstm.setDate(3, regras.getListaQualis()); how to pass a list as parameter
            pstm.setDouble(4, regras.getMultiplicadorPeridicos());
            pstm.setInt(5, regras.getQuantidadeDeAnosConsiderar());
            pstm.setDouble(6, regras.getPontuacaoMinimaRecredenciamento());
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
    /* listaRegras salva regras do banco de dados em um array*/
    public List<RegrasPontuacao> listarRegras() {
        List<RegrasPontuacao> listaRegras = new ArrayList<>();
        String sql = "SELECT * FROM regras";
        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = DBConnection.conectarMysql();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                RegrasPontuacao regras = new RegrasPontuacao();
                regras.setDataInicio((Date) rset.getDate("dataInicio"));
                regras.setDataFim((Date) rset.getDate("dataFim"));
                //regras.setListaQualis(listaQualis);
                regras.setMultiplicadorPeridicos(rset.getDouble("multiplicadorPeridicos"));
                regras.setQuantidadeDeAnosConsiderar(rset.getInt("quantidadeDeAnosConsiderar"));
                regras.setPontuacaoMinimaRecredenciamento(rset.getInt("pontuacaoMinimaRecredenciamento"));
                // add in the lista regras
                listaRegras.add(regras);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaRegras;

    }
    
}
