package producto.repository;

import java.util.ArrayList;
import producto.model.Ejemplar;
import producto.model.Elemento;

public class ElementoManager {
    private ElementoRepository repo;


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
    public boolean addEjemplar(String tituloElemento,String idEjemplar){
        boolean bRes=false;
        if(repo.exists(tituloElemento)){
            repo.addEjemplar(tituloElemento,idEjemplar);
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
    
    public Ejemplar reservarEjemplar(String tituloElemento){
        return repo.reservarEjemplar(tituloElemento);
    }
}
