package producto.model;

public abstract class Elemento {

    private String titulo;
    private String autor;
    protected int diasPrestamo;
    protected String tipo;

    public Elemento(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        
        diasPrestamo = 15;
    }
    
    //pasa al manager
//    public int ejemplaresDisponibles() {
//        return ejemplaresMng.ejemplaresDisponibles();
//    }
    //pasa al manager
//    public Vector<Ejemplar> getEjemplares() {
//        return ejemplares;
//    }
    //pasa al manager
//    public void addEjemplar(String idEjemplar) {
//        //ejemplares.add(new Ejemplar(this,idEjemplar));
//        ejemplaresMng.create(this,idEjemplar);
//    }

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
