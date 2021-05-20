package producto.repository;
import producto.model.Elemento;
import producto.model.IEjemplar;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MemoryEjemplarRepository implements EjemplarRepository{
    private AbstractMap<String,IEjemplar> ejemplares;

    public MemoryEjemplarRepository() {
        ejemplares=new HashMap<String,IEjemplar>();
    }
       
    @Override
    public boolean exists(String idEjemplar) { 
        return ejemplares.containsKey(idEjemplar);
    }

    //CAMBIAR EL NEW EJEMPLAR
    @Override
    public void create(IEjemplar iEjemplar) {
        ejemplares.put(iEjemplar.getIdEjemplar(),iEjemplar);
    }

    @Override
    public int ejemplaresDisponibles() {
        int iRet = 0;
        for (IEjemplar value : ejemplares.values())
            if (!value.isPrestado()) iRet++;
 
        return iRet;
    }
    
    @Override
    public IEjemplar getDisponible() {
        IEjemplar eRet=null;
        for (IEjemplar value : ejemplares.values())
            if (!value.isPrestado()) eRet=value;
        return eRet;
    }
    
    @Override
    public ArrayList<IEjemplar> readAll() {
       Collection<IEjemplar> values = ejemplares.values();
       ArrayList<IEjemplar> rE=new ArrayList<>(values);
       return rE;
    }
}