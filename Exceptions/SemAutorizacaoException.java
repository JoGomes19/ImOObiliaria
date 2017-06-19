package Exceptions;


/**
 * Write a description of class SemAutorizacaoException here.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class SemAutorizacaoException extends Exception
{
  public SemAutorizacaoException() {super();}
  
  public SemAutorizacaoException(String s){super(s);}
  
  public String getMessage(){
      return "Não tem autorização!\n";
    }
}
