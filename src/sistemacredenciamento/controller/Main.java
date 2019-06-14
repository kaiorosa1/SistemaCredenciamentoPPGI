package sistemacredenciamento.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       String docentesFile = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\docentes.csv";
       String veiculosFile = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\veiculos.csv";
       String publicacoesFile = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\publicacoes.csv";
       String qualificacoesFile = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\qualis.csv";
       String regrasFile = "C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCredenciamentoPPGI\\src\\sistemacredenciamento\\regras.csv";
       
       List<Docente> listaDocentes = null;
       List<Veiculo> listaVeiculos = null;
       List<Publicacao> listaPublicacoes = null;
       List<Qualificacao> listaQualificacoes = null;
       RegrasPontuacao regras = null;
       try {
            listaDocentes = readDocentes(docentesFile);
            listaVeiculos = readVeiculos(veiculosFile);
            listaPublicacoes = readPublicacoes(publicacoesFile,listaDocentes, listaVeiculos);
            listaQualificacoes = readQualificacoes(qualificacoesFile, listaVeiculos);
            regras = readRegras(regrasFile,listaQualificacoes);
           
            
        } catch (ParseException e) {
             System.out.println(e.getMessage());
        }
       
       
        //printListaDocente(listaDocentes);
        //printListaVeiculos(listaVeiculos);
        //printListaPublicacoes(listaPublicacoes);
        printListaQualificacoes(listaQualificacoes);
    }
    
    public static List<Docente> readDocentes(String fName) throws ParseException{
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        List<Docente> listaDocentes = new ArrayList<>();
        
        try {

            br = new BufferedReader(new FileReader(fName));
            // header of the file
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] codigo = line.split(cvsSplitBy,'\n');
               
                if(Objects.equals(codigo[4],"X")){
                    listaDocentes.add( new Docente(Long.parseLong(codigo[0]), codigo[1],new SimpleDateFormat("dd/MM/yyyy").parse(codigo[2]),new SimpleDateFormat("dd/MM/yyyy").parse(codigo[3]),true));
                    
                }else{
                    listaDocentes.add( new Docente(Long.parseLong(codigo[0]), codigo[1],new SimpleDateFormat("dd/MM/yyyy").parse(codigo[2]),new SimpleDateFormat("dd/MM/yyyy").parse(codigo[3]),false));
                
                }
            }

        } catch (Exception e) {
             System.out.println( e.getMessage());
            
        } 
        
        return listaDocentes;
    }
    
    public static List<Veiculo> readVeiculos(String fName) throws ParseException{
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        List<Veiculo> listaVeiculos = new ArrayList<>();
        
        try {

            br = new BufferedReader(new FileReader(fName));
            // header of the file
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] codigo = line.split(cvsSplitBy,'\n');
                
                listaVeiculos.add(new Veiculo(codigo[0].trim(),codigo[1].trim(),codigo[2].charAt(0),Double.parseDouble(codigo[3].trim().replace(',', '.')),codigo[4].trim()));
                
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println( e.getMessage());       
        } 
        
        return listaVeiculos;
    }
    
    public static List<Publicacao> readPublicacoes(String fName, List<Docente> ld, List<Veiculo> lv) throws ParseException{
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        List<Publicacao> listaPublicacoes = new ArrayList<>();
        
        try {

            br = new BufferedReader(new FileReader(fName));
            // header of the file
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] codigo = line.split(cvsSplitBy,'\n');
                
                // codigo[0] ano
                int ano = Integer.parseInt(codigo[0].trim());
                
                // codigo[1] sigla veiculo
                Veiculo veiculoPublicacao = lv.get(0);
                // busca veiculo com  a sigla do arquivo de entrada
                for (Veiculo v : lv) {
                    if(v.getSigla().equals(codigo[1].trim())){
                        veiculoPublicacao = v;
                    }
                }
                
                // codigo[2] titulo 
                String titulo = codigo[2].trim();
                
                // codigo[3] codigo autores
                // cria uma lista de autores 
                List<Docente> listaAutores = new ArrayList<>();
                // busca docentes com os codigos dados e adiciona na lista de autores
                String[] listaCodigoAutores;
                
                listaCodigoAutores = codigo[3].trim().split(",");
                
                for (String codAutor : listaCodigoAutores) {
                    // para cada codigo da publicacao encontrar o docente associado
                    for(Docente d : ld){
                        // encontrado o autor adicionar na lista de autores dessa publicacao
                        if(d.getCodigo() == Long.parseLong(codAutor)){
                            listaAutores.add(d);
                        }
                    }
                }
                
                // codigo[4] numero
                int numero = Integer.parseInt(codigo[4]);

                if(veiculoPublicacao.getTipo() == 'P'){
                    
                    // codigo[5] volume  if  tipo veiculo P 
                    int volume = Integer.parseInt(codigo[5]);
                    // codigo[7] pag inicial if  tipo veiculo P
                    int pagInicial = Integer.parseInt(codigo[7]);
                    // codigo[8] pag final if  tipo veiculo P
                    int pagFinal = Integer.parseInt(codigo[8]);
                    listaPublicacoes.add(new Periodico(volume,pagInicial,pagFinal,ano,veiculoPublicacao,titulo,listaAutores,numero));
                
                }else if(veiculoPublicacao.getTipo() == 'C'){
                    
                    // codigo[6] local if tipo veiculo C
                    String local = codigo[6];
                    listaPublicacoes.add(new Conferencia(local,ano,veiculoPublicacao,titulo,listaAutores,numero));
                   
                }
                
                 
                
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());       
        } 
        
        return listaPublicacoes;
    }
    
    public static List<Qualificacao> readQualificacoes(String fName, List<Veiculo> lv) throws ParseException{
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        List<Qualificacao> listaQualificacoes = new ArrayList<>();
        
        try {

            br = new BufferedReader(new FileReader(fName));
            // header of the file
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] codigo = line.split(cvsSplitBy,'\n');
                int ano = Integer.parseInt(codigo[0].trim());
                Veiculo veiculoQualificacao = null;
                for(Veiculo v : lv){
                    if(v.getSigla().equals(codigo[1].trim())){
                        veiculoQualificacao = v;
                    }
                }
                Qualis qualisQualificacao = new Qualis(codigo[2].trim());
                
                listaQualificacoes.add(new Qualificacao(ano,veiculoQualificacao,qualisQualificacao));
            }

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
            
        } 
        
        return listaQualificacoes;
    }
    
    public static RegrasPontuacao readRegras(String fName, List<Qualificacao> lg)throws ParseException{
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        RegrasPontuacao regrasPontuacao = null;
        
        try {

            br = new BufferedReader(new FileReader(fName));
            // header of the file
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] codigo = line.split(cvsSplitBy,'\n');
                
            
            }

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        } 
        
        return regrasPontuacao;
    }
    
    public static void printListaDocente(List<Docente> list){
        
        list.forEach((l) -> {
            System.out.println(l.getNome());
        });
        
    }
    
    public static void printListaVeiculos(List<Veiculo> list){
        
        list.forEach((l) -> {
            System.out.println(l.getSigla() + " "+ l.getNome() + " "+ l.getTipo());
        });
        
    }
    
     public static void printListaPublicacoes(List<Publicacao> list){
        
        list.forEach((l) -> {
            System.out.println(l.getTitulo());
            System.out.println("Autores Publicacao");
            for(Docente d :l.getListaAutores()){
                System.out.println(d.getNome());
            }
        }); 
    }
     public static void printListaQualificacoes(List<Qualificacao> list){
        
        list.forEach((l) -> {
            System.out.println(l.getAno() + " " + l.getVeiculoQualificacao().getNome() +" "+l.getQualis().getSiglaQualis());
        });
        
    }
     
}

