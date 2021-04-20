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
public class UsuarioConDatos extends Socio implements UserData{
    private static final long serialVersionUID = 12345678911L;
    private String nombre="";
    private String primerAp="";
    private String segundoAp="";
    public UsuarioConDatos(String user, String pass) {
        super(user, pass);
    }
    public UsuarioConDatos(String user, String pass,String nombre, String primerAp, String segundoAp) {
        super(user, pass);
        setUserData(nombre, primerAp, segundoAp);
    }
    @Override
    public boolean setUserData(String nombre, String primerAp, String segundoAp) {
        if (nombre!="" && primerAp!="" && segundoAp!=""){
            this.nombre=nombre;
            this.primerAp=primerAp;
            this.segundoAp=segundoAp;
            return true;
        }
        return false;
    }

    @Override
    public String getNombre() {
         return nombre;
    }

    @Override
    public String getPrimerAp() {
        return primerAp;
    }

    @Override
    public String getSegundoAp() {
        return segundoAp;
    }

    @Override
    public String toString() {
        return "UsuarioConDatos{" + "nombre=" + nombre + ", primerAp=" + primerAp + ", segundoAp=" + segundoAp + '}'+
                super.toString();
    }
    
}
