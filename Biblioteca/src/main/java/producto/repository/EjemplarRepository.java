package producto.repository;

import java.util.ArrayList;
import producto.model.Elemento;
import producto.model.Ejemplar;

public interface EjemplarRepository {
    public boolean exists(String idEjemplar);
    public void create(String idEjemplar, Elemento e);
    public int ejemplaresDisponibles();
    public Ejemplar getDisponible();
    public ArrayList<Ejemplar> readAll();
}

