package controller;

import application.Main;
import application.Tela;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Cliente;
import modeldao.ClienteDAO;

public class CadClienteController {
    Tela tela;
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String nascimento;
    
    @FXML
    private Button back;

    @FXML
    private ImageView backlogo;

    @FXML
    private TextField nomecadcli;

    @FXML
    private TextField cpfcadcli;

    @FXML
    private TextField endcadcli;

    @FXML
    private TextField mailcadcli;

    @FXML
    private Label cadclilbl;

    @FXML
    private Button cadclibttn;

    @FXML
    private TextField telcadcli;

    @FXML
    private DatePicker datacadcli;

    public void onActionBack() throws IOException {
        tela= new Tela();
        tela.criarTela("/fxml/MainMenu.fxml", Main.MainMenu);
        Main.CadastroCliente.close();
    }
    
    public void onActionCadastrarCliente() {
        nome= nomecadcli.getText();
        cpf= cpfcadcli.getText();
        endereco= endcadcli.getText();
        email= mailcadcli.getText();
        telefone= telcadcli.getText();
        
        LocalDate dataNascimento= datacadcli.getValue();
        
        try {
            //dataNascimento.format(DateTimeFormatter.ofPattern("dd MM uuuu"));
            nascimento= dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            cliente= new Cliente(cpf, nome, telefone, endereco, email, nascimento);

            clienteDAO= new ClienteDAO();
            clienteDAO.inserir(cliente);
        } catch(Exception ex) {
            Alert alert;
            alert = new Alert(AlertType.ERROR, "Ocorreu um problema", ButtonType.OK);
            alert.setTitle("Estudante não foi cadastrado!");
            alert.setHeaderText("Informação");
            alert.show();
            ex.printStackTrace();
        }
    }
    
    public boolean validaDados() {
        String errorMessage= "";
        
        
    }
}
