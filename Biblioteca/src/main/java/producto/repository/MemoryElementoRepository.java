package producto.repository;
import producto.model.Elemento;
import producto.model.IEjemplar;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class MemoryElementoRepository implements IElementoRepository{
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
    public void create(Elemento e,IEjemplar iEjemplar) {
        elementos.put(e.getTitulo(),e);
        if (repoEjemplares.containsKey(e.getTitulo()))
            repoEjemplares.get(e.getTitulo()).create(iEjemplar);
        else{
            MemoryEjemplarRepository temp=new MemoryEjemplarRepository();
            temp.create(iEjemplar);
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
    public void addEjemplar(String titulo,IEjemplar iEjemplar) {
        Elemento e=elementos.get(titulo);
        repoEjemplares.get(titulo).create(iEjemplar);
    }

    @Override
    public int ejemplaresDisponibles(String titulo) {
        return repoEjemplares.get(titulo).ejemplaresDisponibles();
    }

    @Override
    public IEjemplar reservarEjemplar(String titulo) {
        return repoEjemplares.get(titulo).getDisponible();
    }
}