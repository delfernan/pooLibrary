package producto.repository;

import producto.model.IEjemplar;

import java.util.ArrayList;

public interface EjemplarRepository {
    public boolean exists(String idEjemplar);
    public void create(IEjemplar iEjemplar);
    public int ejemplaresDisponibles();
    public IEjemplar getDisponible();
    public ArrayList<IEjemplar> readAll();
}

