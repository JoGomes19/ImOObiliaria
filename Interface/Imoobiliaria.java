package Interface;
import Source.*;
import Exceptions.*;
import java.util.*;
import java.io.*;
/**
 * É nesta classe que definimos as estruturas de dados da aplicação,
 * e que temos todos os métodos necessários para registar um utilizador,
 * iniciar sessão, registar imóveis, etc.
 * 
 * @author Luis Ventuzelos, João Gomes, Paulo Barbosa 
 * @version 20/5/2016
 */
public class Imoobiliaria implements Serializable
{
    public HashMap<String,Utilizador> utilizadores; //Email -> utilizador
    public ArrayList<Vendedor> vendedores;
    public ArrayList<Comprador> compradores;
    public HashMap<String,Imovel> imoveis; //ID do imovel -> Lista de todos os imoveis publicados
    public ArrayList<Consulta> consultas;
    private String email;
    
    
    public Imoobiliaria(){
        this.utilizadores = new HashMap<String,Utilizador>();
        this.imoveis = new HashMap<String,Imovel>();
        this.vendedores = new ArrayList<Vendedor>();
        this.compradores =  new ArrayList<Comprador>();
        this.consultas = new ArrayList<Consulta>();
    }
    
    public Imoobiliaria(Map<String,Utilizador> users){
        this.utilizadores.clear();
        for(Utilizador u : users.values()){
            this.utilizadores.put(u.getMail(),u.clone());
        }
    }
    
    public Imoobiliaria(HashMap<String,Imovel> ims){
        this.imoveis.clear();
        for(Imovel i : ims.values()){
            this.imoveis.put(i.getID(),i.clone());
        }
    }
    
    public Imoobiliaria(ArrayList<Consulta> cons){
        this.consultas.clear();
        for(Consulta c : cons){
            this.consultas.add(c.clone());
        }
    }
    
    
    
    public Imoobiliaria(Map<String,Utilizador> users,HashMap<String,Imovel> ims, ArrayList<Comprador> comps, ArrayList<Vendedor> vend){
        this.utilizadores.clear();
        for(Utilizador u : users.values()){
            this.utilizadores.put(u.getMail(),u.clone());
        }
        this.imoveis.clear();
        for(Imovel i : ims.values()){
            this.imoveis.put(i.getID(),i.clone());
        }
        this.compradores.clear();
        for(Comprador c : comps){
            this.compradores.add(c.clone());
        }
        this.vendedores.clear();
        for(Vendedor v : vend){
            this.vendedores.add(v.clone());
        }
    }
    
   /* 
    public static Imoobiliaria initApp(){
        Imoobiliaria app = new Imoobiliaria();}
       
        try {
           ObjectInputStream ois = new ObjectInputStream( 
               new FileInputStream("Backup"));
           app = (Imoobiliaria) ois.readObject();
        }
        catch(IOException e1) { System.out.println(e1.getMessage()); }
        catch(ClassNotFoundException e1) { System.out.println(e1.getMessage()); }
        return app;
    }*/
    
    
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException{
        for(Utilizador u : this.utilizadores.values()){
            if(utilizador == u){
                throw new UtilizadorExistenteException("O utilizador ja está registado\n");
            }
        }
        if(utilizador instanceof Vendedor){
            vendedores.add((Vendedor) utilizador.clone());
        }
        if(utilizador instanceof Comprador){
            compradores.add((Comprador) utilizador.clone());
        }
        this.utilizadores.put(utilizador.getMail(),utilizador.clone());
    }
    
    
   public void iniciaSessao ( String email , String password )throws SemAutorizacaoException {
        if(!(utilizadores.containsKey(email)))throw new SemAutorizacaoException();
        else if(!(utilizadores.get(email).getPassword().equals(password)))throw new SemAutorizacaoException();
   }
    
   public void addConsulta(Consulta c){
        this.consultas.add(c);
    }

    
    public Utilizador getUtilizador(String email){
        return utilizadores.get(email);
    }
    
    public Vendedor getVendedor(String email){
        Vendedor novo = new Vendedor();
        for(Vendedor v : vendedores){
            if(v.getMail() == email){
                novo = v;
            }
        }
        return novo;
    }
    
    public void registaMail(String mail)throws EmailInvalidoException,EmailJaExisteException{
        Scanner read20 = new Scanner (System.in).useDelimiter("\\n");
        if (!mail.contains("@") || !mail.contains("."))
            throw new EmailInvalidoException(); // um email tem de ter um @ e um .

        if (utilizadores.containsKey(mail))
            throw new EmailJaExisteException();
        
        //mail = read20.next();
    }
    
