package Source;

import java.io.*;
import java.util.*;
/**
 * Nesta classe estão definidos todos os construtores para podermos criar imóveis.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public abstract class Imovel implements Serializable
{
   public String id,rua,estado;
   public int precopedido;
   public String distrito;
   private int precominimo;// nao pode ser mostrado ao comprador
   
   public Imovel(){
       this.id = "";
       this.rua = "";
       this.precopedido = 0;
       this.precominimo = 0;
       this.estado = "";
       this.distrito = "";
   }
   
   public Imovel(String id1,String rua,int precop,int precomin,String est,String dist){
       this.id = id1; 
       this.rua = rua;
       this.precopedido = precop;
       this.precominimo = precomin;
       this.estado = est;
       this.distrito = dist;
   }
   
   public Imovel(Imovel i){
       this.id = i.getID();
       this.rua = i.getRua();
       this.precopedido = i.getPrecopedido();
       this.precominimo = i.getPrecominimo();
       this.estado = i.getEstado();
       this.distrito = i.getDistrito();
   }
   
   public String getID(){
       return this.id;
   }
   
   public String getRua(){
       return this.rua;
   }
    
   public int getPrecopedido(){
       return this.precopedido;
   }
   
   public int getPrecominimo(){
       return this.precominimo;
   }
    
   public String getEstado(){
       return this.estado;
   }
    
   public String getDistrito(){
        return this.distrito;
    }
   
   public void setID(String nova){
       this.id = nova;
   }
   
   public void setRua(String nova){
       this.rua = nova;
   }
    
   public void setPrecopedido(int nova){
       this.precopedido = nova;
   }
   
   public void setPrecominimo(int nova){
       this.precominimo = nova;
   }
   
   public void setEstado(String nova){
       this.estado = nova;
   }
   
    
   public void detDistrito(String novo){
        this.distrito = novo;
    }
    
   
   
   public String toString() {
        StringBuilder s = new StringBuilder(); 
        //s.append("----- Imóvel -----\n");
        s.append("ID: " + this.id + "\n"); 
        s.append("Rua: " + this.rua + "\n"); 
        s.append("Preço Pedido: " + this.precopedido + "\n"); 
        s.append("Estado do Imóvel: " + this.estado + "\n");
        s.append("Distrito: " + this.distrito + "\n");
      
        return s.toString(); 
   }     
   
   public boolean equals(Object o) 
    {
       if (this==o)
         return true;
            
       if ((o==null) || (this.getClass() != o.getClass ()))
          return false;
            
       Imovel j=(Imovel) o;
            
            return (this.id==j.getID()
                && (this.rua==j.getRua()) 
                && (this.precopedido==j.getPrecopedido()) 
                && (this.precominimo==j.getPrecominimo()) 
                && (this.distrito == j.getDistrito())
                && this.estado == j.getEstado());
    }
   
   public abstract Imovel clone();
       
    
    
}
