package acceso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import usuario.repository.MemorySocioRepository;
import usuario.repository.SocioManager;
import usuario.repository.ISocioRepository;
import usuario.ui.CreateSocioController;

/**
 *
 * @author Fernando
 */
public class BibliotecaFXMain extends Application {
    private ISocioRepository repoSocio;
    private SocioManager mngSocio;
    @Override
    public void start(Stage stage) throws Exception {
        repoSocio=new MemorySocioRepository();
        mngSocio=new SocioManager(repoSocio);
        FXMLLoader root = new FXMLLoader(getClass().getResource("/usuario/ui/CreateSocio.fxml"));
        CreateSocioController controller = new CreateSocioController();
        controller.setManager(mngSocio);
        root.setController(controller);
        stage.setTitle("Create Socio");
        stage.setScene(new Scene(root.load(), 300, 275));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(BibliotecaFXMain.class,args);
    }

}
