
import java.util.Vector;

public class Socio {
    private String nombre;
    private Vector<Prestamo> listaPrestamos;

    public Socio(String nombre) {
        this.nombre = nombre;
        listaPrestamos=new Vector();
    }
    
    public Vector<Ejemplar> ejemplaresPasadosDeFecha() {
        Vector<Ejemplar> vRet=new Vector();
        for (int i = 0; i < listaPrestamos.size(); i++)
            if(listaPrestamos.elementAt(i).fueraDePlazo())
                vRet.add(listaPrestamos.elementAt(i).getEjemplar());
        return vRet;
    }
    
    public void addListaPrestamos(Ejemplar ejemplar) {
        listaPrestamos.add(new Prestamo(this,ejemplar));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String sRet="Socio " + "nombre=" + nombre+"\n";
        sRet+="\tLista de Prestamos: \n";
        for (int i=0;i<listaPrestamos.size();i++)
            sRet+="\t"+listaPrestamos.elementAt(i)+"\n";
        return sRet;
    }

}
