package acceso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import usuario.MemorySocioRepository;
import usuario.SocioManager;
import usuario.SocioRepository;
import usuario.ui.CreateSocioController;

/**
 *
 * @author apari
 */
public class BibliotecaFXMain extends Application {
    private SocioRepository repoSocio;
    private SocioManager mngSocio;
    @Override
    public void start(Stage stage) throws Exception {
        repoSocio=new MemorySocioRepository();
        mngSocio=new SocioManager(repoSocio);
        Parent root = FXMLLoader.load(getClass().getResource("/usuario/ui/CreateSocio.fxml"));
        CreateSocioController controller = new CreateSocioController();
        controller.setManager(mngSocio);
        stage.setTitle("Create Socio");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(BibliotecaFXMain.class,args);
    }

}