    public Map<String,Imovel> getImoveis(){
        HashMap<String,Imovel> novo = new HashMap<String,Imovel>();
        for(Imovel i : this.imoveis.values()){
            novo.put(i.getID(),i.clone());
        }
        return novo;
    }
    
    public List<Imovel> getImoveisPorID(String id){
        List<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : imoveis.values()){
            novo.add(i.clone());
        }
        return novo;
    }
    
    
    
    public void fechaSessao (){}
    
    public void addMailInImoo(String mail){
        this.email=mail;
    }
    
    public boolean getTipoVendedor(){
        if (getUtilizador(this.email) instanceof Vendedor){
            return true;
        }
        else return false;
    }
    
    //Problema nas exceptions
    public void registaImovel(Imovel im) throws ImovelExisteException,SemAutorizacaoException{
        if(getTipoVendedor()==false){
            throw new SemAutorizacaoException("Não tem autorização para registrar");
        }
        for(Imovel i : imoveis.values()){
            if(i.getID().equals(im.getID())){
                System.out.println("Opa!");
                   throw new ImovelExisteException("O imóvel ja esta registado");
            }
        }
        
        this.imoveis.put(im.getID(),im.clone());  
    }
                 
    
    // Falta esta
    public List<Consulta> getConsultas() throws SemAutorizacaoException{
        if(getTipoVendedor()==false){
            throw new SemAutorizacaoException("Não tem autorização para registrar");
        }
        List<Consulta> novo = new ArrayList<Consulta>();
        for(Consulta cs : this.consultas){
            novo.add(cs.clone());
        }
        return novo;
    }
    
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException,
    SemAutorizacaoException , EstadoInvalidoException{
        for(Utilizador u : this.utilizadores.values()){
            if(u instanceof Comprador){
                throw new SemAutorizacaoException("Não tem autorização para alterar o estado");
            }
            else{
                if(estado != "Em venda" || estado != "Vendido" || estado != "Reservado"){
                    throw new EstadoInvalidoException("O estado escrito não é permitido");
                }
                for(Imovel i : imoveis.values()){
                    if(i.getID() != idImovel){
                        throw new ImovelInexistenteException("O imovel não existe");
                    }
                    else{
                        i.setEstado(estado);
                    }
                }   
            }
        }
    }
   
    
    public Set<String> getTopImoveis(int n){
        Set<String> top = new TreeSet<String>();
        return top;
    }
    
    public Map<String,Imovel> getImovelPorPreco(String classe, int preco){
        Map<String,Imovel> nova = new HashMap<String,Imovel>();   
        for(Imovel i : imoveis.values()){
            if(classe == "Moradia" || classe == "Apartamento" || classe == "Loja" || classe == "Terreno" && i.getPrecopedido() <= preco){
                nova.put(i.getID(),i.clone());
            }
        }
        return nova;
    }
    
    //PESQUISA MORADIA
    
    public List<Imovel> getMoradiaPorDistrito(String loc){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia && i.getDistrito().equals(loc) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getMoradiaPorID(String id){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia && i.getID().equals(id) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    
    public List<Imovel> getMoradiaPorPreco(int prec){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia && (i.getPrecopedido() <= prec) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
   
    public List<Imovel> getMoradiaPorArea(int ar){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia){
                Moradia mor = (Moradia) i;
                if(mor.getAreaImplantacao() <= ar){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getMoradiaPorQuartos(int quartos){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia){
                Moradia mor = (Moradia) i;
                if(mor.getQuartos() == quartos){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getMoradiaPorTipo(String tipe){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Moradia){
                Moradia mor = (Moradia) i;
                if(mor.getTipo().equals(tipe)){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
     public List<Imovel> getApartamentoPorPreco(int loc){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento && (i.getPrecopedido() <= loc) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    
    
    //PESQUISA APARTAMENTO
    public List<Imovel> getApartamentoPorDistrito(String loc){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if((i instanceof Apartamento) && i.getDistrito().equals(loc) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getApartamentoPorID(String id){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento && i.getID().equals(id) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getApartamentoPorArea(int ar){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento){
                Apartamento apa = (Apartamento) i;
                if(apa.getAreaTotal() <= ar){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getApartamentoPorQuartos(int quartos){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento){
                Apartamento mor = (Apartamento) i;
                if(mor.getQuartos() == quartos){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getApartamentoPorTipo(String tipe){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento){
                Apartamento mor = (Apartamento) i;
                if(mor.getTipo().equals(tipe) && (tipe == "Gaveto" || tipe == "Banda" || tipe == "Geminada")){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getApartamentoPorGaragem(String tipe){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Apartamento){
                Apartamento mor = (Apartamento) i;
                if(mor.getGaragem().equals(tipe)){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    
    //PESQUISA LOJA
    public List<Imovel> getLojaPorDistrito(String loc){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if((i instanceof Loja) && i.getDistrito().equals(loc) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    
    public List<Imovel> getLojaPorID(String id){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja && i.getID().equals(id) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getLojaPorPreco(int prec){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja && (i.getPrecopedido() <= prec) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getLojaPorArea(int ar){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja){
                Loja apa = (Loja) i;
                if(apa.getArea() <= ar){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getLojaPorWC(String ans){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja){
                Loja mor = (Loja) i;
                if(mor.getWC() == ans){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getLojaPorTipo(String tipe){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja){
                Loja mor = (Loja) i;
                if(mor.getTipo().equals(tipe)){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getLojaPorHabitabilidade(){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Loja){
                Loja mor = (Loja) i;
                if(mor.ehabitavel()){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    //PESQUISA TERRENO
    public List<Imovel> getTerrenoPorDistrito(String loc){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if((i instanceof Terreno) && i.getDistrito().equals(loc) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorID(String id){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno && i.getID().equals(id) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorPreco(int prec){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno && (i.getPrecopedido() <= prec) ){
             nova.add(i.clone());
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorArea(int ar){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno){
                Terreno apa = (Terreno) i;
                if(apa.getAreaTotal() <= ar){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorDiametro(int ans){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno){
                Terreno mor = (Terreno) i;
                if(mor.getCanalizacao() <= ans){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorTipo(String tipe){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno){
                Terreno mor = (Terreno) i;
                if(mor.getTipo().equals(tipe)){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    public List<Imovel> getTerrenoPorRedeEletrica(String res){
        List<Imovel> nova = new ArrayList<Imovel>();   
        for(Imovel i : imoveis.values()){
            if(i instanceof Terreno){
                Terreno mor = (Terreno) i;
                if(mor.getRedeEle().equals(res) && mor.redeeletrica()){
                    nova.add(i.clone());
                }
            }
        }
        return nova;
    }
    
    //
    
    public void guardarEstado(String ficheiro) throws IOException{
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(ficheiro);
            oos = new ObjectOutputStream(fos);
         
            oos.writeObject(this);
            oos.close();
             
        } catch (IOException ex) {
             System.out.println("Erro a guardar");
        }
    }
    
    public Imoobiliaria carregarEstado(String ficheiro) throws IOException{
           FileInputStream fis;
           ObjectInputStream ois;
           Imoobiliaria imo = new Imoobiliaria();
        try {
              fis = new FileInputStream(ficheiro);
              ois = new ObjectInputStream(fis);
              
              imo = (Imoobiliaria)ois.readObject();
              ois.close();
        } catch(StreamCorruptedException | FileNotFoundException | ClassNotFoundException ex){
             System.out.println("Erro a carregar");
        }
        
        return imo;
    }
    
    public List<Imovel> getHabitaveis(int preco){
        List<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : this.imoveis.values()){
            if(i instanceof Habitavel && i.getPrecopedido() <= preco){
                novo.add(i.clone());
            }
        }
        return novo;
    }
    
    public List<Imovel> porID(String d){
        List<Imovel> novo = new ArrayList<Imovel>();
        for(Imovel i : imoveis.values()){
            if(d.equals(i.getID())){
                novo.add(i.clone());
            }
        }
        return novo;
    }
    
        public TreeSet<Imovel> getFavoritosTree() throws SemAutorizacaoException{
        TreeSet<Imovel> novo = new TreeSet<Imovel>(new ComparatorPreco());
        for (Utilizador u: utilizadores.values()){
            if (u instanceof Vendedor){
                throw new SemAutorizacaoException("Não tem autorização para alterar o estado");
            }
            else{
            Comprador c=(Comprador) u;
            for(Imovel i : c.favoritos){
            novo.add(i);
           }
         }     
        }
        return novo;
    }
    
    
    public Map<Imovel, Vendedor> getMapeamentoImoveis(){
        Map<Imovel, Vendedor> novo = new HashMap<Imovel, Vendedor>();
        for(Vendedor v : vendedores){
            for(Imovel i : v.emVenda){
                novo.put(i.clone(),v.clone());
            }
        }
        return novo;
    }
    


}
