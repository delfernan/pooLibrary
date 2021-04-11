package producto;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import producto.negocio.Ejemplar;
import producto.negocio.Elemento;

//import java.util.AbstractList;
//import java.util.ArrayList;

public class MemoryEjemplarRepository implements EjemplarRepository{
//    private AbstractList<Ejemplar> ejemplares;
    private AbstractMap<String,Ejemplar> ejemplares;

    public MemoryEjemplarRepository() {
        ejemplares=new HashMap<String,Ejemplar>();
    }
       
    @Override
    public boolean exists(String idEjemplar) { 
        return ejemplares.containsKey(idEjemplar);
    }

    @Override
    public void create(String idEjemplar, Elemento e) {
        ejemplares.put(idEjemplar,new Ejemplar(e,idEjemplar));
    }

    @Override
    public int ejemplaresDisponibles() {
        int iRet = 0;
        for (Ejemplar value : ejemplares.values())
            if (!value.isPrestado()) iRet++;
 
        return iRet;
    }

    @Override
    public ArrayList<Ejemplar> readAll() {
       Collection<Ejemplar> values = ejemplares.values();
       ArrayList<Ejemplar> rE=new ArrayList<>(values);
       return rE;
    }
}