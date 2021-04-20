/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.model;

import java.io.Serializable;

/**
 *
 * @author apari
 */
public class UsuarioSinDatos extends Socio implements Serializable{
    private static final long serialVersionUID = 12345678912L;
    public UsuarioSinDatos(String user, String pass) {
        super(user, pass);
    }
    
}
