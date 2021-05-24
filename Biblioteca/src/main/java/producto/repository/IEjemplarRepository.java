package producto.repository;

import producto.model.IEjemplar;

import java.util.ArrayList;
/**
 * Interface para inyectar el repositorio en el EjemplarManager
 * @author Fernando
 *
 */
public interface IEjemplarRepository {
    public boolean exists(String idEjemplar);
    public void create(IEjemplar iEjemplar);
    public int ejemplaresDisponibles();
    public IEjemplar getDisponible();
    public ArrayList<IEjemplar> readAll();
}

