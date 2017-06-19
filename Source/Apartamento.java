package Source;


import java.io.*;
import java.util.*;
/**
 * Na classe Apartamento o objetivo é implementar os dados associados a esta subclasse.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Apartamento extends Imovel implements Habitavel
{
    public String tipo; // Simples,Duplex,Triplex
    public int areaTotal; // em m^2
    public int nQuartos, nWC, nPorta, andar; //numero de quartos, numero de WC, numero da porta do predio, andar do apartamento
    public String garagem;
    
    public Apartamento(){
        super();
        this.tipo = "";
        this.areaTotal = 0;
        this.nQuartos = 0;
        this.nWC = 0;
        this.nPorta = 0;
        this.andar = 0;
        this.garagem = "";
    }
    
    public Apartamento(String id,String rua,int precop,int precomin,String dist,String estado,String t,int aTotal, int nQ, int nCB, int porta, int a, String g){
        super(id,rua,precop,precomin,estado,dist);
        this.tipo = t;
        this.areaTotal = aTotal;
        this.nQuartos = nQ;
        this.nWC = nCB;
        this.nPorta = porta;
        this.andar = a;
        this.garagem = g;
    }


    public Apartamento(Apartamento a){
        super(a);
        this.tipo = a.getTipo();
        this.areaTotal = a.getAreaTotal(); 
        this.nQuartos = a.getQuartos();
        this.nWC = a.getWcs();
        this.nPorta = a.getPorta();
        this.andar = a.getAndar();
        this.garagem = a.getGaragem();
    }

    ////////////////
    ///// GETs /////
    ////////////////

    public String getTipo(){
        return this.tipo;
    }

    public int getAreaTotal(){
        return this.areaTotal;
    }

    public int getQuartos(){
        return this.nQuartos;
    }

    public int getWcs(){
        return this.nWC;
    }

    public int getPorta(){
        return this.nPorta;
    }

    public int getAndar(){
        return this.andar;
    }

    public String getGaragem(){
        return this.garagem;
    }

    ////////////////
    ///// SETs /////
    ////////////////


    public void setTipo(String t){
        this.tipo = t;
    }

    public void setAreaTotal(int a){
        this.areaTotal = a;
    }

    public void setNQuartos(int q){
        this.nQuartos = q;
    }

    public void setNWC(int wc){
        this.nWC = wc;
    }

    public void setPorta(int p){
        this.nPorta = p;
    }

    public void setAndar(int a){
        this.andar = a;
    }

    public void setGaragem(String g){
        this.garagem = g;
    }
    
     public boolean ehabitavel(){
        return true;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("----- Apartamento -----\n");
        s.append(super.toString());
        s.append("Tipo:" + this.tipo + "\n");
        s.append("Area Total" + this.areaTotal + "\n");
        s.append("Número de quartos:" + this.nQuartos + "\n");
        s.append("Número de WCs:" + this.nWC + "\n");
        s.append("Porta:" + this.nPorta + "\n");
        s.append("Andar:" + this.andar + "\n");
        s.append("Garagem:" + this.garagem + "\n");
        return s.toString();
    }

    public boolean equals(Object o){
        if (this == o)
            return true;

        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;

        Apartamento a = (Apartamento) o;

        return ((this.tipo == a.getTipo()) 
            && (this.areaTotal == a.getAreaTotal()) 
            && (this.nQuartos == a.getQuartos())
            && (this.nWC == a.getWcs()) 
            && (this.nPorta == a.getPorta()) 
            && (this.andar == a.getAndar()) 
            && (this.garagem == a.getGaragem())
            && (super.equals(o)));
    }

    public Apartamento clone(){
        return(new Apartamento(this));
    }
}
