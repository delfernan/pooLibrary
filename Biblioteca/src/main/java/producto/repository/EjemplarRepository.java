package producto.repository;

import java.util.ArrayList;

public interface EjemplarRepository {
    public boolean exists(String idEjemplar);
    public void create(String idEjemplar, Elemento e);
    public int ejemplaresDisponibles();
    public ArrayList<Ejemplar> readAll();
}

