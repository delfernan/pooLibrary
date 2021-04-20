package usuario.repository;

import common.FileUtil;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import usuario.model.Socio;

public class FileSocioRepository implements SocioRepository{
    private final String filePath="data/socio.dat";
    private AbstractMap<String,Socio> socios;

    public FileSocioRepository() {
        socios=new HashMap<>();
    }
       
    @Override
    public boolean exists(String user) { 
        return socios.containsKey(user);
    }

    @Override
    public void create(Socio s) {
        socios.put(s.getUser(),s);
        FileUtil.serializeToFile(filePath,(HashMap)socios);
    }

    @Override
    public Socio read(String user) {
        return socios.get(user);
    }

    @Override
    public ArrayList<Socio> readAll() {
        socios=FileUtil.deserializeFromFile(filePath);
        Collection<Socio> values = socios.values();
        ArrayList<Socio> rE=new ArrayList<>(values);
        return rE;
    }
}