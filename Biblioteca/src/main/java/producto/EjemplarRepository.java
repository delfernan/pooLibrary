package producto;

import java.util.ArrayList;
import producto.negocio.Ejemplar;
import producto.negocio.Elemento;

public interface EjemplarRepository {
    public boolean exists(String idEjemplar);
    public void create(String idEjemplar, Elemento e);
    public int ejemplaresDisponibles();
    public ArrayList<Ejemplar> readAll();
}

