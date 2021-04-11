package producto.negocio;

import prestamo.negocio.Prestamo;
import java.util.Vector;

public class Ejemplar {

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
