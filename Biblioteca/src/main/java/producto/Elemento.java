package producto;


import java.util.Vector;

public abstract class Elemento {

    private Vector<Ejemplar> ejemplares = new Vector();
    private String titulo;
    private String autor;
    protected int diasPrestamo;
    protected String tipo;

    public Elemento(String titulo, String autor,String idEjemplar) {
        this.titulo = titulo;
        this.autor = autor;
        ejemplares.add(new Ejemplar(this,idEjemplar));
        diasPrestamo = 15;
    }

    public int ejemplaresDisponibles() {
        int iRet = 0;
        for (int i = 0; i < ejemplares.size(); i++) {
            if (!ejemplares.elementAt(i).isPrestado()) {
                iRet++;
            }
        }
        return iRet;
    }
    
    public Vector<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void addEjemplar(String idEjemplar) {
        ejemplares.add(new Ejemplar(this,idEjemplar));
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

    @Override
    public String toString() {
        String sRes = "Elemento Titulo=" + titulo + ", autor=" + autor + ", ";
        sRes += "numero de ejemplares=" + ejemplares.size() + ", ";
        sRes += "numero de disponibles=" + ejemplaresDisponibles() + ", ";
        sRes += "tipo=" + tipo;
        return sRes;
    }

}
