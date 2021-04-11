package producto.negocio;

import java.util.ArrayList;
import producto.EjemplarRepository;

public class EjemplarManager {
    private EjemplarRepository repo;

    public EjemplarManager(EjemplarRepository repo) {
        this.repo = repo;
    }
    
    public boolean create(Elemento e,String idEjemplar){
        boolean bRes=false;
        if(!repo.exists(idEjemplar)){
            repo.create(idEjemplar,e);
            bRes=true;
        }
        return bRes;
    }
    
    public ArrayList<Ejemplar> readAll(){
        return repo.readAll();
    }
    
    public int ejemplaresDisponibles() {
        return repo.ejemplaresDisponibles();
    }
}
