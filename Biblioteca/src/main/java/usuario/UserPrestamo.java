/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.Vector;
import producto.Ejemplar;

/**
 *
 * @author apari
 */
public interface UserPrestamo {
    public Vector<Ejemplar> ejemplaresPasadosDeFecha();
    public void addListaPrestamos(Ejemplar ejemplar);
}
