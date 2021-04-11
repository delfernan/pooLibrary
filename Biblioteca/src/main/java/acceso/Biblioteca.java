package acceso;

import java.util.ArrayList;
import producto.ElementoRepository;
import producto.MemoryEjemplarRepository;
import producto.MemoryElementoRepository;
import usuario.negocio.*;
import producto.negocio.*;
import usuario.MemorySocioRepository;
import usuario.SocioRepository;
/**
 * Biblioteca demo para POO
 * @author Fernando
 */
public class Biblioteca {
//    private Vector<Socio> listaSocios;
//    private Vector<Elemento> listaElementos;
    private SocioManager mngSocio;
    private ElementoManager mngElemento;

    /**
     * Constructor
     * @param listaSocios lista de socios dados de alta
     * @param listaElementos lista de productos disponibles
     */
    public Biblioteca(SocioManager mngSocio, ElementoManager mngElemento) {
        this.mngSocio = mngSocio;
        this.mngElemento = mngElemento;
    }

    public void listarSocios() {
        ArrayList listaSocios=mngSocio.readAll();
        for (int i = 0; i < listaSocios.size(); i++){
            Socio e=(Socio)listaSocios.get(i);
            System.out.println(e.getUser());
        }
    }

    public void listarElementos() {
        ArrayList listaElementos=mngElemento.readAll();
        for (int i = 0; i < listaElementos.size(); i++){
            Elemento e=(Elemento)listaElementos.get(i);
            System.out.println(e.getTitulo());
        }
    }

    public boolean ejemplaresDisponibles(String titulo) {
        int iRes=0;
        Elemento e=mngElemento.read(titulo);
        if (e!=null)
            iRes=e.ejemplaresDisponibles();
        return iRes>0;
    }

    public Socio esSocio(Socio socio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    public void prestar(Socio socio, Elemento elemento) {
//        //buscamos el primer ejemplar disponible en el elemento
//        for (int i = 0; i < elemento.getEjemplares().size(); i++) {
//            if (!elemento.getEjemplares().elementAt(i).isPrestado()) {
//                socio.addListaPrestamos(elemento.getEjemplares().elementAt(i));
//                break;
//            }
//        }
//    }

    public static void main(String[] args) {
        //Creo repositorios de elemento y socio en memoria
        //Elementos
        ElementoRepository repoElemento=new MemoryElementoRepository();
        ElementoManager mngElemento=new ElementoManager(repoElemento);
        
        SocioRepository repoSocio=new MemorySocioRepository();
        SocioManager mngSocio=new SocioManager(repoSocio);
        
        //Socios
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos1","pass1"));
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos2","pass2"));
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos3","pass3"));
        mngSocio.create(new UsuarioConDatos("SocioConDatos1","passConDatos1"));
        mngSocio.create(new UsuarioConDatos("SocioConDatos2","passConDatos2"));

        //Elementos (con un ejemplar cada uno al menos)
        //creo un repositorio de ejemplares para cada elemento
        mngElemento.create(new Libro(new MemoryEjemplarRepository(),"Libro1", "idLibro1", "idEjemplarLibro11"), "idEjemplarLibro11");
        mngElemento.create(new Libro(new MemoryEjemplarRepository(),"Libro1", "idLibro1", "idEjemplarLibro11"), "idEjemplarLibro11");
        mngElemento.create(new Libro(new MemoryEjemplarRepository(),"Libro2", "idLibro2", "idEjemplarLibro21"), "idEjemplarLibro21");
        mngElemento.create(new Libro(new MemoryEjemplarRepository(),"Libro3", "idLibro3", "idEjemplarLibro31"), "idEjemplarLibro31");

        mngElemento.create(new Musica(new MemoryEjemplarRepository(),"Musica1", "idMusica1", "idEjemplarMusica11"), "idEjemplarMusica11");
        mngElemento.create(new Musica(new MemoryEjemplarRepository(),"Musica2", "idMusica2", "idEjemplarMusica21"), "idEjemplarMusica21");
        mngElemento.create(new Musica(new MemoryEjemplarRepository(),"Musica3", "idMusica3", "idEjemplarMusica31"), "idEjemplarMusica31");

        mngElemento.create(new Ebook(new MemoryEjemplarRepository(),"Ebook1", "idEbook1", "idEjemplarEbook11"), "idEjemplarEbook11");
        mngElemento.create(new Ebook(new MemoryEjemplarRepository(),"Ebook2", "idEbook2", "idEjemplarEbook21"), "idEjemplarEbook21");
        mngElemento.create(new Ebook(new MemoryEjemplarRepository(),"Ebook3", "idEbook3", "idEjemplarEbook31"), "idEjemplarEbook31");
        
        //Creo biblioteca
        Biblioteca biblio = new Biblioteca(mngSocio, mngElemento);
        
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

//        //Podemos agregar ejemplares a algunos elemento
//        listaElementos.elementAt(0).addEjemplar("idEjemplarLibro12");
//        listaElementos.elementAt(3).addEjemplar("idEjemplarMusica12");
//
//        //Y realizar alguna reserva para un socio, por ejemplo para las primeras posiciones
//        Elemento eReserva = listaElementos.elementAt(0);
//        Socio sReserva = listaSocios.elementAt(0);
//        if (biblio.elementoDisponible(eReserva)
//                && sReserva.ejemplaresPasadosDeFecha().isEmpty()) {
//            //buscamos el primer ejemplar disponible en el elemento
//            for (int i = 0; i < eReserva.getEjemplares().size(); i++) {
//                if (!eReserva.getEjemplares().elementAt(i).isPrestado()) {
//                    sReserva.addListaPrestamos(eReserva.getEjemplares().elementAt(i));
//                    break;
//                }
//            }
//        }
//
//        //Volvemos a imprimir todo
//        //listo socios
//        System.out.println("---------------------");
//        System.out.println("SOCIOS");
//        System.out.println("---------------------");
//        biblio.listarSocios();
//        //listo elementos
//        System.out.println("---------------------");
//        System.out.println("ELEMENTOS");
//        System.out.println("---------------------");
//        biblio.listarElementos();
    }
}
