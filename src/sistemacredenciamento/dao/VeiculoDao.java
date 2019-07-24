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
import sistemacredenciamento.model.Veiculo;

/**
 *
 * @author Kaio Rosa
 */
public class VeiculoDao {

    /* salvarVeiculo salva veiculo no banco de dados */
    public void salvarDocente(Veiculo veiculo) {
        // sql query
        String sql = "INSERT INTO veiculo(sigla,nome,tipo,fatorImpacto,issn) VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, veiculo.getSigla());
            pstm.setString(2, veiculo.getNome());
            pstm.setString(3, String.valueOf(veiculo.getTipo()));
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

    /* listarVeiculo salva veiculo do banco de dados em um array*/
    public List<Veiculo> listarVeiculo() {

        List<Veiculo> listaVeiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = DBConnection.conectarMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setSigla(rset.getString("sigla"));
                veiculo.setNome(rset.getString("nome"));
                veiculo.setTipo(rset.getString("tipo").charAt(0));
                veiculo.setFatorDeImpacto(rset.getDouble("fatorImpacto"));
                veiculo.setISSN(rset.getString("issn"));
                // add in the lista veiculos
                listaVeiculos.add(veiculo);
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
