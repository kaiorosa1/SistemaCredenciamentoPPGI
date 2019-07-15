/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.dao;

import java.sql.Connection;
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
public class PublicacaoDao {

    public void salvarPublicacao(Publicacao publicacao) {
        String sql = "INSERT INTO qualis(sigla,pontos) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, publicacao.getAno());
            pstm.setString(2, publicacao.getVeiculoPublicacao().getSigla()); // usar Sigla com foreign key?
            pstm.setString(3, publicacao.getTitulo());
            // lista de docentes (how to save that?)
            pstm.setInt(5, publicacao.getNumero());
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

    public List<Publicacao> listarPublicacao() {

        List<Publicacao> listaPublicacoes = new ArrayList<>();
        String sql = "SELECT * FROM publicacao";
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DBConnection.conectarMysql();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Publicacao publi = new Publicacao();
                publi.setAno(rset.getInt("ano"));
                // continue with the other attributes 
                listaPublicacoes.add(publi);

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

        return listaPublicacoes;

    }
}
