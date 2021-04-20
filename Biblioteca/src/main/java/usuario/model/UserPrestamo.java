/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.model;

import java.util.ArrayList;
import producto.model.Ejemplar;
/**
 *
 * @author apari
 */
public interface UserPrestamo{
    public ArrayList<Ejemplar> ejemplaresPasadosDeFecha();
    public void addListaPrestamos(Ejemplar ejemplar);
}
