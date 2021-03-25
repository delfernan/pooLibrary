
public class Musica extends Elemento {

    public Musica(String titulo, String autor, String idEjemplar) {
        super(titulo, autor, idEjemplar);
        setTipo("Musica");
    }

    @Override
    public int getDiasPrestamo() {
        return super.diasPrestamo * 4;
    }

    @Override
    public void setTipo(String tipo) {
        super.tipo = tipo;
    }
}
