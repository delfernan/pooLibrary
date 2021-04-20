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
public abstract class UserLogin {
    protected String user;
    protected String pass;

    public UserLogin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public abstract String getUser();
}
