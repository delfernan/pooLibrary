package producto.model;

import java.util.ArrayList;
import producto.repository.EjemplarManager;
import producto.repository.EjemplarRepository;

public abstract class Elemento {

    private EjemplarManager ejemplaresMng;
    private String titulo;
    private String autor;
    protected int diasPrestamo;
    protected String tipo;

    public Elemento(EjemplarRepository repo,String titulo, String autor,String idEjemplar) {
        this.titulo = titulo;
        this.autor = autor;
        ejemplaresMng=new EjemplarManager(repo);
        ejemplaresMng.create(this,idEjemplar);
        //agregamos tambien a la propiedad
        //ejemplares.add(new Ejemplar(this,idEjemplar));
        
        diasPrestamo = 15;
    }

    public int ejemplaresDisponibles() {
        return ejemplaresMng.ejemplaresDisponibles();
    }
    
//    public Vector<Ejemplar> getEjemplares() {
//        return ejemplares;
//    }

    public void addEjemplar(String idEjemplar) {
        //ejemplares.add(new Ejemplar(this,idEjemplar));
        ejemplaresMng.create(this,idEjemplar);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /**
     * Cada subclase puede tener dias de prestamo diferentes
     *
     * @return numero de dias
     */
    public abstract int getDiasPrestamo();

    public abstract void setTipo(String tipo);

//    @Override
//    public String toString() {
//        String sRes = "Elemento Titulo=" + titulo + ", autor=" + autor + ", ";
//        sRes += "numero de ejemplares=" + ejemplares.size() + ", ";
//        sRes += "numero de disponibles=" + ejemplaresDisponibles() + ", ";
//        sRes += "tipo=" + tipo;
//        return sRes;
//    }

}
