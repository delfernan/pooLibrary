package producto.negocio;

import producto.EjemplarRepository;


public class Libro extends Elemento {

    public Libro(EjemplarRepository repo,String titulo, String autor, String idEjemplar) {
        super(repo,titulo, autor, idEjemplar);
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
