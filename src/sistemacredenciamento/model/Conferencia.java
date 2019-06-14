/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

import java.util.List;

/**
 *
 * @author Kaio Rosa
 */
public class Conferencia extends Publicacao{
     private String localConferencia;

    public Conferencia(String localConferencia, int ano, Veiculo veiculoPublicacao, String titulo, List<Docente> listaAutores, int numero) {
        super(ano, veiculoPublicacao, titulo, listaAutores, numero);
        this.localConferencia = localConferencia;
    }

    
 

    public String getLocalConferencia() {
        return localConferencia;
    }

    public void setLocalConferencia(String localConferencia) {
        this.localConferencia = localConferencia;
    }
}
