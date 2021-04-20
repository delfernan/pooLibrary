package producto.repository;

import java.util.ArrayList;
import producto.model.Elemento;

public interface ElementoRepository {
    public boolean exists(String titulo);
    public void create(Elemento e,String idEjemplar);
    public Elemento read(String titulo);
    public void createEjemplar(String titulo,String idEjemplar);
    public ArrayList<Elemento> readAll();
}

