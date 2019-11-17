package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ConsultaClienteController {

    @FXML
    private Button back;

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

}
