package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ConsultarEstoqueController {

    @FXML
    private Button back;

    @FXML
    private Label lblconprod;

    @FXML
    private TextField conprod;

    @FXML
    private ImageView conprodlogo;

    @FXML
    private TableView<?> tableconcprod;

    @FXML
    private TableColumn<?, ?> idtableconprod;

    @FXML
    private TableColumn<?, ?> nometableconprod;

    @FXML
    private TableColumn<?, ?> marcatableconprod;

    @FXML
    private TableColumn<?, ?> qmintableconprod;

    @FXML
    private TableColumn<?, ?> qatualtableconprod;

}
