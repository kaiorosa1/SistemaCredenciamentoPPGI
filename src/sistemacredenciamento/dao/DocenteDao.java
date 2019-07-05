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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sistemacredenciamento.connection.DBConnection;
import sistemacredenciamento.model.Docente;

/**
 *
 * @author Kaio Rosa
 */
public class DocenteDao {

    public void salvarDocente(Docente docente) {
        //conectar com o banco de dados aqui
        String sql = "INSERT INTO docente(codigo, nome, dataNascimento, dataIngresso, isCoordenador) VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, docente.getCodigo());
            pstm.setString(2, docente.getNome());
            pstm.setDate(3, (Date) docente.getDataNascimeto());
            pstm.setDate(4, (Date) docente.getDataIngresso());
            pstm.setBoolean(5, docente.isIsCoordenador());
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

    public ArrayList<Docente> listarDocente() {
        //INCOMPLETE
        ArrayList<Docente> listaDocentes = new ArrayList<>();
        String sql = "SELECT * FROM docente";
        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        

        try {
            conn = DBConnection.conectarMysql();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Docente docente = new Docente();
                docente.setCodigo(rset.getInt("codigo"));
                docente.setNome(rset.getString("nome"));
                docente.setDataNascimeto( (Date) rset.getDate("dataNascimento"));
                docente.setDataIngresso((Date) rset.getDate("dataIngresso"));
                docente.setIsCoordenador(rset.getBoolean("isCoordenador"));
                //Adiciono o produto recuperado em uma lista
               
                listaDocentes.add(docente);

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
        
        return listaDocentes;

    }
}
