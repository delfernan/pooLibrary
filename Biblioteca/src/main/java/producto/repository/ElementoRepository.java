package producto.repository;

import producto.model.Elemento;
import producto.model.IEjemplar;

import java.util.ArrayList;

public interface ElementoRepository {
    public boolean exists(String titulo);
    public void create(Elemento e, IEjemplar iEjemplar);
    public Elemento read(String titulo);
    public void addEjemplar(String titulo,IEjemplar iEjemplar);
    public int ejemplaresDisponibles(String titulo);
    public IEjemplar reservarEjemplar(String titulo);
    public ArrayList<Elemento> readAll();
}

