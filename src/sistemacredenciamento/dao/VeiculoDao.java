/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import sistemacredenciamento.connection.DBConnection;
import sistemacredenciamento.model.Veiculo;

/**
 *
 * @author user
 */
public class VeiculoDao {
     public void salvarDocente(Veiculo veiculo) {
        // sql query
        String sql = "INSERT INTO veiculo(sigla,nome,tipo,fatorImpacto,issn) VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, veiculo.getSigla());
            pstm.setString(2,veiculo.getNome());
            pstm.setString(3,String.valueOf(veiculo.getTipo()));
            pstm.setDouble(4, veiculo.getFatorDeImpacto());
            pstm.setString(5, veiculo.getISSN());
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
}
