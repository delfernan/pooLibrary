/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import usuario.MemorySocioRepository;
//import usuario.SocioRepository;
import usuario.SocioManager;
import usuario.negocio.UsuarioSinDatos;
 
public class CreateSocioController {
    @FXML
    private TextField txUser;
    @FXML
    private TextField txPassword;
    @FXML
    private Button createId;
    
//    private SocioRepository repoSocio;
    private SocioManager mngSocio;
    
//    public CreateSocioController() {
//        repoSocio=new MemorySocioRepository();
//        mngSocio=new SocioManager(repoSocio);
//    }
    
    public void setManager(SocioManager mngSocio){
        this.mngSocio=mngSocio;
    }

    @FXML  protected void onActionCreate(ActionEvent event) {
        //Socios
        mngSocio.create(new UsuarioSinDatos(txUser.getText(),txPassword.getText()));
        System.out.println("creado"+txUser.getText());
    }


}
