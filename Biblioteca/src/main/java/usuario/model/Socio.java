package usuario.negocio;


import prestamo.negocio.Prestamo;
import producto.negocio.Ejemplar;
import java.util.Vector;

public class Socio extends UserLogin implements UserPrestamo{
    private Vector<Prestamo> listaPrestamos;

    public Socio(String user, String pass) {
        super(user, pass);
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

    public String getUser() {
        return super.user;
    }

    @Override
    public String toString() {
        String sRet="Socio user=" + user+"\n";
        sRet+="\tLista de Prestamos: \n";
        for (int i=0;i<listaPrestamos.size();i++)
            sRet+="\t"+listaPrestamos.elementAt(i)+"\n";
        return sRet;
    }

}
