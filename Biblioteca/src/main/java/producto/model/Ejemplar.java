package producto.model;

import prestamo.model.Prestamo;
import java.util.Vector;

public class Ejemplar implements IEjemplar{

    private Vector<Prestamo> historicoPrestamos;

    private String idEjemplar;
    private Elemento elemento;
    private boolean prestado;
    public Ejemplar(Elemento elemento,String idEjemplar) {
        this.elemento = elemento;
        this.idEjemplar=idEjemplar;
        historicoPrestamos=new Vector();
        prestado=false;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar=idEjemplar;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void addPrestamo(Prestamo prestamo){
        if(!prestado)
            historicoPrestamos.add(prestamo);
        prestado=true;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Elemento getElemento() {
        return elemento;
    }

    @Override
    public String toString() {
        return "Ejemplar{idEjemplar=" + idEjemplar + ", elemento=" + elemento + ", prestado=" + prestado + '}';
    }
    
}
