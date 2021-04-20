package producto.model;

import producto.repository.EjemplarRepository;

public class Ebook extends Elemento {

    public Ebook(EjemplarRepository repo,String titulo, String autor, String idEjemplar) {
        super(repo,titulo, autor, idEjemplar);
        setTipo("Ebook");
    }
    @Override
    public int getDiasPrestamo() {
        return super.diasPrestamo*2;
    }
    @Override
    public void setTipo(String tipo) {
        super.tipo = tipo;
    }
}
