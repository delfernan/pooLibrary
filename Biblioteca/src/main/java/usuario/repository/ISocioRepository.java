package usuario.repository;

import java.util.ArrayList;
import usuario.model.Socio;
/**
 * Interface para inyectar el repositorio en el SocioManager
 * @author Fernando
 *
 */
public interface ISocioRepository {
    public boolean exists(String user);
    public void create(Socio s);
    public Socio read(String user);
//    public void addReserva(String titulo,String idEjemplar);
    public ArrayList<Socio> readAll();
}

