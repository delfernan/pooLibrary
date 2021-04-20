package producto.repository;

import java.util.ArrayList;
import producto.model.Elemento;
import producto.model.Ejemplar;

public interface ElementoRepository {
    public boolean exists(String titulo);
    public void create(Elemento e,String idEjemplar);
    public Elemento read(String titulo);
    public void addEjemplar(String titulo,String idEjemplar);
    public int ejemplaresDisponibles(String titulo);
    public Ejemplar reservarEjemplar(String titulo);
    public ArrayList<Elemento> readAll();
}

