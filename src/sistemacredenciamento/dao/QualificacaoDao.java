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
import sistemacredenciamento.model.Qualificacao;
import sistemacredenciamento.model.Veiculo;

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
         List<Qualificacao> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * FROM qualificacao";
        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = DBConnection.conectarMysql();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Qualificacao qualificacao = new Qualificacao();
                qualificacao.setAno(rset.getInt("ano"));
                //set Veiculo 
                // set Qualis
                
                // add in the lista veiculos
                listaVeiculos.add(qualificacao);
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
        return listaVeiculos;

    }
    
}
