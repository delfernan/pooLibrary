package producto.model;

import producto.repository.EjemplarRepository;


public class Musica extends Elemento {

    public Musica(EjemplarRepository repo,String titulo, String autor, String idEjemplar) {
        super(repo,titulo, autor, idEjemplar);
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
