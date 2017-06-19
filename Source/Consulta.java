package Source;

import java.util.*;
import java.io.*;
import java.time.*;

/**
 * Write a description of class Consulta here.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Consulta
{
    public LocalDate data;
    public String email;

    public Consulta(){
        this.email = "";
        this.data = LocalDate.now();
    }
    
    public Consulta(String ma){
        this.email = ma;
        this.data = LocalDate.now();
    }
        
    
    public Consulta(String ma,LocalDate date){
        this.email = ma;
        this.data = date;
    }
    
    public Consulta(Consulta c){
        this.email = c.getMail();
        this.data = c.getData();
    }
    
    public String getMail(){
        return this.email;
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public void setMail(String mail){
        this.email = mail;
    }
    
    public void getData(LocalDate novo){
        this.data = novo;
    }
  
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("----------Consulta----------\n");
        sb.append("E-mail: " + this.email + "\n");
        sb.append("Data de consulta: " + this.data + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o) 
    {
        if (this==o)
            return true;
            
        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;
            
        Consulta j=(Consulta) o;
            
        return ((this.email == j.getMail())
                && (this.data == j.getData()));
    }
    
    public Consulta clone(){
        return new Consulta(this);
    }

}
