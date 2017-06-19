package Source;

import Exceptions.*;
import java.io.*;
import java.util.*;
/**
 *Na classe Moradia o objetivo é implementar os dados associados a esta subclasse.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Moradia extends Imovel implements Habitavel
{
    public String tipo; //Isolada,germinada,banda,gaveto
    public int areaimplantacao,areatotalcoberta,areaterreno;
    public int quartos,wcs,numero;
   
    public Moradia(){
        super();
        this.tipo = "";
        this.areaimplantacao = 0;
        this.areatotalcoberta = 0;
        this.areaterreno = 0;
        this.quartos = 0;
        this.wcs = 0;
        this.numero = 0;
    }
    
    public Moradia(String id,String rua,int precop,int precomin,String dist,String estado,String type,int areaimplanta,int areacoberta,int areaterre,int rooms,int wc,int num){
        super(id,rua,precop,precomin,estado,dist);
        this.tipo = type;
        this.areaimplantacao = areaimplanta;
        this.areatotalcoberta = areacoberta;
        this.areaterreno = areaterre;
        this.quartos = rooms;
        this.wcs = wc;
        this.numero = num;
    }
    
    public Moradia(Moradia m){
        super(m);
        this.tipo = m.getTipo();
        this.areaimplantacao = m.getAreaImplantacao();
        this.areatotalcoberta = m.getAreaCoberta();
        this.areaterreno = m.getAreaTerreno();
        this.quartos = m.getQuartos();
        this.wcs = m.getWcs();
        this.numero = m.getNum();
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public int getAreaImplantacao(){
        return this.areaimplantacao;
    }
    
    public int getAreaCoberta(){
        return this.areatotalcoberta;
    }
    
    public int getAreaTerreno(){
        return this.areaterreno;
    }
    
    public int getQuartos(){
        return this.quartos;
    }
    
     public int getWcs(){
        return this.wcs;
    }
    
     public int getNum(){
        return this.numero;
    }
    
    
    public void setTipo(String nova){
        this.tipo = nova;
    }
    
    public void setAreaImplantacao(int nova){
        this.areaimplantacao = nova;
    }
    
    public void setAreaCoberta(int nova){
        this.areatotalcoberta = nova;
    }
    
    public void setAreaTerreno(int nova){
        this.areaterreno = nova;
    }
    
    public void setQuartos(int nova){
        this.quartos = nova;
    }
    
     public void setWcs(int nova){
        this.wcs = nova;
    }
    
     public void setNum(int nova){
        this.numero = nova;
    }
    
    public boolean ehabitavel(){
        return true;
    }
     
    public boolean equals(Object o) 
    {
        if (this==o)
            return true;
            
        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;
            
        Moradia j=(Moradia) o;
            
        return ((this.tipo == j.getTipo()) 
            && (this.areaimplantacao == j.getAreaImplantacao())
            && (this.areatotalcoberta == j.getAreaCoberta()) 
            && (this.areaterreno == j.getAreaTerreno()) 
            && (this.quartos == j.getQuartos())
            && (this.wcs == j.getWcs()) 
            && (this.numero ==j.getNum())
            && (super.equals(o)));
    }
    
     public String toString() {
        StringBuilder s = new StringBuilder(); 
        s.append("----- Moradia -----\n");
        s.append(super.toString());
        s.append("Tipo: " + this.tipo + "\n"); 
        s.append("Area de Implantação: " + this.areaimplantacao + "\n"); 
        s.append("Area Total Coberta: " + this.areatotalcoberta + "\n"); 
        s.append("Area do Terreno Envolvente: " + this.areaterreno + "\n"); 
        s.append("Número de Quartos: " + this.quartos + "\n"); 
        s.append("Número de WC's: " + this.wcs + "\n");
        s.append("Número da porta: " + this.numero + "\n");
        return s.toString(); 
    }
    
    public Moradia clone(){
        return new Moradia(this);
    }
    
}