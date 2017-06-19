package Source;

import java.io.*;
import java.util.*;
/**
 * Nesta classe não há a distinção entre comprador e vendedor (abstrata)
 * pois essa distinção vai ser feita nas classes Vendedor e Comprador.
 * Essa duas classe herdam tudo o que é feito na classe Utilizador,
 * apenas acrescentando certos dados e permissões ao perfil de utilizador.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public abstract class Utilizador implements Serializable
{
    private String email,nome,password,morada,username;
    private GregorianCalendar datanasc; //GregorianCalendar datanasc;
    public Utilizador(){
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.datanasc =  new GregorianCalendar(); //new GregorianCalendar();
    }
    
    public Utilizador(String email,String nome,String username,String password,String morada,GregorianCalendar data){
        this.email = email;
        this.nome = nome;
        this.username=username;
        this.password = password;
        this.morada = morada;
        this.datanasc = data;
        
    }
    
    public Utilizador(Utilizador u){
        this.email = u.getMail();
        this.nome = u.getNome();
        this.password = u.getPassword();
        this.morada =u.getMorada();
        this.datanasc = u.getData();
        this.username=u.getUsername();
    }
    
    public String getMail(){
        return this.email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public GregorianCalendar getData(){ 
        return (GregorianCalendar)datanasc.clone(); }
    
    public void setMail(String nova){
        this.email = nova;
    }
    
    public void setNome(String nova){
        this.nome = nova;
    }
    
    public void setPassword(String nova){
        this.password = nova;
    }
    
    public void setMorada(String nova){
        this.morada = nova;
    }
    
    public void setData(GregorianCalendar d){
        this.datanasc=(GregorianCalendar)d.clone(); }
    
      public void setUsername(String nova){
        this.username = username;
    }
    
    
    public String toString() {
        StringBuilder s = new StringBuilder(); 
        s.append("----- Utilizador -----\n");
        s.append("Email: " + this.email + "\n"); 
        s.append("Nome: " + this.nome + "\n");
        s.append("Username: " + this.username + "\n"); 
        s.append("Password: " + this.password + "\n"); 
        s.append("Morada: " + this.morada + "\n"); 
        s.append("Data de nascimento : " + this.getData().get(Calendar.DAY_OF_MONTH)+"/"
                                          + this.getData().get(Calendar.MONTH)+"/"
                                          + this.getData().get(Calendar.YEAR)+"\n");
        return s.toString(); 
    }        
    
     public boolean equals(Object o) 
    {
        if (this==o)
            return true;
            
        if ((o==null) || (this.getClass() != o.getClass ()))
            return false;
            
        Utilizador j=(Utilizador) o;
            
        return ((this.email==j.getMail())
            && (this.nome==j.getNome()) 
            && (this.password==j.getPassword())
            && (this.username==j.getUsername())
            && (this.morada==j.getMorada()) 
            && (this.datanasc==j.getData()) );
    }
    
    public abstract Utilizador clone();
}