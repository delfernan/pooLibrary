package usuario.model;

import prestamo.model.Prestamo;
import producto.model.IEjemplar;

import java.util.ArrayList;

public class Socio extends UserLogin implements UserPrestamo{
    private ArrayList<Prestamo> listaPrestamos;

    public Socio(String user, String pass) {
        super(user, pass);
        listaPrestamos=new ArrayList<>();
    }

    public ArrayList<IEjemplar> ejemplaresPasadosDeFecha() {
        ArrayList<IEjemplar> aRet=new ArrayList();
        for (int i = 0; i < listaPrestamos.size(); i++)
            if(listaPrestamos.get(i).fueraDePlazo())
                aRet.add((IEjemplar) listaPrestamos.get(i).getEjemplar());
        return aRet;
    }
    
    public void addListaPrestamos(IEjemplar ejemplar) {
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
