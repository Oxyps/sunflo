package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginController {

    @FXML
    private BorderPane bgborder;

    @FXML
    private BorderPane bpanelog;

    @FXML
    private VBox loginbox;

    @FXML
    private TextField cpf;

    @FXML
    private PasswordField pass;

    @FXML
    private Label errorid;

    @FXML
    private ImageView imgerro;

    @FXML
    private Button loginbtn;

    @FXML
    private Label resetpsslbl;

    @FXML
    private Hyperlink passfrgt;

    @FXML
    private Hyperlink alteradmin;

    @FXML
    private ImageView logo;

}
