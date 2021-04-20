/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.model;

/**
 *
 * @author apari
 */
public interface UserData {
    boolean setUserData(String nombre, String primerAp, String segundoAp);
    String getNombre();
    String getPrimerAp();
    String getSegundoAp();
}
