package usuario.repository;

import java.util.ArrayList;
import producto.model.Ejemplar;
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
    
    public Socio read(String user){
        Socio eRet=null;
        if(repo.exists(user))
            eRet=repo.read(user);
        return eRet;
    }
    
    public ArrayList<Socio> readAll(){
        return repo.readAll();
    }
    
    public void addPrestamo(String user,Ejemplar ejemplar){
        if(!repo.exists(user))
            repo.read(user).addListaPrestamos(ejemplar);
    }
}
