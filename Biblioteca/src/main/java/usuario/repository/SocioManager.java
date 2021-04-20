package usuario.repository;

import java.util.ArrayList;
import usuario.model.Socio;

public class SocioManager {
    private SocioRepository repo;

    public SocioManager(SocioRepository repo) {
        this.repo = repo;
    }
    
    public boolean create(Socio s){
        boolean bRes=false;
        if(!repo.exists(s.getUser())){
            repo.create(s);
            bRes=true;
        }
        return bRes;
    }
    
    public ArrayList<Socio> readAll(){
        return repo.readAll();
    }
}
