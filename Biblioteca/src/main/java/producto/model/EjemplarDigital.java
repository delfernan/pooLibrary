package producto.model;

import prestamo.model.Prestamo;

import java.util.Vector;

public class EjemplarDigital implements IEjemplar{

    private Vector<Prestamo> historicoPrestamos;
    private String idEjemplar;
    private Elemento elemento;
    private boolean prestado;
    public EjemplarDigital(Elemento elemento, String idEjemplar) {
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
    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar=idEjemplar;
    }
    public String getIdEjemplar() { return idEjemplar; }

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
        return "Ejemplar Digital{idEjemplarDigital=" + idEjemplar + ", elemento=" + elemento + ", prestado=" + prestado + '}';
    }
    
}
