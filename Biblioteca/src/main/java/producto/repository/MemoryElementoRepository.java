package producto.repository;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import producto.model.Ejemplar;
import producto.model.Elemento;


public class MemoryElementoRepository implements ElementoRepository{
    private AbstractMap<String,Elemento> elementos;
    //identificamos cada elemento por su titulo
    private AbstractMap<String,MemoryEjemplarRepository> repoEjemplares;

    public MemoryElementoRepository() {
        elementos=new HashMap();
        repoEjemplares=new HashMap();
    }
       
    @Override
    public boolean exists(String titulo) { 
        return elementos.containsKey(titulo);
    }

    @Override
    public void create(Elemento e,String idEjemplar) {
        elementos.put(e.getTitulo(),e);
        if (repoEjemplares.containsKey(e.getTitulo()))
            repoEjemplares.get(e.getTitulo()).create(idEjemplar, e);
        else{
            MemoryEjemplarRepository temp=new MemoryEjemplarRepository();
            temp.create(idEjemplar, e);
            repoEjemplares.put(e.getTitulo(), temp);
        }
    }
    @Override
    public Elemento read(String titulo) {
        return elementos.get(titulo);
    }
    @Override
    public ArrayList<Elemento> readAll() {
       Collection<Elemento> values = elementos.values();
       ArrayList<Elemento> rE=new ArrayList<>(values);
       return rE;
    }

    @Override
    public void addEjemplar(String titulo,String idEjemplar) {
        Elemento e=elementos.get(titulo);
        repoEjemplares.get(titulo).create(idEjemplar, e);
    }

    @Override
    public int ejemplaresDisponibles(String titulo) {
        return repoEjemplares.get(titulo).ejemplaresDisponibles();
    }

    @Override
    public Ejemplar reservarEjemplar(String titulo) {
        return repoEjemplares.get(titulo).getDisponible();
    }
}