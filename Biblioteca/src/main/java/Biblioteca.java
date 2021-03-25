
import java.util.Vector;

public class Biblioteca {

    private Vector<Socio> listaSocios;
    private Vector<Elemento> listaElementos;

    public Biblioteca(Vector<Socio> listaSocios, Vector<Elemento> listaElementos) {
        this.listaSocios = listaSocios;
        this.listaElementos = listaElementos;
    }

    public void listarSocios() {
        for (int i = 0; i < listaSocios.size(); i++) 
            System.out.println(listaSocios.elementAt(i).toString());
    }

    public void listarElementos() {
        for (int i = 0; i < listaElementos.size(); i++)
            System.out.println(listaElementos.elementAt(i));
    }

    public boolean elementoDisponible(Elemento elemento) {
        return elemento.ejemplaresDisponibles() > 0;
    }

    public Socio esSocio(Socio socio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void prestar(Socio socio, Elemento elemento) {
        //buscamos el primer ejemplar disponible en el elemento
        for (int i = 0; i < elemento.getEjemplares().size(); i++) {
            if (!elemento.getEjemplares().elementAt(i).isPrestado()) {
                socio.addListaPrestamos(elemento.getEjemplares().elementAt(i));
                break;
            }
        }
    }

    public static void main(String[] args) {
        //Socios
        Vector<Socio> listaSocios = new Vector();
        listaSocios.add(new Socio("Socio1"));
        listaSocios.add(new Socio("Socio2"));
        listaSocios.add(new Socio("Socio3"));
        listaSocios.add(new Socio("Socio4"));
        listaSocios.add(new Socio("Socio5"));

        //Elementos (con un ejemplar cada uno al menos)
        Vector<Elemento> listaElementos = new Vector();
        listaElementos.add(new Libro("Libro1", "idLibro1", "idEjemplarLibro11"));
        listaElementos.add(new Libro("Libro2", "idLibro2", "idEjemplarLibro21"));
        listaElementos.add(new Libro("Libro3", "idLibro3", "idEjemplarLibro31"));

        listaElementos.add(new Musica("Musica1", "idMusica1", "idEjemplarMusica11"));
        listaElementos.add(new Musica("Musica2", "idMusica2", "idEjemplarMusica21"));
        listaElementos.add(new Musica("Musica3", "idMusica3", "idEjemplarMusica31"));

        listaElementos.add(new Ebook("Ebook1", "idEbook1", "idEjemplarEbook11"));
        listaElementos.add(new Ebook("Ebook2", "idEbook2", "idEjemplarEbook21"));
        listaElementos.add(new Ebook("Ebook3", "idEbook3", "idEjemplarEbook31"));

        //Creo biblioteca
        Biblioteca biblio = new Biblioteca(listaSocios, listaElementos);
        //listo socios
        System.out.println("---------------------");
        System.out.println("SOCIOS");
        System.out.println("---------------------");
        biblio.listarSocios();
        //listo elementos
        System.out.println("---------------------");
        System.out.println("ELEMENTOS");
        System.out.println("---------------------");
        biblio.listarElementos();

        //Podemos agregar ejemplares a algunos elemento
        listaElementos.elementAt(0).addEjemplar("idEjemplarLibro12");
        listaElementos.elementAt(3).addEjemplar("idEjemplarMusica12");

        //Y realizar alguna reserva para un socio, por ejemplo para las primeras posiciones
        Elemento eReserva = listaElementos.elementAt(0);
        Socio sReserva = listaSocios.elementAt(0);
        if (biblio.elementoDisponible(eReserva)
                && sReserva.ejemplaresPasadosDeFecha().isEmpty()) {
            //buscamos el primer ejemplar disponible en el elemento
            for (int i = 0; i < eReserva.getEjemplares().size(); i++) {
                if (!eReserva.getEjemplares().elementAt(i).isPrestado()) {
                    sReserva.addListaPrestamos(eReserva.getEjemplares().elementAt(i));
                    break;
                }
            }
        }

        //Volvemos a imprimir todo
        //listo socios
        System.out.println("---------------------");
        System.out.println("SOCIOS");
        System.out.println("---------------------");
        biblio.listarSocios();
        //listo elementos
        System.out.println("---------------------");
        System.out.println("ELEMENTOS");
        System.out.println("---------------------");
        biblio.listarElementos();
    }
}
