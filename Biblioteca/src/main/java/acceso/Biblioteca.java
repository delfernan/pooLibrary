package acceso;

import producto.model.*;
import producto.repository.ElementoManager;
import producto.repository.ElementoRepository;
import producto.repository.MemoryElementoRepository;
import usuario.model.Socio;
import usuario.model.UsuarioConDatos;
import usuario.model.UsuarioSinDatos;
import usuario.repository.FileSocioRepository;
import usuario.repository.SocioManager;
import usuario.repository.SocioRepository;

import java.util.ArrayList;
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
        System.out.println("---------------------");
        System.out.println("SOCIOS");
        System.out.println("---------------------");
        if(listaSocios!=null)
            for (int i = 0; i < listaSocios.size(); i++){
                Socio e=(Socio)listaSocios.get(i);
                System.out.println(e);
            }
    }

    public void listarElementos() {
        ArrayList listaElementos=mngElemento.readAll();
        System.out.println("---------------------");
        System.out.println("ELEMENTOS");
        System.out.println("---------------------");
        for (int i = 0; i < listaElementos.size(); i++){
            Elemento e=(Elemento)listaElementos.get(i);
            System.out.println(e.getTitulo());
            System.out.println("\tEjemplares disopobles="+ejemplaresDisponibles(e.getTitulo()));
        }
    }

    public int ejemplaresDisponibles(String titulo) {
        int iRes=0;
        Elemento e=mngElemento.read(titulo);
        
        if (e!=null)
            iRes=mngElemento.ejemplaresDisponibles(titulo);
        return iRes;
    }

    public Socio esSocio(Socio socio) {
        return mngSocio.read(socio.getUser());
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
//        try {
//            String dirName = "./data";
//            
//            Files.list(new File(dirName).toPath())
//                    .limit(10)
//                    .forEach(path -> {
//                        System.out.println(path);
//                    });
//        } catch (IOException ex) {
//            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
        //Creo repositorios de elemento y socio en memoria
        //Elementos
        ElementoRepository repoElemento=new MemoryElementoRepository();
        ElementoManager mngElemento=new ElementoManager(repoElemento);
        
        SocioRepository repoSocio=new FileSocioRepository();
        SocioManager mngSocio=new SocioManager(repoSocio);
        
        //Socios
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos1","pass1"));
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos2","pass2"));
        mngSocio.create(new UsuarioSinDatos("SocioSinDatos3","pass3"));
        mngSocio.create(new UsuarioConDatos("SocioConDatos1","passConDatos1","nombre1","ap11","ap12"));
        mngSocio.create(new UsuarioConDatos("SocioConDatos2","passConDatos2","nombre2","ap21","ap22"));

        //Elementos (con un ejemplar cada uno al menos)
        //creo un repositorio de ejemplares para cada elemento
        Elemento eLibro1=new Libro("Libro1", "autorLibro1");
        Ejemplar ejLibro11=new Ejemplar(eLibro1,"ejLibro11");
        Elemento eMusica1=new Libro("Musica1", "autorMusica1");
        Ejemplar ejMusica11=new Ejemplar(eMusica1,"ejMusica11");
        Elemento eEbook1=new Libro("Ebook1", "autorEbook1");
        Ejemplar ejEbook11=new Ejemplar(eEbook1,"ejEbook11");

        mngElemento.create(eLibro1,ejLibro11);
        mngElemento.create(eMusica1,ejMusica11);
        mngElemento.create(eEbook1,ejEbook11);

        //Creo biblioteca
        Biblioteca biblio = new Biblioteca(mngSocio, mngElemento);
        
        //listo socios
        biblio.listarSocios();
        //listo elementos
        biblio.listarElementos();

        //Podemos agregar ejemplares a algunos elemento
        Ejemplar ejLibro12=new Ejemplar(eLibro1,"ejLibro12");
        Ejemplar ejMusica12=new Ejemplar(eMusica1,"ejMusica12");
        mngElemento.addEjemplar("Libro1", ejLibro12);
        mngElemento.addEjemplar("Musica1", ejMusica12);
        //listo elementos
        biblio.listarElementos();
        
        //Y realizar alguna reserva para un socio
        mngSocio.addPrestamo("SocioSinDatos1", (Ejemplar)mngElemento.reservarEjemplar("Libro1"));
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
