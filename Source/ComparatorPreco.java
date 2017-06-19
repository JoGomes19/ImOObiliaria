package Source;
import java.util.Comparator;
import java.io.Serializable;

/**
 * Write a description of class ComparatorPreco here.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class ComparatorPreco implements Comparator<Imovel>, Serializable {
 
    public int compare(Imovel e1, Imovel e2) {
     
     if(e1.getPrecopedido() > e2.getPrecopedido())
       return 1; 
     if(e1.getPrecopedido() < e2.getPrecopedido())
       return -1;
     else return 0;     
     
     
   }

}
