package Source;

import java.io.*;
import java.util.*;
/**
 * Na classe Terreno o objetivo é implementar os dados associados a esta subclasse.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Terreno extends Imovel
{
    int areaTotal; // em m2
    double canalizacao; //diametro em mm
    String redeEle; 
    double capMaxRede; // em kWh, no caso de redeEle == true
    String tipo;
    
    public Terreno(){
        super();
        this.areaTotal = 0;
        this.canalizacao = 0.0;
        this.redeEle = "";
        this.capMaxRede = 0.0;
        this.tipo = "";
    }
    
    public Terreno(String id,String rua,int precop,int precomin,String dist,String estado,int area, double can, String rede, double cap, String tipo){
        super(id,rua,precop,precomin,estado,dist);
        this.areaTotal = area;
        this.canalizacao = can;
        this.redeEle = rede;
        this.capMaxRede = cap;
        this.tipo = tipo;
    }
    
    public Terreno(String id,String rua,int precop,int precomin,String estado,int area, double can, String rede, String tipo, String dist, String conc){
        super(id,rua,precop,precomin,estado,dist);
        this.areaTotal = area;
        this.canalizacao = can;
        this.redeEle = rede;
        this.tipo = tipo;
    }
    
    public Terreno(Terreno t){
        super(t);
        this.areaTotal = t.getAreaTotal();
        this.canalizacao = t.getCanalizacao();
        this.redeEle = t.getRedeEle();
        this.capMaxRede = t.getCapRede();
        this.tipo = t.getTipo();
    }
    
    public int getAreaTotal(){
        return this.areaTotal;
    }
    
    public double getCanalizacao(){
        return this.canalizacao;
    }
    
    public String getRedeEle(){
        return this.redeEle;
    }
    
    public double getCapRede(){
        return this.capMaxRede;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setAreaTotal(int area){
        this.areaTotal = area;
    }
    
    public void setCanalizacao(double can){
        this.canalizacao = can;
    }
    
    public void setRedeEle(String rede){
        this.redeEle = rede;
    }
    
    public void setCapRede(double cap){
         this.capMaxRede = cap;
    }
    
    public void setTipo(String nova){
        this.tipo = nova;
    }
   
    public boolean ehabitavel(){
        return true;
    }
    
    public boolean redeeletrica(){
        return (this.redeEle == "Sim" || this.redeEle == "SIM" || this.redeEle == "sim");
    }
    
    

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("----- Terreno -----\n:");
        s.append(super.toString());
        s.append("Área Total" + this.areaTotal + "\n");
        s.append("Canalização" + this.canalizacao + "\n");
        s.append("Rede Elétrica" + this.redeEle + "\n");
        s.append("Tipo do terreno:" + this.tipo + "\n");
        return s.toString();
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;

        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;
            
        Terreno t = (Terreno) o;
        
        return ((this.areaTotal == t.getAreaTotal()) 
             && (this.canalizacao == t.getCanalizacao()) 
             && (this.redeEle == t.getRedeEle()) 
             && (this.capMaxRede == t.getCapRede())
             && (this.tipo == t.getTipo())
             && (super.equals(o)));

    }
    
    public Terreno clone(){
        return(new Terreno(this));
    }
    
    
    
    
    
}
