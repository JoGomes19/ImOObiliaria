package Source;

import java.io.*;
import java.util.*;

/**
 * Na classe Loja o objetivo é implementar os dados associados a esta subclasse.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Loja extends Imovel
{
    // instance variables - replace the example below with your own
    public int areaT;
    public String wc;
    public String tipo;
    public int numeroP;
    public String habitavel;
    
    public Loja(){
        super();
        this.areaT=0;
        this.wc="";
        this.tipo="N/A";
        this.numeroP=0;
        this.habitavel = "";
    }
    
    public Loja(String id,String rua,int precop,int precomin,String dist,String estado,int areaT,String wc,int numeroP, String tipo,String hab){
        super(id,rua,precop,precomin,estado,dist);
        this.areaT=areaT;
        this.wc=wc;
        this.tipo=tipo;
        this.numeroP=numeroP;
        this.habitavel = hab;
    }
    
    public Loja (Loja l){
        super(l);
        this.areaT=l.areaT;
        this.wc=l.wc;
        this.tipo=l.tipo;
        this.numeroP=l.numeroP;
        this.habitavel = l.getHabitavel();
    }
    //Setters
    
    public void setArea(int area){
        this.areaT=area;
    }
    
    public void setWC(String casabanho){
        this.wc=casabanho;
    }
    
    public void setTipo(String type){
        this.tipo=type;
    }
    
    public void setNumero(int number){
        this.numeroP=number;
    }
    
     //Getters
     public int getArea(){
        return (this.areaT);
    }
    
    public String getWC(){
        return (this.wc);
    }
    
    public String getTipo(){
        return (this.tipo);
    }
    
    public int getNumero(){
        return (this.numeroP);
    }
    
    public String getHabitavel(){
        return (this.habitavel);
    }
    
    public boolean ehabitavel(){
        return true;
    }
 
    
    public String toString() {
        StringBuilder s = new StringBuilder(); 
        s.append("----- Loja -----\n");
        s.append(super.toString());
        s.append("Área da loja: " + this.areaT + "\n"); 
        s.append("Tipo de loja: " + this.tipo + "\n"); 
        s.append("Numero da porta: " + this.numeroP + "\n");
        s.append("WC: " + this.wc+ "\n"); 
         s.append("Habitabilidade: " + this.habitavel + "\n");
        return s.toString(); 
    } 
     
    public boolean equals(Object o) 
    {
        if (this==o)
            return true;
            
        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;
            
        Loja j=(Loja) o;
            
        return ((this.areaT == j.getArea()) 
            && (this.wc == j.getWC()) 
            && (this.tipo == j.getTipo()) 
            && (this.numeroP == j.getNumero())
            && (this.habitavel == j.getHabitavel())
            && (super.equals(o)));
    }
    
    public Loja clone(){
        return(new Loja(this));
    }
  
}
