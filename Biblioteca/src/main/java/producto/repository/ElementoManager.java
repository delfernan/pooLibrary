package producto.repository;

import java.util.ArrayList;
import producto.model.Elemento;

public class ElementoManager {
    private ElementoRepository repo;
    private EjemplarRepository repoEjemplar;


    public ElementoManager(ElementoRepository repo) {
        this.repo = repo;
    }
    
    public boolean create(Elemento e,String idEjemplar){
        boolean bRes=false;
        if(!repo.exists(e.getTitulo())){
            repo.create(e,idEjemplar);
            bRes=true;
        }
        return bRes;
    }
    
    public Elemento read(String titulo){
        Elemento eRet=null;
        if(repo.exists(titulo))
            eRet=repo.read(titulo);
        return eRet;
    }
    public boolean createEjemplar(String tituloElemento,String idEjemplar){
        boolean bRes=false;
        if(!repo.exists(tituloElemento)){
            repo.createEjemplar(tituloElemento,idEjemplar);
            bRes=true;
        }
        return bRes;
    }
    public ArrayList<Elemento> readAll(){
        return repo.readAll();
    }
}
