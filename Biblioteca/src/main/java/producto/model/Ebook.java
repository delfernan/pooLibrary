package producto.model;

public class Ebook extends Elemento {

    public Ebook(String titulo, String autor) {
        super(titulo, autor);
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
