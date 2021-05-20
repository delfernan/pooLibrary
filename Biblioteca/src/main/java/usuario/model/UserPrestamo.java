/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.model;

import producto.model.IEjemplar;

import java.util.ArrayList;

/**
 *
 * @author apari
 */
public interface UserPrestamo{
    ArrayList<IEjemplar> ejemplaresPasadosDeFecha();
    public void addListaPrestamos(IEjemplar ejemplar);
}
