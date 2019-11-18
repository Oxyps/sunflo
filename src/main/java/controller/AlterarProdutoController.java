package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AlterarProdutoController {

    @FXML
    private Button back;

    @FXML
    private Label altprodlbl;

    @FXML
    private ChoiceBox<?> altprodchbx;

    @FXML
    private Button savealtprod;

    @FXML
    private TextField codprodalt;

    @FXML
    private TextField qtatualprodalt;

    @FXML
    private TextField descprodalt;

    @FXML
    private TextField marcaprodalt;

    @FXML
    private TextField qtminprodalt;

    @FXML
    private TextField nomeprodalt;

    @FXML
    private RadioButton cabeloprodalt;

    @FXML
    private ToggleGroup tipoestoquealt;

    @FXML
    private RadioButton maqprodalt;

    @FXML
    private RadioButton unhaprodalt;

}
