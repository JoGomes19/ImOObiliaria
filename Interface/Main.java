package Interface;

import Source.*;
import Exceptions.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.lang.String;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import java.io.*;
import java.io.Console;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Inicialiazação da aplicação, é aqui que todos os Menus da aplicação estão definidos.
 * 
 * 
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 * 
 */
public class Main implements Serializable
{
    public static void main (String[] args){
        
        Imoobiliaria app = new Imoobiliaria();
        try{
        app=app.carregarEstado("backup.obj");
    }
    catch (IOException e){
        System.out.println(e.getMessage());
    }
        
        
        
        //CRIAR SEPARADOR COM CRIAR NOVO UTILIZADOR
        Scanner ler = new Scanner (System.in).useDelimiter("\\n");
        System.out.println("Imobiliaria\n");
        int base=0;
        while (base!=5){
             System.out.println("################## João Gomes      -> a70400 -> LCC\n");
            System.out.println("## Imoobiliaria ## Luis Ventuzelos -> a73002 -> LCC" + "\n");
            System.out.println("################## Paulo Barbosa   -> a70073 -> LCC\n\n\n");
            System.out.println("1 - Login" + "\n");
            System.out.println("2 - Criar Comprador" + "\n");
            System.out.println("3 - Criar Vendedor" + "\n");
            System.out.println("4 - Visitante\n");
            System.out.println("5 - Sair" + "\n");
            System.out.println("Insira uma opção válida:\n");
            base=ler.nextInt();
            switch (base) {
case 1:{
    System.out.println("Login\n");
    System.out.println("E-mail:" + "\n");
    String email;
    email = ler.next();
    System.out.println("\nPalavra-chave:" + "\n");
    String password;
    password=ler.next();
    Utilizador actual;
    try {
        app.iniciaSessao(email,password);
    } catch (SemAutorizacaoException e){
        System.out.println("Email ou password errado");
        break;
    }
        
    actual = app.getUtilizador(email);
    
    //if (actual==null){}
        if (actual!=null){
            System.out.println("\nLogin efectuado com sucesso.\n");
            if(actual instanceof Comprador){ // Comprador //
            //
            int choice=0;
while (choice!=4){
            System.out.println("1 - Pesquisar Imovel" + "\n");
            System.out.println("2 - Minhas informações" + "\n");
            System.out.println("3 - Favoritos\n");
            System.out.println("4 - Sair" + "\n");
            System.out.println("Insira uma opção válida:\n");
            choice=ler.nextInt();
            switch (choice) {
            case 1:{
                int escolha=0;
                 while (escolha!=7){
                System.out.println("######################\n");
                System.out.println("## Pesquisar Imovel ##\n");
                System.out.println("######################\n\n\n");
                System.out.println("Escolha o tipo de Imovel que pretende:\n");
                System.out.println("1 - Moradia" + "\n");
                System.out.println("2 - Apartamento" + "\n");
                System.out.println("3 - Loja" + "\n");
                System.out.println("4 - Terreno" + "\n");
                System.out.println("5 - Pesquisar por ID do imóvel" + "\n");
                System.out.println("6 - Pesquisar todos os imóveis habitáveis" + "\n");
                System.out.println("7 - Sair" + "\n");
                escolha=ler.nextInt();
                switch (escolha) {
                case 1:{  Scanner read = new Scanner (System.in).useDelimiter("\\n"); // Moradia
                    
                     System.out.println("#############\n");
                     System.out.println("## Moradia ##\n");
                     System.out.println("#############\n\n\n");
                     int le = 0;
                      while (le!=7){
                System.out.println("######################\n");
                System.out.println("## Pesquisar Moradia ##\n");
                System.out.println("######################\n\n\n");
                System.out.println("Escolha o tipo de pesquisa:\n");
                System.out.println("1 - Pesquisar por Distrito" + "\n");
                System.out.println("2 - Pesquisar por limite de preço" + "\n");
                System.out.println("3 - Pesquisar por Area Total" + "\n");
                System.out.println("4 - Pesquisar por nº de quartos" + "\n");
                System.out.println("5 - Pesquisar por tipo da moradia" + "\n");
                System.out.println("6 - Pesquisar por ID da moradia" + "\n");
                System.out.println("7 - Sair" + "\n");
                le=read.nextInt();
          
                     switch(le){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    
                                   /* HashMap<Imovel,Vendedor> mapeia = new  HashMap<Imovel,Vendedor>();
                                    mapeia = app.getMapeamentoImoveis();
                                    
                                    i.getID().equals(v.get*/
                                    
                                    novabusca = app.getMoradiaPorDistrito(distrito);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        
                                        /*i.getID() -> busca de ID de imovel
                                        atraves deste id ir buscar mail //do vendedor*/
                                        
                                        
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                           
                                    // Consulta nova = new Consulta(c.getMail());
                                     //app.addConsulta(nova);
                                    
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorPreco(precomax);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorArea(area);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por nº de quartos\n");
                                    System.out.println("Introduza o nº de quartos:\n");
                                    int quartos; 
                                    quartos = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorQuartos(quartos);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de moradia (Geminada / Gaveto / Banda)\n");
                                    System.out.println("Introduza o tipo de moradia:\n");
                                    String tipo; 
                                    tipo = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorTipo(tipo);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 6:{
                                    System.out.println("Procurar por ID de imóvel\n");
                                    System.out.println("Introduza o ID da moradia:\n");
                                    String id; 
                                    id = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorID(id);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta moradia à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    
                    case 7:{
                        break;
                    }
                     
                }
            }
            break;
        }
                     
                case 2:{  Scanner read1 = new Scanner (System.in).useDelimiter("\\n"); // apartamento
                    
                     System.out.println("#################\n");
                     System.out.println("## Apartamento ##\n");
                     System.out.println("#################\n\n\n");
                     
                      int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("## Pesquisar Apartamento ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area Total" + "\n");
                          System.out.println("4 - Pesquisar por nº de quartos" + "\n");
                          System.out.println("5 - Pesquisar por tipo de apartamento" + "\n");
                          System.out.println("6 - Pesquisar por existência de garagem" + "\n");
                          System.out.println("7 - Pesquisar por ID do Apartamento" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read1.nextInt();
                    
              
                    
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorDistrito(distrito);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorPreco(precomax);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorArea(area);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por nº de quartos\n");
                                    System.out.println("Introduza o nº de quartos:\n");
                                    int quartos; 
                                    quartos = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorQuartos(quartos);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo (Simples / Duplex / Triplex)\n");
                                    System.out.println("Introduza o tipo de apartamento:\n");
                                    String tipo; 
                                    tipo = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorTipo(tipo);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de garagem\n");
                                    System.out.println("Introduza Sim para pesquisar apartamentos com garagem \n");
                                    String tipo; 
                                    tipo = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorGaragem(tipo);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID do apartamento\n");
                                    System.out.println("Introduza o ID do apartamento:\n");
                                    String id; 
                                    id = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorID(id);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este apartamento à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read1.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
            break;
        }
                     
                case 3:{  Scanner read2 = new Scanner (System.in).useDelimiter("\\n"); // Loja
                    
                    System.out.println("##########\n");
                    System.out.println("## Loja ##\n");
                    System.out.println("##########\n\n\n");
                    
                    
                              int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("### Pesquisar Loja ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area Total" + "\n");
                          System.out.println("4 - Pesquisar por existência de WC" + "\n");
                          System.out.println("5 - Pesquisar por tipo de loja" + "\n");
                          System.out.println("6 - Pesquisar por existência de zona de habitabilidade" + "\n");
                          System.out.println("7 - Pesquisar por ID da loja" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read2.nextInt();
                    
                         
                    
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorDistrito(distrito);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read2.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorPreco(precomax);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read2.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorArea(area);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por existência de WC\n");
                                    System.out.println("Introduza Sim para procurar lojas com WC:\n");
                                    String wc; 
                                    wc = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorWC(wc);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de negócio\n");
                                    System.out.println("Introduza o tipo de negócio:\n");
                                    String tipo; 
                                    tipo = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorTipo(tipo);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de parte habitacional\n");
                                    System.out.println("Introduza Sim para pesquisar lojas com parte habitacional \n");
                                    String hab; 
                                    hab = read2.next();
                                  
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                   
                                     novabusca = app.getLojaPorHabitabilidade();
                                        
                                    
                                    //novabusca = app.getLojaPorHabitabilidade(novo);
                                     Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                            
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID da loja\n");
                                    System.out.println("Introduza o ID da loja:\n");
                                    String id; 
                                    id = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorID(id);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar esta loja à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read2.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
                     
                     break;
          }
                    
                case 4:{  Scanner read3 = new Scanner (System.in).useDelimiter("\\n"); // Terreno
                     System.out.println("#############\n");
                     System.out.println("## Terreno ##\n");
                     System.out.println("#############\n\n\n");
                     
                     
                     
                  
                   int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("## Pesquisar Terreno ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area" + "\n");
                          System.out.println("4 - Pesquisar por diâmetro da canalização" + "\n");
                          System.out.println("5 - Pesquisar por tipo de terreno" + "\n");
                          System.out.println("6 - Pesquisar por existência de rede elétrica" + "\n");
                          System.out.println("7 - Pesquisar por ID do Terreno" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read3.nextInt();
                    
                         
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorDistrito(distrito);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorPreco(precomax);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorArea(area);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por diâmetro da canalização\n");
                                    System.out.println("Introduza o diâmetro da canalização:\n");
                                    int diam; 
                                    diam = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorDiametro(diam);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de terreno\n");
                                    System.out.println("Introduza o tipo de terreno:\n");
                                    String tipo; 
                                    tipo = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorTipo(tipo);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de rede elétrica\n");
                                    System.out.println("Introduza Sim para pesquisar terrenos com rede elétrica \n");
                                    String rede; 
                                    rede = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    
                                    novabusca = app.getTerrenoPorRedeEletrica(rede);
                                    //novabusca = app.getLojaPorHabitabilidade(novo);
                                     Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                           
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID da loja\n");
                                    System.out.println("Introduza o ID da loja:\n");
                                    String id; 
                                    id = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorID(id);
                                    Comprador c = (Comprador) actual;
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        c.adicionaHistorico(i);
                                        Consulta nova = new Consulta(c.getMail());
                                        app.addConsulta(nova);
                                        System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                                        int resposta;
                                        resposta=read3.nextInt();
                                        switch (resposta) {
                                            case 1:{
                                                    c.adicionaFavorito(i);
                                                }
                                            case 0:{
                                                break;
                                            }
                                        }
                                     }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
                        break;
          }
                
          case 5:{
                  Scanner read39 = new Scanner (System.in).useDelimiter("\\n");
                  System.out.println("Pesquisar por ID do Imovel:\n");
                  System.out.println("Introduza o ID da loja:\n");
                  
                  String id; 
                  id = read39.next();
                  List<Imovel> novabusca = new ArrayList<Imovel>();
                  novabusca = app.getImoveisPorID(id);
                  Comprador c = (Comprador) actual;
                 
                  for(Imovel i : novabusca){
                          System.out.println(i.toString());
                          c.adicionaHistorico(i);
                          Consulta nova = new Consulta(c.getMail());
                          app.addConsulta(nova);
                          System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                          int resposta;
                          resposta=read39.nextInt();
                          switch (resposta) {
                             case 1:{
                                      c.adicionaFavorito(i);
                                     }
                             case 0:{
                                      break;
                                     }
                           }
                  }
                     
                     break;
                  
                  
             
                 }
          
          
          case 6:{Scanner read49 = new Scanner (System.in).useDelimiter("\\n");
                  System.out.println("Pesquisar todos os imóveis habitáveis:\n");
                  System.out.println("Insira o preço limite:\n");
                  
                  int lim; 
                  lim = read49.nextInt();
                  
                  List<Imovel> novabusca = new ArrayList<Imovel>();
                  novabusca = app.getHabitaveis(lim);
                  Comprador c = (Comprador) actual;
                 
                  for(Imovel i : novabusca){
                          System.out.println(i.toString());
                          c.adicionaHistorico(i);
                          Consulta nova = new Consulta(c.getMail());
                          app.addConsulta(nova);
                          System.out.println("Deseja adicionar este terreno à sua lista de favoritos?(1-Adiciona 0-Prossegue)\n");
                          int resposta;
                          resposta=read49.nextInt();
                          switch (resposta) {
                             case 1:{
                                      c.adicionaFavorito(i);
                                     }
                             case 0:{
                                      break;
                                     }
                           }
                  }
                     
                     break;
                  
                  
                 }    
            
                     
           case 7:{System.out.println("\nSaída efectuada com sucesso.\n");
                        
                        break;
                  }
 
                default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                    break;}
        }
    }
    break;
    }
                
        case 2:{
             System.out.println("########################\n");
             System.out.println("## Minhas informações ##\n");
             System.out.println("########################\n\n\n");
             System.out.println(actual.toString());
             int pick=0;
                while (pick!=7){
                
                System.out.println("\nEscolha uma opção:\n");
                System.out.println("1 - Alterar password" + "\n");
                System.out.println("2 - Alterar email" + "\n");
                System.out.println("3 - Alterar Data de nascimento" + "\n");
                System.out.println("4 - Alterar morada" + "\n");
                System.out.println("5 - Historico\n");
                System.out.println("6 - Meu perfil\n");
                System.out.println("7 - Sair" + "\n");
                System.out.println("Insira o número respectivo:" + "\n");
                pick=ler.nextInt();
                
                switch (pick) {
                    case 1:{Scanner read9 = new Scanner (System.in).useDelimiter("\\n");
                
                            System.out.println("Insira a nova password: \n");
                            String newpass;
                            newpass=read9.next();
                            actual.setPassword(newpass);
                            System.out.println("Password alterada com sucesso.\n");
                        
                        break;
                    }
                    
                    
                    case 2:{Scanner read10 = new Scanner (System.in).useDelimiter("\\n");
                            System.out.println("Isira o novo e-mail: \n");
                            String newmail;
                            newmail=read10.next();
                            actual.setMail(newmail);
                            System.out.println("E-mail alterada com sucesso.\n");
                            break;
                    }
                    
                    
                    case 3:{
                         Scanner read11 = new Scanner (System.in).useDelimiter("\\n");
                        
                        System.out.println("Introduza a data de nascimento: (Dia/Mes/Ano) ");
                        String data;
                        String[] dataSplit;
                        int dia, mes, ano;
                        data = read11.next();
                        dataSplit = data.split("/");
        

                        try{
                            dia = Integer.parseInt(dataSplit[0]);               
                            mes = Integer.parseInt(dataSplit[1]);
                            ano = Integer.parseInt(dataSplit[2]);
                            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
                                GregorianCalendar nascimento = new GregorianCalendar(ano, mes, dia);
                                
                                actual.setData(nascimento);
                            }else
                            throw new DataInvalidaException();
                       }catch (DataInvalidaException e) { 
                            System.out.println(e.getMessage());
                        }
                            
                            break;
                    }
                    case 4:{Scanner read12 = new Scanner (System.in).useDelimiter("\\n");
                        System.out.println("Insira a nova morada: \n");
                        String newMorada;
                        newMorada = read12.next();
                        actual.setMorada(newMorada);
                        System.out.println("Morada alterada com sucesso.\n");
                        break;
                    }
                    case 5:{int table=0;
                            System.out.println("HISTÓRICO: \n");
                            Comprador c = (Comprador) actual;
                            ArrayList<Imovel> novo = new ArrayList<Imovel>();
                            novo = c.getHistorico();
                            for(Imovel i : novo){
                                System.out.println(i.toString());
                            }
                         
                        break;
                    }
                    
                    case 6: {
                            System.out.println("O meu perfil: \n");
                            System.out.println(actual.toString());
                                
                    }
                    case 7:{ break;
                    }
                    default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                        break;}
                }
            }
            break;
        }
            
        case 3:{int menuregisto=0;
                 while (menuregisto!=2){
                     System.out.println("###################\n");
                     System.out.println("#### Favoritos ####" + "\n");
                     System.out.println("###################\n\n\n");
                     System.out.println("1 - Ver lista de imóveis favoritos" + "\n");
                     System.out.println("2 - Sair" + "\n"); 
                     
                     System.out.println("Insira uma opção válida:\n");
                  menuregisto=ler.nextInt();
                  switch (menuregisto){
                      case 1:{
                          Comprador c = (Comprador) actual;
                          ArrayList<Imovel> novo = c.getFavoritos();
                          for(Imovel i : novo){
                              System.out.println(i.toString());
                            }
                          
                            break;
      
                      }
                      case 2:{
                          break;
                        }
                 }
                }
               break;
         }
            
         case 4:{  try{
                        app.guardarEstado("backup.obj");
                      }
                    catch (IOException e){
                         System.out.println(e.getMessage());
                        }
    
                  System.out.println("Saída efectuada com sucesso.\n");
                  break;
            }
          
           default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                break;}
            }
        }   
      }
      
      // Comprador //
    }
     
    
    
    
    if(actual instanceof Vendedor){ // Vendedor //
           
            int choice=0;
            while (choice!=6){
            System.out.println("1 - Inserir Imovel" + "\n");
            System.out.println("2 - Minhas informações" + "\n");
            System.out.println("3 - Imóveis em Venda\n");
            System.out.println("4 - Imóveis Vendidos\n");
            System.out.println("5 - Vender Imóvel\n");
            System.out.println("6 - Sair" + "\n");
            System.out.println("Insira uma opção válida:\n");
            choice=ler.nextInt();
            switch (choice) {
            case 1:{
                int escolha=0;
                 while (escolha!=5){
                System.out.println("####################\n");
                System.out.println("## Inserir Imovel ##\n");
                System.out.println("####################\n\n\n");
                System.out.println("Escolha o tipo de imovel que pretende vender:\n");
                System.out.println("1 - Moradia" + "\n");
                System.out.println("2 - Apartamento" + "\n");
                System.out.println("3 - Loja" + "\n");
                System.out.println("4 - Terreno" + "\n");
                System.out.println("5 - Sair" + "\n");
                escolha=ler.nextInt();
                switch (escolha) {
                case 1:{  Scanner readV = new Scanner (System.in).useDelimiter("\\n"); // Moradia
                    
                     System.out.println("#############\n");
                     System.out.println("## Moradia ##\n");
                     System.out.println("#############\n\n\n");
                     
                     System.out.println("Digite um ID:\n");
                     String id; 
                     id=readV.next();
                     
                     System.out.println("Tipo (geminada,banda,gaveto):\n");
                     String tipo; 
                     tipo=readV.next();
                     
                     System.out.println("Distrito:\n");
                     String distrito; 
                     distrito = readV.next();

                     System.out.println("Rua:\n");
                     String rua; 
                     rua = readV.next();
                     
                     System.out.println("Preço pedido:\n");
                     int pedido; 
                     pedido = readV.nextInt();
                     
                     System.out.println("Preço minimo:\n");
                     int minimo; 
                     minimo = readV.nextInt();
                     
                     if(minimo > pedido){
                          System.out.println("O preço minimo não pode ser superior ao preço pedido\n");
                          System.out.println("Introduza novamente os dados:\n");
                          System.out.println("Preço pedido:\n");
                          pedido = readV.nextInt();
                     
                          System.out.println("Preço minimo:\n");
                          minimo = readV.nextInt();
                        }
                          
                     
                     System.out.println("Estado da habitação: (Em Venda / Reservado / Vendido)\n");
                     String estado; 
                     estado = readV.next();
                    
                     System.out.println("Área de implantação (m^2):\n");
                     int areaImplantacao;
                     areaImplantacao = readV.nextInt();
                     
                     System.out.println("Área total coberta (m^2):\n");
                     int areatotalcoberta;
                     areatotalcoberta = readV.nextInt();
                     
                     System.out.println("Área do terreno envolvente (m^2):\n");
                     int areaterreno;
                     areaterreno = readV.nextInt();
                     
                     if(!(areaImplantacao == (areatotalcoberta+areaterreno))){
                          System.out.println("A soma das áreas não coincidem com a área total\n");
                          System.out.println("Introduza novamente os dados:\n");
                          
                          System.out.println("Área de implantação (m^2):\n");
                         areaImplantacao = readV.nextInt();
                         
                         System.out.println("Área total coberta (m^2):\n");
                         areatotalcoberta = readV.nextInt();
                         
                         System.out.println("Área do terreno envolvente (m^2):\n");
                         areaterreno = readV.nextInt();
                        }
                     
                     System.out.println("Numero de quartos:\n");
                     int quartos;
                     quartos =readV.nextInt();
                     
                     System.out.println("Numero de WC's:\n");
                     int wcs;
                     wcs =readV.nextInt();
                     
                     System.out.println("Numero da porta:\n");
                     int num;
                     num =readV.nextInt();
                     //FALTA LANÇAR UMA EXCEPTION NO TRY A SEGUIR
                     Moradia nova = new Moradia(id,rua,pedido,minimo,distrito,estado,tipo,areaImplantacao,
                                    areatotalcoberta,areaterreno,quartos,wcs,num);
                     Vendedor vendedor = (Vendedor) actual;
                     
                     /* try{
                          nova.verificaArea(areaImplantacao,areatotalcoberta,areaterreno);
                        }
                     catch(AreaErradaException e){
                         System.out.println("Dados errados relativamente à area\n");
                     }
                     
                     
                     try{
                          nova.verificaPreco(pedido,minimo);
                        }
                     catch(PrecoMinimoException e){
                         System.out.println("O preço minimo não pode ser superior ao preço pedido\n");
                     }*/
                     
                     
                 
                     
                     
                     app.addMailInImoo(email);
                     try {
                            app.registaImovel(nova);
                            vendedor.addImovel(nova);
                         } 
                     catch (SemAutorizacaoException e){
                            System.out.println("Não tem autorização\n");
                            //e.getMessage();
                     }
                     catch (ImovelExisteException e){
                            System.out.println("O imóvel ja esta registado\n");
                            //e.getMessage();
                        }
                     
                     break;
                    }
                     
                case 2:{  Scanner readV1 = new Scanner (System.in).useDelimiter("\\n"); // apartamento
                    
                     System.out.println("#################\n");
                     System.out.println("## Apartamento ##\n");
                     System.out.println("#################\n\n\n");
                     
                     System.out.println("Digite um ID:\n");
                     String id; 
                     id=readV1.next();
                     
                     System.out.println("Rua:\n");
                     String rua; 
                     rua = readV1.next();
                     
                     System.out.println("Preço pedido:\n");
                     int pedido; 
                     pedido = readV1.nextInt();
                     
                     System.out.println("Preço minimo:\n");
                     int minimo; 
                     minimo = readV1.nextInt();
                     
                      if(minimo > pedido){
                          System.out.println("O preço minimo não pode ser superior ao preço pedido\n");
                          System.out.println("Introduza novamente os dados:\n");
                          System.out.println("Preço pedido:\n");
                          pedido = readV1.nextInt();
                     
                          System.out.println("Preço minimo:\n");
                          minimo = readV1.nextInt();
                        }
                     
                     System.out.println("Estado da habitação: (Em Venda / Reservado / Vendido)\n");
                     String estado; 
                     estado = readV1.next();
                     
                     System.out.println("Tipo (simples, duplex, triplex): \n");
                     String tipo;
                     tipo = readV1.next();
                     
                     System.out.println("Área total (m^2):\n");
                     int area;
                     area = readV1.nextInt();
                     
                     System.out.println("Numero de quartos:\n");
                     int quartos;
                     quartos =readV1.nextInt();
                     
                     System.out.println("Numero de WC's:\n");
                     int wcs;
                     wcs =readV1.nextInt();
                     
                     System.out.println("Numero da porta:\n");
                     int porta;
                     porta =readV1.nextInt();
                     
                     System.out.println("Andar:\n");
                     int andar;
                     andar =readV1.nextInt();
                     
                     System.out.println("Garagem ? Sim/Não\n");
                     String garagem;
                     garagem = readV1.next();
                     
                     
                     System.out.println("Distrito:\n");
                     String distrito; 
                     distrito = readV1.next();
              
                     
                     Apartamento novo = new Apartamento(id,rua,pedido,minimo,distrito,estado,tipo,area,quartos,wcs,porta,andar,garagem);
                     Vendedor vendedor = (Vendedor) actual;
                    
                    
                     app.addMailInImoo(email);
                     try {
                            app.registaImovel(novo);
                            vendedor.addImovel(novo);
                         } 
                     catch (SemAutorizacaoException e){
                            System.out.println("Não tem autorização\n");
                     }
                     catch (ImovelExisteException e){
                            System.out.println("O imóvel ja esta registado\n");
                            
                        }
                     
                     break;
                    }
                     
                case 3:{  Scanner readV2 = new Scanner (System.in).useDelimiter("\\n"); // Loja
                    
                    System.out.println("##########\n");
                    System.out.println("## Loja ##\n");
                    System.out.println("##########\n\n\n");
                    
                     System.out.println("Digite um ID:\n");
                     String id; 
                     id=readV2.next();
                     
                     System.out.println("Rua:\n");
                     String rua; 
                     rua = readV2.next();
                     
                     System.out.println("Preço pedido:\n");
                     int pedido;
                     pedido = readV2.nextInt();

                     
                     System.out.println("Preço minimo:\n");
                     int minimo; 
                     minimo = readV2.nextInt();
                     
                      if(minimo > pedido){
                          System.out.println("O preço minimo não pode ser superior ao preço pedido\n");
                          System.out.println("Introduza novamente os dados:\n");
                          System.out.println("Preço pedido:\n");
                          pedido = readV2.nextInt();
                     
                          System.out.println("Preço minimo:\n");
                          minimo = readV2.nextInt();
                        }
                     
                     System.out.println("Estado da habitação: (Em Venda / Reservado / Vendido)\n");
                     String estado; 
                     estado = readV2.next();
                     
                     System.out.println("Habitavel ? Sim/Não\n");
                     String habit;
                     habit = readV2.next();
                     
                     
                        
                     System.out.println("Área (m^2):\n");
                     int area;
                     area = readV2.nextInt();
                     
                     System.out.println("WC ? Sim/Não\n");
                     String wc;
                     wc = readV2.next();
                     
                     System.out.println("Tipo de negocio:\n");
                     String tipo;
                     tipo = readV2.next();
                     
                     System.out.println("Numero da porta:\n");
                     int porta; 
                     porta = readV2.nextInt();
                     
                     System.out.println("Distrito:\n");
                     String distrito; 
                     distrito = readV2.next();

                    if(habit.equals("Sim") || habit.equals("SIM") || habit.equals("sim")){
                      System.out.println("Número de quartos:\n");
                      int quartos; 
                      quartos = readV2.nextInt();
                     
                      System.out.println("Número de WC's:\n");
                      int wcs; 
                      wcs = readV2.nextInt();
                      
                      System.out.println("Garagem:\n");
                      String garagem; 
                      garagem = readV2.next();
                     
                      System.out.println("Tipo de Apartamento(simples, duplex, triplex):\n");
                      String type; 
                      type = readV2.next();
                      
                      
                      
                      LojaHabitavel lojahab = new LojaHabitavel(id,rua,pedido,minimo,estado,distrito,area,wc,porta,tipo,habit,wcs,quartos,garagem,type);
                       Vendedor vendedor = (Vendedor) actual;
                    
 
                     app.addMailInImoo(email);
                     try {
                            app.registaImovel(lojahab);
                            vendedor.addImovel(lojahab);
                         } 
                     catch (SemAutorizacaoException e){
                            System.out.println("Não tem autorização\n");
                     }
                     catch (ImovelExisteException e){
                            System.out.println("O imóvel ja esta registado\n");
                        }
                     
                     break;
                    }
                      
                
                     else{
                     Loja loja = new Loja(id,rua,pedido,minimo,distrito,estado,area,wc,porta,tipo,habit);
                     
                     Vendedor vendedor = (Vendedor) actual;
                    
 
                     app.addMailInImoo(email);
                     try {
                            app.registaImovel(loja);
                            vendedor.addImovel(loja);
                         } 
                     catch (SemAutorizacaoException e){
                            System.out.println("Não tem autorização\n");
                     }
                     catch (ImovelExisteException e){
                            System.out.println("O imóvel ja esta registado\n");
                        }
                     
                  
                    }
                 
                     break;
                    }
                    
                case 4:{  Scanner readV3 = new Scanner (System.in).useDelimiter("\\n"); // Terreno
                     System.out.println("#############\n");
                     System.out.println("## Terreno ##\n");
                     System.out.println("#############\n\n\n");
                     
                     System.out.println("Digite um ID:\n");
                     String id; 
                     id=readV3.next();
                     
                     System.out.println("Rua:\n");
                     String rua; 
                     rua = readV3.next();
                     
                     System.out.println("Preço pedido:\n");
                     int pedido; 
                     pedido = readV3.nextInt();
                     
                     System.out.println("Preço minimo:\n");
                     int minimo; 
                     minimo = readV3.nextInt();
                     
                      if(minimo > pedido){
                          System.out.println("O preço minimo não pode ser superior ao preço pedido\n");
                          System.out.println("Introduza novamente os dados:\n");
                          System.out.println("Preço pedido:\n");
                          pedido = readV3.nextInt();
                     
                          System.out.println("Preço minimo:\n");
                          minimo = readV3.nextInt();
                        }
                     
                     System.out.println("Estado da habitação: (Em Venda / Reservado / Vendido)\n");
                     String estado; 
                     estado = readV3.next();
                 
                     System.out.println("Tipo (Habitação ou Armazém):\n");
                     String tipo;
                     tipo = readV3.next();
                     
                     System.out.println("Área Total (m^2):\n");
                     int area;
                     area = readV3.nextInt();
                     
                     System.out.println("Rede Elétrica (Sim/Não):\n");
                     String rede;
                     rede = readV3.next();
                     
                     System.out.println("Capacidade máxima da rede (kw/h): (0 caso não tenha rede elétrica)\n");
                     double m;
                     m = readV3.nextDouble();
                        
                     
                     System.out.println("Diâmetro da canalização (mm):\n");
                     double d;
                     d = readV3.nextDouble();
                     
                     System.out.println("Distrito:\n");
                     String distrito; 
                     distrito = readV3.next();
                     
                     Terreno novo = new Terreno(id,rua,pedido,minimo,distrito,estado,area,d,rede,m,tipo);
                    
                     Vendedor vendedor = (Vendedor) actual;
                     
                     app.addMailInImoo(email);
                     try {
                            app.registaImovel(novo);
                            vendedor.addImovel(novo);
                         } 
                     catch (SemAutorizacaoException e){
                            System.out.println("Não tem autorização\n");
                     }
                     catch (ImovelExisteException e){
                            System.out.println("O imóvel ja esta registado\n");
                        
                        }
                   
                     break;
                    }
                case 5:{System.out.println("\nSaída efectuada com sucesso.\n");
                        //System.out.println("\nOLA\n");
                        break;
                        }
 
                default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                    break;}
        }
    }
    break;
    }
                
        case 2:{
             System.out.println("########################\n");
             System.out.println("## Minhas informações ##\n");
             System.out.println("########################\n\n\n");
             System.out.println(actual.toString());
             int pick=0;
                while (pick!=8){
                
                System.out.println("\nEscolha uma opção:\n");
                System.out.println("1 - Alterar password" + "\n");
                System.out.println("2 - Alterar email" + "\n");
                System.out.println("3 - Alterar Data de nascimento" + "\n");
                System.out.println("4 - Alterar morada" + "\n");
                System.out.println("5 - Ver consultas" + "\n");
                System.out.println("6 - Meu perfil" + "\n");
                System.out.println("7 - Alterar o estado de um imóvel para reservado" + "\n");
                System.out.println("8 - Sair" + "\n");
                System.out.println("Insira o número respectivo:" + "\n");
                pick=ler.nextInt();
                
                switch (pick) {
                    case 1:{Scanner read9 = new Scanner (System.in).useDelimiter("\\n");
                 
                            System.out.println("Insira a nova password): \n");
                            String newpass;
                            newpass=read9.next();
                            actual.setPassword(newpass);
                            System.out.println("Password alterada com sucesso.\n");
                        //}
                        
                        break;
                    }
                    
                    
                    case 2:{Scanner read10 = new Scanner (System.in).useDelimiter("\\n");
                            System.out.println("Insira o novo e-mail: \n");
                            String newmail;
                            newmail=read10.next();
                            actual.setMail(newmail);
                            System.out.println("E-mail alterada com sucesso.\n");
                            break;
                    }
                    
                    
                    case 3:{
                        Scanner read11 = new Scanner (System.in).useDelimiter("\\n");
                        
                        System.out.println("Introduza a data de nascimento: (Dia/Mes/Ano) ");
                        String data;
                        String[] dataSplit;
                        int dia, mes, ano;
                        data = read11.next();
                        dataSplit = data.split("/");
        

                        try{
                            dia = Integer.parseInt(dataSplit[0]);               
                            mes = Integer.parseInt(dataSplit[1]);
                            ano = Integer.parseInt(dataSplit[2]);
                            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
                                GregorianCalendar nascimento = new GregorianCalendar(ano, mes, dia);
                                
                                actual.setData(nascimento);
                            }else
                            throw new DataInvalidaException();
                       }catch (DataInvalidaException e) { 
                            System.out.println(e.getMessage());
                        }
                            
                        break;
                    }
                    case 4:{Scanner read12 = new Scanner (System.in).useDelimiter("\\n");
                        System.out.println("Insira a nova morada: \n");
                        String newMorada;
                        newMorada = read12.next();
                        actual.setMorada(newMorada);
                        System.out.println("Morada alterada com sucesso.\n");
                        break;
                    }
                    
                    case 5: {
                            System.out.println("Consulta de Imóveis: \n");
                            List<Consulta> nova = new ArrayList<Consulta>();
                           
                            
                            try{
                            nova = app.getConsultas();
                            for(Consulta cs : nova){
                                System.out.println(cs.toString());
                            }
                        
                       }
                       catch(SemAutorizacaoException e){
                           System.out.println("O imóvel que pretende apagar não existe!\n");
                        }
                            
                            
                           
                                
                            
                       break;         
                    }
                    
                    case 6: {
                            System.out.println("O meu perfil: \n");
                            System.out.println(actual.toString());
                                break;
                    }
                    case 7: {
                            System.out.println("Alterar o estado de um imóvel para reservado \n");
                            System.out.println("Digite o ID do imóvel" + "\n");
                        Scanner readVenda = new Scanner (System.in).useDelimiter("\\n");
                        List<Imovel> nova = new ArrayList<Imovel>();
                        String ID;
                        ID = readVenda.next();
                        Vendedor v = (Vendedor)actual;
                        nova=v.getEmVenda();
                        for (Imovel i: nova){
                            if (i.getID().equals(ID)){
                                i.setEstado("Reservado");
                            }
                        }
                        break;
                    }
                    
                   
                    case 8:{ break;
                    }
                    default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                        break;}
                }
            }
            break;
        }
            
        case 3:{int menuregisto=0;
                 while (menuregisto!=2){
                     System.out.println("##########################\n");
                     System.out.println("#### Imóveis em Venda ####" + "\n");
                     System.out.println("##########################\n\n\n");
                     System.out.println("1 - Ver Lista de Imóveis em venda" + "\n");
                     System.out.println("2 - Sair" + "\n"); 
                     System.out.println("Insira uma opção válida:\n");
                  menuregisto=ler.nextInt();
                  switch (menuregisto) {
                    case 1:{
                        Vendedor v = (Vendedor)actual;
                        ArrayList<Imovel> novo = v.getEmVenda();
                        for(Imovel i : novo){
                            System.out.println(i.toString());
                        }
                        break;
                    }
                    case 2:{ break;
                    }
              }
            }
            break;
        }
        
        case 4:{int menuregisto=0;
                 while (menuregisto!=2){
                     System.out.println("##########################\n");
                     System.out.println("#### Imóveis Vendidos ####" + "\n");
                     System.out.println("##########################\n\n\n");
                     System.out.println("1 - Ver Lista de Imóveis Vendidos" + "\n");
                     System.out.println("2 - Sair" + "\n"); 
                  menuregisto=ler.nextInt();
                      switch (menuregisto) {
                    case 1:{
                        Vendedor v = (Vendedor)actual;
                        ArrayList<Imovel> novo = v.getVendidos();
                        for(Imovel i : novo){
                            System.out.println(i.toString());
                        }
                        break;
                    }
                    case 2:{ break;
                    }
              }
      
              }
              break;
       
        }
        
        case 5:{int menuregisto=0;
                 while (menuregisto!=2){
                     System.out.println("##########################\n");
                     System.out.println("#### Vender Imóvel ####" + "\n");
                     System.out.println("##########################\n\n\n");
                     System.out.println("1 - Digite o ID do imóvel a vender" + "\n");
                     System.out.println("2 - Sair" + "\n"); 
                     System.out.println("Insira uma opção válida:\n");
                  menuregisto=ler.nextInt();
                  switch (menuregisto) {
                    case 1:{
                        System.out.println("Digite o ID do imóvel" + "\n");
                        Scanner readVenda = new Scanner (System.in).useDelimiter("\\n");
                        String avender;
                        avender = readVenda.next();
                        Vendedor v = (Vendedor)actual;
                        
                        try{
                            v.vendeImovel(avender);
                            ArrayList<Imovel> novo = v.getEmVenda();
                        for(Imovel i : novo){
                            if (i.getID().equals(avender)){
                                v.removeImovel(i);
                            }
                        }
                       }
                       catch(ImovelInexistenteException e){
                           System.out.println("O imóvel que pretende apagar não existe!\n");
                        }
                        
                        break;
                    }
                    case 2:{ 
                        break;
                    }
              }
            }
            break;
        }
            
         case 6:{  try{
                        app.guardarEstado("backup.obj");
                    }
              catch (IOException e){
                  System.out.println(e.getMessage());
              }
                  System.out.println("Saída efectuada com sucesso.\n");
                  break;
            }
          
           default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                break;}
            }
        }   
      }
      
      // Vendedor //
    
      
    else {
    System.out.println("\nDados incorrectos.\n");
    }
     
    break;
    }
