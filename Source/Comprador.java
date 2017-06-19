package Source;


import java.io.*;
import java.util.*;
/**
 * Write a description of class Comprador here.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Comprador extends Utilizador
{
    public ArrayList<Imovel> favoritos;
    private ArrayList<Imovel> historico;
    public Comprador(){
        super();
        this.favoritos = new ArrayList<Imovel>();
        this.historico = new ArrayList<Imovel>();
    }
    
    public Comprador(String email,String nome,String username,String password,String morada,GregorianCalendar data,ArrayList<Imovel> novo, ArrayList<Imovel> hist){
        super(email,nome,username,password,morada,data);
        this.favoritos=new ArrayList<Imovel>();
        for (Imovel act:novo){
            this.favoritos.add(act.clone());
        }
        this.historico = new ArrayList<Imovel>();
        for (Imovel act:hist){
            this.historico.add(act.clone());
        }
    }
    
    public Comprador(Comprador c){
        super(c);
        this.favoritos = c.getFavoritos();
        this.historico = c.getHistorico();
    }
    
    public ArrayList<Imovel> getFavoritos(){
        ArrayList<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : this.favoritos){
            novo.add(i);
        }
        return novo;
    }
    
   
    
     public ArrayList<Imovel> getHistorico(){
        ArrayList<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : this.historico){
            novo.add(i);
        }
        return novo;
    }
    
    public void setFavoritos(ArrayList<Imovel> a){
        this.favoritos.clear();
        for (Imovel i:a)
        favoritos.add(i.clone());
    }
    
    public void setHistorico(ArrayList<Imovel> a){
        this.historico.clear();
        for (Imovel i:a)
        historico.add(i.clone());
    }
    
    public int numeroFavoritos(){
        return this.favoritos.size();
    }
    
    public void adicionaFavorito(Imovel act){
        this.favoritos.add(act);
    }
    
    public void adicionaHistorico(Imovel act){ 
        this.historico.add(act);
    }
    
    public void apagaFavorito(Imovel act){
        for(Imovel i : this.favoritos){
            if(i.equals(act)){
                this.favoritos.remove(i);
            }
        }
    }
  

    public void apagaFavoritos(){
        this.favoritos.clear();
    }
    
    public void apagaHistorico(){
        this.historico.clear();
    }
    
    public void apagaDosFavoritos(String er){
        for(Imovel i: this.favoritos){
            if( er.equals(i.getID())){
                this.favoritos.remove(i);
            }
        }
    }
    
    public void apagaDoHistorico(String er){
        for(Imovel i: this.historico){
            if( er.equals(i.getID())){
                this.historico.remove(i);
            }
        }
    }
    
    //public void setFavorito(String idImovel) throws ImovelInexistenteException,SemAutorizacaoException{}
  
       public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Comprador p = (Comprador) o;
        if(favoritos.size() != p.getFavoritos().size()){
            return false;
        }
        for(int i=0;i < favoritos.size();i++){
            if(!favoritos.get(i).equals(p.getFavoritos().get(i))){
                return false;
            }
        }
        if(historico.size() != p.getHistorico().size()){
            return false;
        }
        for(int i=0;i < historico.size();i++){
            if(!historico.get(i).equals(p.getHistorico().get(i))){
                return false;
            }
        }
        super.equals(o);
        
        return true;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("-------Comprador--------\n");
        sb.append(super.toString());
        sb.append("Favoritos\n");
        for(Imovel i : this.favoritos){
            i.toString();
        }
        sb.append("Histórico\n");
        for(Imovel i : this.historico){
            i.toString();
        }
        
        return sb.toString();
    }
    
    public Comprador clone(){
        return new Comprador(this);
    }
}
