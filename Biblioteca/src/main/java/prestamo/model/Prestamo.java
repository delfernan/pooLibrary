package prestamo.model;


import producto.model.IEjemplar;
import usuario.model.Socio;

public class Prestamo {
    private Socio socio;
    private long fechaFin;
    private long fechaDevolucionReal;
    private IEjemplar ejemplar;

    public Prestamo(Socio socio, IEjemplar ejemplar) {
        this.socio = socio;
        this.ejemplar = ejemplar;
        fechaFin=System.currentTimeMillis()+
                ejemplar.getElemento().getDiasPrestamo()*24*3600*1000;
        ejemplar.setPrestado(true);
        fechaDevolucionReal=-1;
    }

    public boolean estaDevuelto() {
        boolean bRet=false;
        if(fechaDevolucionReal-fechaFin>0)
            bRet=true;
        return bRet;
    }
    
    public boolean fueraDePlazo() {
        boolean bRet=true;
        long now=System.currentTimeMillis();
        if(fechaFin-now>0)
            bRet=false;
        return bRet;
    }
    
    public IEjemplar getEjemplar() {
        return ejemplar;
    }

    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaDevolucionReal(long fechaDevolucionReal) {
        this.fechaDevolucionReal=fechaDevolucionReal;
    }

    @Override
    public String toString() {
        String sRet="Ejemplar:\n";
        sRet+="\t"+ejemplar+"\n";
        sRet+="\tfechaFin=" + fechaFin + ", fechaDevolucionReal=" + fechaDevolucionReal;
        sRet+="\tdevuelto="+estaDevuelto();
        sRet+="\tfuera de plazo="+fueraDePlazo();
        return sRet;
    }
    
}
