package Source;

import java.io.*;
import java.util.*;
/**
 * Na classe Loja Habitavel o objetivo é fazer uma união das classes Loja e Apartamento,
 * implementando os dados associados a esta subclasse de Loja
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class LojaHabitavel extends Loja implements Habitavel
{
    public Apartamento a;
    public String tipo; // Simples,Duplex,Triplex
    public int areaTotal; // em m^2
    public int nQuartos, nWC, nPorta, andar; //numero de quartos, numero de WC, numero da porta do predio, andar do apartamento
    public String garagem;
    
    
    public LojaHabitavel(){
        super();
        this.a = new Apartamento();
        this.tipo = "";
        this.nQuartos = 0;
        this.nWC = 0;
        this.garagem = "";
    }
    
    public LojaHabitavel(String id,String rua,int precop,int precomin,String dist,String estado,int areaT,String wc,int numeroP, String tipo,String hab,int nwcs,int nquartos,String gar,String tipoA){
        super(id,rua,precop,precomin,estado,dist,areaT,wc,numeroP,tipo,hab);
        this.tipo = tipoA;
        this.nQuartos = nquartos;
        this.nWC = nwcs;
        this.garagem = gar;
    }
    
     public LojaHabitavel(LojaHabitavel lh){
        super(lh);
        this.tipo = lh.getTipo();
        this.nQuartos = lh.getQuartos();
        this.nWC = lh.getWcs();
        this.garagem = lh.getGaragem();
    }

    
    public int getQuartos(){
        return this.nQuartos;
    }
    
    public int getWcs(){
        return this.nWC;
    }
    
    public String getGaragem(){
        return this.garagem;
    }
    
    public String getTipo(){
        return this.tipo;
    }

   
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("----- Informações da Loja  -----\n");
        s.append(super.toString());
        s.append("----- Parte Habitacional -----\n");
        s.append("Tipo:" + this.tipo + "\n");
        s.append("Número de quartos:" + this.nQuartos + "\n");
        s.append("Número de WCs:" + this.nWC + "\n");
        s.append("Garagem:" + this.garagem + "\n");

        return s.toString();
    }

    public boolean equals(Object o){
        if (this == o)
            return true;

        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;

        LojaHabitavel a = (LojaHabitavel) o;

        return ((this.nQuartos == a.getQuartos())
                 && (this.nWC == a.getWcs()) 
                 && (this.garagem == a.getGaragem()) 
                 && (this.tipo == a.getTipo()) 
                 && (a.equals(o)));
    }

    public LojaHabitavel clone(){
        return(new LojaHabitavel(this));
    }
}
