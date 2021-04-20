package usuario.model;

import java.util.ArrayList;
import prestamo.model.Prestamo;
import producto.model.Ejemplar;

public class Socio extends UserLogin implements UserPrestamo{
    private ArrayList<Prestamo> listaPrestamos;

    public Socio(String user, String pass) {
        super(user, pass);
        listaPrestamos=new ArrayList<>();
    }

    public ArrayList<Ejemplar> ejemplaresPasadosDeFecha() {
        ArrayList<Ejemplar> aRet=new ArrayList();
        for (int i = 0; i < listaPrestamos.size(); i++)
            if(listaPrestamos.get(i).fueraDePlazo())
                aRet.add(listaPrestamos.get(i).getEjemplar());
        return aRet;
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
            sRet+="\t"+listaPrestamos.get(i)+"\n";
        return sRet;
    }

}
