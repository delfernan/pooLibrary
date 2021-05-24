package producto.model;

import prestamo.model.Prestamo;
/**
 * Interface para inyectar el Ejemplar
 * @author Fernando
 *
 */
public interface IEjemplar {
    public void setIdEjemplar(String idEjemplar);
    public String getIdEjemplar();
    public void addPrestamo(Prestamo prestamo);
    public boolean isPrestado();
    public Elemento getElemento();
    public void setPrestado(boolean prestado);
}
