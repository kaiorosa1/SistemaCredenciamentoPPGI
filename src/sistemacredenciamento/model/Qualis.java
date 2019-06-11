/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacredenciamento.model;

/**
 *
 * @author Kaio Rosa
 */
public class Qualis {
    private String siglaQualis;

    public Qualis(String siglaQualis) {
        this.siglaQualis = siglaQualis;
    }

    public String getSiglaQualis() {
        return siglaQualis;
    }

    public void setSiglaQualis(String siglaQualis) {
        this.siglaQualis = siglaQualis;
    }
    
    
    public void setPontuacaoQualis(){
        // solves the issues concerning to calculate the range of points
    }
}
