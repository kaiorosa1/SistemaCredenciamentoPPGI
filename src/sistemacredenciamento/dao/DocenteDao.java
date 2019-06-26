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
import sistemacredenciamento.model.Docente;

/**
 *
 * @author Kaio Rosa
 */
public class DocenteDao {

    public void salvarDocente(Docente docente) {
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO docente(codigo, nome, dataNascimento, dataIngresso, isCordenador) VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, docente.getCodigo());
            pstm.setString(2,docente.getNome());
            pstm.setDate(3, (Date) docente.getDataNacimeto());
            pstm.setDate(4, (Date) docente.getDataIngresso());
            pstm.setBoolean(5,docente.isIsCordenador());
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
