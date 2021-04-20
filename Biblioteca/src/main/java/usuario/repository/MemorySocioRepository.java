package usuario.repository;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import usuario.model.Socio;

//import java.util.AbstractList;
//import java.util.ArrayList;

public class MemorySocioRepository implements SocioRepository{
//    private AbstractList<Ejemplar> ejemplares;
    private AbstractMap<String,Socio> socios;

    public MemorySocioRepository() {
        socios=new HashMap<String,Socio>();
    }
       
    @Override
    public boolean exists(String user) { 
        return socios.containsKey(user);
    }

    @Override
    public void create(Socio s) {
        socios.put(s.getUser(),s);
    }

    @Override
    public Socio read(String user) {
        return socios.get(user);
    }

    @Override
    public ArrayList<Socio> readAll() {
       Collection<Socio> values = socios.values();
       ArrayList<Socio> rE=new ArrayList<>(values);
       return rE;
    }
}