package producto.repository;

import producto.model.Elemento;
import producto.model.IEjemplar;

import java.util.ArrayList;


public class EjemplarManager {
    private EjemplarRepository repo;

    public EjemplarManager(EjemplarRepository repo) {
        this.repo = repo;
    }
    
    public boolean create(Elemento e,IEjemplar iEjemplar){
        boolean bRes=false;
        if(!repo.exists(iEjemplar.getIdEjemplar())){
            repo.create(iEjemplar);
            bRes=true;
        }
        return bRes;
    }
    
    public ArrayList<IEjemplar> readAll(){
        return repo.readAll();
    }
    
    public int ejemplaresDisponibles() {
        return repo.ejemplaresDisponibles();
    }
}
