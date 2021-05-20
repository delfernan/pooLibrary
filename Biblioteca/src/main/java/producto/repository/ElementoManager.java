package producto.repository;

import producto.model.Elemento;
import producto.model.IEjemplar;

import java.util.ArrayList;

public class ElementoManager {
    private ElementoRepository repo;
    public ElementoManager(ElementoRepository repo) {
        this.repo = repo;
    }
    
    public boolean create(Elemento e,IEjemplar iEjemplar){
        boolean bRes=false;
        if(!repo.exists(e.getTitulo())){
            repo.create(e,iEjemplar);
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
    public boolean addEjemplar(String tituloElemento,IEjemplar iEjemplar){
        boolean bRes=false;
        if(repo.exists(tituloElemento)){
            repo.addEjemplar(tituloElemento,iEjemplar);
            bRes=true;
        }
        return bRes;
    }
    public ArrayList<Elemento> readAll(){
        return repo.readAll();
    }
    
    public int ejemplaresDisponibles(String tituloElemento) {
        return repo.ejemplaresDisponibles(tituloElemento);
    }
    
    public IEjemplar reservarEjemplar(String tituloElemento){
        return repo.reservarEjemplar(tituloElemento);
    }
}
