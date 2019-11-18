package controller;

import application.Main;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.RenderizarView;

public class ConsultarClienteController {
    RenderizarView tela;

    @FXML
    private Label lblconcli;

    @FXML
    private TextField concli;

    @FXML
    private ImageView conclilogo;

    @FXML
    private TableView<?> tableconcli;

    @FXML
    private TableColumn<?, ?> idtableconcli;

    @FXML
    private TableColumn<?, ?> nometableconcli;

    @FXML
    private TableColumn<?, ?> cpftableconcli;

    @FXML
    private TableColumn<?, ?> dtnasctableconcli;

    @FXML
    private TableColumn<?, ?> teltableconcli;

    @FXML
    private TableColumn<?, ?> endtableconcli;

    @FXML
    private TableColumn<?, ?> mailtableconcli;

    public void onActionBack() throws IOException {
        tela= new RenderizarView();
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.ConsultarClienteView.close();
    }
}
