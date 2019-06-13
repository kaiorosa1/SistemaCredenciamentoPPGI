package sistemacredenciamento.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import sistemacredenciamento.model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaio Rosa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Read Files and create the objects
       String fileName = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\docentes.csv";
       readDocentes(fileName);
       
       
       
    }
    
    public static void readDocentes(String fName){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        List<Docente> listaDocentes = null;
        
        try {

            br = new BufferedReader(new FileReader(fName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] codigo = line.split(cvsSplitBy);

                System.out.println(codigo[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

