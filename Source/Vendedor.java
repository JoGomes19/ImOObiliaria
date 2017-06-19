package Source;

import Source.*;
import Exceptions.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class Vendedor here.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Vendedor extends Utilizador
{
    public ArrayList<Imovel> emVenda = new ArrayList<Imovel>();
    public ArrayList<Imovel> vendidos = new ArrayList<Imovel>();
    
    
    public Vendedor(){
       super();
       this.emVenda = new ArrayList<Imovel>();
       this.vendidos = new ArrayList<Imovel>();
    }
    
    public Vendedor(String email,String nome,String username,String password,String morada,GregorianCalendar data,ArrayList<Imovel> n, ArrayList<Imovel> m){
       super(email,nome,username,password,morada,data);
       this.emVenda.clear();
       for(Imovel i : n){
           this.emVenda.add(i);
        }
       this.vendidos.clear();
       for(Imovel i : m){
           this.vendidos.add(i);
        }
    }
    
    public Vendedor(Vendedor v){
        super(v);
        this.emVenda = v.getEmVenda();
        this.vendidos = v.getVendidos();
    }
    
    public ArrayList<Imovel> getEmVenda(){
        ArrayList<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : this.emVenda){
           novo.add(i);
        }
        return novo;
    }
    
    public ArrayList<Imovel> getVendidos(){
        ArrayList<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : this.vendidos){
           novo.add(i);
        }
        return novo;
    }
   
    
    public void setEmVenda(ArrayList<Imovel> a){
        this.emVenda.clear();
        for (Imovel i:a)
        emVenda.add(i.clone());
    }
    
    public void setVendidos(ArrayList<Imovel> a){
        this.vendidos.clear();
        for (Imovel i:a)
        vendidos.add(i.clone());
    }
    
    public int numAnuncios(){
        return this.emVenda.size();
    }
    
    public int numVendidos(){
        return this.vendidos.size();
    }
    
    public int totalAnuncios(){
        return (this.emVenda.size() + this.vendidos.size());
    }
    
    public void addImovel(Imovel i){
        if( i instanceof Moradia || i instanceof Apartamento || i instanceof Terreno || i instanceof Loja || i instanceof LojaHabitavel){
            emVenda.add(i.clone());
       }
    }
    
    public void removeImovel(Imovel i){
        if( i instanceof Moradia || i instanceof Apartamento || i instanceof Terreno || i instanceof Loja){
            emVenda.remove(i);
            //this.vendidos.add(i);
        }
    }
    
    public void vendeImovel(String id) throws ImovelInexistenteException{
        for(Imovel i : this.emVenda){
            if(id.equals(i.getID())){
                i.setEstado("Vendido");
                this.vendidos.add(i.clone());
               
            }
            else if(id.equals(i.getID())){
                throw new ImovelInexistenteException("O imóvel a apagar não existe\n");
            }
        }
    }
    
            
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("---------Vendedor--------");
        sb.append(super.toString());
        sb.append("Lista de imóveis em venda:\n");
        for(Imovel i : this.emVenda){
           i.toString();
        }
         sb.append("Lista de imóveis vendidos:\n");
        for(Imovel i : this.vendidos){
           i.toString();
        }
        return sb.toString();
    }
    
       public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Vendedor p = (Vendedor) o;
        if(emVenda.size() != p.getEmVenda().size()){
            return false;
        }
        for(int i=0;i < emVenda.size();i++){
            if(!emVenda.get(i).equals(p.getEmVenda().get(i))){
                return false;
            }
        }
        
        if(vendidos.size() != p.getVendidos().size()){
            return false;
        }
        for(int i=0;i < vendidos.size();i++){
            if(!vendidos.get(i).equals(p.getVendidos().get(i))){
                return false;
            }
        }
        
        super.equals(o);
        return true;
    }
    
    public Vendedor clone(){
        return new Vendedor(this);
    }
        
    
    
    
    
  
}
