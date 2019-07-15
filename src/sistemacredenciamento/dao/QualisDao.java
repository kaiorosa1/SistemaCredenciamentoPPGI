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
import sistemacredenciamento.model.Qualis;

/**
 *
 * @author Kaio Rosa
 */
public class QualisDao {

    public void salvarQualis(Qualis qualis) {
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO qualis(sigla,pontos) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, qualis.getSiglaQualis());
            pstm.setInt(2, qualis.getPontoQualis());
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

    public List<Qualis> listarQualis() {
        List<Qualis> listaQualis = new ArrayList<>();
        String sql = "SELECT * FROM qualis";
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DBConnection.conectarMysql();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Qualis qualis = new Qualis();
                qualis.setSiglaQualis(rset.getString("sigla"));
                qualis.setPontoQualis(rset.getInt("pontos"));
                listaQualis.add(qualis);

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

        return listaQualis;

    }

}
