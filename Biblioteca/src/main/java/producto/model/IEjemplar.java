package producto.model;

import prestamo.model.Prestamo;

public interface IEjemplar {
    public void setIdEjemplar(String idEjemplar);
    public String getIdEjemplar();
    public void addPrestamo(Prestamo prestamo);
    public boolean isPrestado();
    public Elemento getElemento();
    public void setPrestado(boolean prestado);
}
