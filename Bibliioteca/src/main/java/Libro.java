
public class Libro extends Elemento {

    public Libro(String titulo, String autor, String idEjemplar) {
        super(titulo, autor, idEjemplar);
        setTipo("Libro");
    }
    @Override
    public int getDiasPrestamo() {
        return super.diasPrestamo;
    }
    @Override
    public void setTipo(String tipo) {
        super.tipo = tipo;
    }
}