case 2:{Scanner read19 = new Scanner (System.in).useDelimiter("\\n");
        System.out.println("######################");
        System.out.println("## Criar Comprador ##");
        System.out.println("######################\n\n\n");
        ArrayList<Imovel> novo = new ArrayList<Imovel>();
        ArrayList<Imovel> historico=new ArrayList<Imovel>();
        Utilizador novouti;
        
        System.out.println("Username: ");
        String name;
        name=read19.next();
        
        System.out.println("E-mail: ");
        String mail;
        mail = read19.next();

        try{
            app.registaMail(mail);
           }
        catch(EmailInvalidoException e){
             System.out.println(e.getMessage());
            break;
        }
        catch(EmailJaExisteException e){
            System.out.println(e.getMessage());
            break;
        }
        
        System.out.println("Password: ");
        String secretpass;
        secretpass=read19.next();
        
        System.out.println("Nome: ");
        String nomeproprio;
        nomeproprio=read19.next();
        
         System.out.println("Morada: ");
        String morada;
        morada=read19.next();
        
        
        System.out.println("Introduza data de nascimento: (Dia/Mes/Ano) ");
        String data;
        String[] dataSplit;
        int dia, mes, ano;
        data = read19.next();
        dataSplit = data.split("/");
        

        try{
            dia = Integer.parseInt(dataSplit[0]);               
            
            
            
            mes = Integer.parseInt(dataSplit[1]);
            ano = Integer.parseInt(dataSplit[2]);
            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
                GregorianCalendar nascimento = new GregorianCalendar(ano, mes, dia);
                novouti = new Comprador(mail,nomeproprio,name,secretpass,morada,nascimento,novo,historico);
                try{
                    app.registarUtilizador(novouti);
                }
                catch(UtilizadorExistenteException e){
                    System.out.println("Utilizador já registado!\n");
                }
            }else
            throw new DataInvalidaException();
       }catch (DataInvalidaException e) { 
            System.out.println(e.getMessage());
        }
       try{
                        app.guardarEstado("backup.obj");
           }
       catch (IOException e){
                  System.out.println(e.getMessage());
              }
   
    break;
}

    
case 3:{Scanner read20 = new Scanner (System.in).useDelimiter("\\n");
        System.out.println("####################");
        System.out.println("## Criar Vendedor ##");
        System.out.println("####################\n\n\n");
        ArrayList<Imovel> emVenda = new ArrayList<Imovel>();
        ArrayList<Imovel> vendidos= new ArrayList<Imovel>();
        Utilizador novovendedor;
        
        
        
        System.out.println("Username: ");
        String name;
        name=read20.next();
        
        System.out.println("Email: \n");    
        String mail;
        mail = read20.next();
        try{
            app.registaMail(mail);
           }
        catch(EmailInvalidoException e){
             System.out.println(e.getMessage());
            break;
        }
        catch(EmailJaExisteException e){
            System.out.println(e.getMessage());
            break;
        }
        
        System.out.println("Password: \n");
        String secretpass;
        secretpass=read20.next();
        
        System.out.println("Nome: \n");
        String nomeproprio;
        nomeproprio=read20.next();
        
        
        System.out.println("Morada: \n");
        String morada;
        morada=read20.next();
       
       System.out.println("Introduza data de nascimento: (Dia/Mes/Ano) ");
        String data;
        String[] dataSplit;
        int dia, mes, ano;
        data = read20.next();
        dataSplit = data.split("/");
        

        try{
            dia = Integer.parseInt(dataSplit[0]);
            mes = Integer.parseInt(dataSplit[1]);
            ano = Integer.parseInt(dataSplit[2]);
            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && String.valueOf(ano).length() == 4) {
                GregorianCalendar nascimento = new GregorianCalendar(ano, mes, dia);
                novovendedor = new Vendedor(mail,nomeproprio,name,secretpass,morada,nascimento,emVenda,vendidos);
                try{
                    app.registarUtilizador(novovendedor);
                }
                catch(UtilizadorExistenteException e){
                    System.out.println("Utilizador já registado!\n");
                }
                    
            }else
            throw new DataInvalidaException();
       }catch (DataInvalidaException e) { 
            System.out.println(e.getMessage());
        }
        
        try{
               app.guardarEstado("backup.obj");
            }
        catch (IOException e){
                  System.out.println(e.getMessage());
              }
        
    break;
}


case 4: {
        System.out.println("###############\n");
        System.out.println("## Visitante ##\n");
        System.out.println("###############\n\n\n");
        int choice = 0;
          while (choice!=2){
            System.out.println("1 - Pesquisar Imovel" + "\n");
            System.out.println("2 - Sair" + "\n");
            System.out.println("Insira uma opção válida:\n");
            choice=ler.nextInt();
            switch (choice) {
            case 1:{
                int escolha=0;
                 while (escolha!=6){
                System.out.println("######################\n");
                System.out.println("## Pesquisar Imovel ##\n");
                System.out.println("######################\n\n\n");
                System.out.println("Escolha o tipo de Imovel que pretende:\n");
                System.out.println("1 - Moradia" + "\n");
                System.out.println("2 - Apartamento" + "\n");
                System.out.println("3 - Loja" + "\n");
                System.out.println("4 - Terreno" + "\n");
                System.out.println("5 - Pesquisar por ID do imóvel" + "\n");
                System.out.println("6 - Sair" + "\n");
                escolha=ler.nextInt();
                switch (escolha) {
                case 1:{  Scanner read = new Scanner (System.in).useDelimiter("\\n"); // Moradia
                    
                     System.out.println("#############\n");
                     System.out.println("## Moradia ##\n");
                     System.out.println("#############\n\n\n");
                     int le = 0;
                      while (le!=7){
                System.out.println("######################\n");
                System.out.println("## Pesquisar Moradia ##\n");
                System.out.println("######################\n\n\n");
                System.out.println("Escolha o tipo de pesquisa:\n");
                System.out.println("1 - Pesquisar por Distrito" + "\n");
                System.out.println("2 - Pesquisar por limite de preço" + "\n");
                System.out.println("3 - Pesquisar por Area Total" + "\n");
                System.out.println("4 - Pesquisar por nº de quartos" + "\n");
                System.out.println("5 - Pesquisar por tipo da moradia" + "\n");
                System.out.println("6 - Pesquisar por ID da moradia" + "\n");
                System.out.println("7 - Sair" + "\n");
                le=read.nextInt();
    
                     switch(le){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorDistrito(distrito);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorPreco(precomax);
                                 
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorArea(area);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por nº de quartos\n");
                                    System.out.println("Introduza o nº de quartos:\n");
                                    int quartos; 
                                    quartos = read.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorQuartos(quartos);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de moradia (Geminada / Gaveto / Banda)\n");
                                    System.out.println("Introduza o tipo de moradia:\n");
                                    String tipo; 
                                    tipo = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorTipo(tipo);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    case 6:{
                                    System.out.println("Procurar por ID de imóvel\n");
                                    System.out.println("Introduza o ID da moradia:\n");
                                    String id; 
                                    id = read.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getMoradiaPorID(id);
                                
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    
                    case 7:{
                        break;
                    }
                     
                }
            }
            break;
        }
                     
                case 2:{  Scanner read1 = new Scanner (System.in).useDelimiter("\\n"); // apartamento
                    
                     System.out.println("#################\n");
                     System.out.println("## Apartamento ##\n");
                     System.out.println("#################\n\n\n");
                     
                      int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("## Pesquisar Apartamento ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area Total" + "\n");
                          System.out.println("4 - Pesquisar por nº de quartos" + "\n");
                          System.out.println("5 - Pesquisar por tipo de apartamento" + "\n");
                          System.out.println("6 - Pesquisar por existência de garagem" + "\n");
                          System.out.println("7 - Pesquisar por ID do Apartamento" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read1.nextInt();
                    
                        
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorDistrito(distrito);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorPreco(precomax);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorArea(area);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por nº de quartos\n");
                                    System.out.println("Introduza o nº de quartos:\n");
                                    int quartos; 
                                    quartos = read1.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorQuartos(quartos);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo (Simples / Duplex / Triplex)\n");
                                    System.out.println("Introduza o tipo de apartamento:\n");
                                    String tipo; 
                                    tipo = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorTipo(tipo);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de garagem\n");
                                    System.out.println("Introduza Sim para pesquisar apartamentos com garagem \n");
                                    String tipo; 
                                    tipo = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorGaragem(tipo);
                             
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                      }
                     
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID do apartamento\n");
                                    System.out.println("Introduza o ID do apartamento:\n");
                                    String id; 
                                    id = read1.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getApartamentoPorID(id);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                       }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
            break;
        }
                     
                case 3:{  Scanner read2 = new Scanner (System.in).useDelimiter("\\n"); // Loja
                    
                    System.out.println("##########\n");
                    System.out.println("## Loja ##\n");
                    System.out.println("##########\n\n\n");
                    
                    
                     
                              int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("### Pesquisar Loja ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area Total" + "\n");
                          System.out.println("4 - Pesquisar por existência de WC" + "\n");
                          System.out.println("5 - Pesquisar por tipo de loja" + "\n");
                          System.out.println("6 - Pesquisar por existência de zona de habitabilidade" + "\n");
                          System.out.println("7 - Pesquisar por ID da loja" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read2.nextInt();
                    
                         
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorDistrito(distrito);

                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read2.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorPreco(precomax);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read2.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorArea(area);
                                    
                  
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                      }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por existência de WC\n");
                                    System.out.println("Introduza Sim para procurar lojas com WC:\n");
                                    String wc; 
                                    wc = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorWC(wc);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                       }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de negócio\n");
                                    System.out.println("Introduza o tipo de negócio:\n");
                                    String tipo; 
                                    tipo = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorTipo(tipo);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                     }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de parte habitacional\n");
                                    System.out.println("Introduza Sim para pesquisar lojas com parte habitacional \n");
                                    String hab; 
                                    hab = read2.next();
                                  
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                   
                                     novabusca = app.getLojaPorHabitabilidade();
                                        
                                    for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                       }
                            
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID da loja\n");
                                    System.out.println("Introduza o ID da loja:\n");
                                    String id; 
                                    id = read2.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getLojaPorID(id);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
                     
                     break;
          }
                    
                case 4:{  Scanner read3 = new Scanner (System.in).useDelimiter("\\n"); // Terreno
                     System.out.println("#############\n");
                     System.out.println("## Terreno ##\n");
                     System.out.println("#############\n\n\n");
                     
                     
                     
                     
                      
                                       int leA = 0;
                      while (leA!=8){
                          System.out.println("###########################\n");
                          System.out.println("## Pesquisar Terreno ##\n");
                          System.out.println("###########################\n\n\n");
                          System.out.println("Escolha o tipo de pesquisa:\n");
                          System.out.println("1 - Pesquisar por Distrito" + "\n");
                          System.out.println("2 - Pesquisar por limite de preço" + "\n");
                          System.out.println("3 - Pesquisar por Area" + "\n");
                          System.out.println("4 - Pesquisar por diâmetro da canalização" + "\n");
                          System.out.println("5 - Pesquisar por tipo de terreno" + "\n");
                          System.out.println("6 - Pesquisar por existência de rede elétrica" + "\n");
                          System.out.println("7 - Pesquisar por ID do Terreno" + "\n");
                          System.out.println("8 - Sair" + "\n");
                          leA=read3.nextInt();
                    
                          
                    
                       switch(leA){
                         case 1:{
                                    System.out.println("Procurar por Distrito\n");
                                    System.out.println("Distrito:\n");
                                    String distrito; 
                                    distrito = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorDistrito(distrito);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                    }
                    
                    case 2:{
                                    System.out.println("Procurar por limite de preço\n");
                                    System.out.println("Preço Máximo:\n");
                                    int precomax; 
                                    precomax = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorPreco(precomax);
                                  
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                      }
                     
                     break;
                        
                    }
                    
                    case 3:{
                                    System.out.println("Procurar por área total\n");
                                    System.out.println("Introduza a área total:\n");
                                    int area; 
                                    area = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorArea(area);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                       }
                     
                     break;
                        
                    }
                    
                    case 4:{
                                    System.out.println("Procurar por diâmetro da canalização\n");
                                    System.out.println("Introduza o diâmetro da canalização:\n");
                                    int diam; 
                                    diam = read3.nextInt();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorDiametro(diam);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                       }
                     
                     break;
                        
                    }
                    
                    case 5:{
                                    System.out.println("Procurar por tipo de terreno\n");
                                    System.out.println("Introduza o tipo de terreno:\n");
                                    String tipo; 
                                    tipo = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorTipo(tipo);
                                    
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                     case 6:{
                                    System.out.println("Procurar por existência de rede elétrica\n");
                                    System.out.println("Introduza Sim para pesquisar terrenos com rede elétrica \n");
                                    String rede; 
                                    rede = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    
                                    novabusca = app.getTerrenoPorRedeEletrica(rede);
                                 
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                           
                     break;
                        
                    }
                    
                    case 7:{
                                    System.out.println("Procurar por ID da loja\n");
                                    System.out.println("Introduza o ID da loja:\n");
                                    String id; 
                                    id = read3.next();
                                    List<Imovel> novabusca = new ArrayList<Imovel>();
                                    novabusca = app.getTerrenoPorID(id);
                                   
                 
                                     for(Imovel i : novabusca){
                                        System.out.println(i.toString());
                                        }
                     
                     break;
                        
                    }
                    
                    
                    case 8:{
                        break;
                    }
                     
                }
            }
                        break;
          }
                    
            
                     
                case 6:{System.out.println("\nSaída efectuada com sucesso.\n");
                        //System.out.println("\nOLA\n");
                        break;
                        }
 
                default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                    break;}
        }
      }
            break;
        }
               
         case 2:{  try{
                        app.guardarEstado("backup.obj");
                      }
                    catch (IOException e){
                         System.out.println(e.getMessage());
                        }
    
                  System.out.println("Saída efectuada com sucesso.\n");
                  break;
            }
          
           default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
                break;}
            }
        } 
        
      break;
}
        
      
case 5:{System.out.println("\nSaída efectuada com sucesso.\n");
    //System.out.println("\nOLA\n");
    break;
}
default:{System.out.println("\nOpção inválida. Insira uma opção válida.\n");
break;}
}
}

try{
         app.guardarEstado("backup.obj");
                    }
catch (IOException e){
          System.out.println(e.getMessage());
}

    }
}
